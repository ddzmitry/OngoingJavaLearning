package com.ddzmitry.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public class TodoData {
    // Singleton
    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";

    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter formater;

    public static TodoData getInstance() {
        return instance;
    }

    // To have it executed only once have only one constriuctor created
    private TodoData() {
        formater = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem todoItem) {

        todoItems.add(todoItem);
    }
//
//    public void setTodoItems(ObservableList<TodoItem> todoItems) {
//        this.todoItems = todoItems;
//    }

    public void loadRodoItems() throws IOException {
        // observable will allow to use method setall , so we can load it
        todoItems = FXCollections.observableArrayList();

        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;

        try {
            // Append Data Load to list
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t");
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];
                // Format date
                LocalDate date = LocalDate.parse(dateString, formater);
                TodoItem todoItem = new TodoItem(shortDescription, details, date);
                todoItems.add(todoItem);
            }
        } finally {
            if (br != null) {
                br.close();
            }
        }

    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            // get items
            // instead of for loop use iterator
            Iterator<TodoItem> iter = todoItems.iterator();
            while (iter.hasNext()) {
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s\t",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formater)));
                bw.newLine();

            }

        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }



}
