package ntemo.com.apiclientes.models;

import java.time.Instant;

import groovy.transform.ToString;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "contacts")
public class RegisterContact implements Serializable {

    // TODO Cantact iniciar classe spring e TODO de propriedade

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", columnDefinition = "VARCHAR(250)")
    private String uuid;

    @Column(name = "name", columnDefinition = "VARCHAR(250)")
    private String name;

    @ManyToOne
    private RegisterClient registerClient;

    @ManyToOne
    private Country country;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    /*
     * controller times recorder to system
     */
    @Column(name = "createdAt", columnDefinition = "TIMESTAMP")
    private Instant createdAt;

    @Column(name = "updateAt", columnDefinition = "TIMESTAMP")
    private Instant updateAt;

    @Column(name = "deletedAt", columnDefinition = "TIMESTAMP")
    private Instant deletedAt;

}
