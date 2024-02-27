package ntemo.com.apiclientes.https.controllers;

import java.time.Instant;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ntemo.com.apiclientes.https.validation.CountryTDO;
import ntemo.com.apiclientes.models.Country;
import ntemo.com.apiclientes.providers.services.CountryService;
import ntemo.com.apiclientes.util.GenericRepository;
import ntemo.com.apiclientes.util.RestGenericController;

@RestController
@RequestMapping("/countries")
public class CountryController extends RestGenericController<Country> {

    final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping
    ResponseEntity<Country> save(@RequestBody @Valid CountryTDO attr) {

        // TODO cria procedimento seguro para a gravação

        Country attribute = new Country();

        BeanUtils.copyProperties(attr, attribute);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.countryService.save(attribute));
    }

    /**
     * @param uuid
     * @param data
     * @return
     */
    @PutMapping("/{uuid}")
    ResponseEntity<Country> update(@PathVariable(value = "uuid") String uuid,
            @RequestBody @Valid CountryTDO data) {

        Country attr = this.countryService.one(uuid);

        if (attr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        BeanUtils.copyProperties(data, attr);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.countryService.save(attr));

    }

    @Override
    protected GenericRepository<Country> getService() {

        return this.countryService;
    }

}
