package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import zus.App;
import zus.controller.OverviewControl;
import zus.model.Person;
import zus.model.utility.JDBCUtils;

import java.sql.SQLException;

public class ResidentsView extends BorderPane {
    private TableView<Person> tvResidents;
    private Button btnback;

    public ResidentsView() throws SQLException {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() throws SQLException {
        tvResidents = new PersonTable(JDBCUtils.selectPersonsForUser(App.current.getUsername()));
        btnback = new Button("Nazad");
    }

    private void addElements() {
        setPadding(new Insets(10));

        VBox vBox = new VBox();
        vBox.getChildren().addAll(tvResidents, btnback);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        setCenter(vBox);
    }

    private void addActions() {
        btnback.setOnAction(new OverviewControl());
    }


}
