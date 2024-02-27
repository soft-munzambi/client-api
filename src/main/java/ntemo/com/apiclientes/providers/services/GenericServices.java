package ntemo.com.apiclientes.providers.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import ntemo.com.apiclientes.providers.repositories.SrcGenericRepository;

public abstract class GenericServices<T, R extends SrcGenericRepository<R>> {

    protected abstract R getInstance();

    @SuppressWarnings("unchecked")
    public List<T> allWithParm(String designation, List<String> uuid,
            List<String> rangeData) {

        Calendar calendar = Calendar.getInstance();
        Instant end = calendar.getTime().toInstant(); // Data final é a data atual

        calendar.add(Calendar.MONTH, -2); // Subtrai dois mês
        Instant start = calendar.getTime().toInstant();

        if (rangeData != null && rangeData.size() == 2) {
            start = Instant.parse(rangeData.get(0) + "T00:00:00Z");
            end = Instant.parse(rangeData.get(1) + "T00:00:00Z");
        }

        // Instant.parse(rangeData.get(0) + "T00:00:00Z").plus(1, ChronoUnit.DAYS);
        if (rangeData != null && rangeData.size() == 1) {
            start = Instant.parse(rangeData.get(0) + "T00:00:00Z");
            end = Instant.parse(rangeData.get(0) + "T00:00:00Z").plus(1, ChronoUnit.DAYS);
            ;
        }

        // funciona devidamente porque vem da interface pai;
        return (List<T>) this.getInstance().allWithParamAnDateBETWEEN(designation, uuid, start, end);

    }

    // T save(T attr) {
    // // TODO implementa variaveis que permitem armazenar o tempo

    // if (this.getInstance().getReferenceKy(attr) == null)
    // this.getInstance().setInstantCreated(attr);

    // this.getInstance().setInstantUpdated(Instant.now());

    // // Guardar infromação no banco de dados

    // return this.getInstance().save(attr);
    // }

    // String getReferenceKey(T attr) {

    // return (String) getInstance().getReferenceKey(attr);
    // }

}
