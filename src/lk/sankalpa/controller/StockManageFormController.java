package lk.sankalpa.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.dto.StockDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.StockService;
import lk.sankalpa.tm.StockTM;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class StockManageFormController {

    public JFXHamburger hmbMain;
    public Pane slider;
    public JFXHamburger hmbMainClose;
    public Label lblManager;
    public TableView tblStock;
    @FXML
    private Label lbl_P_O_Manage;

    @FXML
    private Label lblProjects;

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

    public StockService stockService;


    public void initialize(){

        this.stockService= ServiceFactory.getInstance().getService(ServiceType.STOCK);



        MenuTranslater.setTranslater(hmbMain,hmbMainClose,slider);
        hmbMain.setCursor(Cursor.HAND);
        hmbMainClose.setCursor(Cursor.HAND);
        lblDetails.setCursor(Cursor.HAND);
        lblEmployee.setCursor(Cursor.HAND);
        lblIncome.setCursor(Cursor.HAND);
        lblOrders.setCursor(Cursor.HAND);
        lbl_P_O_Manage.setCursor(Cursor.HAND);
        lblReport.setCursor(Cursor.HAND);
        lblPayments.setCursor(Cursor.HAND);
        lblProjects.setCursor(Cursor.HAND);
        lblManager.setCursor(Cursor.HAND);


        tblId.setCellValueFactory(new PropertyValueFactory<StockTM, String>("id"));
        tblDescription.setCellValueFactory(new PropertyValueFactory<>("descrption"));
        tblDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tblQTY.setCellValueFactory(new PropertyValueFactory<>("QTY"));
        tblPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));


//        List<StockTM> collect = stockService.allItems().stream().map(items ->
//                        new StockTM(items.getId(), items.getDescrption(), items.getDate(), items.getQTY(), items.getUnitPrice()))
//                .collect(Collectors.toList());
//
//        tblStock.setItems(FXCollections.observableArrayList(collect));
         loadAllStockItems();

    }

    @FXML
    private AnchorPane StockManageForm;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtDescription;

    @FXML
    private JFXTextField txtQTY;

    @FXML
    private JFXTextField txtPrice;

    @FXML
    private JFXTextField txtDate;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private TableColumn<StockTM, String> tblId;

    @FXML
    private TableColumn<?, ?> tblDescription;

    @FXML
    private TableColumn<?, ?> tblQTY;

    @FXML
    private TableColumn<?, ?> tblPrice;

    @FXML
    private TableColumn<?, ?> tblDate;

    @FXML
    private JFXButton btnReloard;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnDelete;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        String id=txtId.getText();
        String descrption=txtDescription.getText();
        String QTY=txtQTY.getText();
        Double unitPrice=Double.parseDouble(txtPrice.getText());
        String date=txtDate.getText();



        if(stockService.AddStock(new StockDTO(id,descrption,date,QTY,unitPrice))!=null){
            JOptionPane.showMessageDialog(null,"Item Added Successfully");
            loadAllStockItems();
        }else {
            JOptionPane.showMessageDialog(null,"Item Added UnSuccessfully");
           
        }
    }

//=======================================================================================================================
    private void loadAllStockItems() {

        List<StockTM> collect = stockService.allItems().stream().map(items ->
                        new StockTM(items.getId(), items.getDescrption(), items.getDate(), items.getQTY(), items.getUnitPrice()))
                .collect(Collectors.toList());

        tblStock.setItems(FXCollections.observableArrayList(collect));
//        ObservableList<StockTM> obList = FXCollections.observableArrayList();
//        try {
//            for (Stock c : loadAll()) {
//                StockTM tm = new StockTM(c.getId(), c.getDescrption(), c.getDate(), c.getQTY(),c.getUnitPrice());
//
//                obList.add(tm);
//                tblStock.setItems(obList);

//======================================================Right Click Start===============================================
                tblId.setCellFactory(new Callback<TableColumn<StockTM, String>, TableCell<StockTM, String>>() {

                    @Override
                    public TableCell<StockTM, String> call(TableColumn<StockTM, String> column) {

                        final TableCell<StockTM, String> cell = new TableCell<>();
                        cell.textProperty().bind(cell.itemProperty()); // in general might need to subclass TableCell and override updateItem(...) here
                        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.SECONDARY) {
                                    System.out.println("Haloo");
                                    // handle right click on cell...
                                    cell.getItem();
                                    StockTM item = (StockTM) cell.getTableRow().getItem();
                                    //item.equals(btnDelete);
                                }
                            }
                        });
                        return cell;
                    }
                });
//==============================================Right Click Ends========================================================
            }
//        }catch (SQLException | ClassNotFoundException e){
//            System.out.println(e);
//        }
//    }
//=======================================================================================================================

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

        stockService.deleeteItem(txtId.getText());
        new Alert(Alert.AlertType.INFORMATION,"Item deleted successful").show();
        loadAllStockItems();
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {

        String id=txtId.getText();
        String descrption=txtDescription.getText();
        String QTY=txtQTY.getText();
        Double unitPrice= Double.parseDouble(txtPrice.getText());
        String date=txtDate.getText();


        if(stockService.uppdateStock(new StockDTO(id,descrption,date,QTY,unitPrice))!=null){

            JOptionPane.showMessageDialog(null,"Item Details Updated Successfully");
            loadAllStockItems();
        }else {
            JOptionPane.showMessageDialog(null,"Item Details Updated UnSuccessfully");
            loadAllStockItems();

        }
    }

    @FXML
    void btnReloardOnAction(ActionEvent event) {
        loadAllStockItems();
    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {


        StockDTO stockDTO = stockService.searchItemById(txtId.getText());

        if(stockDTO!=null){

            txtDescription.setText(stockDTO.getDescrption());
            txtDate.setText(stockDTO.getDate());
            txtQTY.setText(stockDTO.getQTY());
            txtPrice.setText(String.valueOf(stockDTO.getUnitPrice()));
        }else {
            JOptionPane.showMessageDialog(null,"Item Is Not Found ");
        }
    }
    public void delete(ActionEvent actionEvent) {
        btnDeleteOnAction(actionEvent);

    }

    public void baackToOrderManage(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,StockManageForm);

    }

    public void backToManagerForm(MouseEvent mouseEvent) throws IOException {

Navigation.navigate(Routes.MANAGER_FORM,StockManageForm);

    }



    public void backToProjectManageForm(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PROJECTS,StockManageForm);
    }

    public void backToP_OwnerForm(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PROJECT_OWNER_MANAGE,StockManageForm);
    }

    public void backToPaymentForm(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,StockManageForm);
    }

    public void backToIncomeForm(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.INCOME,StockManageForm);
    }

    public void backToReportForm(MouseEvent mouseEvent) {

    }

    public void backToDetailsForm(MouseEvent mouseEvent) throws IOException {
        System.out.println("sdsd");
       Navigation.navigate(Routes.ORDER_DETAILS,StockManageForm);
    }

    public void backToEmployeeForm(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,StockManageForm);
    }
//===================================================================================================================

}
