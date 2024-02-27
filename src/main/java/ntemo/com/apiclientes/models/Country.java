package ntemo.com.apiclientes.models;

import java.time.Instant;

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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "uuid", columnDefinition = "VARCHAR(250)")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Column(name = "designation", columnDefinition = "VARCHAR(250)")
    private String designation;

    @Column(name = "acronym", columnDefinition = "VARCHAR(250)")
    private String acronym;

    @Column(name = "currency", columnDefinition = "VARCHAR(250)")
    private String currency;

    // @OneToMany
    // private List<Contact> contacts;

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
