package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.EmployeeDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.EmployeeDTO;
import lk.sankalpa.entity.Employee;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.EmployeeService;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    private Converter converter;
    private EmployeeDao employeeDao;
    private Connection connection;

    public EmployeeServiceImpl() {
       converter=new Converter();
       employeeDao= DaoFactory.getInstance().getDAO(connection, DaoType.EMPLOYEE);
       connection= DBConnection.getInstance().getConnection();
    }

    @Override
    public EmployeeDTO SaveEmployee(EmployeeDTO employeeDTO) {


        employeeDao.save(converter.toEmployee(employeeDTO));

        return employeeDTO;

    }

    @Override
    public List<EmployeeDTO> allEmployees() {

        return employeeDao.allData().stream().map(employee -> converter.fromEmployee(employee)).collect(Collectors.toList());

    }

    @Override
    public EmployeeDTO searchEmployee(String Nic) {

        Employee search = employeeDao.search(Nic);
        return converter.fromEmployee(search);

    }

    @Override
    public void deleteemployee(String Nic) {

        employeeDao.delete(Nic);

    }

    @Override
    public EmployeeDTO editemployeeDetails(EmployeeDTO employeeDTO) {

        employeeDao.update(converter.toEmployee(employeeDTO));
        return employeeDTO;

    }
}
