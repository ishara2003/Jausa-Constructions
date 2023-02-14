package lk.sankalpa.Util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {

    public static AnchorPane pane;

    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage)Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;

            case CREATE_ACCOUNT:
                window.setTitle("Create account From");
                initUI("CreateAccount.fxml");
                break;

            case CHEANGE_PASSWORD:
                window.setTitle("Cheange Password Form");
                initUI("FogotPasswordForm.fxml");
                break;

            case MAIN_FROM:
                window.setTitle("MainForm");
                initUI("MainForm.fxml");
                break;

            case ADMIN_FROM:
                window.setTitle("Admin Form");
                initUI("AdminManageForm.fxml");
                break;

            case MANAGER_FORM:
                window.setTitle("Manager Form");
                initUI("ManagerForm.fxml");
                break;

            case STOCK_MANAGE:
                window.setTitle("Stock Manage");
                initUI("StockManageForm.fxml");
                break;

            case ORDERS_MANAGE:
                window.setTitle("Manage Orders");
                initUI("OrderManageForm.fxml");
                break;

            case PROJECT_OWNER_MANAGE:
                window.setTitle("Manage project owners");
                initUI("P_Owner_ManageForm.fxml");
                break;

            case PROJECTS:
                window.setTitle("Project Manage Form");
                initUI("ProjectForm.fxml");
                break;

            case INCOME:
                window.setTitle("Income Form");
                initUI("incomeForm.fxml");
                break;

            case PAYMENTS:
                window.setTitle("Payment Form");
                initUI("paymentForm.fxml");
                break;

            case ORDER_DETAILS:
                initUI("OrderDetailsForm.fxml");
                break;

            case ADMIN_PROJECT_OWNER_MANAGE:
                initUI("AdminProjectOwnerForm.fxml");
                break;

            case ADMIN_INCOME_FROM:
                initUI("AdminIncomeForm.fxml");
                break;

            case ADMIN_PROJECT_MANAGE:
                initUI("AdminProjectForm.fxml");
                break;

            case EMPLOYEE:
                initUI("EmployeeForm.fxml");
                break;

            default:
                new Alert(Alert.AlertType.ERROR, "UI Not Found!").show();
        }
    }
    public static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/sankalpa/view/" + location)));
    }

}
