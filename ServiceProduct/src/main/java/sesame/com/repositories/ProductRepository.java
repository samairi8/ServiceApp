package sesame.com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sesame.com.entities.Product;

@RepositoryRestResource

public interface ProductRepository extends JpaRepository<Product, Long> {



}
