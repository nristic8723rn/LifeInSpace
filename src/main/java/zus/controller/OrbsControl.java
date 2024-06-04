package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.OrbsView;

import java.sql.SQLException;

public class OrbsControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            App.window.setScene(new Scene(new OrbsView(), 300, 300));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
