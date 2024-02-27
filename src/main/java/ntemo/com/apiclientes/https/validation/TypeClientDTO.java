package ntemo.com.apiclientes.https.validation;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

import io.swagger.v3.oas.annotations.Hidden;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeClientDTO implements Serializable {

    // TODO : class TypeClientDTO iniciar seu spring e TODO de propriedade

    @Hidden
    private String uuid;

    @NotBlank(message = "o campo designação é de caracter obrigatorio,"
            + " é importante descrever a caracteristica do tipo de cliente.")

    private String name;

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
