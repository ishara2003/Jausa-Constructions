package lk.sankalpa.controller;

import com.jfoenix.controls.JFXHamburger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dto.PaymentDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.PaymentService;
import lk.sankalpa.tm.PaymentTM;
import lk.sankalpa.to.Payment;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentFormController {

    public PaymentService paymentService;


    public void initialize(){

        paymentService= ServiceFactory.getInstance().getService(ServiceType.PAYMENTS);

        MenuTranslater.setTranslater(hbMenu,hbCloseOnAction,ManagerMenu);
        lblDetails.setCursor(Cursor.HAND);
        lblEmployee.setCursor(Cursor.HAND);
        lblStock.setCursor(Cursor.HAND);
        lblIncome.setCursor(Cursor.HAND);
        lblOrders.setCursor(Cursor.HAND);
        lblReport.setCursor(Cursor.HAND);
        lblPayments.setCursor(Cursor.HAND);
        lblProject.setCursor(Cursor.HAND);
        lblManager.setCursor(Cursor.HAND);
        hbMenu.setCursor(Cursor.HAND);
        hbCloseOnAction.setCursor(Cursor.HAND);

        colPaymentId.setCellValueFactory(new PropertyValueFactory<PaymentTM,String>("payment_Id"));
        colPaymentNIC.setCellValueFactory(new PropertyValueFactory<>("payment_Date"));
        colPaymentPrice.setCellValueFactory(new PropertyValueFactory<>("payment_Owner_NIC"));
        colPaymentDate.setCellValueFactory(new PropertyValueFactory<>("payment_Price"));


        loadAllPayments();
        setPaymentId();
    }

    @FXML
    private AnchorPane paymentPane;

    @FXML
    private TextField txtPaymentId;

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
    private Label lblDetails;

    @FXML
    private TextField txtPaymentNIC;

    @FXML
    private TextField txtPaymentPrice;

    @FXML
    private TextField txtPaymentDate;

    @FXML
    private TableView<PaymentTM> tblPayment;

    @FXML
    private TableColumn<PaymentTM, String> colPaymentId;

    @FXML
    private TableColumn<?, ?> colPaymentNIC;

    @FXML
    private TableColumn<?, ?> colPaymentPrice;

    @FXML
    private TableColumn<?, ?> colPaymentDate;

    @FXML
    private Button btnAddPayment;

    @FXML
    void AddPaymentOnAction(ActionEvent event) {

        String id = txtPaymentId.getText();
        String nic = txtPaymentNIC.getText();
        String price = txtPaymentPrice.getText();
        String date = txtPaymentDate.getText();

        if(paymentService.savePayment(new PaymentDTO(id,nic,price,date))!=null){
            JOptionPane.showMessageDialog(null,"Added Success");
            loadAllPayments();
        }else {
            JOptionPane.showMessageDialog(null,"Added UnSuccess");
            loadAllPayments();}

//        Payment payment=new Payment(id,nic,price,date);
//
//        try {
//            boolean isadded= PaymnetModel.addPaymetn(payment);
//
//            if(isadded){
//                JOptionPane.showMessageDialog(null,"Added Success");
//                loadAllPayments();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }


    }

    @FXML
    void baackToOrderManage(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,paymentPane);
    }

    @FXML
    void backToDetailsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDER_DETAILS,paymentPane);
    }

    @FXML
    void backToEmployeeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,paymentPane);
    }

    @FXML
    void backToIncomeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME,paymentPane);
    }

    @FXML
    void backToManagerForm(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGER_FORM,paymentPane);
    }

    @FXML
    void backToPaymentOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECT_OWNER_MANAGE,paymentPane);
    }

    @FXML
    void backToProjectsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECTS,paymentPane);
    }

    @FXML
    void backToReportOnAction(MouseEvent event) {
       // Navigation.navigate(Routes.EMPLOYEE,paymentPane);
    }

    @FXML
    void backToStockOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.STOCK_MANAGE,paymentPane);
    }


    public ArrayList<Payment> loadAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = CrudUtil.execute("SELECT * FROM payments");
        ArrayList<Payment> list= new ArrayList<>();
        while (resultSet.next()){
            list.add(new Payment(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4)));
        }
        return list;
    }


    private void loadAllPayments() {

        List<PaymentTM> collect = paymentService.allPayment().stream().map(paymentDTO ->
                new PaymentTM(paymentDTO.getPayment_Id(), paymentDTO.getPayment_Owner_NIC(), paymentDTO.getPayment_Price(), paymentDTO.getPayment_Date())).collect(Collectors.toList());

        tblPayment.setItems(FXCollections.observableArrayList(collect));

//        ObservableList<PaymentTM> obList = FXCollections.observableArrayList();
//        try {
//            for (Payment c : loadAll()) {
//                PaymentTM tm = new PaymentTM(c.getPayment_Id(),c.getPayment_Owner_NIC(),c.getPayment_Price(),c.getPayment_Date());
//
//                obList.add(tm);
//                tblPayment.setItems(obList);
// }
//        }catch (SQLException | ClassNotFoundException e){
//            System.out.println(e);
//        }
    }

    public void setPaymentId() {
        try {
            String sql = "SELECT Id FROM `payments` ORDER BY Id DESC LIMIT 1;"; // 10 not working... (UNSIGNED)
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tempOrderId = resultSet.getString(1);
                //  String[] array = tempOrderId.split("0");//[D,3]
                int tempNumber = Integer.parseInt(tempOrderId);
                int finalizeOrderId = tempNumber + 1;
                txtPaymentId.setText("00" + finalizeOrderId);
            } else {
                txtPaymentId.setText("001");
            }
        } catch (SQLException ex) {


        }
    }

}
