package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.IncomeDao;
import lk.sankalpa.entity.Income;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomDaoImpl implements IncomeDao {

    private final Connection connection;
    public IncomDaoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Income save(Income income) {
        CrudUtil.execute("insert into income values(?,?,?)",

                income.getIncomeId(),
                income.getDate(),
                income.getPaymentId()


        );
        return income;
    }

    @Override
    public Income update(Income entity) {
        return null;
    }

    @Override
    public Income search(String Id) {
        return null;
    }

    @Override
    public void delete(String Id) {

    }

    @Override
    public List<Income> allData() {

        ResultSet resultSet = CrudUtil.execute("SELECT * FROM income");

        return allIncomes(resultSet);

    }

    @Override
    public List<Income> allIncomes(ResultSet resultSet) {


        ArrayList<Income> list= new ArrayList<>();
            try {
        while (resultSet.next()){

            list.add(new Income(resultSet.
                    getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)));

                }
                    return list;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}
