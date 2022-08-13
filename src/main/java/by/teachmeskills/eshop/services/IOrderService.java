package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.Order;

import java.util.Map;
import java.util.Set;

public interface IOrderService{

    Set<Order> getUserOrderById(int userId) throws Exception;
    void create(Order order) throws Exception;
}
