package kz.dar.academy.backend.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Long> {
    List<ClientEntity> findClientEntitiesBy();

    ClientEntity findClientEntityByClientId(String clientId);

    @Transactional
    void deleteClientEntityByClientId(String clientId);
}
