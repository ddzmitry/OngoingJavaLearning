package View_Controller;

/**
 * Sample Skeleton for 'Main_screen.fxml' Controller Class
 */

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    Inventory inv;

    @FXML // fx:id="root"
    private AnchorPane root; // Value injected by FXMLLoader

    @FXML // fx:id="viewParts"
    private TableView<Part> viewParts; // Value injected by FXMLLoader

    @FXML // fx:id="viewPartID"
    private TableColumn<Part, Integer> viewPartID; // Value injected by FXMLLoader

    @FXML // fx:id="viewPartName"
    private TableColumn<Part, String> viewPartName; // Value injected by FXMLLoader

    @FXML // fx:id="viewPartInv"
    private TableColumn<Part, Integer> viewPartInv; // Value injected by FXMLLoader

    @FXML // fx:id="viewPartPrice"
    private TableColumn<Part, Double> viewPartPrice; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearchParts"
    private Button buttonSearchParts; // Value injected by FXMLLoader

    @FXML // fx:id="dataSearchParts"
    private TextField dataSearchParts; // Value injected by FXMLLoader

    @FXML // fx:id="dataSearchProducts"
    private TextField dataSearchProducts; // Value injected by FXMLLoader

    @FXML // fx:id="buttonSearchProducts"
    private Button buttonSearchProducts; // Value injected by FXMLLoader

    @FXML // fx:id="viewProducts"
    private TableView<Product> viewProducts; // Value injected by FXMLLoader

    @FXML // fx:id="viewProductID"
    private TableColumn<Product, Integer> viewProductID; // Value injected by FXMLLoader

    @FXML // fx:id="viewProductName"
    private TableColumn<Product, String> viewProductName; // Value injected by FXMLLoader

    @FXML // fx:id="viewProductInv"
    private TableColumn<Product, Integer> viewProductInv; // Value injected by FXMLLoader

    @FXML // fx:id="viewProductPrice"
    private TableColumn<Product, Double> viewProductPrice; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddParts"
    private Button buttonAddParts; // Value injected by FXMLLoader

    @FXML // fx:id="buttonModifyParts"
    private Button buttonModifyParts; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDeleteParts"
    private Button buttonDeleteParts; // Value injected by FXMLLoader

    @FXML // fx:id="buttonExit"
    private Button buttonExit; // Value injected by FXMLLoader

    @FXML // fx:id="buttonAddProducts"
    private Button buttonAddProducts; // Value injected by FXMLLoader

    @FXML // fx:id="buttonModifyProducts"
    private Button buttonModifyProducts; // Value injected by FXMLLoader

    @FXML // fx:id="buttonDeleteProducts"
    private Button buttonDeleteProducts; // Value injected by FXMLLoader

    // Get inventory to constructor
    public MainScreenController(Inventory inv) {
    }

    @FXML
    void activateAddPartsScreen(ActionEvent event) {

    }

    @FXML
    void activateAddProductsScreen(ActionEvent event) {

    }

    @FXML
    void activateDeletePartsScreen(ActionEvent event) {

    }

    @FXML
    void activateDeleteProductsScreen(ActionEvent event) {

    }

    @FXML
    void activateModifyPartsScreen(ActionEvent event) {

    }

    @FXML
    void activateModifyProductsScreen(ActionEvent event) {

    }

    @FXML
    void lookupPartsSearch(ActionEvent event) {

    }

    @FXML
    void lookupProductsSearch(ActionEvent event) {

    }

    @FXML
    void exitApp(){
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
