package lk.sankalpa.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.connection.DBConnection;
import lk.sankalpa.dto.IncomeDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.IncomeService;
import lk.sankalpa.tm.IncomeTM;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class AdminIncomeFormController {


    public AnchorPane IncomePane;

    public IncomeService incomeService;

    public void initialize(){
        incomeService= ServiceFactory.getInstance().getService(ServiceType.INCOME);

        MenuTranslater.setTranslater(hbMenu,hbCloseOnAction,ManagerMenu);

        lbl_P_O_Manage.setCursor(Cursor.HAND);
        lblReport.setCursor(Cursor.HAND);
        lblPayments.setCursor(Cursor.HAND);
        lblProjects.setCursor(Cursor.HAND);
        lblManager.setCursor(Cursor.HAND);
        hbMenu.setCursor(Cursor.HAND);
        hbCloseOnAction.setCursor(Cursor.HAND);
        btnReloard.setCursor(Cursor.HAND);
        btnSave.setCursor(Cursor.HAND);

        tblIncomeId.setCellValueFactory(new PropertyValueFactory<IncomeTM,String>("incomeId"));
        tblPaymentId.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("paymentId"));

        loadAllIncome();
        setOrderId();
    }
    public Label lblManager;
    @FXML
    private Label lblStock;

    @FXML
    private Label lblProjects;

    @FXML
    private Label lblPayments;

    @FXML
    private Label lbl_P_O_Manage;

    @FXML
    private Label lblReport;

    @FXML
    private Label lblOrders;

    @FXML
    private Label lblEmployee;

    @FXML
    private Label lblDetails;

    @FXML
    private TableView<IncomeTM> tblIncome;

    @FXML
    private TableColumn<IncomeTM, String> tblIncomeId;

    @FXML
    private TableColumn<?, ?> tblPaymentId;

    @FXML
    private TableColumn<?, ?> tblDate;

    @FXML
    private JFXTextField txtIncomeId;

    @FXML
    private JFXTextField txtPaymentId;

    @FXML
    private JFXTextField txtIncomeDate;

    @FXML
    private JFXHamburger hbMenu;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnReloard;

    @FXML
    private Pane ManagerMenu;

    @FXML
    private JFXHamburger hbCloseOnAction;


//    public ArrayList<Income> loadAll() throws SQLException, ClassNotFoundException {
//
//        ResultSet resultSet = CrudUtil.execute("SELECT * FROM income");
//        ArrayList<Income> list= new ArrayList<>();
//        while (resultSet.next()){
//            list.add(new Income(resultSet.getString(1),resultSet.getString(2),
//                    resultSet.getString(3)));
//        }
//        return list;
//    }


    private void loadAllIncome() {

        List<IncomeTM> collect = incomeService.allIncomes().stream().map(incomeDTO ->
                new IncomeTM(incomeDTO.getIncomeId(), incomeDTO.getPaymentId(), incomeDTO.getDate())).collect(Collectors.toList());

        tblIncome.setItems(FXCollections.observableArrayList(collect));

//        ObservableList<IncomeTM> obList = FXCollections.observableArrayList();
//        try {
//            for (Income c : loadAll()) {
//                IncomeTM tm = new IncomeTM(c.getIncomeId(),c.getPaymentId(),c.getDate());
//
//                obList.add(tm);
//                tblIncome.setItems(obList);
//            }
//        }catch (SQLException | ClassNotFoundException e){
//            System.out.println(e);
//        }
    }
    @FXML
    void backToP_OwnerOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ADMIN_PROJECT_OWNER_MANAGE,IncomePane);
    }

    @FXML
    void backToManagerForm(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ADMIN_FROM,IncomePane);
    }

    @FXML
    void backToPaymentOnAction(MouseEvent event) {

    }

    @FXML
    void backToProjectsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ADMIN_PROJECT_MANAGE,IncomePane);
    }

    @FXML
    void backToReportOnAction(MouseEvent event) {

    }


    @FXML
    void btnReloardOnAction(ActionEvent event) {
        loadAllIncome();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        String incomeId=txtIncomeId.getText();
        String paymentId=txtPaymentId.getText();
        String date=txtIncomeDate.getText();

        if(incomeService.AddIncome(new IncomeDTO(incomeId,paymentId,date))!=null){
            JOptionPane.showMessageDialog(null,"Added Success");
            loadAllIncome();
        }else{
            JOptionPane.showMessageDialog(null,"Added UnSuccess");
            //loadAllIncome();
        }

//        Income income=new Income(incomeId,paymentId,date);
//
//        try {
//            boolean isadded= IncomeModel.addIncome(income);
//
//            if(isadded){
//                JOptionPane.showMessageDialog(null,"Added Success");
//                loadAllIncome();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//
//        }

    }

    public void setOrderId() {
        try {
            String sql = "SELECT Id FROM `income` ORDER BY Id DESC LIMIT 1;"; // 10 not working... (UNSIGNED)
            PreparedStatement statement = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String tempOrderId = resultSet.getString(1);
                //  String[] array = tempOrderId.split("0");//[D,3]
                int tempNumber = Integer.parseInt(tempOrderId);
                int finalizeOrderId = tempNumber + 1;
                txtIncomeId.setText("00" + finalizeOrderId);
            } else {
                txtIncomeId.setText("001");
            }
        } catch (SQLException ex) {

        }
    }

}
