package ntemo.com.apiclientes.providers.services;

import org.springframework.stereotype.Service;
import java.time.Instant;
import ntemo.com.apiclientes.models.RegisterClient;
import ntemo.com.apiclientes.providers.repositories.RegisterClientRepository;
import ntemo.com.apiclientes.util.GenericRepository;

@Service
public class RegisterClientService extends GenericServices<RegisterClient, RegisterClientRepository>
        implements GenericRepository<RegisterClient> {

    final RegisterClientRepository registerClientRepository;

    public RegisterClientService(RegisterClientRepository registerClientRepository) {
        this.registerClientRepository = registerClientRepository;
    }

    public RegisterClient save(RegisterClient attr) {

        // TODO implementa variaveis que permitem armazenar o tempo

        if (attr.getUuid() == null)
            attr.setCreatedAt(Instant.now());

        attr.setUpdateAt(Instant.now());

        // Guardar infromação no banco de dados

        return this.registerClientRepository.save(attr);
    }

    public RegisterClient one(String uuid) {
        return this.registerClientRepository.findById(uuid).get();
    }

    @Override
    public void setTimeDelete(RegisterClient entity) {
        // TODO Auto-generated method stub
        entity.setDeletedAt(Instant.now());
    }

    @Override
    public String getReferenceKey(RegisterClient attr) {
        // TODO Auto-generated method stub
        return attr.getUuid();
    }

    @Override
    public void setTimeUpdate(RegisterClient attr) {
        // TODO Auto-generated method stub
        attr.setUpdateAt(Instant.now());
    }

    @Override
    public void setTimeCreated(RegisterClient attr) {
        // TODO Auto-generated method stub
        attr.setUpdateAt(Instant.now());
    }

    @Override
    protected RegisterClientRepository getInstance() {
        // TODO Auto-generated method stub
        return this.registerClientRepository;
    }

}
