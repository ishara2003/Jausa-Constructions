package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.AdminDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.AdminDTO;
import lk.sankalpa.entity.Admin;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.AdminService;

import java.sql.Connection;

public class AdminServiceImpl implements AdminService {


    private  AdminDao adminDao;
    private  Connection connection;
    private  Converter convertor;
    private AdminService adminService;
    public AdminServiceImpl() {

        connection= DBConnection.getInstance().getConnection();
        adminDao = DaoFactory.getInstance().getDAO(connection, DaoType.ADMIN);
        convertor=new Converter();

    }


    @Override
    public AdminDTO saveAdmin(AdminDTO adminDTO)throws NullPointerException {

        adminDao.save(convertor.toAdmin(adminDTO));
        return  adminDTO;

    }

    @Override
    public AdminDTO updateAdmin(AdminDTO adminDTO)throws NullPointerException {


        adminDao.update(convertor.toAdmin(adminDTO));
        return adminDTO;
    }

    @Override
    public AdminDTO searchAdmin(String nic) {

        Admin search = adminDao.search(nic);
        return convertor.fromAdmin(search);

    }

    @Override
    public AdminDTO logIn(String username) {

        Admin admin = adminDao.logIn(username);

      return convertor.fromAdmin(admin);

    }
}
