package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.domain.entities.Category;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.List;

@AllArgsConstructor
@Repository
public class CategoryDaoImpl implements ICategoryDao {

    private final SessionFactory sessionFactory;

    @Override
    public void create(Category category) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();
    }

    @Override
    public List<Category> read() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category ").list();
    }

    @Override
    public void update(Category category) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(category);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Category category) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(category);
        session.getTransaction().commit();
    }
}
