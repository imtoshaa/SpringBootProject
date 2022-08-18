package by.teachmeskills.eshop.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.ResultSet;

import static by.teachmeskills.eshop.utils.EshopConstants.DATE;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.PRICE;
import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.EshopConstants.USER_ID;

@Getter
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {
    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID", nullable = false, referencedColumnName = "id")
    private User user;
    @Column(name = "DATE")
    private String date;
    @Column(name = "PRICE")
    private int price;
    @ManyToOne(optional = false)
    @JoinTable(
            name = "ORDERS_PRODUCTS",
            joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")
    )
    private Product product;
}
