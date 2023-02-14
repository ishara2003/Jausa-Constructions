package lk.sankalpa.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dto.OrderDTO;
import lk.sankalpa.dto.P_OwnerDTO;
import lk.sankalpa.dto.ProjectDTO;
import lk.sankalpa.dto.StockDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.OrderService;
import lk.sankalpa.service.custome.ProjectOwnerService;
import lk.sankalpa.service.custome.ProjectService;
import lk.sankalpa.service.custome.StockService;
import lk.sankalpa.tm.OrderTm;
import lk.sankalpa.to.Orders;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderManageFormController {

    public TextField txtProjectName;

    //==================================================================================================================================
//    public ArrayList<Stock> loadAllD() throws SQLException, ClassNotFoundException {
//
//        ResultSet resultSet = CrudUtil.execute("SELECT * FROM stock");
//        ArrayList<Stock> list= new ArrayList<>();
//        while (resultSet.next()){
//            list.add(new Stock(resultSet.getString(1),resultSet.getString(2),
//                    resultSet.getString(3),resultSet.getString(4),resultSet.getDouble(5)));
//        }
//        return list;
//    }
//
//    private void loadAllStockItems() {
//
//        ObservableList<StockTM> obList = FXCollections.observableArrayList();
//        try {
//            for (Stock c : loadAllD()) {
//                StockTM tm = new StockTM(c.getId(), c.getDescrption(), c.getDate(), c.getQTY(),c.getUnitPrice());
//
//                obList.add(tm);
//                tblTry.setItems(obList);
//         }
//        }catch (SQLException | ClassNotFoundException e){
//            System.out.println(e);
//        }
//    }

    //==================================================================================================================================


    public Label lblManagerForm;
    public TableView tblOrders;
    public TableColumn colDate;
    public TextField txtUnite_Price;
    public TextField txtP_Owner_Name;
    public TextField ItemName;
    public TextField qtyAvailable;
    public TableView tblTry;
    public TableColumn colDESC;
    public StockService stockService;
    public OrderService orderService;
    public ProjectOwnerService projectOwnerService;

    public ProjectService projectService;

    public OrderManageFormController() throws SQLException, ClassNotFoundException {
    }

    public void initialize() {

        projectService=ServiceFactory.getInstance().getService(ServiceType.PROJECT);
        projectOwnerService=ServiceFactory.getInstance().getService(ServiceType.PROJECT_OWNER);
        orderService=ServiceFactory.getInstance().getService(ServiceType.ORDERS);
        stockService= ServiceFactory.getInstance().getService(ServiceType.STOCK);

        MenuTranslater.setTranslater(hmbMain, hmbMainClose, slider);
        hmbMain.setCursor(Cursor.HAND);
        hmbMainClose.setCursor(Cursor.HAND);
        lblDetails.setCursor(Cursor.HAND);
        lblEmployee.setCursor(Cursor.HAND);
        lblStock.setCursor(Cursor.HAND);
        lblIncome.setCursor(Cursor.HAND);
        lblP_Owners.setCursor(Cursor.HAND);
        lblReport.setCursor(Cursor.HAND);
        lblPayments.setCursor(Cursor.HAND);
        lblProject.setCursor(Cursor.HAND);
        lblManagerForm.setCursor(Cursor.HAND);


        tblItem_d.setCellValueFactory(new PropertyValueFactory<OrderTm, String>("Item_Id"));
        tblDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        tblQTY.setCellValueFactory(new PropertyValueFactory<>("QTY_Used"));
        tblPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        tblTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("order_Set_Date"));

        loadAllOrders();
        setOrderId();

        //setP_Onwer_NIC();
        //setUnitPrice();

        slider.setVisible(true);
    }

    public AnchorPane OrderManageForm;
    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXTextField txtP_Owner_NIC;

    @FXML
    private JFXTextField txtItem_Id;

    @FXML
    private JFXTextField txtQTY;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private TableColumn<OrderTm, String> tblItem_d;

    @FXML
    private TableColumn<?,? > tblDescription;

    @FXML
    private TableColumn<?, ?> tblQTY;

    @FXML
    private TableColumn<?, ?> tblPrice;

    @FXML
    private TableColumn<?, ?> tblTotal;

    @FXML
    private JFXButton btnReloard;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXHamburger hmbMain;

    @FXML
    private Pane slider;

    @FXML
    private JFXHamburger hmbMainClose;

    @FXML
    private Label lblOrderId;

    @FXML
    private JFXTextField txtProject_Id;

//======================================================================================================================

    public ArrayList<Orders> loadAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = CrudUtil.execute("SELECT * FROM orders_for_unique_project");
        ArrayList<Orders> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(new Orders(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getInt(3),
                    resultSet.getDouble(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8)
            ));
        }
        return list;
    }

    private void loadAllOrders() {

//        List<OrderTm> collect = orderService.allOrders().stream().map(orders ->
//                new OrderTm(orders.getItem_Id(),
//                        orders.getDescription(),
//                        orders.getQTY_Used(),
//                        orders.getUnitPrice(),
//                        orders.getQTY_Used()*
//                                orders.getUnitPrice(),
//                        orders.getOrder_Set_Date())).
//                        collect(Collectors.toList());
//
//        tblOrders.setItems(FXCollections.observableArrayList(collect));



        ObservableList<OrderTm> obList = FXCollections.observableArrayList();
        try {
            for (Orders c : loadAll()) {
                double Total = c.getQTY_Used() * c.getCost();

                //String description= ItemName.getText();

                OrderTm tm = new OrderTm(c.getO_Id(), c.getDescription(), c.getQTY_Used(), c.getCost(), Total, c.getOrder_Set_Date());

                obList.add(tm);
                tblOrders.setItems(obList);

            }
        } catch (SQLException | ClassNotFoundException | NumberFormatException e) {
            e.printStackTrace();
        }
    }


//======================================================================================================================

    public void setUnitPrice(){

        StockDTO stockDTO = stockService.searchItemById(txtItem_Id.getText());

        if(stockDTO!=null){

            //txtDate.setText(stockDTO.getDate());
            txtUnite_Price.setText(String.valueOf(stockDTO.getUnitPrice()));
            ItemName.setText(stockDTO.getDescrption());
            qtyAvailable.setText(stockDTO.getQTY());
        }else {
            JOptionPane.showMessageDialog(null,"Item Is Not Found ");
        }

//        try {
//           // Stock stock=OrdersModel.searchunitPrice(txtItem_Id.getText());
//            Stock stock1 = StockModel.SearchItems(txtItem_Id.getText());
//            if(stock1!=null){
//                txtUnite_Price.setText(String.valueOf(stock1.getUnitPrice()));
//                ItemName.setText(stock1.getDescrption());
//                qtyAvailable.setText(stock1.getQTY());
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//
//        }
    }
    public void setProjectName(){

        ProjectDTO projectDTO = projectService.searchProject(txtProject_Id.getText());
        if(projectDTO!=null){
            txtProjectName.setText(projectDTO.getName());
            txtP_Owner_NIC.setText(projectDTO.getNic());


            P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(txtP_Owner_NIC.getText());
            txtP_Owner_Name.setText(p_ownerDTO.getName());
        }else{
            JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
        }
//
//        try {
//
//            Projects projects1 = ProjectsModel.SearchProjects(txtProject_Id.getText());
//            if(projects1!=null){
//                txtProjectName.setText(projects1.getP_Name());
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//
//        }
    }
    public void setP_Onwer_NIC(){

        P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(txtP_Owner_NIC.getText());

        if(p_ownerDTO!=null){
            txtP_Owner_Name.setText(p_ownerDTO.getName());

        }else {
            JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
        }

//        try {
//
//            Project_Owners projectOwners1 = P_OwnerModel.searchP_Owner(txtP_Owner_NIC.getText());
//            if(projectOwners1!=null){
//                txtP_Owner_Name.setText(projectOwners1.getName());
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//
//            System.out.println(e);
//        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException {

        double unitPrice = Double.parseDouble(txtUnite_Price.getText());
        int qty=Integer.parseInt(txtQTY.getText());
        //double total = Double.parseDouble(String.valueOf(qty*unitPrice));

        String P_Id = txtProject_Id.getText();
        String item_Id = txtItem_Id.getText();
        String P_OwnerNIC = txtP_Owner_NIC.getText();
        String date=txtDate.getText();
        String O_Id=lblOrderId.getText();
        String description=ItemName.getText();

        if(Integer.parseInt(txtQTY.getText())<=Integer.parseInt(qtyAvailable.getText())){

                Connection connections = null;
            try {

                OrderDTO orderDTO = orderService.saveOrder(new OrderDTO(O_Id, date, qty, unitPrice, P_OwnerNIC, P_Id, item_Id, description));

                connections = DBConnection.getInstance().getConnection();
                connections.setAutoCommit(false);
                if (orderDTO != null) {
                    JOptionPane.showMessageDialog(null, "Order Added Successfully");

//                    loadAllOrders();

                } else {
                    new Alert(null, "Error");
                    connections.rollback();
                }

                boolean b = orderService.qtyUpdate(item_Id, qty);
                if (b) {

                    JOptionPane.showMessageDialog(null, "Order Added Successfully");
                    connections.commit();
                    loadAllOrders();
                    setOrderId();
                    setUnitPrice();
                    setOrderId();
                } else {

                }

            } catch (SQLException e) {
            }finally {
               // connections.rollback();
                connections.setAutoCommit(true);
            }
            // orderService.saveOrder(new OrderDTO(O_Id,date,qty,unitPrice,P_OwnerNIC,P_Id,item_Id,description),item_Id,qty);

//            Orders orders=new Orders(O_Id,date,qty,unitPrice,P_OwnerNIC,P_Id,item_Id,description);
//
//            Connection connection=null;
//            try {
//                connection=DBConnection.getInstance().getConnection();
//                connection.setAutoCommit(false);
//
//                boolean isadded= OrdersModel.AddOrder(orders);
//
//                if(isadded){
//                    JOptionPane.showMessageDialog(null,"Order Added Successfully");
//
//                    loadAllOrders();
//                    setOrderId();
//                }else{
//                    connection.rollback();
//                }
//            } catch (SQLException | ClassNotFoundException | NumberFormatException e) {
//
//                System.out.println(e);
//            }
//            try {
//
//                boolean isadad=OrdersModel.editQTY(item_Id,qty);
//                if(isadad){
//                    connection.commit();
//                }
//            } catch (SQLException | ClassNotFoundException e) {
//            }finally {
//                connection.rollback();
//                connection.setAutoCommit(true);
//            }
//
//

        }else {
            JOptionPane.showMessageDialog(null,"Out Of Stock Or Stock Dose Not Have That Much Quantity","Worrnin",JOptionPane.WARNING_MESSAGE);
        }
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {

    }

    @FXML
    void btnReloardOnAction(ActionEvent event) {

    }

    @FXML
    void backToStock(MouseEvent event) throws IOException {

        Navigation.navigate(Routes.STOCK_MANAGE, OrderManageForm);

    }


    public void backToManagerForm(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.MANAGER_FORM, OrderManageForm);

    }

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
    private Label lblP_Owners;

    @FXML
    private Label lblEmployee;

    @FXML
    private Label lblDetails;

    @FXML
    void backToDetaisOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,OrderManageForm);
    }

    @FXML
    void backToEmployeesOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,OrderManageForm);
    }

    @FXML
    void backToIncomeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME, OrderManageForm);

    }

    @FXML
    void backToP_OwnersOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECT_OWNER_MANAGE, OrderManageForm);
    }

    @FXML
    void backToPaymentsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,OrderManageForm);
    }

    @FXML
    void backToProjectsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECTS, OrderManageForm);
    }

    @FXML
    void backToReportOnAction(MouseEvent event) {

    }
    //================================================Order Id Genarate====================================================
    public void setOrderId() {
        try {
        String sql = "SELECT Oreder_Id FROM `orders_for_unique_project` ORDER BY Oreder_Id DESC LIMIT 1;"; // 10 not working... (UNSIGNED)
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tempOrderId = resultSet.getString(1);
              //  String[] array = tempOrderId.split("0");//[D,3]
                int tempNumber = Integer.parseInt(tempOrderId);
                int finalizeOrderId = tempNumber + 1;
                lblOrderId.setText("00" + finalizeOrderId);
            } else {
                lblOrderId.setText("001");
            }
        } catch (SQLException ex) {


    }
}

    public void cmP_Owner_Name(ActionEvent actionEvent) {

        setP_Onwer_NIC();
    }

    public void P_Owner_NIC(KeyEvent keyEvent) {
        setP_Onwer_NIC();

    }

    public void UnitPriceOnReleased(KeyEvent keyEvent) {
        setUnitPrice();
    }

    public void PNameOnAction(KeyEvent keyEvent) {
        setProjectName();
    }


//================================================Order Id Genarate Ends====================================================
}
