package ntemo.com.apiclientes.providers.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntemo.com.apiclientes.models.RegisterContact;
import ntemo.com.apiclientes.models.TypeClient;

@Repository
public interface ContactRepository
        extends CrudRepository<RegisterContact, String>, SrcGenericRepository<ContactRepository> {

    @Query("SELECT t FROM RegisterContact t WHERE t.uuid = :uuid AND t.deletedAt IS NULL")
    RegisterContact one(@Param("uuid") String uuid);

    @Query("SELECT t FROM RegisterContact t "
            // + "LEFT JOIN t.registerClients ON t.registerClients.typeClient = t.uuid"
            + "WHERE (t.createdAt BETWEEN :startDate AND :endDate) "
            + "AND (COALESCE(:name, '') = '' OR t.name LIKE CONCAT(:name, '%')) "
            + "AND (COALESCE(:uuidList, '') = '' OR t.uuid IN :uuidList) AND t.deletedAt IS NULL")

    List<RegisterContact> allWithParamAnDateBETWEEN(
            @Param("name") String name, @Param("uuidList") List<String> uuidList,
            @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);
}
