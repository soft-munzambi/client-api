package ntemo.com.apiclientes.providers.services;

import java.time.Instant;

import org.springframework.stereotype.Service;

import ntemo.com.apiclientes.models.Country;
import ntemo.com.apiclientes.providers.repositories.CountryRepository;
import ntemo.com.apiclientes.util.GenericRepository;

@Service
public class CountryService extends GenericServices<Country, CountryRepository>
        implements GenericRepository<Country> {

    final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country one(String uuid) {

        return this.countryRepository.one(uuid);
    }

    @Override
    public Country save(Country attr) {

        if (attr.getUuid() == null) {
            attr.setCreatedAt(Instant.now());
        }

        attr.setUpdateAt(Instant.now());

        return this.countryRepository.save(attr);
    }

    @Override
    public void setTimeDelete(Country entity) {

        entity.setDeletedAt(Instant.now());
    }

    @Override
    public String getReferenceKey(Country attr) {

        return attr.getUuid();
    }

    @Override
    public void setTimeUpdate(Country attr) {

        attr.setUpdateAt(Instant.now());
    }

    @Override
    public void setTimeCreated(Country attr) {

        attr.setCreatedAt(Instant.now());
    }

    @Override
    protected CountryRepository getInstance() {

        return this.countryRepository;
    }

}
