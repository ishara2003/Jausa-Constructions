package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.IncomeDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.IncomeDTO;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.IncomeService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class IncomeServiceImpl implements IncomeService {

    private Connection connection;
    private Converter converter;
    private IncomeDao incomeDao;

    public IncomeServiceImpl() {
        connection= DBConnection.getInstance().getConnection();
        converter=new Converter();
        incomeDao= DaoFactory.getInstance().getDAO(connection, DaoType.INCOME);
    }

    @Override
    public IncomeDTO AddIncome(IncomeDTO incomeDTO) {

        incomeDao.save(converter.toIncome(incomeDTO));
       return incomeDTO;
    }

    @Override
    public List<IncomeDTO> allIncomes() {

       return incomeDao.allData().stream().map(incomes ->converter.fromIncome(incomes)).collect(Collectors.toList());

    }
}
