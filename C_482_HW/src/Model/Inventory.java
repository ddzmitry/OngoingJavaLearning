package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Random;

// Inventory of all items in the application
public class Inventory {

    // All parts and products
    protected static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    protected static ObservableList<Part> allParts = FXCollections.observableArrayList();

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


    public static Integer generateId(){
        Random r = new Random();
        return r.nextInt((1000 - 1) + 1) + 1;
    };
    public static Integer generateIdPart(){
        // Little Recursion here
        Integer id = generateId();
        System.out.println("ID is " + id);
        ArrayList<Integer> partIds = new ArrayList<>();
        for (Part p : getAllParts()){
            partIds.add(p.getPartID());
        }

        if(partIds.contains(id)){
            return generateIdPart();
        }

        return  id;

    };

    public static Integer generateProductPart(){
        // Little Recursion here
        Integer id = generateId();
        ArrayList<Integer> productIds = new ArrayList<>();
        for (Product p : getAllProducts()){
            productIds.add(p.getProductID());
        }

        if(productIds.contains(id)){
            return generateIdPart();
        }

        return  id;

    };



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
