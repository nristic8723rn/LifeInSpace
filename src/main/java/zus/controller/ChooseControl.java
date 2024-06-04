package zus.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import zus.App;
import zus.model.HousingUnit;
import zus.view.AddPeopleView;
import zus.view.HousingView;

public class ChooseControl implements EventHandler<ActionEvent> {
    private HousingView housingView;

    public ChooseControl(HousingView housingView)
    {
        this.housingView=housingView;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        HousingUnit housingUnit = housingView.getTvHousingUnits().getSelectionModel().getSelectedItem();
        if(housingUnit != null)
        {
            App.window.setScene(new Scene(new AddPeopleView(housingUnit), 550, 450));
        }
    }
}
