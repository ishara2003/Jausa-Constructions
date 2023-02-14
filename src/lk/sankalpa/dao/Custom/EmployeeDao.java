package lk.sankalpa.dao.Custom;

import lk.sankalpa.dao.CrudDao;
import lk.sankalpa.entity.Employee;

import java.sql.ResultSet;
import java.util.List;

public interface EmployeeDao extends CrudDao<Employee,String> {

    List<Employee>allEmployees(ResultSet resultSet);

}
