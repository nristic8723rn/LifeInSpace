package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.VoyagesView;

import java.sql.SQLException;

public class TicketsControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            App.window.setScene(new Scene(new VoyagesView(), 600, 300));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
