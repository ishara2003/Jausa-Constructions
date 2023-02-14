package lk.sankalpa.controller;

import animatefx.animation.FadeInDown;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.dto.P_OwnerDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.ProjectOwnerService;
import lk.sankalpa.tm.P_OwnerTM;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class POwnerManageFormController {


    public Label lblDeletePanter;
    private Pattern patternNIC;
    private Pattern patternName;
    private Pattern patternAddress;
    private Pattern patternNumber;
    public Button btnReload;
    @FXML
    private Label lblAddNamerPattern;

    @FXML
    private Label lblAddNicPattern;

    @FXML
    private Label lblAddAddressPattern;

    @FXML
    private Label lblAddNumberPattern;

    @FXML
    private AnchorPane SearchSlider;

    @FXML
    private JFXTextField searchName;

    @FXML
    private JFXTextField searchNIC;

    @FXML
    private JFXTextField SearchAddress;

    @FXML
    private JFXTextField SearchNumber;

    @FXML
    private JFXHamburger SearchCloseOnAction;

    @FXML
    private Button btnSearch;

    @FXML
    private Label lblSearchNICPattern;

    @FXML
    private AnchorPane EditSlider;

    @FXML
    private JFXTextField EdtName;

    @FXML
    private JFXTextField EditNIC;

    @FXML
    private JFXTextField EditAddress;

    @FXML
    private JFXTextField EditNumber;

    @FXML
    private JFXHamburger EditCloseOnAction;

    @FXML
    private Button btnEdit;

    @FXML
    private Label lblEditNamerPattern;

    @FXML
    private Label lblEditNICPattern;

    @FXML
    private Label lblEditAddressPattern;

    @FXML
    private Label lblEditNuymberPattern;

    public JFXHamburger hbMenu;
    public JFXHamburger hbCloseOnAction;
    public Pane ManagerMenu;
    public Label lblManager;
    public MenuItem EditSliderById;
    public AnchorPane tryPane;
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
    private AnchorPane Project_Owner_Form;
    @FXML
    private JFXButton btnreloard;
    @FXML
    private TableView<P_OwnerTM> P_O_Table;
    @FXML
    private TableColumn<P_OwnerTM, String> tblName;
    @FXML
    private TableColumn<?, ?> tblNIC;
    @FXML
    private TableColumn<?, ?> tblAddress;
    @FXML
    private TableColumn<?, ?> tblNumber;
    @FXML
    private ImageView imgAdd;
    @FXML
    private JFXHamburger hbAdd;
    @FXML
    private ImageView imgSearch;
    @FXML
    private JFXHamburger hbSearch;
    @FXML
    private ImageView imgEdit;
    @FXML
    private JFXHamburger hbEdit;
    @FXML
    private ImageView imgDelete;
    @FXML
    private JFXHamburger hbDelete;
    @FXML
    private AnchorPane AddSlider;
    @FXML
    private JFXTextField addName;
    @FXML
    private JFXTextField addNIC;
    @FXML
    private JFXTextField addAddress;
    @FXML
    private JFXTextField addNumber;
    @FXML
    private JFXHamburger closeOnAction;
    @FXML
    private Button btnAdd;

    @FXML
    private AnchorPane DeleteSlider;
    @FXML
    private JFXTextField DeleteName;
    @FXML
    private JFXTextField DeleteNic;
    @FXML
    private JFXTextField DeleteAddress;
    @FXML
    private JFXTextField DeleteNumbewr;
    @FXML
    private JFXHamburger DeleteCloseOnAction;
    @FXML
    private JFXButton btndelete;


    public ProjectOwnerService projectOwnerService;
    public void initialize(){

        this.projectOwnerService= ServiceFactory.getInstance().getService(ServiceType.PROJECT_OWNER);
//=============================================Codes Start For Slides====================================================
        MenuTranslater.setAddTranclate(hbAdd,closeOnAction,AddSlider);
        MenuTranslater.setSearchTranclate(hbSearch,SearchCloseOnAction,SearchSlider);
        MenuTranslater.setEditTranclate(hbEdit,EditCloseOnAction,EditSlider);
        MenuTranslater.setDeleteTranclate(hbDelete,DeleteCloseOnAction,DeleteSlider);
        MenuTranslater.setTranslater(hbMenu,hbCloseOnAction, ManagerMenu);
//=============================================Codes End For Slides======================================================

//============================================Coursor Starts=============================================================
        btnAdd.setCursor(Cursor.HAND);
        btndelete.setCursor(Cursor.HAND);
        btnSearch.setCursor(Cursor.HAND);
        btnEdit.setCursor(Cursor.HAND);
        DeleteCloseOnAction.setCursor(Cursor.HAND);
        closeOnAction.setCursor(Cursor.HAND);
        SearchCloseOnAction.setCursor(Cursor.HAND);
        EditCloseOnAction.setCursor(Cursor.HAND);
        hbAdd.setCursor(Cursor.HAND);
        hbSearch.setCursor(Cursor.HAND);
        hbEdit.setCursor(Cursor.HAND);
        hbDelete.setCursor(Cursor.HAND);
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
//==============================================Cursors Ends============================================================

//=============================================Set Data To The Table====================================================

        tblName.setCellValueFactory(new PropertyValueFactory<P_OwnerTM, String>("name"));
        tblNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblNumber.setCellValueFactory(new PropertyValueFactory<>("number"));

//==========================================Patterns====================================================================

        patternNIC =Pattern.compile("^[0-9]{12}$");
        patternName =Pattern.compile("^[a-zA-Z\\s\\W]{1,}$");
        patternAddress =Pattern.compile("^[A-Z a-z 0-9 \\W\\s]{1,}$");
        patternNumber =Pattern.compile("^\\d{10}$");

//===========================================Load Data==================================================================
        loadAllCustomers();
//============================================Set Sliders Visibility====================================================
        EditSlider.setVisible(true);
        AddSlider.setVisible(true);
        SearchSlider.setVisible(true);
        DeleteSlider.setVisible(true);
    }
//=================================End Of Initialize Methode============================================================
public void setPatternNIC(KeyEvent keyEvent) {

    boolean matches = patternNIC.matcher(addNIC.getText()).matches();
    if(matches){
        addNIC.setFocusColor(Paint.valueOf("Blue"));
        lblAddNicPattern.setText("");
    }else{

        addNIC.setFocusColor(Paint.valueOf("Red"));
        lblAddNicPattern.setText("Enter 12 Number NIC");
    }

}
    public void setPatternName(KeyEvent keyEvent) {
        boolean matches = patternName.matcher(addName.getText()).matches();
        if(matches){
            addName.setFocusColor(Paint.valueOf("Blue"));
            lblAddNamerPattern.setText("");
        }else {
            addName.setFocusColor(Paint.valueOf("Red"));
            lblAddNamerPattern.setText("Invalid Name");

        }
    }
    public void setPatternAddress(KeyEvent keyEvent) {
        boolean matches = patternAddress.matcher(addAddress.getText()).matches();
        if(matches){
            addAddress.setFocusColor(Paint.valueOf("Blue"));
            lblAddAddressPattern.setText("");
        }else {

            addAddress.setFocusColor(Paint.valueOf("Red"));
            lblAddAddressPattern.setText("Invalid Addres Type");
        }
    }
    public void setPattternNumber(KeyEvent keyEvent) {
        boolean matches = patternNumber.matcher(addNumber.getText()).matches();
        if(matches){
            addNumber.setFocusColor(Paint.valueOf("Blue"));
            lblAddNumberPattern.setText("");
        }else {

            addNumber.setFocusColor(Paint.valueOf("Red"));lblAddNumberPattern.setText("Invalid Phone Number");
        }
    }
    @FXML
    void setSearchNamePattern(KeyEvent event) {
        boolean matches = patternNIC.matcher(searchNIC.getText()).matches();
        if(matches){
            searchNIC.setFocusColor(Paint.valueOf("Blue"));
            lblSearchNICPattern.setText("");
        }else{

            searchNIC.setFocusColor(Paint.valueOf("Red"));lblSearchNICPattern.setText("Enter 12 Number NIC");
        }
    }
    @FXML
    void setDeleteNICPattern(KeyEvent event) {

        boolean matches = patternNIC.matcher(DeleteNic.getText()).matches();
        if(matches){
            DeleteNic.setFocusColor(Paint.valueOf("Blue"));
            lblDeletePanter.setText("");
        }else{

            DeleteNic.setFocusColor(Paint.valueOf("Red"));
            lblDeletePanter.setText("Enter 12 Number NIC");
        }
    }

    @FXML
    void setEditAddressPattern(KeyEvent event) {

        boolean matches = patternAddress.matcher(EditAddress.getText()).matches();
        if(matches){
            EditAddress.setFocusColor(Paint.valueOf("Blue"));
            lblEditAddressPattern.setText("");
        }else {

            EditAddress.setFocusColor(Paint.valueOf("Red"));lblEditAddressPattern.setText("Invalid Address Type");
        }

    }

    @FXML
    void setEditNICPattern(KeyEvent event) {

        boolean matches = patternNIC.matcher(EditNIC.getText()).matches();
        if(matches){
            EditNIC.setFocusColor(Paint.valueOf("Blue"));lblEditNICPattern.setText("");
        }else {

            EditNIC.setFocusColor(Paint.valueOf("Red"));lblEditNICPattern.setText("Enter 12 Number NIC");
        }

    }

    @FXML
    void setEditNamePattern(KeyEvent event) {

        boolean matches = patternName.matcher(EdtName.getText()).matches();
        if(matches){
            EdtName.setFocusColor(Paint.valueOf("Blue"));lblEditNamerPattern.setText("");
        }else {
            EdtName.setFocusColor(Paint.valueOf("Red"));lblEditNamerPattern.setText("Invalid name");

        }

    }

    @FXML
    void setEditNumberPattern(KeyEvent event) {
        boolean matches = patternNumber.matcher(EditNumber.getText()).matches();
        if(matches){
            EditNumber.setFocusColor(Paint.valueOf("Blue"));lblEditNuymberPattern.setText("");
        }else {
            EditNumber.setFocusColor(Paint.valueOf("Red"));lblEditNuymberPattern.setText("Invalid Number Tyep");

        }
    }

//===============================================Stat Of @FXLM==========================================================


//==========================================End Of @FXML================================================================

    @FXML
    public void AddOnAction(ActionEvent event) {

        String name = addName.getText();
        String nic = addNIC.getText();
        String address = addAddress.getText();
        String number = addNumber.getText();

        if (name.equals("") | nic.equals("") | address.equals("") | number.equals("")) {
            JOptionPane.showMessageDialog(null, "Fill Details");
        } else {

            P_OwnerDTO p_ownerDTO = projectOwnerService.AddProject(new P_OwnerDTO(name, nic, address, number));
            if(p_ownerDTO!=null){
                JOptionPane.showMessageDialog(null, "Ownerd Added Successfuly");
                loadAllCustomers();
            }else{
                JOptionPane.showMessageDialog(null, "Ownerd Added UnSuccessfuly");
            }
//            Project_Owners projectOwners = new Project_Owners(name, nic, address, number);
//            try {
//                boolean issadded = P_OwnerModel.addP_Owner(projectOwners);
//                if (issadded) {
//                    JOptionPane.showMessageDialog(null, "Ownerd Added Successfuly");
//                    loadAllCustomers();
//                }
//            } catch (SQLException | ClassNotFoundException e) {
//                JOptionPane.showMessageDialog(null, "All ready Exists Project Owner!", "Information", JOptionPane.INFORMATION_MESSAGE);
//            }
        }
    }

    @FXML
    void DeleteOnAction(ActionEvent event) {



        int i = JOptionPane.showConfirmDialog(null, "Are You Sure ?");

        if(i==JOptionPane.YES_OPTION){


                projectOwnerService.deleteP_Owner(DeleteNic.getText());
                    JOptionPane.showMessageDialog(null,"Deleted Successfuly");
                    loadAllCustomers();

        }
    }

    @FXML
    void EditOnAction(ActionEvent event) {

        String name=EdtName.getText();
        String nic=EditNIC.getText();
        String address=EditAddress.getText();
        String number=EditNumber.getText();

        if(projectOwnerService.editOwner(new P_OwnerDTO(name,nic,address,number))!=null){
            JOptionPane.showMessageDialog(null, "Information Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            loadAllCustomers();
        }else {
            JOptionPane.showMessageDialog(null, "Information Cheanged Unsuccessfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            loadAllCustomers();
        }

//        try {
//            boolean   isUpdated = P_OwnerModel.updateP_OWners(name,nic,address,number);
//            if(isUpdated){
//                JOptionPane.showMessageDialog(null, "Information Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
//                loadAllCustomers();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//
//            System.out.println(e);
//        }

    }
    @FXML
    public void SearchOnAction(ActionEvent event) {


        P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(searchNIC.getText());

        if(p_ownerDTO!=null){
            searchName.setText(p_ownerDTO.getName());
            SearchAddress.setText(p_ownerDTO.getAddress());
            SearchNumber.setText(p_ownerDTO.getNumber());
        }else {
            JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
        }

//        try {
//            Project_Owners projectOwners=P_OwnerModel.searchP_Owner(searchNIC.getText());
//            if (projectOwners != null) {
//                searchName.setText(projectOwners.getName());
//                SearchAddress.setText(projectOwners.getAddress());
//                SearchNumber.setText(projectOwners.getNumber());
//            }else {
//                JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
    }

//    public ArrayList<Project_Owners> loadAll() throws SQLException, ClassNotFoundException {
//
//        ResultSet resultSet = CrudUtil.execute("SELECT * FROM project_owners");
//        ArrayList<Project_Owners> list= new ArrayList<>();
//        while (resultSet.next()){
//            list.add(new Project_Owners(resultSet.getString(1),resultSet.getString(2),
//                    resultSet.getString(3),resultSet.getString(4)));
//        }
//        return list;
//    }

    private void loadAllCustomers() {

        List<P_OwnerTM> collect = projectOwnerService.allP_Owners().stream().map(owners ->
                new P_OwnerTM(owners.getName(), owners.getNic(), owners.getAddress(), owners.getNumber())).collect(Collectors.toList());

        P_O_Table.setItems(FXCollections.observableArrayList(collect));

//        ObservableList<P_OwnerTM> obList = FXCollections.observableArrayList();
//        try {
//            for (Project_Owners c : loadAll()) {
//                P_OwnerTM tm = new P_OwnerTM(c.getName(), c.getNIC(), c.getAddress(), c.getNumber());
//
//                obList.add(tm);
//                P_O_Table.setItems(obList);
//======================================================Right Click Start===============================================
                tblName.setCellFactory(new Callback<TableColumn<P_OwnerTM, String>, TableCell<P_OwnerTM, String>>() {

                    @Override
                    public TableCell<P_OwnerTM, String> call(TableColumn<P_OwnerTM, String> column) {

                        final TableCell<P_OwnerTM, String> cell = new TableCell<>();
                        cell.textProperty().bind(cell.itemProperty()); // in general might need to subclass TableCell and override updateItem(...) here
                        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.SECONDARY) {
                                    System.out.println("Haloo");
                                    // handle right click on cell...
                                    cell.getItem();
                                    P_OwnerTM item = (P_OwnerTM) cell.getTableRow().getItem();
                                }
                            }
                        });
                        return cell;
                    }
                });
//==============================================Right Click Ends========================================================

//        }catch (SQLException | ClassNotFoundException e){
//            System.out.println(e);
//        }
    }
    public void SearchbyOnAction(ActionEvent actionEvent) {
        SearchOnAction(actionEvent);
    }
    public void searchbyDeleteOnAction(ActionEvent actionEvent) {

        P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(DeleteNic.getText());

        if(p_ownerDTO!=null){
            DeleteName.setText(p_ownerDTO.getName());
            DeleteAddress.setText(p_ownerDTO.getAddress());
            DeleteNumbewr.setText(p_ownerDTO.getNumber());
        }else {
            JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
        }

//        try {
//            Project_Owners projectOwners=P_OwnerModel.searchP_Owner(DeleteNic.getText());
//            if (projectOwners != null) {
//                DeleteName.setText(projectOwners.getName());
//                DeleteAddress.setText(projectOwners.getAddress());
//                DeleteNumbewr.setText(projectOwners.getNumber());
//            }else {
//                JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }

       // SearchOnAction(actionEvent);
    }
    public void SearchNICByEditOnAction(ActionEvent actionEvent) {

        P_OwnerDTO p_ownerDTO = projectOwnerService.searchOwnerByNIC(EditNIC.getText());

        if(p_ownerDTO!=null){
            EdtName.setText(p_ownerDTO.getName());
            EditAddress.setText(p_ownerDTO.getAddress());
            EditNumber.setText(p_ownerDTO.getNumber());
        }else {
            JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
        }

//        try {
//            Project_Owners projectOwners=P_OwnerModel.searchP_Owner(EditNIC.getText());
//            if (projectOwners != null) {
//                EdtName.setText(projectOwners.getName());
//                EditAddress.setText(projectOwners.getAddress());
//                EditNumber.setText(projectOwners.getNumber());
//            }else {
//                JOptionPane.showMessageDialog(null,"Project Owner Is Not Found","worning",JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//        }
    }

//=======================================Tables Right click Slider Starts===============================================
    public void EditSliderOnAction(ActionEvent actionEvent) {
        new FadeInDown(EditSlider).play();
    }
    public void DeleteSliderOnAction(ActionEvent actionEvent) {
        new FadeInDown(DeleteSlider).play();
    }
//=======================================Tables Right click Slider Ends=================================================

//==========================================Navigation Part Starts======================================================
    @FXML
    void backToDetailsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDER_DETAILS,Project_Owner_Form);
    }
    @FXML
    void backToEmployeeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,Project_Owner_Form);
    }
    @FXML
    void backToIncomeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME,Project_Owner_Form);
    }
    @FXML
    void backToManagerForm(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGER_FORM,Project_Owner_Form);
    }
    @FXML
    void backToPaymentOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,Project_Owner_Form);
    }
    @FXML
    void backToProjectsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECTS,Project_Owner_Form);
    }
    @FXML
    void backToReportOnAction(MouseEvent event) {

    }
    @FXML
    void backToStockOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.STOCK_MANAGE,Project_Owner_Form);
    }
    public void baackToOrderManage(MouseEvent mouseEvent) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,Project_Owner_Form);
    }

//==========================================Navigation Part Ends========================================================
    public void ReloadOnAction(ActionEvent actionEvent) {

        loadAllCustomers();
    }


}
