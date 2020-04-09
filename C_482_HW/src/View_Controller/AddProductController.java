package View_Controller;

import Model.*;
import Utils.Util;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddProductController implements Initializable {

    private ObservableList<Part> partInv = FXCollections.observableArrayList();
    private ObservableList<Product> productInv = FXCollections.observableArrayList();

    private ObservableList<Part> partInvSearch = FXCollections.observableArrayList();
    private ObservableList<Part> partInvAddToProduct = FXCollections.observableArrayList();

    private final Integer index;
    private final Inventory inv;
    private final Product productToUpdate;

    // Product parts
    private String ProductName = null;
    private Double ProductPrice = 0.0;
    private int ProductStock = 0;
    private int ProductMin = 0;
    private int ProductMax = 0;
    private Double PriceToCheck = 0.0;
    Integer ProductID;


    public AddProductController(Inventory inv, Product product, Integer index) {
        this.productToUpdate = product;
        this.inv = inv;
        this.index = index;
    }


    @FXML
    private void generateAddPartsTableValues() {
        partInv.addAll(inv.getAllParts());
        addParts.setItems(partInv);
        addParts.refresh();
    }



    @FXML
    private TableView<Part> addParts;

    @FXML
    private TableColumn<Part, Integer> addPartID;

    @FXML
    private TableColumn<Part, String> addPartName;

    @FXML
    private TableColumn<Part, Integer> addPartStock;

    @FXML
    private TableColumn<Part, Double> addPartPrice;

    @FXML
    private TableView<Part> deleteParts;

    @FXML
    private TableColumn<Part, Integer> deletePartID;

    @FXML
    private TableColumn<Part, String> deletePartName;

    @FXML
    private TableColumn<Part, Integer> deletePartStock;

    @FXML
    private TableColumn<Part, Double> deletePartPrice;

    @FXML
    private Label AddProductsScreenDefenition;

    @FXML
    private Button buttonSearchParts;

    @FXML
    private TextField productSearch;

    @FXML
    private Button btnAddProductsAdd;

    @FXML
    private Button btnAddProductDelete;

    @FXML
    private Button btnAddProductCancel;

    @FXML
    private Button btnAddProductSave;

    @FXML
    private Label addProductIdLabel;


    @FXML
    private TextField addProductName;
    @FXML
    private Label addProductNameValidator;

    @FXML
    private Label addProductStockValidator;
    @FXML
    private TextField addProductStock;


    @FXML
    private TextField addProductPrice;
    @FXML
    private Label addProductPriceValidator;


    @FXML
    private TextField addProductMin;
    @FXML
    private Label addProductMinValidator;

    @FXML
    private TextField addProductMax;
    @FXML
    private Label addProductMaxValidator;


    @FXML
    private void generateDeletePartsTableValues() {

        deleteParts.setItems(partInvAddToProduct);
        deleteParts.refresh();
    }

    @FXML
    private void updateAddPartsViewOnPartAdded() {

        addParts.setItems(partInv);
        addParts.refresh();
    }

    @FXML
    void updatePriceInnerText() {

        addProductPrice.setPromptText(String.format(">=%s", PriceToCheck));
    }

    @FXML
    void handleAdd(ActionEvent event) {
        // Get highlighted Part
        if (partInv.size() > 0) {
            Part partToAdd = addParts.getSelectionModel().getSelectedItem();
            // Update Price
            PriceToCheck += partToAdd.getPartPrice();
            updatePriceInnerText(); // Update Prompt Text for UI

            partInv.remove(partToAdd);
            partInvAddToProduct.add(partToAdd);
            // populate
            generateDeletePartsTableValues();
            updateAddPartsViewOnPartAdded();
            generateDeletePartsTableValues();

        } else {
            Alert nodataToRemove = new Alert(Alert.AlertType.INFORMATION);
            nodataToRemove.setTitle("There is no parts to add");
            nodataToRemove.setHeaderText("No Parts available");
            nodataToRemove.showAndWait();
        }

        // we need to update a price

    }

    @FXML
    void handleDeletePart(ActionEvent event) {

        if (!partInvAddToProduct.isEmpty()) {
            // get A part
            if (!deleteParts.getSelectionModel().isEmpty()) {
                Part partToBeRemoved = deleteParts.getSelectionModel().getSelectedItem();
                // Remove part
                partInvAddToProduct.remove(partToBeRemoved);
                PriceToCheck -= partToBeRemoved.getPartPrice();
                updatePriceInnerText(); // Update Prompt Text for UI
                // check for duplicates
                if (!partInv.contains(partToBeRemoved)) {
                    partInv.add(partToBeRemoved);
                }
                updateAddPartsViewOnPartAdded();
            } else {
                Alert nodataToRemove = new Alert(Alert.AlertType.INFORMATION);
                nodataToRemove.setTitle("Select Part to delete");
                nodataToRemove.setHeaderText("Select Part to delete");
                nodataToRemove.showAndWait();
            }

        } else {
            Alert nodataToRemove = new Alert(Alert.AlertType.INFORMATION);
            nodataToRemove.setTitle("There is no parts to delete");
            nodataToRemove.setHeaderText("Add Part to delete it");
            nodataToRemove.showAndWait();
        }


    }


    @FXML
    private static void AlertValidation(String validatedValue) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error Inputs");
        alert.setHeaderText("Did not Passed Check for Inventory");
        alert.setContentText(validatedValue);
        alert.showAndWait();
    }

    @FXML
    void AddProductCancel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        View_Controller.MainScreenController controller = new View_Controller.MainScreenController(inv);
        loader.setController(controller);
        loader.setLocation(getClass().getResource("Main_screen.fxml"));
        Parent product_page_parent = loader.load();
        Scene main_page_scene = new Scene(product_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(main_page_scene);
        app_stage.show();
    }

    @FXML
    void handleAddProductSave(ActionEvent event) throws IOException {
        // add product


        if (productToUpdate == null) {
            ProductID = Inventory.generateProductPart();
        } else {
            // for update
            ProductID = productToUpdate.getProductID();
        }

        String validatedValue = "";
        //String name, double price, int stock, int min, int max, ObservableList<Part> parts
        System.out.println("Product Name: " + ProductName);
        System.out.println("Product Price: " + ProductPrice);
        System.out.println("Product ProductStock: " + ProductStock);
        System.out.println("Product ProductMin: " + ProductMin);
        System.out.println("Product ProductMax: " + ProductMax);

        validatedValue = Product.isProductValid(ProductName, ProductPrice, ProductStock, ProductMin, ProductMax, partInvAddToProduct);
        System.out.println(validatedValue);

        if (!validatedValue.isEmpty()) {
            // Alert if something wrong
            AlertValidation(validatedValue);
        } else {
            if (productToUpdate == null) {
                Product ProductToAdd = new Product(ProductID, ProductName, ProductPrice, ProductStock, ProductMin, ProductMax);
                for (Part p : partInvAddToProduct) {
                    ProductToAdd.addAssociatedPart(p);
                }
                inv.addProduct(ProductToAdd);

            } else {
                Product ProductTUpdate = new Product(ProductID, ProductName, ProductPrice, ProductStock, ProductMin, ProductMax);
                for (Part p : partInvAddToProduct) {
                    ProductTUpdate.addAssociatedPart(p);
                }
                inv.updateProduct(index, ProductTUpdate);
            }
            AddProductCancel(event);

        }

    }

    @FXML
    private void generateSearchPartsTableValues() {

        addParts.setItems(partInvSearch);
        addParts.refresh();
        if (partInvSearch.size() > 0 && partInvSearch.size() != inv.getAllParts().size()) {
            buttonSearchParts.setText(String.format("Found(%s)", partInvSearch.size()));
        } else {
            buttonSearchParts.setText("Search");
        }

    }

    @FXML
    void partFuzzySearch() {
        //clear observable
        partInvSearch.clear();
        for (Part p : inv.getAllParts()) {
            // Fizzy Search on contains function
            if (p.getPartName().toLowerCase().contains(productSearch.getText().toLowerCase())) {
                //append to observable
                partInvSearch.add(p);

            }

        }


        generateSearchPartsTableValues();
    }

    @FXML
    void addProductNameValidation(KeyEvent key) {

        /**    @FXML private TextField addProductName;
         @FXML private Label addProductNameValidator;*/
        System.out.println("ADD PRODUCT NAME" + addProductName.getText());
        if (addProductName.getText().isEmpty()) {
            addProductNameValidator.setText("Name can't be empty!");
        } else {
            ProductName = addProductName.getText();
            addProductNameValidator.setText(null);
        }


    }

    @FXML
    void addProductStockValidator(KeyEvent key) {
        /**
         *   @FXML
         *     private Label addProductStockValidator;
         *     @FXML
         *     private TextField addProductStock;
         */

        if (addProductStock.getText() != null && Util.isNumeric(addProductStock.getText())) {
            ProductStock = Integer.parseInt(addProductStock.getText()); // will use this to construct
            ProductMin = ProductStock;
            addProductMin.setText(addProductStock.getText());
            addProductMax.setPromptText(String.format(">=%s", addProductStock.getText()));
            addProductStockValidator.setText(null);
        } else if (addProductStock.getText().isEmpty()) {

            addProductStockValidator.setText("Stock can't be empty");
            addProductMin.setText(null);
            addProductMax.setText(null);
            addProductMin.setPromptText("Min");
            addProductMax.setPromptText("Max");
        } else {
            addProductMin.setText(null);
            addProductMin.setPromptText("Min");
            addProductStockValidator.setText("Stock must be an integer");
        }

    }

    @FXML
    void addProductPriceValidator(KeyEvent key) {
        /**    @FXML private TextField addProductPrice;
         @FXML private Label addProductPriceValidator;*/

        if (addProductPrice.getText() != null && Util.isDouble(addProductPrice.getText())) {

//            System.out.println("HERE");
//            System.out.println("PriceToCheck: " + PriceToCheck);
//            System.out.println("CurrentPrice: " + Double.parseDouble(addProductPrice.getText()));
//            System.out.println(PriceToCheck > Double.parseDouble(addProductPrice.getText()));

            if (PriceToCheck > Double.parseDouble(addProductPrice.getText())) {
                // Error
                addProductPriceValidator.setText(String.format("Need More then >=%s", PriceToCheck));
            } else {
                ProductPrice = Double.parseDouble(addProductPrice.getText()); // will use this to construct
                addProductPriceValidator.setText(null);
            }

        } else if (addProductPrice.getText().isEmpty()) {
            addProductPriceValidator.setText("Price can't be empty");
        } else {
            addProductPriceValidator.setText("Price must be a double");
        }


    }

    @FXML
    void addProductMinValidator(KeyEvent key) {
        /**    @FXML private TextField addProductMin;
         @FXML private Label addProductMinValidator;*/

        if (!key.getCode().toString().contains("TAB")) {

            if (addProductMin.getText() != null && Util.isNumeric(addProductMin.getText())) {
                ProductMin = Integer.parseInt(addProductMin.getText()); // will use this to construct
                addProductMinValidator.setText(null);
                if (ProductStock > ProductMin) {

                    addProductMinValidator.setText("No less then stock");
                }
            } else if (addProductMin.getText().isEmpty()) {
                addProductMinValidator.setText("Min can't be empty");
            } else {
                addProductMinValidator.setText("Must be Int");
            }
        }
    }

    @FXML
    void addProductMaxValidator(KeyEvent key) {
        /**    @FXML private TextField addProductMax;
         @FXML private Label addProductMaxValidator;*/
        if (!key.getCode().toString().contains("TAB")) {
            if (addProductMax.getText() != null && Util.isNumeric(addProductMax.getText())) {
                ProductMax = Integer.parseInt(addProductMax.getText()); // will use this to construct
                addProductMaxValidator.setText(null);
                if (ProductStock > ProductMax) {
                    addProductMaxValidator.setText("Stock higher then max");
                }
            } else if (addProductMax.getText().isEmpty()) {
                addProductMaxValidator.setText("Max can't be empty");
            } else {
                addProductMaxValidator.setText("Must be Int");
            }
        }

    }

    public void populateFileds() {

        addProductIdLabel.setText(ProductID.toString());
        AddProductsScreenDefenition.setText(String.format("Update Product: %s", ProductName));
        addProductName.setText(ProductName);
        addProductStock.setText(String.valueOf(ProductStock));
        addProductPrice.setText(String.valueOf(ProductPrice));
        addProductMin.setText(String.valueOf(ProductMin));
        addProductMax.setText(String.valueOf(ProductMax));
        //Generate Parts to Delete

        for(Part p : partInvAddToProduct){
            partInv.remove(p);
        }
        generateDeletePartsTableValues();
        // Set only for items avaliable to be added
        addParts.setItems(partInv);
        addParts.refresh();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        if (productToUpdate != null) {
            ProductName = productToUpdate.getProductName();
            ProductPrice = productToUpdate.getProductPrice();
            ProductStock = productToUpdate.getProductStock();
            ProductMin = productToUpdate.getProductMin();
            ProductMax = productToUpdate.getProductMax();
            ProductID = productToUpdate.getProductID();
            partInvAddToProduct = productToUpdate.getAssociatedPartsList();

            System.out.println("=====UPDATE PRODUCT===");
            System.out.println("Product Name: " + ProductName);
            System.out.println("Product Price: " + ProductPrice);
            System.out.println("Product ProductStock: " + ProductStock);
            System.out.println("Product ProductMin: " + ProductMin);
            System.out.println("Product ProductMax: " + ProductMax);
            System.out.println("Product ProductID: " + ProductID);
            populateFileds();


        } else{
            generateAddPartsTableValues();

        }
    }
}
