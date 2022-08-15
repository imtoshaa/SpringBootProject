package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.domain.entities.Category;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Repository
@Transactional
public class CategoryDaoImpl implements ICategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Category category) throws Exception {
        entityManager.persist(category);
    }

    @Override
    public List<Category> read() throws Exception {
        return entityManager.createQuery("select с from Category с ").getResultList();
    }

    @Override
    public void update(Category category) throws Exception {
        entityManager.merge(category);
    }

    @Override
    public void delete(Category category) throws Exception {
        if (entityManager.contains(category)) {
            entityManager.remove(category);
        } else {
            entityManager.remove(entityManager.merge(category));
        }
    }
}
