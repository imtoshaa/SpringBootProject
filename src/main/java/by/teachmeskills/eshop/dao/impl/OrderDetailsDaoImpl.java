package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IOrderDetailsDao;
import by.teachmeskills.eshop.domain.entities.OrderDetails;
import by.teachmeskills.eshop.domain.entities.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class OrderDetailsDaoImpl implements IOrderDetailsDao {

    private final SessionFactory sessionFactory;

    @Override
    public void saveOrderDetails(OrderDetails orderDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(orderDetails);
        session.getTransaction().commit();
    }

    @Override
    public List<OrderDetails> getOrderDetails(User user) {
        Session session = sessionFactory.getCurrentSession();
        Query<OrderDetails> getOrders = session.createQuery(
                "select u from OrderDetails u where u.orderDetailsId.order.user.id=:userId");
        getOrders.setParameter("userId", user.getId());
        return getOrders.getResultList();
    }
}

