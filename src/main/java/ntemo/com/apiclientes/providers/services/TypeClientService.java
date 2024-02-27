package ntemo.com.apiclientes.providers.services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import ntemo.com.apiclientes.models.TypeClient;
import ntemo.com.apiclientes.providers.repositories.TypeClientRepository;
import ntemo.com.apiclientes.util.GenericRepository;

@Service
public class TypeClientService extends GenericServices<TypeClient, TypeClientRepository>
        implements GenericRepository<TypeClient> {

    final TypeClientRepository typeClientRepository;

    public TypeClientService(TypeClientRepository typeClientRepository) {
        this.typeClientRepository = typeClientRepository;
    }

    public TypeClient save(TypeClient attr) {

        // TODO implementa variaveis que permitem armazenar o tempo

        if (attr.getUuid() == null)
            attr.setCreatedAt(Instant.now());

        attr.setUpdateAt(Instant.now());

        // Guardar infromação no banco de dados

        return this.typeClientRepository.save(attr);
    }

    public TypeClient one(String uuid) {

        // TODO pegar o tipo de cliente pelo seu uuid

        return this.typeClientRepository.one(uuid);

    }

    @Override
    public void setTimeDelete(TypeClient entity) {
        entity.setDeletedAt(Instant.now());
    }

    @Override
    public String getReferenceKey(TypeClient attr) {
        return attr.getUuid();
    }

    @Override
    protected TypeClientRepository getInstance() {
        return this.typeClientRepository;
    }

    @Override
    public void setTimeUpdate(TypeClient attr) {

        attr.setUpdateAt(Instant.now());
    }

    @Override
    public void setTimeCreated(TypeClient attr) {

        attr.setCreatedAt(Instant.now());
    }

}
