package View_Controller;

import Model.*;
import Utils.Util;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AddPartController {

    private final Inventory inv;
    private String Name = null;
    private Integer Stock = 0;
    private Double Price = 0.0;
    private Integer MinVal = 0;
    private Integer MaxVal = 0;
    private boolean isOutsoursed = false;
    private String MachineIdOrCompany = null;

    @FXML
    private RadioButton buttonRadioInhouse;

    @FXML
    private RadioButton buttonRadioOutsourced;

    @FXML
    private TextField addPartName;
    @FXML
    private Label addPartNameValidator;

    @FXML
    private TextField addPartStock;
    @FXML
    private Label addPartStockValidator;


    @FXML
    private TextField addPartPrice;
    @FXML
    private Label addPartPriceValidator;

    @FXML
    private TextField addPartMin;
    @FXML
    private Label addPartMinValidator;

    @FXML
    private TextField addPartMax;
    @FXML
    private Label addPartMaxValidator;

    @FXML
    private TextField addPartMachineId;
    @FXML
    private Label addPartMachineLabel;
    @FXML
    private Label addPartMorCValidator;


    @FXML
    private Button btrnAddPartSave;

    @FXML
    private Button btnAddPartCancel;

    // This is working
    @FXML
    void AddPartCancel(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        View_Controller.MainScreenController controller = new View_Controller.MainScreenController(inv);
        loader.setController(controller);
        loader.setLocation(getClass().getResource("Main_screen.fxml"));
        Parent product_page_parent = loader.load();
        Scene main_page_scene = new Scene(product_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide(); //optional
        app_stage.setScene(main_page_scene);
        app_stage.show();
    }


    @FXML
    void addPartInhouse(ActionEvent event) {

        System.out.println("Adding Part Inhouse");
        isOutsoursed = false;
        addPartMachineId.setPromptText("Machine ID");
        addPartMachineLabel.setText("Machine ID");

        buttonRadioInhouse.setSelected(true);
        buttonRadioOutsourced.setSelected(false);
        addPartMorCValidator.setText(null);
        MachineIdOrCompany = null;
        addPartMorCValidation();
        addPartMorCValidator.setText(null);
    }

    @FXML
    void addPartOutsourced(ActionEvent event) {
        isOutsoursed = true;
        addPartMachineId.setPromptText("Company Name");
        addPartMachineLabel.setText("Co. Name");
        buttonRadioInhouse.setSelected(false);
        buttonRadioOutsourced.setSelected(true);
        addPartMorCValidator.setText(null);
        MachineIdOrCompany = null;
        addPartMorCValidation();
        addPartMorCValidator.setText(null);
    }


    @FXML
    void addPartNameValidation(KeyEvent key) {
//     @FXML
//    private TextField addPartName;
//    @FXML
//    private Label addPartNameValidator;

        if (addPartName.getText().isEmpty()) {
            addPartNameValidator.setText("Name can't be empty!");
        } else {
            Name = addPartName.getText();
            addPartNameValidator.setText(null);
        }

    }

    @FXML
    void addPartStockValidation(KeyEvent key) {

        if (addPartStock.getText() != null & Util.isNumeric(addPartStock.getText())) {
            Stock = Integer.parseInt(addPartStock.getText()); // will use this to construct
            MinVal = Stock;
            addPartMin.setText(addPartStock.getText());
            addPartMax.setPromptText(String.format(">=%s", addPartStock.getText()));
            addPartStockValidator.setText(null);
        } else if (addPartStock.getText().isEmpty()) {
            addPartStockValidator.setText("Stock can't be empty");
            addPartMin.setText(null);
            addPartMax.setText(null);
            addPartMin.setPromptText("Min");
            addPartMax.setPromptText("Max");
        } else {
            addPartMin.setText(null);
            addPartMin.setPromptText("Min");
            addPartStockValidator.setText("Stock must be an integer");
        }

    }

    @FXML
    void addPartPriceValidation(KeyEvent key) {
        /**  @FXML private TextField addPartPrice;
         @FXML private  Label addPartPriceValidator;*/

        if (addPartPrice.getText() != null & Util.isDouble(addPartPrice.getText())) {
            Price = Double.parseDouble(addPartPrice.getText()); // will use this to construct
            addPartPriceValidator.setText(null);
        } else if (addPartPrice.getText().isEmpty()) {
            addPartPriceValidator.setText("Price can't be empty");
        } else {
            addPartPriceValidator.setText("Price must be a double");
        }
    }

    @FXML
    void addPartMinValidation(KeyEvent key) {
        /**     @FXML private TextField addPartMin;
         @FXML private  Label addPartMinValidator;*/
        if (!addPartMin.getText().isEmpty() & Util.isNumeric(addPartMin.getText())) {
            MinVal = Integer.parseInt(addPartMin.getText()); // will use this to construct
            addPartMinValidator.setText(null);
            if (Stock > MinVal) {
                addPartMinValidator.setText("No less then stock");
            }
        } else if (addPartMin.getText().isEmpty()) {
            addPartMinValidator.setText("Min can't be empty");
        } else {
            addPartMinValidator.setText("Must be Int");
        }

    }

    @FXML
    void addPartMaxValidation(KeyEvent key) {
        /** @FXML private TextField addPartMax;
         @FXML private  Label addPartMaxValidator;*/
        //TODO Debug this crap
        if (!addPartMax.getText().isEmpty() && Util.isNumeric(addPartMax.getText())) {
            MaxVal = Integer.parseInt(addPartMax.getText()); // will use this to construct
            addPartMaxValidator.setText(null);
            if (Stock > MaxVal) {
                addPartMaxValidator.setText("Stock higher then max");
            }
        } else if (addPartMax.getText().isEmpty()) {
            addPartMaxValidator.setText("Max can't be empty");
        } else {
            addPartMaxValidator.setText("Must be Int");
        }
    }

    @FXML
    void addPartMorCValidation() {
        /** @FXML private TextField addPartMachineId;
         @FXML private  Label addPartMorCValidator;*/
        //MachineIdOrCompany

        if (!addPartMachineId.getText().isEmpty()) {

            if (!isOutsoursed && Util.isNumeric(addPartMachineId.getText())) {
                MachineIdOrCompany = addPartMachineId.getText();
                addPartMorCValidator.setText(null);
            } else if (!isOutsoursed & !Util.isNumeric(addPartMachineId.getText())) {
                addPartMorCValidator.setText("Must Be Numerical");
            } else {
                MachineIdOrCompany = addPartMachineId.getText();
                addPartMorCValidator.setText(null);
            }

        } else {
            addPartMorCValidator.setText("Can't be empty!");
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
    void AddPartSave(ActionEvent event) throws IOException {

//
//        System.out.println("Name: " + Name);
//        System.out.println("Price: " + Price);
//        System.out.println("Min: " + MinVal);
//        System.out.println("Max: " + MaxVal);
//        System.out.println("isOutsourced: " + isOutsoursed);
//        System.out.println("MachineIdOrCompany: " + MachineIdOrCompany);

        Integer partId = Inventory.generateIdPart();
        String validatedValue = "";

        // if Outsoursed do check for outsoursed
        if (isOutsoursed) {
            validatedValue = Outsourced.isPartValid(Name, Price, Stock, MinVal, MaxVal, MachineIdOrCompany);
            if(!validatedValue.isEmpty()){
                // Alert if something wrong
                AlertValidation(validatedValue);
            } else{
                inv.addPart(new Outsourced(partId,Name, Price, Stock, MinVal, MaxVal, MachineIdOrCompany));
                AddPartCancel(event);
            }

        } else {
            validatedValue = InHousePart.isPartValid(Name, Price, Stock, MinVal, MaxVal, MachineIdOrCompany);
            if(!validatedValue.isEmpty()){
                AlertValidation(validatedValue);
            } else {
                inv.addPart(new InHousePart(partId,Name, Price, Stock, MinVal, MaxVal, Integer.parseInt(MachineIdOrCompany)));
//                loadMain(event);
                AddPartCancel(event);
            }

        }

    }

    // Get inventory to constructor
    public AddPartController(Inventory inv) {
        this.inv = inv;
    }
}
