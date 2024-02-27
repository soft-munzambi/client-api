package ntemo.com.apiclientes.models;

import java.time.Instant;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "type_clients")
public class TypeClient implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid", columnDefinition = "VARCHAR(250)")
    private String uuid;

    @Column(name = "name", columnDefinition = "VARCHAR(250)", nullable = false)
    private String name;

    @Column(name = "details", columnDefinition = "TEXT")
    private String details;

    // @OneToMany
    // private List<RegisterClient> registerClients;

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
