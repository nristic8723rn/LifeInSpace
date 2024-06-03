package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import zus.controller.ConfirmControl;
import zus.model.Voyage;

public class PassengerNoView extends BorderPane {
    private TextField tfNumber;
    private Button btnConfirm;
    private Voyage voyage;
    public PassengerNoView(Voyage voyage)
    {
        this.voyage = voyage;
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        tfNumber = new TextField();
        btnConfirm = new Button("Potvrdite");
    }

    private void addElements() {
        setPadding(new Insets(10));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("Unesite broj putnika"), tfNumber);
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, btnConfirm);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        setCenter(vBox);
    }

    private void addActions() {
        btnConfirm.setOnAction(new ConfirmControl(this, voyage));
    }

    public TextField getTfNumber() {
        return tfNumber;
    }
}
