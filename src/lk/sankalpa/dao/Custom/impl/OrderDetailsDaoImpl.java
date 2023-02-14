package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.OrderdetailsDao;
import lk.sankalpa.entity.OrderDetails;

import java.sql.Connection;
import java.util.List;

public class OrderDetailsDaoImpl implements OrderdetailsDao {
    private final Connection connection;
    public OrderDetailsDaoImpl(Connection connection) {
        this.connection=connection;

    }

    @Override
    public OrderDetails save(OrderDetails orderDetails) {
        CrudUtil.execute("insert into order_details values(?,?,?,?,?,?)",

               orderDetails.getItem_Id(),
               orderDetails.getOrder_Id(),
               orderDetails.getP_Id(),
               orderDetails.getQty(),
               orderDetails.getCost(),
               orderDetails.getDate()

       );
        return orderDetails;
    }

    @Override
    public OrderDetails update(OrderDetails entity) {
        return null;
    }

    @Override
    public OrderDetails search(String Id) {
        return null;
    }

    @Override
    public void delete(String Id) {

    }

    @Override
    public List<OrderDetails> allData() {
        return null;
    }
}
