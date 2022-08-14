package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IProductDao;
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
import java.util.List;

@AllArgsConstructor
@Repository
public class ProductDaoImpl implements IProductDao {

    private final SessionFactory sessionFactory;
    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM PRODUCTS";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM PRODUCTS WHERE ID = ?";
    private static final String GET_PRODUCTS_BY_CATEGORY_ID_QUERY = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ?";
    private static final String CREATE_PRODUCT_QUERY = "INSERT INTO PRODUCTS (CATEGORY_ID, NAME, PRICE, DESCRIPTION, IMG) VALUE (?, ?, ?, ?, ?)";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM PRODUCTS WHERE ID=?";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE PRODUCTS SET CATEGORY_ID=?, NAME=?, PRICE=?, DESCRIPTION=?, IMG=? WHERE ID=?";

    @Override
    public void create(Product product) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
    }

    @Override
    public List<Product> read() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Product ").list();
    }

    @Override
    public void update(Product product) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(product);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Product product) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("select p from Product p where p.category.id=:categoryId");
        query.setParameter("categoryId", categoryId);
        return query.getResultList();
    }

    @Override
    public Product getProductById(int productId) throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Query<Product> query = session.createQuery("select p from Product p where p.id=:productId");
        query.setParameter("productId", productId);
        return query.getSingleResult();
    }

}
