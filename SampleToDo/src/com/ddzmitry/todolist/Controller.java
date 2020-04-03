package com.ddzmitry.todolist;

import com.ddzmitry.todolist.datamodel.TodoData;
import com.ddzmitry.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;


import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

public class Controller {
    //    To Do Item
    private List<TodoItem> todoItems;
    // todoListView
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea todoDescription;
    @FXML
    private Label deadlineLabel;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItem> filteredList;


    public void initialize() {


//        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
//                LocalDate.of(2020, Month.APRIL, 10));
//        TodoItem item2 = new TodoItem("Doctor's appointment", "Dr. John",
//                LocalDate.of(2020, Month.MAY, 22));
//        TodoItem item3 = new TodoItem("Finish some business stuff", "Write email",
//                LocalDate.of(2020, Month.JUNE, 13));
//        TodoItem item4 = new TodoItem("Buy Groceries", "Trader Joe's",
//                LocalDate.of(2020, Month.MARCH, 22));
//        TodoItem item5 = new TodoItem("Pickup Dry Cleaning", "Close should be ready",
//                LocalDate.of(2020, Month.APRIL, 30));
//
//        todoItems = new ArrayList<TodoItem>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//        TodoData.getInstance().setTodoItems(todoItems);

        // Initialize content menut (right-click on todo item)
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);

            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem);
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                // Listener that will watch on changes on the Itemlist Property
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    todoDescription.setText(item.getDetails());

                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");

                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        // Set todo items from Singleton
//        todoListView.getItems().setAll(TodoData.getInstance().getTodoItems());

        // Filter data USE FOR SEARCHING
        filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem todoItem) {
                // List of all
                return true;
            }
        });

        // Create Sorted list to sort items
        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList, new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem o1, TodoItem o2) {
                // Compare Dates
                return o1.getDeadline().compareTo(o2.getDeadline());
            };
        });

        //Using OBSERVABLE
//        todoListView.setItems(TodoData.getInstance().getTodoItems());
        // Populate with sorted list
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // Select first
        todoListView.getSelectionModel().selectFirst();
        // Set Color
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            // go through cells
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        //update each cell
                        super.updateItem(item, empty);
                        // check if cell is empty
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))) {
                                // If DATE IS TODAY OR PAST DUE
                                setTextFill(Color.RED);
                                // IF DUE DATE TOMOROW
                            } else if (item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BROWN);
                            }

                        }
                    }
                };
                cell.emptyProperty().addListener(
                        (obs,wasEmpty,isNowEmpty) -> {
                            if(isNowEmpty){
                                cell.setContextMenu(null);
                            } else{
                                // Add ability to click only on items that have text
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );
                return cell;
            }
        });

    }

    @FXML
    public void showNewItemDialog() {
        // ONLY ALLOW DIALOG TO BE USED
        Dialog<ButtonType> dialog = new Dialog<>();
        // Talk to parent
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new todo item");
        dialog.setHeaderText("Use this dialog to create a new item");
        // Load new pane
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        // Add buttons
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {

            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();

            // Push data to todoListView
            // todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); // Using Observable now
            // Select new Item
            todoListView.getSelectionModel().select(newItem);

//            System.out.println("OK Pressed");
        }
    }

    // On click on item
    @FXML
    public void handleClickListView() {
        // Single Item
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        System.out.println("The Seleted item is " + item);

        // Create string builder and append values
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due:" );
//        sb.append(item.getDeadline());

        todoDescription.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());

    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        // check for item
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null){
            //Delete item
            if(keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
    }

    @FXML
    public void deleteItem(TodoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or cancel to Back out");
        // Result from alert
        Optional<ButtonType> result = alert.showAndWait();
        // Check if OK
        if(result.isPresent() && (result.get() == ButtonType.OK)){
            TodoData.getInstance().deleteTodoItem(item);
        }

    }

    @FXML
    // Filter items depending on state of the button
    public void  handleFilterButton(){
        if(filterToggleButton.isSelected()){

            filteredList.setPredicate(new Predicate<TodoItem>() {
                @Override
                // ITEMS FOR TODAY
                public boolean test(TodoItem todoItem) {
                    return (todoItem.getDeadline().equals(LocalDate.now()));
                }
            });

        } else{
            filteredList.setPredicate(new Predicate<TodoItem>() {
                @Override
                public boolean test(TodoItem todoItem) {
                    return true;
                }
            });
        }
    }

}
