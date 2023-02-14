package lk.sankalpa.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.sankalpa.dto.AdminDTO;
import lk.sankalpa.dto.ManagerDTO;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.AdminService;
import lk.sankalpa.service.custome.ManagerServer;

import javax.swing.*;
import java.awt.*;
import java.util.regex.Pattern;

public class CreateAccountController extends Component {
    @FXML
    private AnchorPane paneCreateAccount;
    @FXML
    private JFXTextField Name;

    @FXML
    private JFXTextField NIC;

    @FXML
    private JFXTextField User_Name;
    @FXML
    private JFXTextField setPassword;
    @FXML
    private JFXTextField Conferm_Password;
    public Button jBTN;
    public JFXRadioButton rBtnAdmin;
    public JFXRadioButton rBtnManager;
    public ToggleGroup Login;
    public Label lbl__name;
    public Label lbl_nic;
    public Label lbl_user_name;
    public Label lbl_set_PW;
    public Label lblconform_PW;
    public Pattern patternname;
    public Pattern patternnic;
    public Pattern patternusername;
    public Pattern patternsetPW;
    public Pattern patternconPW;

    public AdminService adminService;
    public ManagerServer managerServer;


    public void initialize(){

        this.adminService=ServiceFactory.getInstance().getService(ServiceType.ADMIN);
        this.managerServer=ServiceFactory.getInstance().getService(ServiceType.MANAGER);

        patternname=Pattern.compile("^[a-zA-Z\\s\\W]{1,}$");
        patternnic=Pattern.compile("^[0-9]{12}$");
        patternusername=Pattern.compile("^[a-zA-Z0-9_-]{3,16}$");
        patternsetPW=Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        patternconPW=Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");


        jBTN.setCursor(Cursor.HAND);
    }

    @FXML
    void PatterNameOnAction(KeyEvent event) {

        boolean matches = patternname.matcher(Name.getText()).matches();
        if(matches){
            lbl__name.setText("");
        }else{
            lbl__name.setText("Invalid Name");
        }

    }

    @FXML
    void patterNicOnAction(KeyEvent event) {

        boolean matches = patternnic
                .matcher(NIC.getText()).matches();
        if(matches){
            lbl_nic.setText("");
        }else {
            lbl_nic.setText("Invalid NIC ");

        }

    }

    @FXML
    void patternConformPWOnAction(KeyEvent event) {

        boolean matches = patternconPW.matcher(Conferm_Password.getText()).matches();
        if(matches){
            lblconform_PW.setText("");
        }else{
            lblconform_PW.setText("Minimum eight characters, at least one letter and one number");
        }

    }

    @FXML
    void patternUserNameOnActio(KeyEvent event) {
        boolean matches = patternusername.matcher(User_Name.getText()).matches();
        if(matches){
            lbl_user_name.setText("");
        }else{
            lbl_user_name.setText("Invalid User name");
        }

    }

    @FXML
    void patternsetPWOnAction(KeyEvent event) {
        boolean matches = patternsetPW.matcher(setPassword.getText()).matches();
        if(matches){
            lbl_set_PW.setText("");
        }else{
            lbl_set_PW.setText("Minimum eight characters, at least one letter and one number");
        }
    }



    //public AdminService adminService;
    public void JbtnCreateOnAction(ActionEvent actionEvent) {

        String name = Name.getText();
        String nic = NIC.getText();
        String user_name = User_Name.getText();
        String password = setPassword.getText();
        String confermPassword = Conferm_Password.getText();

        if(rBtnAdmin.isSelected()) {

    if (name.equals("") | nic.equals("") | user_name.equals("") | password.equals("") | confermPassword.equals("")) {

        JOptionPane.showMessageDialog(null, "Pleas Fill The Details");
    } else {

        if (password.equals(confermPassword)) {

            AdminDTO adminDTO = new AdminDTO(name, nic, user_name, password);


                AdminDTO adminDTO1 = adminService.saveAdmin(adminDTO);


                if(adminDTO1!=null){
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                }else{
                    new Alert(Alert.AlertType.ERROR,"Already Exists").show();

                }

//                if (isAddDetails) {
//                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
//                }

//            } catch (SQLException | ClassNotFoundException e) {
//                JOptionPane.showMessageDialog(null, "Driver Not Found");
//            }

        } else {

            JOptionPane.showMessageDialog(null, "Password Is Not Confirmed");
        }
    }
}

        if (rBtnManager.isSelected()) {

    if (name.equals("") | nic.equals("") | user_name.equals("") | password.equals("") | confermPassword.equals("")) {

        JOptionPane.showMessageDialog(null, "Pleas Fill The Details");
    } else {

        if (password.equals(confermPassword)) {

            ManagerDTO managerDTO = new ManagerDTO(name, nic, user_name, password);


            ManagerDTO managerDTO1 = managerServer.saveManager(managerDTO);


            if(managerDTO1!=null){
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
            }else{
                new Alert(Alert.AlertType.ERROR,"Already Exists").show();

            }

//            Manager manager = new Manager(name, nic, user_name, password);
//
//            try {
//                boolean isAddDetails = ManagerModel.setManagerDetails(manager);
//
//                if (isAddDetails) {
//                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
//                }
//
//            } catch (SQLException | ClassNotFoundException e) {
//                JOptionPane.showMessageDialog(null, "Driver Not Found");
//            }

        } else {

            JOptionPane.showMessageDialog(null, "Password Is Not Confirmed");
        }
      }
     }

   }
}


