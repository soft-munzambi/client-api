package ntemo.com.apiclientes.providers.services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import ntemo.com.apiclientes.models.RegisterContact;
import ntemo.com.apiclientes.providers.repositories.ContactRepository;
import ntemo.com.apiclientes.util.GenericRepository;

@Service
public class ContactService extends GenericServices<RegisterContact, ContactRepository>
        implements GenericRepository<RegisterContact> {

    final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public RegisterContact one(String uuid) {
        // TODO Auto-generated method stub
        return this.contactRepository.one(uuid);
    }

    @Override
    public void setTimeDelete(RegisterContact entity) {
        // TODO Auto-generated method stub

        entity.setDeletedAt(Instant.now());
    }

    @Override
    public String getReferenceKey(RegisterContact attr) {
        // TODO Auto-generated method stub

        return attr.getUuid();
    }

    @Override
    public void setTimeUpdate(RegisterContact attr) {
        // TODO Auto-generated method stub

        attr.setUpdateAt(Instant.now());
    }

    @Override
    public void setTimeCreated(RegisterContact attr) {
        // TODO Auto-generated method stub

        attr.setCreatedAt(Instant.now());
    }

    @Override
    protected ContactRepository getInstance() {

        return this.contactRepository;
    }

    @Override
    public RegisterContact save(RegisterContact attr) {
        // TODO Auto-generated method stub

        if (attr.getUuid() == null)
            attr.setCreatedAt(Instant.now());

        attr.setUpdateAt(Instant.now());

        return this.contactRepository.save(attr);
    }

}
