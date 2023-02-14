package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.OrderDao;
import lk.sankalpa.entity.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private final Connection connection;
    public OrderDaoImpl(Connection connection) {
        this.connection=connection;

    }

    @Override
    public Orders save(Orders orders) {
        CrudUtil.execute("insert into orders_for_unique_project values(?,?,?,?,?,?,?,?)",

                orders.getO_Id(),
                orders.getOrder_Set_Date(),
                orders.getQTY_Used(),
                orders.getCost(),
                orders.getP_Owner_NIC(),
                orders.getP_Id(),
                orders.getItem_Id(),
                orders.getDescription()

        );

        return orders;
    }

    @Override
    public Orders update(Orders orders) {
        return null;

    }

    @Override
    public Orders search(String id) {
        ResultSet execute = CrudUtil.execute("select * from orders_for_unique_project where Oreder_Id='"+id+"'");


        try {
            if (execute.next()){
                return new Orders(
                        execute.getString(1),
                        execute.getString(2),
                        execute.getInt(3),
                        execute.getDouble(4),
                        execute.getString(5),
                        execute.getString(6),
                        execute.getString(7),
                        execute.getString(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;

    }

    @Override
    public void delete(String Id) {

    }


    @Override
    public boolean editQuantity(String item_id, int qty) {
        return (CrudUtil.execute("UPDATE stock SET QTY_On_Hand = QTY_On_Hand -'"+qty+"' where Item_Id='"+item_id+"'")) ;

    }

    @Override
    public Orders searchById(String Id) {
        ResultSet execute = null;
        try {
            execute = CrudUtil.execute("select * from orders_for_unique_project where Oreder_Id='"+Id+"'");
            if (execute.next()){
                return new Orders(
                        execute.getString(1),
                        execute.getString(2),
                        execute.getInt(3),
                        execute.getDouble(4),
                        execute.getString(5),
                        execute.getString(6),
                        execute.getString(7),
                        execute.getString(8));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Orders> allOrders(ResultSet resultSet) {
        try{
            ArrayList<Orders> list = new ArrayList<>();
            while (resultSet.next()) {
                System.out.println("Huththa");
                list.add(new Orders(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                ));
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    @Override
    public List<Orders> allData() {

        ResultSet  resultSet = CrudUtil.execute("SELECT * FROM orders_for_unique_project");

        return allOrders(resultSet);
    }
}
