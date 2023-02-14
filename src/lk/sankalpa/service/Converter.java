package lk.sankalpa.service;

import lk.sankalpa.dto.*;
import lk.sankalpa.entity.*;

public class Converter {

    public OrderDetails toOrderDetails(OrderDetailsDTO orderDetailsDTO){
        return new OrderDetails(orderDetailsDTO.getOrder_Id(), orderDetailsDTO.getItem_Id(),
                orderDetailsDTO.getP_Id(),orderDetailsDTO.getQty(), orderDetailsDTO.getCost(), orderDetailsDTO.getDate());
    }

    public AdminDTO fromAdmin(Admin admin){
        return new AdminDTO(admin.getName(), admin.getNic(), admin.getUser_name(), admin.getPassword());
    }

    public Admin toAdmin(AdminDTO adminDTO){
        return new Admin(adminDTO.getName(), adminDTO.getNic(), adminDTO.getUser_name(), adminDTO.getPassword());
    }

    public ManagerDTO fromManager(Manager manager){
        return new ManagerDTO(manager.getNic(), manager.getName(), manager.getUser_name(), manager.getPassword());
    }
    public Manager toManager(ManagerDTO managerDTO){
        return new Manager(managerDTO.getName(), managerDTO.getNic(), managerDTO.getUser_name(), managerDTO.getPassword());

    }

    public Employee toEmployee(EmployeeDTO employeeDTO){
        return new Employee(employeeDTO.getName(), employeeDTO.getNIC(), employeeDTO.getAddress(), employeeDTO.getNumber(),
                employeeDTO.getAge(), employeeDTO.getSalary(), employeeDTO.getJoinDate(), employeeDTO.getWorkSection());
    }

    public EmployeeDTO fromEmployee(Employee employee){
        return new EmployeeDTO(employee.getName(), employee.getNIC(), employee.getAddress(), employee.getNumber(), employee.getAge(),
                employee.getSalary(), employee.getJoinDate(), employee.getWorkSection());
    }

    public Stock toStock(StockDTO stockDTO){
        return new Stock(stockDTO.getId(), stockDTO.getDescrption(), stockDTO.getDate(),stockDTO.getQTY(), stockDTO.getUnitPrice());
    }

    public StockDTO fromStock(Stock stock){
        return new StockDTO(stock.getId(), stock.getDescrption(), stock.getDate(), stock.getQTY(), stock.getUnitPrice());
    }

    public Projects toProjects(ProjectDTO projectDTO){
        return new Projects( projectDTO.getId(),projectDTO.getName(), projectDTO.getCost(),projectDTO.getNic());
    }

    public ProjectDTO fromProject(Projects projects){
        return new ProjectDTO(projects.getP_id(), projects.getP_Name(), projects.getP_Cost(), projects.getP_O_NIC());
    }

    public Project_Owners toProject_Owner(P_OwnerDTO p_ownerDTO){
        return new Project_Owners(p_ownerDTO.getName(), p_ownerDTO.getNic(), p_ownerDTO.getAddress(), p_ownerDTO.getNumber());
    }

    public P_OwnerDTO fromP_Owner(Project_Owners project_owners){
        return new P_OwnerDTO(project_owners.getName(), project_owners.getNIC(), project_owners.getAddress(), project_owners.getNumber());
    }

    public Income toIncome(IncomeDTO incomeDTO){
        return new Income(incomeDTO.getIncomeId(), incomeDTO.getPaymentId(), incomeDTO.getDate());
    }

    public IncomeDTO fromIncome(Income income){
        return new IncomeDTO(income.getIncomeId(), income.getPaymentId(), income.getDate());
    }

    public Payment toPayments(PaymentDTO paymentDTO){
        return new Payment(paymentDTO.getPayment_Id(), paymentDTO.getPayment_Owner_NIC(), paymentDTO.getPayment_Price(), paymentDTO.getPayment_Date());
    }

    public PaymentDTO fromPayment(Payment payment){
        return new PaymentDTO(payment.getPayment_Id(), payment.getPayment_Owner_NIC(), payment.getPayment_Price(), payment.getPayment_Date());
    }

//    public Orders toOrders(OrderDTO orderDTO){
//        return new Orders(orderDTO.getItem_Id(), orderDTO.getOrder_Set_Date(), orderDTO.getQTY_Used(), orderDTO.getTotal(), orderDTO.getDescription(), orderDTO.getUnitPrice());
//    }

    public OrderDTO fromOrders(Orders orders){
        return new OrderDTO(orders.getO_Id(), orders.getOrder_Set_Date(), orders.getQTY_Used(), orders.getCost(), orders.getP_Owner_NIC(), orders.getP_Id()
                , orders.getItem_Id(), orders.getDescription());
    }

    public Orders toOrders(OrderDTO orderDTO){
        return new Orders(orderDTO.getO_Id(), orderDTO.getOrder_Set_Date(), orderDTO.getQTY_Used(), orderDTO.getCost(), orderDTO.getP_Owner_NIC(), orderDTO.getP_Id()
        , orderDTO.getItem_Id(), orderDTO.getDescription());
    }
}
