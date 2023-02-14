package lk.sankalpa.service.custome.impl;

import javafx.scene.control.Alert;
import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.OrderDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.OrderDTO;
import lk.sankalpa.entity.Orders;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.OrderService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private final Connection connection;
    private final Converter converter;
    private final OrderDao orderDao;


    public OrderServiceImpl() {

        connection= DBConnection.getInstance().getConnection();
        orderDao= DaoFactory.getInstance().getDAO(connection, DaoType.ORDERS);
        converter=new Converter();

    }

    @Override
    public List<OrderDTO> allOrders() {

        return orderDao.allData().stream().map(orders -> converter.fromOrders(orders)).collect(Collectors.toList());

    }

    @Override
    public OrderDTO searchOrderById(String id) {

        Orders orders = orderDao.searchById(id);
       return converter.fromOrders(orders);

    }

    @Override
    public OrderDTO saveOrder(OrderDTO orderDTO)  {


            orderDao.save(converter.toOrders(orderDTO));
            if (orderDTO != null) {

                new Alert(null, "Added");
                return orderDTO;
            }

return null;
    }

    @Override
    public boolean qtyUpdate(String Item_Id, int qty) {

        boolean b = orderDao.editQuantity(Item_Id, qty);
        if (b) {

                return b;

        }
            return false;

    }
}
