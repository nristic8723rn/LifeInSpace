package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.model.Orb;
import zus.view.HousingView;
import zus.view.OrbsView;

import java.sql.SQLException;

public class HousingControl implements EventHandler<ActionEvent> {
    private OrbsView orbsView;

    public HousingControl(OrbsView orbsView)
    {
        this.orbsView = orbsView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        Orb orb = orbsView.getTvOrbs().getSelectionModel().getSelectedItem();
        if(orb != null)
        {
            try {
                App.window.setScene(new Scene(new HousingView(orb)));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
