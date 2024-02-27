package ntemo.com.apiclientes.https.validation;

import java.time.Instant;

import groovy.transform.ToString;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterContactTDO {

    @NotBlank
    private String name;

    @NotBlank
    private String country;

    @NotBlank
    private String client;

    private String details;

    @Hidden
    private Instant createdAt;

    @Hidden
    private Instant updateAt;

    @Hidden
    private Instant deletedAt;

}
