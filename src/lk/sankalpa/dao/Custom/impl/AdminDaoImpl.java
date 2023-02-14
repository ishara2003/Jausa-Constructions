package lk.sankalpa.dao.Custom.impl;

import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.dao.Custom.AdminDao;
import lk.sankalpa.entity.Admin;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl implements AdminDao {

    private final Connection connection;
    public AdminDaoImpl(Connection connection) {
        this.connection=connection;

    }

    @Override
    public Admin save(Admin admin) {
        CrudUtil.execute("INSERT INTO Admin VALUES(?,?,?,?)",

               admin.getName(),
               admin.getNic(),
               admin.getUser_name(),
               admin.getPassword()

       );
        return admin;
    }

    @Override
    public Admin update(Admin admin) {


        if(CrudUtil.execute("update admin set password=? where nic=?",admin.getPassword(), admin.getNic())){
            return admin;
        }

      return null;
    }

    @Override
    public Admin search(String nic) {

        try {
            ResultSet rst = CrudUtil.execute("select * from admin where nic='" + nic + "'");
        if(rst.next()){

            return new Admin(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));

        }
        } catch (SQLException e) {
            System.out.println(e);
        }



        return null;
    }

    @Override
    public void delete(String Id) {

    }

    @Override
    public List<Admin> allData() {
        return null;
    }



    @Override
    public Admin logIn(String username) {
        ResultSet rst = null;
        try {
            rst = CrudUtil.execute("select  * from admin where user_name=? ",username);
        if(rst.next()){

            if(rst!=null) {
                return new Admin(
                        rst.getString(1),
                        rst.getString(2),
                        rst.getString(3),
                        rst.getString(4));
            }
        }else{

            JOptionPane.showMessageDialog(null,"Account is Not Found");
        }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
}
