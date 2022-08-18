package by.teachmeskills.eshop.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.Table;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "ORDERS_PRODUCTS")
public class OrderDetails {

    @EmbeddedId
    @JsonIgnore
    private OrderDetailsId orderDetailsId;
}
