package ntemo.com.apiclientes.https.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import jakarta.validation.Valid;
import ntemo.com.apiclientes.https.validation.TypeClientDTO;
import ntemo.com.apiclientes.models.TypeClient;
import ntemo.com.apiclientes.providers.services.TypeClientService;
import ntemo.com.apiclientes.util.GenericRepository;
import ntemo.com.apiclientes.util.RestGenericController;

@RestController
@RequestMapping("/type-clients")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TypeClientController extends RestGenericController<TypeClient> {

    final TypeClientService typeClientService;

    public TypeClientController(TypeClientService typeClientService) {
        this.typeClientService = typeClientService;
    }

    @PostMapping
    ResponseEntity<TypeClient> save(@RequestBody @Valid TypeClientDTO attr) {

        // TODO cria procedimento seguro para a gravação

        TypeClient attribute = new TypeClient();

        BeanUtils.copyProperties(attr, attribute);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(typeClientService.save(attribute));
    }

    /**
     * @param uuid
     * @param data
     * @return
     */
    @PutMapping("/{uuid}")
    ResponseEntity<TypeClient> update(@PathVariable(value = "uuid") String uuid,
            @RequestBody @Valid TypeClientDTO data) {

        TypeClient attr = this.typeClientService.one(uuid);

        if (attr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        BeanUtils.copyProperties(data, attr);
        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.typeClientService.save(attr));

    }

    @Override
    protected GenericRepository<TypeClient> getService() {

        return this.typeClientService;
    }

}
