package lk.ijse.orm.thogakade.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.orm.thogakade.dto.tm.CustomerTm;
import lk.ijse.orm.thogakade.entity.Customer;
import lk.ijse.orm.thogakade.repository.CustomerRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {

    @FXML
    private JFXTextField txtCustId;

    @FXML
    private JFXTextField txtCustName;

    @FXML
    private JFXTextField txtCustAddress;

    @FXML
    private JFXTextField txtCustSalary;

    @FXML
    private TableView<CustomerTm> mainCOMCustomer;

    @FXML
    private TableColumn<?, ?> COMCusId;

    @FXML
    private TableColumn<?, ?> COMCustomName;

    @FXML
    private TableColumn<?, ?> COMCustContact;

    @FXML
    private TableColumn<?, ?> COMCustSalary;

    @FXML
    void deleteOnAction(ActionEvent event) {
        Customer customer = getCustomer();
        CustomerRepository studentRepository = new CustomerRepository(); //delete eka
        boolean id  =  studentRepository.deleteCustomer(customer);
        if (id) {
            onActionGetAllCustom();
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Delete succsess!").showAndWait();
        } else {
            new javafx.scene.control.Alert(Alert.AlertType.ERROR, "Erorr!").showAndWait();
        }
    }

    @FXML
    void CsstOnMouse(MouseEvent event) {
        TablePosition pos=mainCOMCustomer.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();
        ObservableList<TableColumn<CustomerTm,?>> columns=mainCOMCustomer.getColumns();
        txtCustId.setText(columns.get(0).getCellData(row).toString());
        txtCustName.setText(columns.get(1).getCellData(row).toString());
        txtCustAddress.setText(columns.get(2).getCellData(row).toString());
        txtCustSalary.setText(columns.get(3).getCellData(row).toString());
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        Customer customer = getCustomer();
        CustomerRepository studentRepository = new CustomerRepository();     // save eka
        boolean id  = studentRepository.saveCustomer(customer);
        if (id) {
            onActionGetAllCustom();
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Save succsess!").showAndWait();
        } else {
            new javafx.scene.control.Alert(Alert.AlertType.ERROR, "Erorr!").showAndWait();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        Customer customer = getCustomer();
        CustomerRepository studentRepository = new CustomerRepository();     //update eka
        boolean id  = studentRepository.updateCustomer(customer);
       // System.out.println(bool);
        if (id) {
            onActionGetAllCustom();
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "update succsess!").showAndWait();
        } else {
            new javafx.scene.control.Alert(Alert.AlertType.ERROR, "Erorr!").showAndWait();
        }
    }

    public Customer getCustomer() {
        Customer customer = new Customer();
        customer.setCustId(Integer.parseInt(txtCustId.getText()));
        customer.setCustName(txtCustName.getText());
        customer.setCustAddress(txtCustAddress.getText());
        customer.setCustSalary(txtCustSalary.getText());
        return customer;
    }

    @FXML
    void initialize() {
        onActionGetAllCustom();
        setCellValuefactory();
    }

    void onActionGetAllCustom() {
        try {
            CustomerRepository customerRepository = new CustomerRepository();
            ObservableList<CustomerTm> extingcus = customerRepository.getAllCustomer();
            System.out.println(extingcus);
            mainCOMCustomer.setItems(extingcus);
        } catch (Exception e) {

        }
      // CustomerRepository customerRepository = new CustomerRepository();
        /*Customer number = customerRepository.getStudent(extingcus);   // get eka save karapu erka
        System.out.println(extingcus);*/
    }

    void setCellValuefactory(){
        COMCusId.setCellValueFactory(new PropertyValueFactory<>("custId"));
        COMCustomName.setCellValueFactory(new PropertyValueFactory<>("custName"));
        COMCustContact.setCellValueFactory(new PropertyValueFactory<>("custAddress"));
        COMCustSalary.setCellValueFactory(new PropertyValueFactory<>("custSalary"));
    }
}
