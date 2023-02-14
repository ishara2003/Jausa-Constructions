package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.OrderdetailsDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.OrderDetailsDTO;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.OrderDetailsService;

import java.sql.Connection;

public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final Connection connection;
    private final Converter converter;
    private final OrderdetailsDao orderdetailsDao;

    public OrderDetailsServiceImpl() {
        connection = DBConnection.getInstance().getConnection();
        converter = new Converter();
        orderdetailsDao = DaoFactory.getInstance().getDAO(connection, DaoType.ORDERDETAILS);
    }

    @Override
    public OrderDetailsDTO saveDetails(OrderDetailsDTO detailsDTO) {

        orderdetailsDao.save(converter.toOrderDetails(detailsDTO));
        return detailsDTO;
    }

    @Override
    public OrderDetailsDTO searchDetails(String Id) {

        return null;

    }
}
