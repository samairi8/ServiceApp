package sesame.com.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sesame.com.entities.Product;

@FeignClient(name="INVENTORY-SERVICE")
public interface ProductService {
    @GetMapping("/products/{id}")

    public Product findProductById(@PathVariable(name="id") Long id);
}
