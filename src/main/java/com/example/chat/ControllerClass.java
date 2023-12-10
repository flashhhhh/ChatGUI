package com.example.chat;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class ControllerClass {

    @FXML
    private ListView<String> chatListView;

    @FXML
    private TextField messageTextField;

    @FXML
    private Button sendButton;

    @FXML
    private void initialize() {
        // Set a custom cell factory to customize the appearance of each cell in the ListView
        chatListView.setCellFactory(listView -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);
                    setBackground(item.startsWith("You:") ? createBackground("#e0f7fa") : createBackground("#ffffff"));
                } else {
                    setText(null);
                    setBackground(null);
                }
            }
        });
    }

    @FXML
    private void sendMessage() {
        String message = messageTextField.getText();
        if (!message.isEmpty()) {
            chatListView.getItems().add("You: " + message);
            messageTextField.clear();
        }
    }

    // Helper method to create a background with the specified color
    private Background createBackground(String color) {
        return new Background(new BackgroundFill(Color.web(color), null, null));
    }
}
