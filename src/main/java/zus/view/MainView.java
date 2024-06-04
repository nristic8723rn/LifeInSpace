package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import zus.controller.*;
import zus.model.Person;
import zus.model.base.Server;

import java.time.LocalDate;

public class MainView extends BorderPane {
    private Button btnObjects;
    private Button btnTickets;
    private Button btnOverview;
    private Button btnLogout;

    public MainView()
    {
        initElements();
        addElements();
        addAction();
    }

    private void initElements() {
        btnObjects = new Button("Kupovina objekata");
        btnTickets = new Button("Kupovina karata");
        btnOverview = new Button("Pregled kupljenih stvari");
        btnLogout = new Button("Izlogujte se");
    }

    private void addElements() {
        setPadding(new Insets(20));

        VBox vb = new VBox();
        vb.getChildren().addAll(btnObjects, btnTickets, btnOverview, btnLogout);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);

        setCenter(vb);
    }

    private void addAction() {
        btnObjects.setOnAction(new OrbsControl());
        btnTickets.setOnAction(new TicketsControl());
        btnOverview.setOnAction(new OverviewControl());
        btnLogout.setOnAction(new BackControl());
    }
}
