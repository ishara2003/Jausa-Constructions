package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Income;

import java.sql.ResultSet;
import java.util.List;

public interface IncomeDao extends CrudDao<Income,String> {
    List<Income>allIncomes(ResultSet resultSet);
}
