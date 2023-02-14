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
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.util.Callback;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.dto.ProjectDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.ProjectService;
import lk.sankalpa.tm.ProjectTM;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProjectFormController {

    public AnchorPane AddSlider;
    public AnchorPane SearchSlider;
    public AnchorPane EditSlider;
    public AnchorPane DeleteSlider;
    public JFXButton btnReloard;
    public AnchorPane ProjectFomrPane;



    public ProjectService projectService;
    public void initialize(){

        projectService= ServiceFactory.getInstance().getService(ServiceType.PROJECT);

        MenuTranslater.setTranslater(hbMenu,hmbMainClose,slider);
        MenuTranslater.setAddTranclate(btnAddSlider,hbAddCloseOnAction,AddSlider);
        MenuTranslater.setSearchTranclate(btnSearchSlider,hbSearchClose,SearchSlider);
        MenuTranslater.setAddTranclate(btnEditSlider,hbEditClose,EditSlider);
        MenuTranslater.setAddTranclate(btnDeleteSlider,hbDeleteClose,DeleteSlider);
        btnAddSlider.setCursor(Cursor.HAND);
        btnSave.setCursor(Cursor.HAND);
        btnEditSlider.setCursor(Cursor.HAND);
        btnSearchSlider.setCursor(Cursor.HAND);
        btnDeleteSlider.setCursor(Cursor.HAND);
        btnSearch.setCursor(Cursor.HAND);
        btnDelete.setCursor(Cursor.HAND);
        btnEdit.setCursor(Cursor.HAND);
        hbMenu.setCursor(Cursor.HAND);
        hmbMainClose.setCursor(Cursor.HAND);
        lblManagerForm.setCursor(Cursor.HAND);
        lblProjectOwner.setCursor(Cursor.HAND);
        lblStock.setCursor(Cursor.HAND);
        lblEmployee.setCursor(Cursor.HAND);
        lblI_Report.setCursor(Cursor.HAND);
        lblIncome.setCursor(Cursor.HAND);
        lblOrder.setCursor(Cursor.HAND);
        lbl_O_Details.setCursor(Cursor.HAND);
        lblPayments.setCursor(Cursor.HAND);

        tblProjectId.setCellValueFactory(new PropertyValueFactory<ProjectTM, String>("Id"));
        tblProjectName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tbl_P_Owner.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblProjectCost.setCellValueFactory(new PropertyValueFactory<>("Cost"));

        patternNIC =Pattern.compile("^[0-9]{12}$");
        patternName =Pattern.compile("^[a-zA-Z\\s\\W]{1,}$");
        patternCost =Pattern.compile("^[0-9]{1,}$");
        patternId =Pattern.compile("^\\d{1,}$");

loadAllProjects();

    }

    @FXML
    private JFXHamburger btnAddSlider;

    @FXML
    private JFXHamburger btnEditSlider;

    @FXML
    private JFXHamburger btnDeleteSlider;

    @FXML
    private JFXHamburger btnSearchSlider;

    @FXML
    private JFXHamburger hbMenu;

    @FXML
    private Pane slider;

    @FXML
    private Label lblManagerForm;

    @FXML
    private JFXHamburger hmbMainClose;

    @FXML
    private Label lblProjectOwner;

    @FXML
    private Label lblStock;

    @FXML
    private Label lblPayments;

    @FXML
    private Label lblIncome;

    @FXML
    private Label lblI_Report;

    @FXML
    private Label lblOrder;

    @FXML
    private Label lblEmployee;

    @FXML
    private Label lbl_O_Details;

    @FXML
    private TableView<ProjectTM> tblProjects;

    @FXML
    private TableColumn<ProjectTM, String> tblProjectId;

    @FXML
    private TableColumn<?, ?> tblProjectName;

    @FXML
    private TableColumn<?, ?> tbl_P_Owner;

    @FXML
    private TableColumn<?, ?> tblProjectCost;

    @FXML
    private JFXTextField txtAddId;

    @FXML
    private JFXTextField txtAddNIC;

    @FXML
    private JFXTextField txtAddName;

    @FXML
    private JFXTextField txtAddCost;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXHamburger hbAddCloseOnAction;



    @FXML
    private JFXTextField txtSearchId;

    @FXML
    private JFXTextField txtSearchNIC;

    @FXML
    private JFXTextField txtSearchName;

    @FXML
    private JFXTextField txtSearchCost;

    @FXML
    private JFXButton btnSearch;

    @FXML
    private JFXHamburger hbSearchClose;


    @FXML
    private JFXTextField txtEditId;

    @FXML
    private JFXTextField txtEditNIC;

    @FXML
    private JFXTextField txtEditName;

    @FXML
    private JFXTextField txtEditCost;

    @FXML
    private JFXHamburger hbEditClose;

    @FXML
    private JFXButton btnEdit;
    @FXML
    private JFXTextField txtDeleteId;

    @FXML
    private JFXTextField txtDeleteNIC;

    @FXML
    private JFXTextField txtDeleteName;

    @FXML
    private JFXTextField txtDeleteCost;

    @FXML
    private JFXHamburger hbDeleteClose;

    @FXML
    private JFXButton btnDelete;

    @FXML
    void baackToOrderManage(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,ProjectFomrPane);
    }

    @FXML
    void backToEmployee(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.EMPLOYEE,ProjectFomrPane);
    }

    @FXML
    void backToIncome(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME,ProjectFomrPane);
    }

    @FXML
    void backToManagerForm(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGER_FORM,ProjectFomrPane);
    }

    @FXML
    void backToPayments(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,ProjectFomrPane);
    }

    @FXML
    void backToProjectOwners(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECT_OWNER_MANAGE,ProjectFomrPane);
    }

    @FXML
    void backToStock(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.STOCK_MANAGE,ProjectFomrPane);
    }

    @FXML
    void backTo_I_Report(MouseEvent event) {

    }

    @FXML
    void backTo_O_Details(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDER_DETAILS,ProjectFomrPane);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {



        int yes = JOptionPane.showConfirmDialog(null, "Project Deleted Successfully");

//        ProjectDTO projectDTO = projectService.searchProject(txtSearchId.getText());
//        if(projectDTO!=null){
//            txtSearchId.setText(projectDTO.getId());
//            txtSearchName.setText(projectDTO.getName());
//            txtSearchNIC.setText(projectDTO.getNic());
//            txtSearchCost.setText(String.valueOf(projectDTO.getCost()));
//        }else{
//            JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
//        }

if(yes==JOptionPane.YES_OPTION){

    projectService.deleteProject(txtDeleteId.getText());
    JOptionPane.showMessageDialog(null,"Project Deleted Successfully");
    loadAllProjects();

        }
    }

    @FXML
    void btnEditOnAction(ActionEvent event) {

        String p_id=txtEditId.getText();
        String PO_NIC=txtEditNIC.getText();
        String  P_Name=txtEditName.getText();
        Long P_Cost=Long.parseLong(txtEditCost.getText());

        ProjectDTO projectDTO = projectService.updateProject(new ProjectDTO(p_id, P_Name, P_Cost, PO_NIC));

        if(projectDTO!=null){
            JOptionPane.showMessageDialog(null,"Project Updated Successfully");
            loadAllProjects();
        }else {
            JOptionPane.showMessageDialog(null,"Project Updated UnSuccessfully");
            loadAllProjects();
        }

//        Projects projects=new Projects(p_id,P_Name,P_Cost,PO_NIC);
//
//        boolean isupdated = false;
//        try {
//            isupdated = ProjectsModel.editProjects(projects);
//        if(isupdated){
//            JOptionPane.showMessageDialog(null,"Project Updated Successfully");
//            loadAllProjects();
//        }
//        } catch (SQLException | ClassNotFoundException e) {
//
//            System.out.println(e);
//        }


    }

    @FXML
    void btnSaveOnAction(ActionEvent event)  {

        String p_id=txtAddId.getText();
        String PO_NIC=txtAddNIC.getText();
        String  P_Name=txtAddName.getText();
        Long P_Cost=Long.parseLong(txtAddCost.getText());


        if(projectService.AddProject(new ProjectDTO(P_Name,p_id,P_Cost,PO_NIC))!=null){
            JOptionPane.showMessageDialog(null,"Project Added Successfuly");
            loadAllProjects();
        }else{
            JOptionPane.showMessageDialog(null,"Project Added UnSuccessfuly");
            loadAllProjects();
        }

//        Projects projects=new Projects(P_Name,p_id,P_Cost,PO_NIC);
//
//        boolean isadded= false;
//        try {
//            isadded = ProjectsModel.AddProject(projects);
//        if(isadded){
//            JOptionPane.showMessageDialog(null,"Project Added Successfuly");
//            loadAllProjects();
//        }
//        } catch (SQLException | ClassNotFoundException e) {
//
//            JOptionPane.showMessageDialog(null,"Their is no Project Owner For This National Identy Card","Worring",JOptionPane.WARNING_MESSAGE);
//            System.out.println(e);
//        }


    }

    @FXML
    void btnSearchOnAction(ActionEvent event) {



        ProjectDTO projectDTO = projectService.searchProject(txtSearchId.getText());
        if(projectDTO!=null){
            txtSearchId.setText(projectDTO.getId());
            txtSearchName.setText(projectDTO.getName());
            txtSearchNIC.setText(projectDTO.getNic());
            txtSearchCost.setText(String.valueOf(projectDTO.getCost()));
        }else{
            JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
        }
    }

//    public ArrayList<Projects> loadAll() throws SQLException, ClassNotFoundException {
//
//        ResultSet resultSet = CrudUtil.execute("SELECT * FROM projects");
//        ArrayList<Projects> list= new ArrayList<>();
//        while (resultSet.next()){
//            list.add(new Projects(resultSet.getString(1),resultSet.getString(2),
//                    resultSet.getLong(3),resultSet.getString(4)));
//        }
//        return list;
//    }


    private void loadAllProjects() {

        List<ProjectTM> collect = projectService.allProjects().stream().map(projects ->
                new ProjectTM(projects.getId(), projects.getName(), projects.getCost(), projects.getNic())).collect(Collectors.toList());

        tblProjects.setItems(FXCollections.observableArrayList(collect));

//======================================================Right Click Start===============================================
                tblProjectId.setCellFactory(new Callback<TableColumn<ProjectTM, String>, TableCell<ProjectTM, String>>() {

                    @Override
                    public TableCell<ProjectTM, String> call(TableColumn<ProjectTM, String> column) {

                        final TableCell<ProjectTM, String> cell = new TableCell<>();
                        cell.textProperty().bind(cell.itemProperty()); // in general might need to subclass TableCell and override updateItem(...) here
                        cell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getButton() == MouseButton.SECONDARY) {
                                    System.out.println("Haloo");
                                    // handle right click on cell...
                                    cell.getItem();
                                    ProjectTM item = (ProjectTM) cell.getTableRow().getItem();
                                }
                            }
                        });
                        return cell;
                    }
                });
//==============================================Right Click Ends========================================================
    }


    public void btnReloardOnAction(ActionEvent actionEvent) {
        loadAllProjects();
    }

    public void EditSlideByTables(ActionEvent actionEvent) {

        new FadeInDown(EditSlider).play();
    }

    public void DeleteSlideByTables(ActionEvent actionEvent) {
        new FadeInDown(DeleteSlider).play();
    }

//====================================================================================================================
private Pattern patternNIC;
    private Pattern patternName;
    private Pattern patternCost;
    private Pattern patternId;

    @FXML
    void setAddIdPattern(KeyEvent event) {

        boolean matches = patternId.matcher(txtAddId.getText()).matches();
        if(matches){
            txtAddId.setFocusColor(Paint.valueOf("Blue"));
           // lblAddNicPattern.setText("");
        }else{

            txtAddId.setFocusColor(Paint.valueOf("Red"));
           // lblAddNicPattern.setText("Enter 12 Number NIC");
        }

    }

    @FXML
    void setAddNICPattern(KeyEvent event) {
        boolean matches = patternNIC.matcher(txtAddNIC.getText()).matches();
        if(matches){
            txtAddNIC.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtAddNIC.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }

    }

    @FXML
    void setAddNamePattern(KeyEvent event) {
        boolean matches = patternName.matcher(txtAddName.getText()).matches();
        if(matches){
            txtAddName.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtAddName.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }

    }

    @FXML
    void setAddPricePattern(KeyEvent event) {
        boolean matches = patternCost.matcher(txtAddCost.getText()).matches();
        if(matches){
            txtAddCost.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtAddCost.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }

    }

    @FXML
    void setDeleteNICPattern(KeyEvent event) {
        boolean matches = patternNIC.matcher(txtDeleteNIC.getText()).matches();
        if(matches){
            txtDeleteNIC.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtDeleteNIC.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }
    }

    @FXML
    void setEditIdPattern(KeyEvent event) {
        boolean matches = patternId.matcher(txtEditId.getText()).matches();
        if(matches){
            txtEditId.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtEditId.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }
    }

    @FXML
    void setEditNICPattern(KeyEvent event) {
        boolean matches = patternNIC.matcher(txtEditNIC.getText()).matches();
        if(matches){
            txtEditNIC.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtEditNIC.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }
    }

    @FXML
    void setEditNamePattern(KeyEvent event) {
        boolean matches = patternName.matcher(txtEditName.getText()).matches();
        if(matches){
            txtEditName.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtEditName.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }
    }

    @FXML
    void setEditPricePattern(KeyEvent event) {
        boolean matches = patternCost.matcher(txtEditCost.getText()).matches();
        if(matches){
            txtEditCost.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtEditCost.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }
    }

    @FXML
    void setSearchNICPattern(KeyEvent event) {




        boolean matches = patternNIC.matcher(txtSearchNIC.getText()).matches();
        if(matches){
            txtSearchNIC.setFocusColor(Paint.valueOf("Blue"));
            // lblAddNicPattern.setText("");
        }else{

            txtSearchNIC.setFocusColor(Paint.valueOf("Red"));
            // lblAddNicPattern.setText("Enter 12 Number NIC");
        }
    }

    public void dataOnAction(ActionEvent actionEvent) {}

    public void searchByIdOnAction(ActionEvent actionEvent) {

        ProjectDTO projectDTO = projectService.searchProject(txtDeleteId.getText());
        if(projectDTO!=null){
            txtDeleteId.setText(projectDTO.getId());
            txtDeleteName.setText(projectDTO.getName());
            txtDeleteNIC.setText(projectDTO.getNic());
            txtDeleteCost.setText(String.valueOf(projectDTO.getCost()));
        }else{
            JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void searchByIdEditOnAction(ActionEvent actionEvent) {
        ProjectDTO projectDTO = projectService.searchProject(txtEditId.getText());
        if(projectDTO!=null){
            txtEditId.setText(projectDTO.getId());
            txtEditName.setText(projectDTO.getName());
            txtEditNIC.setText(projectDTO.getNic());
            txtEditCost.setText(String.valueOf(projectDTO.getCost()));
        }else{
            JOptionPane.showMessageDialog(null,"Projec Is Not Found!","Worining",JOptionPane.WARNING_MESSAGE);
        }
    }
}
