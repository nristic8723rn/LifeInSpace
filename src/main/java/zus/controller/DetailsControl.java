package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.model.Ticket;
import zus.model.Voyage;
import zus.model.utility.JDBCUtils;
import zus.view.PurchasesView;
import zus.view.TripView;

import java.sql.SQLException;

public class DetailsControl implements EventHandler<ActionEvent> {
    private PurchasesView purchasesView;

    public DetailsControl(PurchasesView purchasesView)
    {
        this.purchasesView = purchasesView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Ticket ticket = purchasesView.getTvTickets().getSelectionModel().getSelectedItem();
        if(ticket != null) {
            try {
                Voyage voyage = JDBCUtils.selectVoyage(ticket.getVoyageId());
                App.window.setScene(new Scene(new TripView(voyage), 200, 220));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
