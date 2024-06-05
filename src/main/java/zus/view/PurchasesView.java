package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import zus.App;
import zus.controller.DetailsControl;
import zus.controller.PurchaseBackControl;
import zus.model.HousingUnit;
import zus.model.Ticket;
import zus.model.Voyage;
import zus.model.utility.JDBCUtils;

import java.sql.SQLException;

public class PurchasesView extends BorderPane {
    private TableView<HousingUnit> tvHousingUnits;
    private TableView<Ticket> tvTickets;
    private Button btnDetails;
    private Button btnResidents;
    private Button btnBack;

    public PurchasesView() throws SQLException {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() throws SQLException {
        tvHousingUnits = new HousingUnitsTable(JDBCUtils.selectFromHousingUnits(App.current.getUsername()));
        tvTickets = new TicketsTable(JDBCUtils.selectFromTickets(App.current.getUsername()));
        btnDetails = new Button("Detalji");
        btnResidents = new Button("Ukucani");
        btnBack = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(20));

        GridPane gp = new GridPane();
        gp.add(new Label("Kupljeni objekti"), 0, 0);
        gp.add(new Label("Kupljene karte"),0,1);
        gp.add(tvHousingUnits, 1, 0);
        gp.add(tvTickets, 1, 1);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(btnDetails, btnResidents, btnBack);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox= new VBox();
        vBox.getChildren().addAll(gp, hBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        setCenter(vBox);
    }

    private void addActions() {
        btnDetails.setOnAction(new DetailsControl(this));
        btnBack.setOnAction(new PurchaseBackControl());
    }

    public TableView<Ticket> getTvTickets() {
        return tvTickets;
    }
}
