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
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    Inventory inv;
    // Locals
    private ObservableList<Part> partInv = FXCollections.observableArrayList();
    private ObservableList<Product> productInv = FXCollections.observableArrayList();
    // Serchebles
    private ObservableList<Part> partInvSearch = FXCollections.observableArrayList();
    private ObservableList<Product> productInvSearch = FXCollections.observableArrayList();
    private String PartsearchParams;


    @FXML // fx:id="root"
    private AnchorPane root; // Value injected by FXMLLoader

    @FXML // fx:id="viewParts"
    private TableView<Part> viewParts; // Value injected by FXMLLoader

    @FXML
    private TableColumn<Part, Integer> viewPartID;

    @FXML
    private TableColumn<Part, String> viewPartName;

    @FXML
    private TableColumn<Part, Integer> viewPartStock;


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
    void activateAddProductsScreen(ActionEvent event) {

    }

    @FXML
    void activateDeletePartsScreen(ActionEvent event) {
        // We need to find which part is being selected
        if (partInv.size() != 0) {
            Part partSelected = viewParts.getSelectionModel().getSelectedItem();
            // Ve need to Validate if part is being possessed by any PRODUCTS

            boolean found = false;
            StringBuilder warningMessage;
            warningMessage = new StringBuilder();

            for (Product product : productInv) {
                if (product.getAssociatedPartsList().contains(partSelected)) {
                    warningMessage.append(String.format("Product name: %s \n", product.getProductName()));
                    found = true;
                }
            }

            if (found) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Deletion Error");
                alert.setHeaderText("Part cannot be deleted!");
                alert.setContentText("Part is being used by.\n" + warningMessage.toString());
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initModality(Modality.NONE);
                alert.setTitle(String.format("Delete Part ID: " + partSelected.getPartID()));
                alert.setHeaderText("Confirm?");
                alert.setContentText("Are you sure you want to delete Part: " + partSelected.getPartName() + "?");
                // wait for result
                Optional<ButtonType> result = alert.showAndWait();
                // check
                if (result.get() == ButtonType.OK) {
                    partInv.remove(partSelected);
                    viewParts.setItems(partInv);
                    System.out.println(" Part " + partSelected.getPartName() + " was removed");
                } else {
                    System.out.println("Not removing");
                }

                // clear in case if there is output
                if (dataSearchParts.getText() != null) {

                    dataSearchParts.clear();
                    buttonSearchParts.setText("Search");
                }
            }
        } else {
            Alert nodataToRemove = new Alert(Alert.AlertType.INFORMATION);
            nodataToRemove.setTitle("There is nothing to remove");
            nodataToRemove.setHeaderText("No parts available");
            nodataToRemove.showAndWait();
        }
    }

    @FXML
    void activateDeleteProductsScreen(ActionEvent event) {
        // Deleting product
        if (productInv.size() > 0) {
            Product ProductSelected = viewProducts.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.initModality(Modality.NONE);
            alert.setTitle(String.format("Delete Product ID: " + ProductSelected.getParts()));
            alert.setHeaderText("Confirm?");
            alert.setContentText("Are you sure you want to delete Product: " + ProductSelected.getProductName() + "?");
            // wait for result
            Optional<ButtonType> result = alert.showAndWait();
            // check
            if (result.get() == ButtonType.OK) {
                productInv.remove(ProductSelected);
                viewProducts.setItems(productInv);
                System.out.println(" Part " + ProductSelected.getProductName() + " was removed");
            } else {
                System.out.println("Not removing");
            }

        } else {
            Alert nodataToRemove = new Alert(Alert.AlertType.INFORMATION);
            nodataToRemove.setTitle("There is nothing to remove");
            nodataToRemove.setHeaderText("No Products available");
            nodataToRemove.showAndWait();
        }

        if (dataSearchProducts.getText() != null) {

            dataSearchProducts.clear();
            buttonSearchProducts.setText("Search");
        }

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
    void exitApp() {
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generatePartsTableValues();
        generateProductsTableValues();
    }


    /*
     * @generateSearchPartsTableValues
     * @generateSearchProductsTableValues
     * Regenerate data based of the search
     * */
    private void generateSearchPartsTableValues() {

        viewParts.setItems(partInvSearch);
        viewParts.refresh();
        if (partInvSearch.size() > 0 && partInvSearch.size() != partInv.size()) {
            buttonSearchParts.setText(String.format("Found(%s)", partInvSearch.size()));
        } else {
            buttonSearchParts.setText("Search");
        }

    }

    private void generateSearchProductsTableValues() {
        viewProducts.setItems(productInvSearch);
        viewProducts.refresh();
        if (productInvSearch.size() > 0 && productInvSearch.size() != productInv.size()) {
            buttonSearchProducts.setText(String.format("Found(%s)", productInvSearch.size()));
        } else {
            buttonSearchProducts.setText("Search");
        }

    }

    /*
     *
     * Table view generators
     *
     * */
    @FXML
    private void generateProductsTableValues() {
        productInv.addAll(inv.getAllProducts());
        viewProducts.setItems(productInv);
        viewProducts.refresh();
    }

    @FXML
    private void generatePartsTableValues() {
        partInv.addAll(inv.getAllParts());
        viewParts.setItems(partInv);
        viewParts.refresh();
    }

    @FXML
    private void partFuzzySearch(Event e) {
        //clear observable
        partInvSearch.clear();
        for (Part p : partInv) {
            // Fizzy Search on contains function
            if (p.getPartName().toLowerCase().contains(dataSearchParts.getText().toLowerCase())) {
                //append to observable
                partInvSearch.add(p);

            }

        }


        generateSearchPartsTableValues();

    }

    @FXML
    private void productFuzzySearch(Event e) {
        //clear observable
        productInvSearch.clear();
        for (Product p : productInv) {
            // Fizzy Search on contains function
            System.out.println(p.getProductName());
            if (p.getProductName().toLowerCase().contains(dataSearchProducts.getText().toLowerCase())) {
                //append to observable
                productInvSearch.add(p);
            }

        }
        generateSearchProductsTableValues();
    }

    /*
    * Add Part/Product Screens
    *
    * */

    @FXML
    private void activateAddPartsScreen(ActionEvent event) throws IOException {

        try{
            FXMLLoader loader = new FXMLLoader();
            View_Controller.AddPartController controller = new View_Controller.AddPartController(inv,null,null);
            // Add controller programatically to keep persistant storage
            loader.setController(controller);
            loader.setLocation(getClass().getResource("AddPart.fxml"));
            Parent product_page_parent = loader.load();
            Scene main_page_scene = new Scene(product_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide(); //optional
            app_stage.setScene(main_page_scene);
            app_stage.show();
        } catch (IOException err){
            System.out.println("Couldn't load template");
            System.out.println(err.getMessage());
            return;
        }

    }

    @FXML
    void activateModifyPartsScreen(ActionEvent event) throws IOException {

        if (partInv.size() != 0) {
            Part partSelected = viewParts.getSelectionModel().getSelectedItem();
            for (int i = 0; i < partInv.size(); i++) {
                if(partSelected == partInv.get(i)){
                    FXMLLoader loader = new FXMLLoader();
                    View_Controller.AddPartController controller = new AddPartController(inv, partSelected,i);
                    loader.setController(controller);
                    loader.setLocation(getClass().getResource("AddPart.fxml"));
                    Parent product_page_parent = loader.load();
                    Scene main_page_scene = new Scene(product_page_parent);
                    Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_stage.hide(); //optional
                    app_stage.setScene(main_page_scene);
                    app_stage.show();

                }
            }


            //partSelected
        }else {
            Alert nodataToRemove = new Alert(Alert.AlertType.INFORMATION);
            nodataToRemove.setTitle("There is nothing to modify");
            nodataToRemove.setHeaderText("No Products available");
            nodataToRemove.showAndWait();
        }

    }


}
