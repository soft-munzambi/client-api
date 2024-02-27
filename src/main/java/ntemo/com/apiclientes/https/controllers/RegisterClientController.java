package ntemo.com.apiclientes.https.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import jakarta.validation.Valid;
import ntemo.com.apiclientes.providers.services.TypeClientService;
import ntemo.com.apiclientes.util.GenericRepository;
import ntemo.com.apiclientes.util.RestGenericController;
import ntemo.com.apiclientes.https.validation.RegisterClientDTO;
import ntemo.com.apiclientes.https.validation.TypeClientDTO;
import ntemo.com.apiclientes.models.RegisterClient;
import ntemo.com.apiclientes.models.TypeClient;
import ntemo.com.apiclientes.providers.services.RegisterClientService;
import java.time.Instant;

@RestController
@RequestMapping("/clients")
public class RegisterClientController extends RestGenericController<RegisterClient> {

    final RegisterClientService registerClientService;
    final TypeClientService typeClientService;

    public RegisterClientController(RegisterClientService registerClientService, TypeClientService typeClientService) {
        this.registerClientService = registerClientService;
        this.typeClientService = typeClientService;
    }

    @PostMapping
    ResponseEntity<RegisterClient> save(@RequestBody @Valid RegisterClientDTO attr) {

        // Pegar as informações do tipo de cliente

        if (attr.getTypeClient() == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        TypeClient typeClient = this.typeClientService.one(attr.getTypeClient());
        RegisterClient attribute = new RegisterClient();

        BeanUtils.copyProperties(attr, attribute);

        attribute.setTypeClient(typeClient);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", UUID.randomUUID().toString())
                .body(this.registerClientService.save(attribute));
    }

    @PutMapping("/{uuid}")
    ResponseEntity<RegisterClient> update(@PathVariable(value = "uuid") String uuid,
            @RequestBody @Valid TypeClientDTO data) {

        RegisterClient attr = this.registerClientService.one(uuid);

        if (attr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        BeanUtils.copyProperties(data, attr);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.registerClientService.save(attr));
    }

    @Override
    protected GenericRepository<RegisterClient> getService() {

        return this.registerClientService;
    }

}
