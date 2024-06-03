package zus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import zus.controller.LogovanjeControl;
import zus.controller.RegistracijaControl;


public class FirstView extends BorderPane {

    private Button btnLogin;
    private Button btnRegister;

    public FirstView()
    {
        initElements();
        addElements();
        addActions();
    }

    private void initElements() {
        btnLogin = new Button("Logovanje");
        btnRegister = new Button("Registracija");
    }

    private void addElements() {
        setPadding(new Insets(15));

        VBox vb = new VBox();
        vb.getChildren().addAll(this.btnLogin, this.btnRegister);
        vb.setAlignment(Pos.CENTER);
        vb.setSpacing(10);
        setCenter(vb);
    }

    private void addActions() {
        btnLogin.setOnAction(new LogovanjeControl());
        btnRegister.setOnAction(new RegistracijaControl());
    }

}
