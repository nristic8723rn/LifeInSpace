package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
            JDBCUtils.updateVoyageCapacity(voyage.getVoyageId(), noOfPassengers);
            JDBCUtils.insertIntoTicket(App.current.getUsername(), voyage.getVoyageId(), noOfPassengers);
            App.window.setScene(new Scene(new VoyagesView(), 600, 300));
        } catch (SQLException e) {
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Neuspesna kupovina");
            errorAlert.setContentText("Nema dovoljno mesta, dostupno je " + voyage.getCapacity());
            errorAlert.show();
        }
    }
}
