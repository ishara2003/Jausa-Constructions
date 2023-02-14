package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Stock;

import java.sql.ResultSet;
import java.util.List;

public interface StockDao extends CrudDao<Stock,String > {

    List<Stock> getStocks(ResultSet set);

}
