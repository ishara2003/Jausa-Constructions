package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.ManagerDao;
import lk.sankalpa.entity.Manager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ManagerDaoImpl implements ManagerDao {

    private final Connection connection;
    public ManagerDaoImpl(Connection connection) {
        this.connection=connection;
    }

    @Override
    public Manager save(Manager manager) {
        CrudUtil.execute("INSERT INTO Manager VALUES(?,?,?,?)",

                manager.getName(),
                manager.getNic(),
                manager.getUser_name(),
                manager.getPassword()

        );
        return manager;
    }

    @Override
    public Manager update(Manager manager) {

        if(CrudUtil.execute("update manager set password=? where nic=?",manager.getPassword(), manager.getNic())){
            return manager;
        }

        return null;

    }

    @Override
    public Manager search(String nic) {
        ResultSet rst = null;
        try {
            rst = CrudUtil.execute("select * from manager where nic='" + nic + "'");
        if(rst.next()){

            return new Manager(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));

        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public void delete(String Id) {

    }

    @Override
    public List<Manager> allData() {
        return null;
    }

    @Override
    public Manager login(String un) {
        ResultSet rst = null;
        try {
            rst = CrudUtil.execute("select  * from manager where user_name=? ",un);
        if(rst.next()){

            if(rst!=null) {
                return new Manager(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
            }
        }else{

            JOptionPane.showMessageDialog(null,"Account is Not Found");
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return null;


    }

}
