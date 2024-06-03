package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.view.PurchasesView;

import java.sql.SQLException;

public class OverviewControl implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            App.window.setScene(new Scene(new PurchasesView(), 400, 400));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
