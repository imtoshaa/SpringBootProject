package by.teachmeskills.eshop.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Set;

import static by.teachmeskills.eshop.utils.EshopConstants.BIRTHDAY;
import static by.teachmeskills.eshop.utils.EshopConstants.EMAIL;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.IMG;
import static by.teachmeskills.eshop.utils.EshopConstants.INFO;
import static by.teachmeskills.eshop.utils.EshopConstants.NAME;
import static by.teachmeskills.eshop.utils.EshopConstants.PASSWORD;
import static by.teachmeskills.eshop.utils.EshopConstants.SURNAME;
import static by.teachmeskills.eshop.utils.EshopConstants.USERNAME;


@Getter
@Setter
@ToString
@SuperBuilder
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity {
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "BIRTHDAY")
    private String birthday;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "INFO")
    private String info;
    @Column(name = "IMG")
    private String img;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Order> order;

    public User(int id, String username, String name, String surname, String password, String img, String info, String email, String birthday) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.info = info;
        this.email = email;
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

}
