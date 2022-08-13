package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IUserDao;
import by.teachmeskills.eshop.domain.entities.User;
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
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
public class UserDaoImpl implements IUserDao {

    private final SessionFactory sessionFactory;

    @Override
    public void create(User user) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> read() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User ").list();
    }

    @Override
    public void update(User user) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
    }

    @Override
    public void delete(User user) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

    @Override
    public User getUserByLoginAndPassword(String username, String pass) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("select u from User u where u.username=:username and u.password=:password");
        query.setParameter("username", username);
        query.setParameter("password", pass);
        return query.getSingleResult();
    }

    @Override
    public boolean checkUser(User checkedUser) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createNativeQuery(
                "SELECT IF (SELECT * FROM ESHOP_DB.USERS.USERNAME = ? AND ESHOP_DB.USERS.PASSWORD = ?)");
        query.setParameter(1, checkedUser.getUsername());
        query.setParameter(2, checkedUser.getPassword());
        return Optional.ofNullable(query.getSingleResult()).isPresent();
    }

    @Override
    public boolean checkUserByUsername(String username) throws Exception {Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createNativeQuery(
                "SELECT IF (SELECT * FROM ESHOP_DB.USERS.USERNAME = ?");
        query.setParameter(1, username);
        return Optional.ofNullable(query.getSingleResult()).isPresent();
    }
}
