package zus.view;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import zus.App;
import zus.controller.BackControl;
import zus.controller.PurchaseBackControl;
import zus.model.HousingUnit;
import zus.model.Voyage;
import zus.model.utility.JDBCUtils;

import java.sql.SQLException;

public class PurchasesView extends BorderPane {
    private TableView<HousingUnit> tvHousingUnits;
    private TableView<Voyage> tvVoyages;
    private Button btnBack;

    public PurchasesView() throws SQLException {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() throws SQLException {
        tvHousingUnits = new HousingUnitsTable(JDBCUtils.selectFromHousingUnits(App.current.getUsername()));
        tvVoyages = new VoyagesTable(JDBCUtils.selectFromVoyages(App.current.getUsername()));
        btnBack = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(20));

        GridPane gp = new GridPane();
        gp.add(new Label("Kupljeni objekti"), 0, 0);
        gp.add(new Label("Kupljene karte"),0,1);
        gp.add(tvHousingUnits, 1, 0);
        gp.add(tvVoyages, 1, 1);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        VBox vBox= new VBox();
        vBox.getChildren().addAll(gp, btnBack);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        setCenter(vBox);
    }

    private void addActions() {
        btnBack.setOnAction(new PurchaseBackControl());
    }
}
