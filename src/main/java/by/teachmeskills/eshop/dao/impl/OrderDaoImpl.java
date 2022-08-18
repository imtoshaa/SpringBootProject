package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IOrderDao;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static by.teachmeskills.eshop.utils.EshopConstants.DATE;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.PRICE;
import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCT_ID;
import static by.teachmeskills.eshop.utils.EshopConstants.USER_ID;

@AllArgsConstructor
@Repository
@Transactional
public class OrderDaoImpl implements IOrderDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Order order) throws Exception {
        entityManager.persist(order);
    }

    @Override
    public List<Order> read() throws Exception {
        return entityManager.createQuery("select r from Order r ").getResultList();
    }

    @Override
    public void update(Order order) throws Exception {
        entityManager.merge(order);
    }

    @Override
    public void delete(Order order) throws Exception {
        if (entityManager.contains(order)) {
            entityManager.remove(order);
        } else {
            entityManager.remove(entityManager.merge(order));
        }
    }

    @Override
    public Set<Order> getUserOrdersById(int userId) throws Exception {
        Query query = entityManager.createQuery(
                "select o from Order o where o.user.id=:userId");
        query.setParameter("userId", userId);
        return new HashSet<>(query.getResultList());

    }
}
