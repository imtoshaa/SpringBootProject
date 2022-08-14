package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IUserDao;
import by.teachmeskills.eshop.domain.entities.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
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
        return query.uniqueResult();
    }

    @Override
    public boolean checkUser(User checkedUser) throws Exception {
        User user = null;
        Session session = sessionFactory.getCurrentSession();
        Query<User> query =  session.createQuery("select u from User u where u.username=:username and u.password=:password");
        query.setParameter("username", checkedUser.getUsername());
        query.setParameter("password", checkedUser.getPassword());
        user = query.uniqueResult();
        return user != null;
    }

    @Override
    public boolean checkUserByUsername(String username) throws Exception {Session session = sessionFactory.getCurrentSession();
        Query<User> query =  session.createQuery("select u from User u where u.username=:username");
        query.setParameter("username", username);
        User user = query.uniqueResult();
        return user == null;
    }
}
