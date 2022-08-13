package by.teachmeskills.eshop.domain.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Getter
@ToString
@SuperBuilder
@RequiredArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Column(name = "NAME")
    private String name;
    @Column(name = "IMG")
    private String img;
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(img, category.img) && Objects.equals(description, category.description) && Objects.equals(productList, category.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, img, description, productList);
    }
}
