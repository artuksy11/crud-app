package su.dataserver.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import su.dataserver.crud.models.Data;

import java.util.Optional;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

    Optional<Data> findDataByName(String name);

}