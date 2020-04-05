package View_Controller;

/**
 * Sample Skeleton for 'Main_screen.fxml' Controller Class
 */

import Model.Inventory;
import Model.Part;
import Model.Product;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    Inventory inv;
    // Locals
    private ObservableList<Part> partInv = FXCollections.observableArrayList();
    private ObservableList<Product> productInv = FXCollections.observableArrayList();
    // Serchebles
    private ObservableList<Part> partInvSearch = FXCollections.observableArrayList();
    private ObservableList<Product> productInvSearch = FXCollections.observableArrayList();


    @FXML // fx:id="root"
    private AnchorPane root; // Value injected by FXMLLoader

    @FXML // fx:id="viewParts"
    private TableView<Part> viewParts; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Part, Integer>  viewPartID;

    @FXML
    private TableColumn<Part, String> viewPartName;

    @FXML
    private TableColumn<Part, Integer>  viewPartStock;


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
    private TableColumn<Product, Integer> viewProductStock; // Value injected by FXMLLoader


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
        this.inv = inv;
    }

    @FXML
    void activateAddPartsScreen(ActionEvent event) {

    }

    @FXML
    void activateAddProductsScreen(ActionEvent event) {

    }

    @FXML
    void activateDeletePartsScreen(ActionEvent event) {
        // We need to find which part is being selected
        Part partSelected =  viewParts.getSelectionModel().getSelectedItem();
        // Ve need to Validate if part is being possessed by any PRODUCTS
        boolean found = false;
        StringBuilder warningMessage;
        warningMessage = new StringBuilder();

        for(Product product: productInv){
            for(Part innerPart: product.getAssociatedPartsList()){
                System.out.println(innerPart.getPartID());
                if(innerPart.getPartID() == partSelected.getPartID()){
                    warningMessage.append(String.format("Product name: %s\n",product.getProductName()));
                    found = true;
                }
            }
        }

        if(found){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Deletion Error");
            alert.setHeaderText("Part cannot be deleted!");
            alert.setContentText("Part is being used by.\n" + warningMessage.toString());
            alert.showAndWait();

        } else{
            System.out.println("Can Delete");
            partInv.remove(partSelected);
            viewParts.setItems(partInv);
//            generatePartsTableValues();
        }


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
        generatePartsTableValues();
        generateProductsTableValues();
    }
    @FXML
    private void generatePartsTableValues() {
        partInv.addAll(inv.getAllParts());
        // to preserve dollar sign
//        TableColumn<Part,Double> priceColl = formatPrice("Part");
//        viewParts.getColumns().addAll(priceColl);
        viewParts.setItems(partInv);
        viewParts.refresh();
    }
    @FXML
    private void generateProductsTableValues() {
        productInv.addAll(inv.getAllProducts());
//        TableColumn<Product,Double> priceColl = formatPrice("Product");
//        viewProducts.getColumns().addAll(priceColl);
        viewProducts.setItems(productInv);
        viewProducts.refresh();
    }

    // will work for both
//    private <T> TableColumn<T,Double> formatPrice(String ClassName) {
//     TableColumn<T,Double> priceColl = new TableColumn("Price");
//        priceColl.setResizable(false);
//        // Pick ProductPrice , PartPrice
//        priceColl.setCellValueFactory(new PropertyValueFactory<>( String.format("%sPrice",ClassName)));
//
//        priceColl.setCellFactory((TableColumn<T,Double> col)->{
//            return new TableCell<T, Double>(){
//                @Override
//                protected void updateItem(Double item,boolean isempty){
//                    if(!isempty){
//                        setText("$" + String.format("%10.2f",item));
//                    }
//                }
//            };
//        }
//        );
//        return priceColl;
//    }


}
