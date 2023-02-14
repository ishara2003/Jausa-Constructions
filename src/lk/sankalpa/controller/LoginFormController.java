package lk.sankalpa.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.dto.ManagerDTO;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.AdminService;
import lk.sankalpa.service.custome.ManagerServer;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class LoginFormController {


    public JFXRadioButton rBtnAdmin;
    public ToggleGroup login;
    public JFXRadioButton rBtnManager;

    public AdminService adminService;

    public ManagerServer managerServer;

    public void initialize(){

        managerServer=ServiceFactory.getInstance().getService(ServiceType.MANAGER);
        adminService= ServiceFactory.getInstance().getService(ServiceType.ADMIN);
        lblForgetPassword.setCursor(Cursor.HAND);
        lblCreatAccount.setCursor(Cursor.HAND);
        rBtnManager.setCursor(Cursor.HAND);
        rBtnAdmin.setCursor(Cursor.HAND);

    }

    public Button btnLogin;
    @FXML
    private AnchorPane paneLoginForm;
    public Label lblCreatAccount;
    public Label lblForgetPassword;
    public JFXTextField txtUserName;
  public  static boolean isTrue;
    @FXML
    private JFXPasswordField PWpassword;
    public void recreatePassword(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/lk/sankalpa/view/FogotPasswordForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(Boolean.FALSE);
    }
    public void lblCreateAccount(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("/lk/sankalpa/view/CreateAccount.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.resizableProperty().setValue(Boolean.FALSE);
    }

    public void LoginOnAction(ActionEvent actionEvent) throws IOException {

       String un=txtUserName.getText();
        String pw=PWpassword.getText();

        if(rBtnAdmin.isSelected()) {


                if (un.equals("") & pw.equals("")) {

                    JOptionPane.showMessageDialog(null, "Fill the Informations", "Worning", JOptionPane.INFORMATION_MESSAGE);

                }
                if(adminService.logIn(un)!=null){

                    Navigation.navigate(Routes.ADMIN_FROM,paneLoginForm);

                } else {
                    JOptionPane.showMessageDialog(null, "User Name or Password is Invalid", "Worrning", JOptionPane.WARNING_MESSAGE);
                }
//                if (admin != null) {
//
//                    if (admin.getUser_name().equals(un) && admin.getPassword().equals(pw)) {
//
//                        Navigation.navigate(Routes.ADMIN_FROM,paneLoginForm);
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "User Name or Password is Invalid", "Worrning", JOptionPane.WARNING_MESSAGE);
//                    }
//
//                }
        }

        if(rBtnManager.isSelected()) {
            ManagerDTO login1 = managerServer.login(un);
            if(login1!=null){
                if(login1.getUser_name().equals(un) && login1.getPassword().equals(pw)){

                    Navigation.navigate(Routes.MANAGER_FORM,paneLoginForm);

                } else {
                    JOptionPane.showMessageDialog(null, "User Name or Password is Invalid", "Worrning", JOptionPane.WARNING_MESSAGE);
                }
            }

//            try {
//                Manager manager = ManagerModel.loginManager(un, pw);
//
//                if (manager != null) {
//
//                    if (manager.getUser_name().equals(un) && manager.getPassword().equals(pw)) {
//
//                        Navigation.navigate(Routes.MANAGER_FORM,paneLoginForm);
//
//                    } else {
//                        JOptionPane.showMessageDialog(null, "User Name or Password is Invalid", "Worrning", JOptionPane.WARNING_MESSAGE);
//                    }
//
//                }
//
//            } catch (SQLException | ClassNotFoundException e) {
//
//            }
        }
    }
}
