package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import zus.controller.PurchaseBackControl;
import zus.model.Orb;
import zus.model.utility.JDBCUtils;

import java.sql.SQLException;

public class OrbsView extends BorderPane {
    private TableView <Orb> tvOrbs;
    private Button btnHousing;
    private Button btnBack;

    public OrbsView() throws SQLException {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() throws SQLException {
        tvOrbs = new OrbsTable(JDBCUtils.selectFromOrbs());
        btnHousing = new Button("Pogledajte objekte");
        btnBack = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(10));

        GridPane gp = new GridPane();
        gp.add(new Label("Nastanjive planete"), 0, 0);
        gp.add(tvOrbs, 0, 1);
        gp.add(btnHousing, 1, 0);
        gp.add(btnBack, 1, 1);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        setCenter(gp);
    }

    private void addActions() {
        btnBack.setOnAction(new PurchaseBackControl());
    }
}
