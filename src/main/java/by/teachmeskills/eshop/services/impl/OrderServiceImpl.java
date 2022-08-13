package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.IOrderDao;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.services.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderDao orderDao;

    @Override
    public Set<Order> getUserOrderById(int userId) throws Exception {
        return orderDao.getUserOrdersById(userId);
    }

    @Override
    public void create(Order order) throws Exception {
        orderDao.create(order);
    }
}
