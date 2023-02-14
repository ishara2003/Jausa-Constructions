package lk.sankalpa.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;

import java.io.IOException;

public class AdminManageFormController {

    public AnchorPane AdminForm;
    @FXML
    private JFXButton tbn_P_O_M;

    @FXML
    private JFXButton btn_P_M;

    @FXML
    private JFXButton btn_Payment;

    @FXML
    private JFXButton btn_Income;

    @FXML
    private JFXButton btn_Report;

    @FXML
    void IncomeOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMIN_INCOME_FROM,AdminForm);
    }

    @FXML
    void Payment_ManageOnAction(ActionEvent event) {

    }

    @FXML
    void Project_ManageOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMIN_PROJECT_MANAGE,AdminForm);
    }

    @FXML
    void ReportOnAction(ActionEvent event) throws IOException {
    Navigation.navigate(Routes.REPORT,AdminForm);
    }

    @FXML
    void p_Ownser_ManageOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.ADMIN_PROJECT_OWNER_MANAGE,AdminForm);
    }

}
