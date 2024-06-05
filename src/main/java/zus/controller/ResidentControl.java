package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.ResidentsView;

import java.sql.SQLException;

public class ResidentControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            App.window.setScene(new Scene(new ResidentsView()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
