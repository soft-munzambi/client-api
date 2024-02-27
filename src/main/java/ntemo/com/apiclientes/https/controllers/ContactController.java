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
import ntemo.com.apiclientes.https.validation.RegisterContactTDO;
import ntemo.com.apiclientes.models.Country;
import ntemo.com.apiclientes.models.RegisterClient;
import ntemo.com.apiclientes.models.RegisterContact;
import ntemo.com.apiclientes.providers.services.ContactService;
import ntemo.com.apiclientes.providers.services.CountryService;
import ntemo.com.apiclientes.providers.services.RegisterClientService;
import ntemo.com.apiclientes.util.GenericRepository;
import ntemo.com.apiclientes.util.RestGenericController;

@RestController
@RequestMapping("/contacts")
public class ContactController extends RestGenericController<RegisterContact> {

    final ContactService contactService;
    final CountryService countryService;
    final RegisterClientService registerClientService;

    public ContactController(ContactService attrOne, CountryService attrTow, RegisterClientService attr) {
        this.contactService = attrOne;
        this.countryService = attrTow;
        this.registerClientService = attr;

    }

    @PostMapping
    ResponseEntity<RegisterContact> save(@RequestBody @Valid RegisterContactTDO attr) {

        // TODO cria procedimento seguro para a gravação

        RegisterContact attribute = new RegisterContact();

        if (attr.getClient() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        RegisterClient client = this.registerClientService.one(attr.getClient());

        if (attr.getCountry() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        Country country = this.countryService.one(attr.getCountry());

        BeanUtils.copyProperties(attr, attribute);

        // Passar as informações do pais
        attribute.setCountry(country);

        // Passar as informações do propietario do registro
        attribute.setRegisterClient(client);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.contactService.save(attribute));
    }

    /**
     * @param uuid
     * @param data
     * @return
     */
    @PutMapping("/{uuid}")
    ResponseEntity<RegisterContact> update(@PathVariable(value = "uuid") String uuid,
            @RequestBody @Valid RegisterContactTDO data) {

        RegisterContact attr = this.contactService.one(uuid);

        if (attr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        BeanUtils.copyProperties(data, attr);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.contactService.save(attr));

    }

    @Override
    protected GenericRepository<RegisterContact> getService() {

        return this.contactService;
    }

}
