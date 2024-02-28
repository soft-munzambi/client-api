package ntemo.com.apiclientes.providers.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

import ntemo.com.apiclientes.models.Country;
import ntemo.com.apiclientes.models.TypeClient;

@Repository
public interface TypeClientRepository
                extends CrudRepository<TypeClient, String>, SrcGenericRepository<TypeClient, TypeClientRepository> {

        @Query("SELECT t FROM TypeClient t WHERE t.deletedAt IS NULL")
        List<TypeClient> all();

        @Query("SELECT t FROM TypeClient t WHERE t.uuid = :uuid AND t.deletedAt IS NULL")
        TypeClient one(@Param("uuid") String uuid);

        @Query("SELECT t FROM TypeClient t WHERE t.createdAt BETWEEN :startDate AND :endDate AND t.deletedAt IS NULL")
        List<TypeClient> allWithDateRange(Instant startDate, Instant endDate);

        @Query("SELECT t FROM TypeClient t "
                        // + "LEFT JOIN t.registerClients ON t.registerClients.typeClient = t.uuid"
                        + "WHERE (t.createdAt BETWEEN :startDate AND :endDate) "
                        + "AND (COALESCE(:name, '') = '' OR t.name LIKE CONCAT(:name, '%')) "
                        + "AND (COALESCE(:uuidList, '') = '' OR t.uuid IN :uuidList) AND t.deletedAt IS NULL")

        List<TypeClient> allWithParamAnDateBETWEEN(
                        @Param("name") String name, @Param("uuidList") List<String> uuidList,
                        @Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

}
