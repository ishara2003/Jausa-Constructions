package lk.sankalpa.controller;

import animatefx.animation.ZoomInDown;
import animatefx.animation.ZoomOutUp;
import com.jfoenix.controls.JFXHamburger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.sankalpa.Util.CrudUtil;
import lk.sankalpa.Util.Navigation;
import lk.sankalpa.Util.Routes;
import lk.sankalpa.dto.EmployeeDTO;
import lk.sankalpa.others.MenuTranslater;
import lk.sankalpa.service.ServiceFactory;
import lk.sankalpa.service.ServiceType;
import lk.sankalpa.service.custome.EmployeeService;
import lk.sankalpa.tm.EmployeeTM;
import lk.sankalpa.to.Employee;

import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFormController {

    public Button deleteButtern;
    public TextField txtNICDelete;
    public TextField txtWorkSectionDelete;
    public AnchorPane EmployeeForm;
    @FXML
    private JFXHamburger hbMenu;

    @FXML
    private Pane ManagerMenu;

    @FXML
    private Label lblManager;

    @FXML
    private JFXHamburger hbCloseOnAction;

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
    private Label lblP_Owner;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDelete;

    @FXML
    private TableView<EmployeeTM> tblEmplooye;

    @FXML
    private TableColumn<EmployeeTM, String> colName;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colNumber;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colJoinDate;

    @FXML
    private TableColumn<?, ?> colWorkingSection;

    @FXML
    private Pane AddSlider;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtNumber;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtDate;

    @FXML
    private Button addButten;

    @FXML
    private ComboBox<String> cmbWorkSectionAdd;

    @FXML
    private Pane EditSlider;

    @FXML
    private TextField txtNameEdit;

    @FXML
    private TextField txtNICEdit;

    @FXML
    private TextField txtAgeEdit;

    @FXML
    private TextField txtAddressEdit;

    @FXML
    private TextField txtNumberEdit;

    @FXML
    private TextField txtSalaryEdit;

    @FXML
    private TextField txtDateEdit;

    @FXML
    private ComboBox<String> cmbWorkSectionEdit;

    @FXML
    private Button editButtern;

    @FXML
    private Pane DeleteSlider;

    @FXML
    private TextField txtNameDelete;

    @FXML
    private TextField txtNICEditDelete;

    @FXML
    private TextField txtAgeDelete;

    @FXML
    private TextField txtAddressDelete;

    @FXML
    private TextField txtNumberDelete;

    @FXML
    private TextField txtSalaryDelete;

    @FXML
    private TextField txtDateDelete;

    @FXML
    private ComboBox<String> cmbWorkSectionDelete;

    @FXML
    private Button editButtern1;
    public EmployeeService employeeService;

    public void initialize(){

        this.employeeService= ServiceFactory.getInstance().getService(ServiceType.EMPLOYEE);
        lblP_Owner.setCursor(Cursor.HAND);
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
        addButten.setCursor(Cursor.HAND);
        editButtern.setCursor(Cursor.HAND);
        deleteButtern.setCursor(Cursor.HAND);
        btnAdd.setCursor(Cursor.HAND);
        btnEdit.setCursor(Cursor.HAND);
        btnDelete.setCursor(Cursor.HAND);

        ManagerMenu.setVisible(true);
        MenuTranslater.setTranslater(hbMenu,hbCloseOnAction, ManagerMenu);

        colName.setCellValueFactory(new PropertyValueFactory<EmployeeTM, String>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        colJoinDate.setCellValueFactory(new PropertyValueFactory<>("JoinDate"));
        colWorkingSection.setCellValueFactory(new PropertyValueFactory<>("WorkSection"));

        cmbWorkSectionAdd.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {        });
        cmbWorkSectionEdit.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {        });

        cmbWorkSectionAdd.setItems(options);
        cmbWorkSectionEdit.setItems(options);

        loadAllEmployees();

    }


    public ArrayList<Employee> loadAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = CrudUtil.execute("SELECT * FROM employee");
        ArrayList<Employee> list= new ArrayList<>();
        while (resultSet.next()){
            list.add(new Employee(resultSet.getString(1),resultSet.getString(2),
                    resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),resultSet.getString(7)
            ,resultSet.getString(8)));
        }
        return list;
    }

    private void loadAllEmployees() {

        List<EmployeeTM> collect = employeeService.allEmployees().stream().map(employeeDTO -> new EmployeeTM(employeeDTO.getName(), employeeDTO.getNIC(), employeeDTO.getAddress(), employeeDTO.getNumber(),
                employeeDTO.getAge(), employeeDTO.getSalary(), employeeDTO.getJoinDate(), employeeDTO.getWorkSection())).collect(Collectors.toList());

        tblEmplooye.setItems(FXCollections.observableArrayList(collect));

//        ObservableList<EmployeeTM> obList = FXCollections.observableArrayList();
//        try {
//            for (Employee c : loadAll()) {
//                EmployeeTM tm= new EmployeeTM(c.getName(), c.getNIC(), c.getAddress(), c.getNumber(),c.getAge(),c.getSalary(),c.getJoinDate(),c.getWorkSection());
//
//                obList.add(tm);
//                tblEmplooye.setItems(obList);
//            }
//        }catch (SQLException | ClassNotFoundException e){
//            System.out.println(e);
//        }
    }

    @FXML
    void AddEmployeeSlidOnAction(ActionEvent event) {

        new ZoomInDown(AddSlider).play();
        AddSlider.setVisible(true);



    }

    @FXML
    void CloseAddSlider(ActionEvent event) {
        new ZoomOutUp(AddSlider).play();
       // AddSlider.setVisible(false);

    }

    @FXML
    void CloseEditSlider(ActionEvent event) {
        new ZoomOutUp(EditSlider).play();

    }

    @FXML
    void EditEmployeeOnaAtion(ActionEvent event) {
        System.out.println("fgff");



    }

    @FXML
    ObservableList<String> options =
            FXCollections.observableArrayList(
                    "Managing Director" ,
                            "Operation manager" ,
                            "Finamce manager" ,
                            "Project manager" ,
                            "Accountant" ,
                            "Site engineer " ,
                            "Store keeper" ,
                            "Site supervisor" ,
                            "Labor"
            );
    @FXML
    void addEmployeeOnAction(ActionEvent event) {

        String name = txtName.getText();
        String Nic = txtNIC.getText();
        String Address = txtAddress.getText();
        String Number = txtNumber.getText();
        String Age = txtAge.getText();
        String Salary = txtSalary.getText();
        String Date = txtDate.getText();
        String WorkSection = String.valueOf(cmbWorkSectionAdd.getSelectionModel().getSelectedItem());


      //  Employee employee=new Employee(name,Nic,Address,Number,Age,Salary,Date,WorkSection);
        EmployeeDTO employeeDTO = new EmployeeDTO(name, Nic, Address, Number, Age, Salary, Date, WorkSection);

        EmployeeDTO employeeDTO1 = employeeService.SaveEmployee(employeeDTO);
        if(employeeDTO1!=null){
            JOptionPane.showMessageDialog(null,"Employee Added Successfully");
            loadAllEmployees();
        }else {
            JOptionPane.showMessageDialog(null,"Employee Added UnSuccessfully");
           // loadAllEmployees();
        }

//        try {
//            boolean isadded= EmployeeModel.AddEmployee(employee);
//
//            if(isadded){
//                JOptionPane.showMessageDialog(null,"Employee Added Successfully");
//                loadAllEmployees();
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//
//            System.out.println(e);
//        }

    }
    //=================================Start Of Navigation Methods Of Navigathin Methids=======================================================
    @FXML
    void baackToOrderManage(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDERS_MANAGE,EmployeeForm);
    }

    @FXML
    void backToDetailsOnAction(MouseEvent event) throws IOException {
Navigation.navigate(Routes.ORDER_DETAILS,EmployeeForm);
    }

    @FXML
    void backToEmployeeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.ORDER_DETAILS,EmployeeForm);
    }

    @FXML
    void backToIncomeOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.INCOME,EmployeeForm);
    }

    @FXML
    void backToManagerForm(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.MANAGER_FORM,EmployeeForm);
    }

    @FXML
    void backToPaymentOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PAYMENTS,EmployeeForm);
    }

    @FXML
    void backToProjectsOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.PROJECTS,EmployeeForm);
    }

    @FXML
    void backToReportOnAction(MouseEvent event) {

    }

    @FXML
    void backToStockOnAction(MouseEvent event) throws IOException {
        Navigation.navigate(Routes.STOCK_MANAGE,EmployeeForm);
    }
    //=================================End Of Navigathin Methids=======================================================

    @FXML
    void deleteEmployeeSlidOnAction(ActionEvent event) {
        new ZoomInDown(DeleteSlider).play();
        DeleteSlider.setVisible(true);
    }

    @FXML
    void editEmployeeSlidOnAction(ActionEvent event) {
        new ZoomInDown(EditSlider).play();
        EditSlider.setVisible(true);
    }

    @FXML
    void workSectionAddOnAction(ActionEvent event) {

    }

    @FXML
    void workSectionEditOnAction(ActionEvent event) {

    }


    public void CloseDeleteSlider(ActionEvent actionEvent) {
        new ZoomOutUp(DeleteSlider).play();
    }


    public void editt(ActionEvent actionEvent) {
        String name = txtNameEdit.getText();
        String Nic = txtNICEdit.getText();
        String Address = txtAddressEdit.getText();
        String Number = txtNumberEdit.getText();
        String Age = txtAgeEdit.getText();
        String Salary = txtSalaryEdit.getText();
        String Date = txtDateEdit.getText();
        String WorkSection = String.valueOf(cmbWorkSectionEdit.getSelectionModel().getSelectedItem());


        if(employeeService.editemployeeDetails(new EmployeeDTO(name,Nic,Address,Number,Age,Salary,Date,WorkSection))!=null){
            JOptionPane.showMessageDialog(null, "Information Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
            loadAllEmployees();
        }else {
            JOptionPane.showMessageDialog(null, "Information Cheanged Unsuccessfully", "Alert", JOptionPane.WARNING_MESSAGE);
            loadAllEmployees();
        }

//        try {
//
//
//            boolean b = EmployeeModel.editEmployee(name,Nic,Address,Number,Age,Salary,Date,WorkSection);
//            if(b){
//                JOptionPane.showMessageDialog(null, "Information Cheanged successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
//                loadAllEmployees();
//            }
//        } catch (SQLException | ClassNotFoundException e) {
//
//            System.out.println(e);
//        }

    }

    public void delete(ActionEvent actionEvent) {
        String nic = txtNICDelete.getText();

        employeeService.deleteemployee(nic);
        new Alert(null,"Employee Deleted Success fully");
        loadAllEmployees();

//        try {
//            boolean delete = EmployeeModel.delete(nic);
//            System.out.println(delete);
//            if(delete){
//                JOptionPane.showMessageDialog(null,"Employee Has Removed ");
//                loadAllEmployees();
//            }
//
//        } catch (SQLException | ClassNotFoundException e) {
//            System.out.println(e);
//
//        }
    }


    public void setDeleteDetailss(KeyEvent keyEvent) {
        String NIC = txtNICDelete.getText();

        EmployeeDTO employee = employeeService.searchEmployee(NIC);

        if(employee!=null){
            txtNameDelete.setText(employee.getName());
            txtAddressDelete.setText(employee.getAddress());
            txtNumberDelete.setText(employee.getNumber());
            txtAgeDelete.setText(employee.getAge());
            txtSalaryDelete.setText(employee.getSalary());
            txtDateDelete.setText(employee.getJoinDate());
            txtWorkSectionDelete.setText(employee.getWorkSection());
        }else {
            new Alert(null,"Not Found");
        }


//        try {
//            Employee employee = EmployeeModel.searchEmployee(NIC);
//
//            if(employee!=null){
//                txtNameDelete.setText(employee.getName());
//                txtAddressDelete.setText(employee.getAddress());
//                txtNumberDelete.setText(employee.getNumber());
//                txtAgeDelete.setText(employee.getAge());
//                txtSalaryDelete.setText(employee.getSalary());
//                txtDateDelete.setText(employee.getJoinDate());
//                txtWorkSectionDelete.setText(employee.getWorkSection());
//            }else {}
//        } catch (SQLException | ClassNotFoundException e) {
//        }
    }

    public void setDetailsOnActionSearch(KeyEvent keyEvent) {
        String NIC = txtNICDelete.getText();

        EmployeeDTO employee = employeeService.searchEmployee(NIC);

        if(employee!=null){
            txtNameEdit.setText(employee.getName());
            txtAddressEdit.setText(employee.getAddress());
            txtNumberEdit.setText(employee.getNumber());
            txtAgeEdit.setText(employee.getAge());
            txtSalaryEdit.setText(employee.getSalary());
            txtDateEdit.setText(employee.getJoinDate());
            txtWorkSectionDelete.setText(employee.getWorkSection());
        }else {
            new Alert(null,"Not Found");
        }
    }
}
