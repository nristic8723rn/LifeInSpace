package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import zus.controller.ChooseControl;
import zus.controller.OrbsControl;
import zus.model.HousingUnit;
import zus.model.Orb;
import zus.model.utility.JDBCUtils;

import java.sql.SQLException;

public class HousingView extends BorderPane {
    private TableView<HousingUnit> tvHousingUnits;
    private Button btnChoose;
    private Button btnBack;

    private Orb orb;

    public HousingView(Orb orb) throws SQLException {
        this.orb=orb;
        initElements();
        addElements();
        addActions();
    }

    private void initElements() throws SQLException {
        tvHousingUnits = new HousingUnitsTable(JDBCUtils.selectHousingUnitsForOrb(orb.getOrbId()));
        btnChoose = new Button("Izaberite");
        btnBack = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(10));

        GridPane gp = new GridPane();
        gp.add(new Label("Dostupni objekti"), 0, 0);
        gp.add(tvHousingUnits, 0, 1);
        gp.add(btnChoose, 1, 0);
        gp.add(btnBack, 1, 1);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        setCenter(gp);
    }

    private void addActions() {
        btnChoose.setOnAction(new ChooseControl(this));
        btnBack.setOnAction(new OrbsControl());
    }

    public TableView<HousingUnit> getTvHousingUnits() {
        return tvHousingUnits;
    }

    public Button getBtnChoose() {
        return btnChoose;
    }

    public Button getBtnBack() {
        return btnBack;
    }
}
