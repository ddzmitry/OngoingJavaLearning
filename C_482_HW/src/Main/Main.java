package Main;

import Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Inventory inv = new Inventory();
//        // Add Test Data per lecture
        addTestData(inv);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/Main_screen.fxml"));
        View_Controller.MainScreenController controller = new View_Controller.MainScreenController(inv);
        loader.setController(controller);
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setTitle("Inventory Management System");
        primaryStage.setScene(scene);
        // No Resizable
        primaryStage.setResizable(false);
        primaryStage.show();

//        Inventory inv = new Inventory();
//        addTestData(inv);
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View_Controller/AddProduct.fxml"));
//
//        View_Controller.AddProductController controller = new View_Controller.AddProductController(inv,null ,null);
//        loader.setController(controller);
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        primaryStage.setTitle("Inventory Management System");
//        primaryStage.setScene(scene);
//        // No Resizable
//        primaryStage.setResizable(false);
//        primaryStage.show();




//        Parent root = FXMLLoader.load(getClass().getResource("/View_Controller/AddPart.fxml"));
//        primaryStage.setScene(new Scene(root, 900, 500));
//        primaryStage.show();

    }

    private void addTestData(Inventory inv) {

        // Add InHouse Parts
        Part a1 = new InHousePart(1,"Nail Steel",3.44,5,3,10,3);
        Part a2 = new InHousePart(5,"Nail Iron",10.99,17,5,60,8);
        Part b1 = new InHousePart(11,"Oak Wood",7.54,8,6,42,4);
        Part b2 = new InHousePart(16,"Birch Wood",3.44,7,2,15,9);
        //  Add Outsourced Parts
        Part o1 = new Outsourced(10,"Brick Cement",13.99,6,5,32,"Special Delivery Co.");
        Part o2 = new Outsourced(50,"Brick Clay",4.99,10,4,15,"Captain Jack Rabbit");
        Part s1 = new Outsourced(18,"Concrete Regular",13.94,3,8,67,"Captain Jack Rabbit");
        Part s2 = new Outsourced(36,"Concrete Advanced",3.73,56,1,84,"Poofy and Goober Inx.");
        // Add Parts
        inv.addPart(a1);
        inv.addPart(a2);
        inv.addPart(b1);
        inv.addPart(b2);
        inv.addPart(o1);
        inv.addPart(o2);
        inv.addPart(s1);
        inv.addPart(s2);
        // Create Products
        Product prod1 = new Product(100,"Brick Wall",18.99,3,7,42);
        prod1.addAssociatedPart(a1);

        Product prod2 = new Product(200,"Wood Cabin",36.61,6,3,32);
        Product prod3 = new Product(300,"Concrete Cabin",69.99,12,3,18);
        Product prod4 = new Product(400,"Clay Cabin",54.88,7,6,55);
        Product prod5 = new Product(500,"Cement Wall",66.99,42,10,16);
//         add associations
        prod1.addAssociatedPart(a2);

        prod2.addAssociatedPart(a2);
        prod2.addAssociatedPart(s1);

        prod3.addAssociatedPart(a1);
        prod3.addAssociatedPart(o2);

        prod4.addAssociatedPart(s2);

        prod5.addAssociatedPart(a1);
        prod5.addAssociatedPart(b2);
        prod5.addAssociatedPart(o2);
        prod5.addAssociatedPart(s2);


        inv.addProduct(prod1);
        inv.addProduct(prod2);
        inv.addProduct(prod3);
        inv.addProduct(prod4);
        inv.addProduct(prod5);



    }


    public static void main(String[] args) {
        launch(args);


    }
}
