package com.ddzmitry.todolist;

import com.ddzmitry.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;


import java.time.LocalDate;
import java.time.Month;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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


    public void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2020, Month.APRIL, 10));
        TodoItem item2 = new TodoItem("Doctor's appointment", "Dr. John",
                LocalDate.of(2020, Month.MAY, 22));
        TodoItem item3 = new TodoItem("Finish some business stuff", "Write email",
                LocalDate.of(2020, Month.JUNE, 13));
        TodoItem item4 = new TodoItem("Buy Groceries", "Trader Joe's",
                LocalDate.of(2020, Month.MARCH, 22));
        TodoItem item5 = new TodoItem("Pickup Dry Cleaning", "Close should be ready",
                LocalDate.of(2020, Month.APRIL, 30));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                // Listener that will watch on changes on the Itemlist Property
                if(newValue != null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    todoDescription.setText(item.getDetails());

                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");

                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });
        // Set todo items
        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        // Select first
        todoListView.getSelectionModel().selectFirst();

    }

    // On click on item
    @FXML
    public void handleClickListView(){
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

}
