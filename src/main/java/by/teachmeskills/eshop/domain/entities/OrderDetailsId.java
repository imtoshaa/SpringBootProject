package by.teachmeskills.eshop.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class OrderDetailsId implements Serializable {

    @JsonBackReference
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
