package by.teachmeskills.eshop.dao;

import by.teachmeskills.eshop.domain.entities.Order;

import java.util.Map;
import java.util.Set;

public interface IOrderDao extends BaseDao<Order> {

     Set<Order> getUserOrdersById(int userId) throws Exception;
}
