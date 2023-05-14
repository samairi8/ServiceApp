package sesame.com.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor

 public class Billing {
   @Transient
   private Customer customer;

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id;

    private Date billingDate;

    private Long customerID;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;

}
