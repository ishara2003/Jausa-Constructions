package lk.sankalpa.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.layout.AnchorPane;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;

import java.io.IOException;

public class ManagerFormController {



    public void initialize(){

        tbn_P_O_M.setCursor(Cursor.HAND);
        btn_Employee.setCursor(Cursor.HAND);
        btn_Income.setCursor(Cursor.HAND);
        btn_P_M.setCursor(Cursor.HAND);
        btn_Payment.setCursor(Cursor.HAND);
        btn_Report.setCursor(Cursor.HAND);
        btn_Stock.setCursor(Cursor.HAND);
        btnOrder_Details.setCursor(Cursor.HAND);
        btnOrders_For_Unique_Project.setCursor(Cursor.HAND);

    }

    public AnchorPane ManagerForm;
    public JFXButton btnOrders_For_Unique_Project;
    public JFXButton btnOrder_Details;
    @FXML
    private JFXButton tbn_P_O_M;

    @FXML
    private JFXButton btn_P_M;

    @FXML
    private JFXButton btn_Payment;

    @FXML
    private JFXButton btn_Income;

    @FXML
    private JFXButton btn_Employee;

    @FXML
    private JFXButton btn_Stock;

    @FXML
    private JFXButton btn_Report;

    @FXML
    void EmployeeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,ManagerForm);
    }

    @FXML
    void IncomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME,ManagerForm);
    }

    @FXML
    void Payment_ManageOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,ManagerForm);
    }

    @FXML
    void Project_ManageOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECTS,ManagerForm);
    }

    @FXML
    void ReportOnAction(ActionEvent event) {

    }

    @FXML
    void StockOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STOCK_MANAGE,ManagerForm);
    }

    @FXML
    void p_Ownser_ManageOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECT_OWNER_MANAGE,ManagerForm);
    }

    public void btnOrders_For_Unique_ProjectOnAction(ActionEvent actionEvent) throws IOException {

        Navigation.navigate(Routes.ORDERS_MANAGE,ManagerForm);

    }

    public void btnOrder_DetailsOnAction(ActionEvent actionEvent) throws IOException {
Navigation.navigate(Routes.ORDER_DETAILS,ManagerForm);
    }
}
