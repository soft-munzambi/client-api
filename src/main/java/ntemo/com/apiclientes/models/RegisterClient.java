package ntemo.com.apiclientes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class RegisterClient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", columnDefinition = "VARCHAR(250)")
    private String uuid;

    @Column(name = "name", columnDefinition = "VARCHAR(250)", nullable = false)
    private String name;

    @ManyToOne
    private TypeClient typeClient;

    @Column(name = "nif", columnDefinition = "VARCHAR(250)", nullable = false, unique = true)
    private String nif;

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
