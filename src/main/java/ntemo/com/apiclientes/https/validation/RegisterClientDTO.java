package ntemo.com.apiclientes.https.validation;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ntemo.com.apiclientes.models.TypeClient;

import java.time.Instant;

import io.swagger.v3.oas.annotations.Hidden;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterClientDTO implements Serializable {

    // TODO : class RegisterClientDTO iniciar seu spring e TODO de propriedade

    @Hidden
    private String uuid;

    @NotBlank(message = "O campo nome do cliente é obrigatorio, portanto,"
            + " é importante designar o cliente.")
    private String name;

    @NotBlank
    private String nif;

    private String typeClient;

    private String details;

    /**
     * TODO controller TIMES recorde ...
     */

    @Hidden
    private Instant createdAt;

    @Hidden
    private Instant updateAt;

    @Hidden
    private Instant deletedAt;

}
