package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Orders;

import java.sql.ResultSet;
import java.util.List;

public interface OrderDao extends CrudDao<Orders,String> {

    boolean editQuantity(String item_id,int qty);
    Orders searchById(String Id);

    List<Orders> allOrders(ResultSet resultSet);
}
