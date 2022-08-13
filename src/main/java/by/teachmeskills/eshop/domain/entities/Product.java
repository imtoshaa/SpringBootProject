package by.teachmeskills.eshop.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;

import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORY_ID;
import static by.teachmeskills.eshop.utils.EshopConstants.DESCRIPTION;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.IMG;
import static by.teachmeskills.eshop.utils.EshopConstants.NAME;
import static by.teachmeskills.eshop.utils.EshopConstants.PRICE;

@Getter
@SuperBuilder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PRICE")
    private int price;
    @Column(name = "IMG")
    private String img;
    @ManyToOne(optional = false)
    @JoinColumn(name = "CATEGORY_ID", nullable = false, referencedColumnName = "id")
    private Category category;


}
