package sesame.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.com.entities.Billing;

@RepositoryRestResource
public interface BillRepository extends JpaRepository<Billing, Long> {
}
