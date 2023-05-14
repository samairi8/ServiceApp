package sesame.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.com.entities.Customer;

@RepositoryRestResource

public interface CustomerRepository extends JpaRepository<Customer, Long> {



}