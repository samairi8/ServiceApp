package sesame.com.entities.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sesame.com.entities.Billing;
import sesame.com.repositories.BillRepository;
import sesame.com.repositories.ProductItemRepository;

public class BillingRestController {
    private BillRepository billRepository;



    @Autowired

    private ProductItemRepository productItemRepository;



    @Autowired

    private CustomerService customerService;



    @Autowired

    private ProductService productService;



    @GetMapping(path="/dataBill/{id}")

    public Billing getBill(@PathVariable(name="id") Long id) {

        Billing bill=billRepository.findById(id).get();

        bill.setCustomer(customerService.findCustomerById(bill.getCustomerID()));



        bill.getProductItems().forEach(pi->{

            pi.setProduct(productService.findProductById(pi.getProductID()));

        });



        return bill;

    }
}
