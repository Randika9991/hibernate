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
import lk.ijse.orm.thogakade.dto.tm.ItemTm;
import lk.ijse.orm.thogakade.entity.Customer;
import lk.ijse.orm.thogakade.entity.Item;
import lk.ijse.orm.thogakade.repository.CustomerRepository;
import lk.ijse.orm.thogakade.repository.ItemRepository;

public class ItemController {
    @FXML
    private JFXTextField txtItenCode;

    @FXML
    private JFXTextField txtItemDescrip;

    @FXML
    private JFXTextField txtItemPrice;

    @FXML
    private JFXTextField txtItemQOH;

    @FXML
    private TableView<ItemTm> mainCOMItem;

    @FXML
    private TableColumn<?, ?> COMItemCode;

    @FXML
    private TableColumn<?, ?> COMItemAddress;

    @FXML
    private TableColumn<?, ?> COMItemPrice;

    @FXML
    private TableColumn<?, ?> COMQOH;

    @FXML
    void CsstOnMouse(MouseEvent event) {
        TablePosition pos=mainCOMItem.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();
        ObservableList<TableColumn<ItemTm,?>> columns=mainCOMItem.getColumns();
        txtItenCode.setText(columns.get(0).getCellData(row).toString());
        txtItemDescrip.setText(columns.get(1).getCellData(row).toString());
        txtItemPrice.setText(columns.get(2).getCellData(row).toString());
        txtItemQOH.setText(columns.get(3).getCellData(row).toString());
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        Item item = getCustomer();
        ItemRepository studentRepository = new ItemRepository();//delete eka
        boolean id  = studentRepository.deleteItem(item);
        if (id) {
            onActionGetAllCustom();
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Delete succsess!").showAndWait();
        } else {
            new javafx.scene.control.Alert(Alert.AlertType.ERROR, "Erorr!").showAndWait();
        }
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        Item item = getCustomer();
        ItemRepository studentRepository = new ItemRepository();     //update eka
        boolean id  = studentRepository.updateItem(item);
        // System.out.println(bool);
        if (id) {
            onActionGetAllCustom();
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "update succsess!").showAndWait();
        } else {
            new javafx.scene.control.Alert(Alert.AlertType.ERROR, "Erorr!").showAndWait();
        }
    }

    @FXML
    void saveOnAction(ActionEvent event) {
        Item item = getCustomer();
        ItemRepository studentRepository = new ItemRepository();     // save eka
        boolean id  = studentRepository.saveItem(item);
        if (id) {
            onActionGetAllCustom();
            new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION, "Save succsess!").showAndWait();
        }else{
            new javafx.scene.control.Alert(Alert.AlertType.ERROR, "Erorr!").showAndWait();
        }
    }

    public Item getCustomer() {
        Item item = new Item();
        item.setItemCode(txtItenCode.getText());
        item.setItemDescription(txtItemDescrip.getText());
        item.setUnitPrice(Double.parseDouble(txtItemPrice.getText()));
        item.setQtyOnHand(Integer.parseInt(txtItemQOH.getText()));
        return item;
    }

    @FXML
    void initialize() {
        onActionGetAllCustom();
        setCellValuefactory();
    }

    void onActionGetAllCustom() {
        try {
            ItemRepository itemRepository = new ItemRepository();
            ObservableList<ItemTm> extingcus = itemRepository.getAllItem();
            System.out.println(extingcus);
            mainCOMItem.setItems(extingcus);
        } catch (Exception e) {

        }
        // CustomerRepository customerRepository = new CustomerRepository();
        /*Customer number = customerRepository.getStudent(extingcus);   // get eka save karapu erka
        System.out.println(extingcus);*/
    }

    void setCellValuefactory(){
        COMItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        COMItemAddress.setCellValueFactory(new PropertyValueFactory<>("ItemDescription"));
        COMItemPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        COMQOH.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
    }
}
