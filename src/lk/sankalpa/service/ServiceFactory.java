package lk.sankalpa.service;

import lk.sankalpa.service.custome.impl.*;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceType serviceType) {
        switch (serviceType){
            case ADMIN:return  (T)new AdminServiceImpl();

            case MANAGER:return (T) new ManagerServerImpl();

            case EMPLOYEE:return (T) new EmployeeServiceImpl();

            case STOCK:return (T) new StockServiceImpl();

            case PROJECT:return (T) new ProjectServiceImpl();

            case PROJECT_OWNER:return (T) new ProjectOwnerServiceImpl();

            case INCOME:return (T) new IncomeServiceImpl();

            case PAYMENTS:return (T) new PaymentServiceImpl();

            case ORDERS:return (T) new OrderServiceImpl();

            case ORDER_DETAILS:return (T) new OrderDetailsServiceImpl();

            default:return null;
        }

    }
}
