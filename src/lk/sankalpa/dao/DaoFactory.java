package lk.sankalpa.dao;

import lk.sankalpa.dao.Custom.impl.*;

import java.sql.Connection;

public class DaoFactory {

    private static DaoFactory daoFactory ;
    private DaoFactory() {
    }

    public static DaoFactory getInstance(){

        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }

public <T extends SuperDao>T getDAO(Connection connection, DaoType daoType){

        switch (daoType){
            case ADMIN:return (T)new AdminDaoImpl(connection);
            case STOCK:return (T)new StockDaoImpl(connection);
            case INCOME:return (T) new IncomDaoImpl(connection);
            case MANAGER:return (T) new ManagerDaoImpl(connection);
            case EMPLOYEE:return (T) new EmployeeDaoImpl(connection);
            case ORDERS:return (T) new OrderDaoImpl(connection);
            case ORDERDETAILS:return (T) new OrderDetailsDaoImpl(connection);
            case PAYMENTS:return (T) new PaymentDaoImpl(connection);
            case PROJECT_OWNER:return (T) new ProjectownerDaoImpl(connection);
            case PROJECTS:return (T)new ProjectDaoImpl(connection);



            default:return null;
        }

}

}
