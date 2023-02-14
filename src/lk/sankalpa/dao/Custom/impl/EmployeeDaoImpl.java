package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.EmployeeDao;
import lk.sankalpa.entity.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    private final Connection connection;
    public EmployeeDaoImpl(Connection connection) {
        this.connection=connection;

    }

    @Override
    public Employee save(Employee employee) {
        CrudUtil.execute("insert into employee values(?,?,?,?,?,?,?,?)",

               employee.getName(),
               employee.getNIC(),
               employee.getAddress(),
               employee.getNumber(),
               employee.getAge(),
               employee.getSalary(),
               employee.getJoinDate(),
               employee.getWorkSection()
       );
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
 //       if(CrudUtil.execute("update stock set Descrition=?,Last_Stock_Came_Date=?,QTY_On_Hand=?,Unit_Price=? where Item_Id=?",
//                    stock.getDescrption(),
//                    stock.getDate(),
//                    stock.getQTY(),
//                    stock.getUnitPrice(),
//                    stock.getId())){
//                return stock;
//            }
//            return null;
        if(CrudUtil.execute("update employee set Name=?,Address=?,Contact_Number=?,Age=?,Salary=?,Join_Date=?,Work_Section=? where NIC=?",
                employee.getName(),
                employee.getAddress(),
                employee.getNumber(),
                employee.getAge(),
                employee.getSalary(),
                employee.getJoinDate(),
                employee.getWorkSection(),
                employee.getNIC())){
            return employee;
        }
        return null;

//        PreparedStatement prs = null;
//        try {
//            prs = DBConnection.getInstance().getConnection().
//                    prepareStatement("update employee set Name=?,Address=?,Contact_Number=?,Age=?,Salary=?,Join_Date=?,Work_Section=? where NIC=?");
//
//        prs.setObject(8, employee.getNIC());
//        prs.setObject(1, employee.getName());
//        prs.setObject(2, employee.getAddress());
//        prs.setObject(3, employee.getNumber() );
//        prs.setObject(4, employee.getAge());
//        prs.setObject(5, employee.getSalary() );
//        prs.setObject(6, employee.getJoinDate() );
//        prs.setObject(7,employee.getWorkSection() );
//
//      //  int i = prs.executeUpdate();
//
//        return employee;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//
//        }
    }

    @Override
    public Employee search(String nic) {


        ResultSet resultSet = null;
        try {
            resultSet = CrudUtil.execute("select * from employee where NIC='"+nic+"'" );

        while (resultSet.next()) {
            return new Employee(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void delete(String nic) {
        CrudUtil.execute("delete from employee where NIC=?",nic);
    }

    @Override
    public List<Employee> allData() {

        ResultSet resultSet = CrudUtil.execute("SELECT * FROM employee");

        return allEmployees(resultSet);
    }

    @Override
    public List<Employee> allEmployees(ResultSet resultSet) {

        ArrayList<Employee> list= new ArrayList<>();

            try {
        while (resultSet.next()) {


            list.add(new Employee(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7)
                    , resultSet.getString(8)));

        }
        return list;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

    }
}
