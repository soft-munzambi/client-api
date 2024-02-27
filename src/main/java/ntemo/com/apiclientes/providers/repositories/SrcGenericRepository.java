package ntemo.com.apiclientes.providers.repositories;

import java.time.Instant;
import java.util.List;

import ntemo.com.apiclientes.models.TypeClient;

public interface SrcGenericRepository<T> {

    List<TypeClient> allWithParamAnDateBETWEEN(String name, List<String> uuid, Instant start, Instant end);

    // void setInstantUpdated(T attr);

    // void setInstantCreated(T attr);

    // <T> T save(T attr);

    // <T> String getReferenceKy(T attr);

    // <T> T save(T attr);

    // <T> String getReferenceKey(T attr);

}
