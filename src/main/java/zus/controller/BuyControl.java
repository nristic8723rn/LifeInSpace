package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.model.Voyage;
import zus.view.PassengerNoView;
import zus.view.VoyagesView;

public class BuyControl implements EventHandler<ActionEvent> {
    private VoyagesView voyagesView;
    public BuyControl(VoyagesView voyagesView)
    {
        this.voyagesView = voyagesView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Voyage voyage = voyagesView.getTvVoyages().getSelectionModel().getSelectedItem();
        if(voyage != null)
        {App.window.setScene(new Scene(new PassengerNoView(voyage), 200, 200));
        App.window.show();}
    }
}
