package sesame.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sesame.com.entities.Billing;
import sesame.com.entities.ProductItem;
import sesame.com.repositories.BillRepository;
import sesame.com.repositories.ProductItemRepository;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class ServiceBillingApplication {
    @Autowired

    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(ServiceBillingApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BillRepository  billRepository,

                            ProductItemRepository prdRepository
                           CustomerService customerservice,

                            ProductService productservice) {

        return args -> {

            repositoryRestConfiguration.exposeIdsFor(Billing.class);


            Customer c1 = customerservice.findCustomerById(1L);

            Billing bill1 = billRepository.save(new Billing(null,new Date(),c1.getId(),null));

            System.out.println(c1.getName());

            System.out.println(c1.getEmail());



            Product p1 = productservice.findProductById(1L);

            prdRepository.save(new ProductItem(null,p1.getId(),p1.getPrice(),30,bill1));



            Product p2 = productservice.findProductById(2L);

            prdRepository.save(new ProductItem(null,p2.getId(),p2.getPrice(),20,bill1));

        };


    }

}
