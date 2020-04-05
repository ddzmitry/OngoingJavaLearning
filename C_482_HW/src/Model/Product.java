package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {


    private static ObservableList<Part> parts = FXCollections.observableArrayList();
    protected final int ProductID;
    protected final String ProductName;
    protected final Double ProductPrice;
    protected final int ProductStock;
    protected final int ProductMin;
    protected final int ProductMax;

    public Product(int productID, String productName, Double productPrice, int productStock, int productMin, int productMax) {
        ProductID = productID;
        ProductName = productName;
        ProductPrice = productPrice;
        ProductStock = productStock;
        ProductMin = productMin;
        ProductMax = productMax;
    }


    // Getters and setters
    public static ObservableList<Part> getParts() {
        return parts;
    }

    public static void setParts(ObservableList<Part> parts) {
        Product.parts = parts;
    }

    public int getProductID() {
        return ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public Double getProductPrice() {
        return ProductPrice;
    }

    public int getProductStock() {
        return ProductStock;
    }

    public int getProductMin() {
        return ProductMin;
    }

    public int getProductMax() {
        return ProductMax;
    }

    // Other Methods
    public void addAssociatedPart(Part part) {
        // If part is already there , dont add it
        if (parts.contains(part)) {
            System.out.println("Part is already added");
        } else {
            parts.add(part);
        }
    }

    ;

    public boolean deleteAssociatedPart(Part part) {
        // Traverse through parts and if part exists , then pop it
        for (Part innerPart : parts) {
            if (innerPart.getPartID() == part.getPartID()) {

                parts.remove(part);
                return true;
            }
        }
        return false;
    }

    public ObservableList<Part> getAssociatedPartsList() {
        return parts;
    }

    ;

    // Validation

    // We need to make sure that price of part will be more then a price of the Product will be >= Sum of its parts
    public static String isProductValid(String name, double price, int stock, int min, int max, ObservableList<Part> parts) {
        double sumPartsValue = 0.0;
        for (Part innerPart : parts) {
            sumPartsValue += innerPart.getPartPrice();
        }


        StringBuilder errorMessage;
        errorMessage = new StringBuilder();

        if (name == null) {
            errorMessage.append("The name field is REQUIRED.\n");
        } else if (price <= 0) {
            errorMessage.append("Price cannot be negative or zero.\n");
        } else if (sumPartsValue > price) {
            errorMessage.append("Price must be higher or equal the sum of the its parts.\n");
        } else if (stock <= 0) {
            errorMessage.append("Stock cannot be negative or zero.\n");
        } else if (max < min) {
            errorMessage.append("Max value must be greater or equal min value.\n");
        }
        if (stock < min || stock > max) {
            errorMessage.append("Stock value must be between Min and Max.\n");
        }
        return errorMessage.toString();
    }


}
