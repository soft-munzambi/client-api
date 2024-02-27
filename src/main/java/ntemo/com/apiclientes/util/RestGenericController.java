package ntemo.com.apiclientes.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ntemo.com.apiclientes.models.TypeClient;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public abstract class RestGenericController<T> {

    protected abstract GenericRepository<T> getService();

    @GetMapping
    public ResponseEntity<List<T>> all(
            @RequestParam(value = "containers", required = false) String containers,
            @RequestParam(value = "dataRange", required = false) List<String> dataRange,
            @RequestParam(value = "uuid_in", required = false) List<String> uuid_in) {

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(getService().allWithParm(containers, uuid_in, dataRange));
    }

    @PatchMapping("/{uuid}")
    ResponseEntity<T> one(@PathVariable(value = "uuid") String uuid) {

        T attr = this.getService().one(uuid);

        if (attr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // Ser por ventura chegar aqui é porque o cliente mandou o uuid
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", UUID.randomUUID().toString())
                .body(attr);
    }

    @DeleteMapping("/{uuid}")
    ResponseEntity<T> softDelete(@PathVariable(value = "uuid") String uuid) {

        T attr = this.getService().one(uuid);

        if (attr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        getService().setTimeDelete(attr);

        return ResponseEntity.status(HttpStatus.UPGRADE_REQUIRED)
                .header("Header", "Developer", "API CLIENT v0.0.1")
                .header("transfer-encoding", "Developer", "API CLIENT v0.0.1")
                .header("Key", Instant.now().toString())
                .body(this.getService().save(attr));

    }
}
