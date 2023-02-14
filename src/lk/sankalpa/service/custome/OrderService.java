package lk.sankalpa.service.custome;

import lk.sankalpa.dto.OrderDTO;
import lk.sankalpa.service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface OrderService extends SuperService {

    List<OrderDTO>allOrders();

    OrderDTO searchOrderById(String id);
    OrderDTO saveOrder(OrderDTO orderDTOy) throws SQLException;

    boolean qtyUpdate(String Item_Id,int qty);

}
