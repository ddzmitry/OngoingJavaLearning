package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Inventory of all items in the application
public class Inventory {

    // All parts and products
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    public static ObservableList<Product> getAllProducts() {
        return allProducts;
    }

    public static void setAllProducts(ObservableList<Product> allProducts) {
        Inventory.allProducts = allProducts;
    }

    public static ObservableList<Part> getAllParts() {
        return allParts;
    }

    public static void setAllParts(ObservableList<Part> allParts) {
        Inventory.allParts = allParts;
    }

    // Add Part, Product
    public static void addPart(Part part){
        if (part !=null){
            allParts.add(part);
        }
    }
    public static void addProduct(Product product){
        if(product != null){
            allProducts.add(product);
        }
    }

    // Remove Part,Product
    public  static  boolean removePart(Part part){

        return allParts.remove(part);
    }
    public  static  boolean removeProduct(Product product){

        return allProducts.remove(product);
    }
    // Update Part, Product
    public void  updatePart(int index, Part part){
        allParts.set(index,part);

    }

    public void  updateProduct(int index, Product product){
        allProducts.set(index,product);
    }




}
