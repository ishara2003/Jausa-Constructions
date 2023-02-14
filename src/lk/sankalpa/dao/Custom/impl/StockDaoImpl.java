package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.StockDao;
import lk.sankalpa.entity.Stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StockDaoImpl implements StockDao {
    private final Connection connection;
    public StockDaoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Stock save(Stock stock) {
        CrudUtil.execute("insert into Stock values(?,?,?,?,?)",

                stock.getId(),
                stock.getDescrption(),
                stock.getDate(),
                stock.getQTY(),
                stock.getUnitPrice()

        );
        return stock;
    }

    @Override
    public Stock update(Stock stock) {

            if(CrudUtil.execute("update stock set Descrition=?,Last_Stock_Came_Date=?,QTY_On_Hand=?,Unit_Price=? where Item_Id=?",
                    stock.getDescrption(),
                    stock.getDate(),
                    stock.getQTY(),
                    stock.getUnitPrice(),
                    stock.getId())){
                return stock;
            }
            return null;

    }

    @Override
    public Stock search(String Id) {

        try {
            ResultSet   resultSet = CrudUtil.execute("select * from stock where Item_Id='" + Id + "'");
        while (resultSet.next()){

            return new Stock(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getDouble(5));
        }
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void delete(String Id) {
        CrudUtil.execute("delete from stock where Item_Id='"+Id+"'");
    }

    @Override
    public List<Stock> allData() {

      ResultSet  resultSet = CrudUtil.execute("SELECT * FROM stock");
      return getStocks(resultSet);
    }

    @Override
    public List<Stock> getStocks(ResultSet set) {

        try {

            ArrayList<Stock> list= new ArrayList<>();
            while (set.next()){
                list.add(new Stock(set.getString(1),
                        set.getString(2),
                        set.getString(3),
                        set.getString(4),
                        set.getDouble(5)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
