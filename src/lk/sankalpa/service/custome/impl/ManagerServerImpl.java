package lk.sankalpa.service.custome.impl;

import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dao.Custom.ManagerDao;
import lk.sankalpa.dao.DaoFactory;
import lk.sankalpa.dao.DaoType;
import lk.sankalpa.dto.ManagerDTO;
import lk.sankalpa.entity.Manager;
import lk.sankalpa.service.Converter;
import lk.sankalpa.service.custome.ManagerServer;

import java.sql.Connection;

public class ManagerServerImpl implements ManagerServer {

    private ManagerDao managerDao;
    private Connection connection;
    private  Converter convertor;
    public ManagerServerImpl() {
        connection= DBConnection.getInstance().getConnection();
        managerDao = DaoFactory.getInstance().getDAO(connection, DaoType.MANAGER);
        convertor=new Converter();
    }

    @Override
    public ManagerDTO saveManager(ManagerDTO managerDTO) {

        managerDao.save(convertor.toManager(managerDTO));
        return managerDTO;

    }

    @Override
    public ManagerDTO updateManager(ManagerDTO managerDTO) {

        managerDao.update(convertor.toManager(managerDTO));
        return managerDTO;
    }

    @Override
    public ManagerDTO searchManager(String nic) {

        Manager search = managerDao.search(nic);
        return convertor.fromManager(search);

    }

    @Override
    public ManagerDTO login(String username) {

        Manager login = managerDao.login(username);
        return convertor.fromManager(login);

    }
}
