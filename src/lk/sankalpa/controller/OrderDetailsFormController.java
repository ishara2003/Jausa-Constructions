package lk.sankalpa.controller;

import com.jfoenix.controls.JFXHamburger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dto.*;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class OrderDetailsFormController {

    public Button btnSave;
    public Button btnPreView;

    public StockService stockService;
    public OrderDetailsService orderDetailsService;
    public ProjectOwnerService projectOwnerService;
    public ProjectService projectService;
    public OrderService orderService;

    public void initialize(){

        orderService=ServiceFactory.getInstance().getService(ServiceType.ORDERS);
        projectService=ServiceFactory.getInstance().getService(ServiceType.PROJECT);
        projectOwnerService=ServiceFactory.getInstance().getService(ServiceType.PROJECT_OWNER);
        orderDetailsService=ServiceFactory.getInstance().getService(ServiceType.ORDER_DETAILS);
        stockService= ServiceFactory.getInstance().getService(ServiceType.STOCK);
        MenuTranslater.setTranslater(hbMenu,hbCloseOnAction,ManagerMenu);
        lblP_Owner.setCursor(Cursor.HAND);
        lblEmployee.setCursor(Cursor.HAND);
        lblStock.setCursor(Cursor.HAND);
        lblOrders.setCursor(Cursor.HAND);
        lblIncome.setCursor(Cursor.HAND);
        lblReport.setCursor(Cursor.HAND);
        lblPayments.setCursor(Cursor.HAND);
        lblProject.setCursor(Cursor.HAND);
        lblManager.setCursor(Cursor.HAND);
        hbMenu.setCursor(Cursor.HAND);
        hbCloseOnAction.setCursor(Cursor.HAND);


    }
    @FXML
    private AnchorPane OrderDetailsPnae;

    @FXML
    private TextField txtP_Id;

    @FXML
    private TextField txtP_Owner_NIC;

    @FXML
    private TextField txtItemId;

    @FXML
    private TextField txtOrderId;

    @FXML
    private TextField txtP_Name;

    @FXML
    private TextField txtP_Cost;

    @FXML
    private TextField txtP_O_Name;

    @FXML
    private TextField txtP_O_Address;

    @FXML
    private TextField txtP_O_Number;

    @FXML
    private TextField txtItem_Name;

    @FXML
    private TextField txtItem_Price;

    @FXML
    private TextField txtxOrdere_Date;

    @FXML
    private TextField txtxOrdere_QTY;

    @FXML
    private TextField txtxOrdere_Cost;

    @FXML
    private JFXHamburger hbMenu;

    @FXML
    private Pane ManagerMenu;

    @FXML
    private Label lblManager;

    @FXML
    private JFXHamburger hbCloseOnAction;

    @FXML
    private Label lblStock;

    @FXML
    private Label lblProject;

    @FXML
    private Label lblPayments;

    @FXML
    private Label lblIncome;

    @FXML
    private Label lblReport;

    @FXML
    private Label lblOrders;

    @FXML
    private Label lblEmployee;

    @FXML
    private Label lblP_Owner;

    @FXML
    void baackToOrderManage(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,OrderDetailsPnae);
    }

    @FXML
    void backToDetailsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECT_OWNER_MANAGE,OrderDetailsPnae);
    }

    @FXML
    void backToEmployeeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,OrderDetailsPnae);
    }

    @FXML
    void backToIncomeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME,OrderDetailsPnae);
    }

    @FXML
    void backToManagerForm(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGER_FORM,OrderDetailsPnae);
    }

    @FXML
    void backToPaymentOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,OrderDetailsPnae);
    }

    @FXML
    void backToProjectsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECTS,OrderDetailsPnae);
    }

    @FXML
    void backToReportOnAction(MouseEvent event) {

    }

    @FXML
    void backToStockOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.STOCK_MANAGE,OrderDetailsPnae);
    }



    public void setItemDetailsOnAction(KeyEvent keyEvent) {



    }

    public void setOrderDetailsOnActoin(KeyEvent keyEvent) {

        OrderDTO order = orderService.searchOrderById(txtOrderId.getText());

        if(order!=null){
            txtxOrdere_Date.setText(order.getOrder_Set_Date());
            txtxOrdere_QTY.setText(String.valueOf(order.getQTY_Used()));
            txtxOrdere_Cost.setText(String.valueOf(order.getCost()));
            txtP_Id.setText(order.getP_Id());
            txtItemId.setText(order.getItem_Id());
        }

//        try {
//           // Orders orders= OrdersDetailsModel.OrderDetails(txtOrderId.getText());
//            Orders orders1 = OrdersModel.OrderDetails(txtOrderId.getText());
//
//            if(orders1!=null) {
//                txtxOrdere_Date.setText(orders1.getOrder_Set_Date());
//                txtxOrdere_QTY.setText(String.valueOf(orders1.getQTY_Used()));
//                txtxOrdere_Cost.setText(String.valueOf(orders1.getCost()));
//                txtP_Id.setText(orders1.getP_Id());
//                txtItemId.setText(orders1.getItem_Id());
//            }else {
//               // JOptionPane.showMessageDialog(null,"Item Is Not Found ");
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }

        ProjectDTO projects = projectService.searchProject(txtP_Id.getText());

        if(projects!=null){
            txtP_Name.setText(projects.getName());
            txtP_Cost.setText(String.valueOf(projects.getCost()));
            txtP_Owner_NIC.setText(projects.getNic());
        }else{
            JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
        }

//        try {
//
//            Projects projects = ProjectsModel.SearchProjects(txtP_Id.getText());
//            if(projects!=null){
//
//                txtP_Name.setText(projects.getP_Name());
//                txtP_Cost.setText(String.valueOf(projects.getP_Cost()));
//                txtP_Owner_NIC.setText(projects.getP_O_NIC());
//               // txtOrderId.setText(projects.g);
//            }else{
//                //JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//
//        }

        P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(txtP_Owner_NIC.getText());

        if(p_ownerDTO!=null){
            txtP_O_Name.setText(p_ownerDTO.getName());
            txtP_O_Address.setText(p_ownerDTO.getAddress());
            txtP_O_Number.setText(p_ownerDTO.getNumber());
        }else {
            JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
        }

//        try {
//            Project_Owners projectOwners= P_OwnerModel.searchP_Owner(txtP_Owner_NIC.getText());
//            if (projectOwners != null) {
//                txtP_O_Name.setText(projectOwners.getName());
//                txtP_O_Address.setText(projectOwners.getAddress());
//                txtP_O_Number.setText(projectOwners.getNumber());
//            }else {
//                // JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }

        StockDTO stockDTO = stockService.searchItemById(txtItemId.getText());

        if(stockDTO!=null){

            txtItem_Name.setText(stockDTO.getDescrption());
            txtItem_Price.setText(String.valueOf(stockDTO.getUnitPrice()));
        }else {
            JOptionPane.showMessageDialog(null,"Item Is Not Found ");
        }
    }
    public void setP_detailsOnAction(KeyEvent keyEvent) {


            ProjectDTO projectDTO = projectService.searchProject(txtP_Id.getText());
            if(projectDTO!=null){
                txtOrderId.setText(projectDTO.getId());
                txtP_Name.setText(projectDTO.getName());
                txtP_Owner_NIC.setText(projectDTO.getNic());
                txtP_Cost.setText(String.valueOf(projectDTO.getCost()));
//            }else{
//                JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
//            }
//
//            Projects projects = ProjectsModel.SearchProjects(txtP_Id.getText());
//            if(projects!=null){
//
//                txtP_Name.setText(projects.getP_Name());
//                txtP_Cost.setText(String.valueOf(projects.getP_Cost()));
//                txtP_Owner_NIC.setText(projects.getP_O_NIC());
//                // txtOrderId.setText(projects.g);

                P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(txtP_Owner_NIC.getText());

                if(p_ownerDTO!=null){
                    txtP_O_Name.setText(p_ownerDTO.getName());
                    txtP_O_Address.setText(p_ownerDTO.getAddress());
                    txtP_O_Number.setText(p_ownerDTO.getNumber());
                }else {
                    JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
                }
//                Project_Owners projectOwners= P_OwnerModel.searchP_Owner(txtP_Owner_NIC.getText());
//                if (projectOwners != null) {
//                    txtP_O_Name.setText(projectOwners.getName());
//                    txtP_O_Address.setText(projectOwners.getAddress());
//                    txtP_O_Number.setText(projectOwners.getNumber());
//                }
            }else{
                JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
            }

    }


    public void saveOnAction(ActionEvent actionEvent) {
        String P_Id = txtP_Id.getText();
        String itemId = txtItemId.getText();
        String O_Id = txtOrderId.getText();
        int qty = Integer.parseInt(txtxOrdere_QTY.getText());
        double cost = Double.parseDouble(txtxOrdere_Cost.getText());
        String date = txtxOrdere_Date.getText();


        if(orderDetailsService.saveDetails(new OrderDetailsDTO(P_Id,itemId,O_Id,qty,cost,date))!=null){
            new Alert(null,"Added Successfully");
        }

//        OrderDetails orderDetails=new OrderDetails(P_Id,itemId,O_Id,qty,cost,date);
//
//        try {
//            boolean b = OrdersDetailsModel.addDetails(orderDetails);
//            if(b) {
//                System.out.println("fsdfs");
//            }
//
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }


    }

    public void PrintOnAction(ActionEvent actionEvent) {
        InputStream inputStream = this.getClass().getResourceAsStream("/lk/sankalpa/repoarts/Jausa Project Orders.jrxml");
        HashMap<String,Object> name=new HashMap<>();
        name.put("Project_Id",txtP_Id.getText());



        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, name, DBConnection.getInstance().getConnection());
             JasperPrintManager.printReport(jasperPrint,true);
            //JasperViewer.viewReport(jasperPrint,false);


        } catch (JRException e) {
            System.out.println(e);
        }
    }


    public void PreViewOnAction(ActionEvent actionEvent) {

        InputStream inputStream = this.getClass().getResourceAsStream("/lk/sankalpa/repoarts/Jausa Project Orders.jrxml");
        HashMap<String,Object> name=new HashMap<>();
        name.put("Project_Id",txtP_Id.getText());



        try {

            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, name, DBConnection.getInstance().getConnection());
            // JasperPrintManager.printReport(jasperPrint,true);
            JasperViewer.viewReport(jasperPrint,false);


        } catch (JRException  e) {
            System.out.println(e);
        }
    }
}
