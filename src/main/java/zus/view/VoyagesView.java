package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import zus.controller.PurchaseBackControl;
import zus.model.Voyage;
import zus.model.utility.JDBCUtils;

import java.sql.SQLException;

public class VoyagesView extends BorderPane {
    private TableView<Voyage> tvVoyages;
    private Button btnBuy;
    private Button btnBack;

    public VoyagesView() throws SQLException {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() throws SQLException {
        tvVoyages = new VoyagesTable(JDBCUtils.selectAllFromVoyages());
        btnBuy = new Button("Kupi");
        btnBack = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(10));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btnBuy, btnBack);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(tvVoyages, vBox);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        setCenter(hBox);
    }

    private void addActions() {
        btnBack.setOnAction(new PurchaseBackControl());
    }
}
