package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import zus.App;
import zus.controller.OverviewControl;
import zus.model.Voyage;

public class TripView extends BorderPane {
    private Button btnBack;
    private Voyage voyage;
    public TripView(Voyage voyage)
    {
        this.voyage = voyage;
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        btnBack = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(10));

        GridPane gp = new GridPane();
        gp.add(new Label("ID putovanja"), 0 ,0);
        gp.add(new Label("ID planete"), 0 ,1);
        gp.add(new Label("Datum polaska"), 0, 2);
        gp.add(new Label("Vreme polaska"), 0, 3);
        gp.add(new Label("Ime prevoza"), 0, 4);
        gp.add(new Label(String.valueOf(voyage.getVoyageId())), 1, 0);
        gp.add(new Label(String.valueOf(voyage.getOrbId())), 1, 1);
        gp.add(new Label(String.valueOf(voyage.getDateOfDeparture())), 1, 2);
        gp.add(new Label(String.valueOf(voyage.getTimeOfDeparture())), 1, 3);
        gp.add(new Label(voyage.getName()), 1, 4);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(gp, new Label("Nosilac karte: " + App.current.getName() + " " + App.current.getFamilyName()), btnBack);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        setCenter(vBox);
    }

    private void addActions() {
        btnBack.setOnAction(new OverviewControl());
    }
}
