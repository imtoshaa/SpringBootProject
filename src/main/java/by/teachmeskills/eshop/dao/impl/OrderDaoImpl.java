package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IOrderDao;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

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
public class OrderDaoImpl implements IOrderDao {

    private final SessionFactory sessionFactory;

    @Override
    public void create(Order order) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    @Override
    public List<Order> read() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Order ").list();
    }

    @Override
    public void update(Order order) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(order);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Order order) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
    }

    @Override
    public Set<Order> getUserOrdersById(int userId) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Query<Order> query = session.createQuery(
                "select o from Order o where o.user.id=:userId");
        query.setParameter("userId", userId);
        return new HashSet<>(query.getResultList());

    }
}
