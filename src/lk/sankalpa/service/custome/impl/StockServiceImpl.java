package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.StockDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.StockDTO;
import lk.sankalpa.entity.Stock;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.StockService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class StockServiceImpl implements StockService {

    private Connection connection;
    private Converter converter;
    private StockDao stockDao;

    public StockServiceImpl() {
        connection= DBConnection.getInstance().getConnection();
        converter=new Converter();
        stockDao= DaoFactory.getInstance().getDAO(connection, DaoType.STOCK);
    }

    @Override
    public StockDTO AddStock(StockDTO stockDTO) {

        stockDao.save(converter.toStock(stockDTO));
        return stockDTO;

    }

    @Override
    public StockDTO uppdateStock(StockDTO stockDTO) {

        stockDao.update(converter.toStock(stockDTO));
        return stockDTO;

    }

    @Override
    public StockDTO searchItemById(String id) {

        Stock search = stockDao.search(id);
      return converter.fromStock(search);

    }

    @Override
    public void deleeteItem(String id) {
        stockDao.delete(id);
    }

    @Override
    public List<StockDTO> allItems() {
        return stockDao.allData().stream().map(stock ->
                converter.fromStock(stock)).collect(Collectors.toList());
    }
}
