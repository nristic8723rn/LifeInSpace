package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.model.Voyage;
import zus.model.utility.JDBCUtils;
import zus.view.PassengerNoView;
import zus.view.VoyagesView;

import java.sql.SQLException;

public class ConfirmControl implements EventHandler<ActionEvent> {
    private PassengerNoView passengerNoView;
    private Voyage voyage;

    public ConfirmControl(PassengerNoView passengerNoView, Voyage voyage) {
        this.passengerNoView = passengerNoView;
        this.voyage = voyage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int noOfPassengers = Integer.parseInt(passengerNoView.getTfNumber().getText());
        try {
            JDBCUtils.insertIntoTicket(App.current.getUsername(), voyage.getVoyageId(), noOfPassengers);
            App.window.setScene(new Scene(new VoyagesView(), 500, 300));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
