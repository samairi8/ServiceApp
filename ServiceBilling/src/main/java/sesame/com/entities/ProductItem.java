package sesame.com.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )

    private Long id;

    private Long productID;

    private double price;

    private double quantity;
    @Transient

    private Product product;



    private double quantity;

    @ManyToOne
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
    private Billing bill;
}
