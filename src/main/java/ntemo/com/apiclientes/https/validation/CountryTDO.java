package ntemo.com.apiclientes.https.validation;

import groovy.transform.ToString;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CountryTDO {

    @Hidden
    private String uuid;
    @NotBlank
    private String name;
    private String acronym;
    private String currency;
    private String details;
}
