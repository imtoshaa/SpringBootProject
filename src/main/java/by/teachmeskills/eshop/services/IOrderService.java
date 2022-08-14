package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.Product;

import java.util.Map;
import java.util.Set;

public interface IOrderService{

    Set<Order> getUserOrderById(int userId) throws Exception;
    void create(Order order, Product product) throws Exception;
}
