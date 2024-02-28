package ntemo.com.apiclientes.providers.repositories;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ntemo.com.apiclientes.models.RegisterClient;

@Repository
public interface RegisterClientRepository
                extends CrudRepository<RegisterClient, String>,
                SrcGenericRepository<RegisterClient, RegisterClientRepository> {

        @Query("SELECT t FROM RegisterClient t WHERE t.deletedAt IS NULL")
        List<RegisterClient> all();

        @Query("SELECT t FROM RegisterClient t " +
                        "WHERE (t.createdAt BETWEEN :startDate AND :endDate) "
                        + "AND (COALESCE(:name, '') = '' OR t.name LIKE CONCAT(:name, '%')) "
                        + "AND (COALESCE(:uuidList, '') = '' OR t.uuid IN :uuidList) AND t.deletedAt IS NULL")

        List<RegisterClient> allWithParamAnDateBETWEEN(
                        @Param("name") String name,
                        @Param("uuidList") List<String> uuidList,
                        @Param("startDate") Instant startDate,
                        @Param("endDate") Instant endDate);

        boolean existsByNif(String nif);
}
