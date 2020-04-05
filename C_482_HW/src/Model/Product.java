package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {


    protected static ObservableList<Part> parts = FXCollections.observableArrayList();
    protected final int id;
    protected final String name;
    protected final Double price;
    protected final int stock;
    protected final int min;
    protected final int max;

    public Product(int id, String name, Double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
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
            if (innerPart.getId() == part.getId()) {

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

        // Check the sum of parts
        double sumPartsValue = 0.0;
        for (Part innerPart : parts) {
            sumPartsValue += innerPart.getPrice();
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
