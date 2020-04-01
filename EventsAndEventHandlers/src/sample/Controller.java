package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    //    Same as ID on textfield
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label ourLabel;

    // INIT UI
    @FXML
    public void initialize() {
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {
        if (e.getSource().equals(helloButton)) {

            System.out.println("Hello, " + nameField.getText());
        } else if (e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        // Process of runnable
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI THREAD" : "Background Thread";
                    System.out.println("I am going to sleep " + s);
                    Thread.sleep(10000);
                    // JAVA FX THREAD ON UI
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI THREAD" : "Background Thread";
                            System.out.println("I am Updating the label on " + s);
                            ourLabel.setText("We did something");
                        }
                    });

                } catch (InterruptedException event) {
                    System.out.println(e);
                }
            }
        };
        // Start thread
        new Thread(task).run();

//        Cleat TextField if the box is empty
        if (checkBox.isSelected()) {

            nameField.clear();
            helloButton.setDisable(true);
            byeButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
//        To check and make sure if there is no text value field will be disabled
        String text = nameField.getText();
        boolean disableButton = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButton);
        byeButton.setDisable(disableButton);

    }

    @FXML
    public void checkBoxCheck() {
        System.out.println("The Checkbox is " + (checkBox.isSelected() ? "checked" : "non checked"));

    }


}
