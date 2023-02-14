package lk.sankalpa.controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
import java.util.regex.Pattern;


public class FogotPasswordFormController {
    public TextField textNIC;
    public TextField JtxtUser_name;
    public TextField jtxtPassword;
    public TextField jtxtNewPassword;
    public Button jBTN;
    public AnchorPane fogotPasswordPane;
    public JFXRadioButton rBtnAdmin;
    public ToggleGroup login;
    public JFXRadioButton rBtnManager;
    public Label lblNIC;
    public Label lblNewPassword;
    public Label lblConformPassword;

    public Pattern patternNIC;
    public Pattern NewPassword;
    public Pattern ConformPassword;
    public AdminService adminService;
    public ManagerServer managerServer;

    public void initialize(){
        this.adminService= ServiceFactory.getInstance().getService(ServiceType.ADMIN);
        this.managerServer=ServiceFactory.getInstance().getService(ServiceType.MANAGER);

        this.textNIC.requestFocus();

//==========================================Patterns====================================================================

        patternNIC = Pattern.compile("^[0-9]{12}$");
        NewPassword=Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        ConformPassword=Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");

        jBTN.setVisible(false);
    }
    public void conferm_PasswordOnAction(ActionEvent actionEvent) {

        String nic=textNIC.getText();
        String setpw=jtxtPassword.getText();
        String confermpw=jtxtNewPassword.getText();

        if(rBtnAdmin.isSelected()) {

            if (!setpw.equals(confermpw)) {

                JOptionPane.showMessageDialog(null, "Password Is Not Confermed", "Alert", JOptionPane.INFORMATION_MESSAGE);

                this.jtxtNewPassword.requestFocus();

            } else {
                AdminDTO adminDTO = adminService.updateAdmin(new AdminDTO(nic, confermpw));

                if(adminDTO!=null){

                    JOptionPane.showMessageDialog(null, "Password Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);

                }else {
                    System.out.println("gfdddfg");
                }
//                try {
//                    Admin admin = new Admin(nic, confermpw);
//
//                    Admin isupdated = AdminModel.cheangepassword(new Admin(nic,confermpw));
//
//                    if (isupdated!=null) {
//
//                        JOptionPane.showMessageDialog(null, "Password Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
//
//                    }else {
//                        JOptionPane.showMessageDialog(null, "Password Cheanged Unsuccessfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
//
//                    }
//
//                } catch (SQLException | ClassNotFoundException e) {
//                    JOptionPane.showMessageDialog(null, "Driver not Found", "Alert", JOptionPane.INFORMATION_MESSAGE);
//                    System.out.println(e);
//
//                }
            }
        }

//=============================================================================================================================================================================================
//=============================================================================================================================================================================================
//=============================================================================================================================================================================================

        if(rBtnManager.isSelected()){

         if(!setpw.equals(confermpw)){

            JOptionPane.showMessageDialog(null,"Password Is Not Confermed","Alert",JOptionPane.INFORMATION_MESSAGE);

            this.jtxtNewPassword.requestFocus();

        }else {
             ManagerDTO managerDTO = managerServer.updateManager(new ManagerDTO(nic, confermpw));

             if(managerDTO!=null){

                 JOptionPane.showMessageDialog(null, "Password Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);

             }else {
                 System.out.println("gfdddfg");
             }
        }
      }
    }

    public void NicOnAction(ActionEvent actionEvent) {

        String nic=textNIC.getText();

        if(rBtnAdmin.isSelected()) {


            AdminDTO adminDTO = adminService.searchAdmin(nic);
            if(adminDTO!=null){

                JtxtUser_name.setText(adminDTO.getUser_name());

            } else {
                JOptionPane.showMessageDialog(null, "Their is no account for this NIC", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }

//            try {
//
//                Admin admin = AdminModel.searchUserName(nic);
//
//                if (admin != null) {
//
//                    JtxtUser_name.setText(admin.getUser_name());
//
//                } else {
//                    JOptionPane.showMessageDialog(null, "Their is no account for this NIC", "Alert", JOptionPane.INFORMATION_MESSAGE);
//                }
//
//            } catch (SQLException | ClassNotFoundException e) {
//                System.out.println(e);
//
//            }
        }

        //************************************************
      if(rBtnManager.isSelected()) {

          ManagerDTO managerDTO = managerServer.searchManager(nic);
          if(managerDTO!=null){
              JtxtUser_name.setText(managerDTO.getUser_name());

          } else {
              JOptionPane.showMessageDialog(null, "Their is no account for this NIC", "Alert", JOptionPane.INFORMATION_MESSAGE);
          }

//          try {
//
//              Manager manager = ManagerModel.searchUserName(nic);
//
//              if (manager != null) {
//
//                  JtxtUser_name.setText(manager.getUser_name());
//
//              } else {
//                  JOptionPane.showMessageDialog(null, "Their is no account for this NIC", "Alert", JOptionPane.INFORMATION_MESSAGE);
//              }
//
//          } catch (SQLException | ClassNotFoundException e) {
//              System.out.println(e);
//
//          }
      }
    }

    public void JbtnCreateOnAction(ActionEvent actionEvent) {
        conferm_PasswordOnAction(actionEvent);
    }

    public void NICPatterOnAction(KeyEvent keyEvent) {


        boolean matches = patternNIC.matcher(textNIC.getText()).matches();
        if(matches){
            lblNIC.setText("");
        }else {
            lblNIC.setText("Invalid NIC ");

        }
    }

    public void newPasswordOnAction(KeyEvent keyEvent) {

        boolean matches = NewPassword.matcher(jtxtPassword.getText()).matches();
        if(matches){
            lblNewPassword.setText("");
        }else{
            lblNewPassword.setText("Minimum eight characters, at least one letter and one number");
        }
    }

    public void conformPasswordOnAction(KeyEvent keyEvent) {

        boolean matches = ConformPassword.matcher(jtxtNewPassword.getText()).matches();
        if(matches){
                lblConformPassword.setText("");
                jBTN.setVisible(true);
        }else {
            lblConformPassword.setText("Minimum eight characters, at least one letter and one number");
        }
    }
}
