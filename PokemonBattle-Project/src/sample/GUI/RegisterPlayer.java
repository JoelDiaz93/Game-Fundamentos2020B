package sample.GUI;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.playerRegister.InputView;
import sample.playerRegister.PlayerRegister;

public class RegisterPlayer extends Application {
    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";

    private PlayerRegister playerRegister;

    //@Override
   // public void init() throws Exception {
    //    this.playerRegister = new PlayerRegister();
    //}

    @Override
    public void start(Stage stage) throws Exception {
        this.playerRegister = new PlayerRegister();
        stage.setTitle("Registro de Jugadores");
        InputView inputView = new InputView(this.playerRegister);


        Button anteriorView = new Button("Ir a seleccionar personajes");
        anteriorView.setFont(Font.font("Arial", 15));
        anteriorView.setMinSize(100, 35);

        BorderPane layout = new BorderPane();
        layout.setCenter(inputView.getView());
        layout.setBottom(anteriorView);
        layout.setPadding(new Insets(5, 5, 5, 5));

        //ESTA PARTE ES PARA QUE VAYA A LA OTRA PANTALLA
        SelectPlayer anterior = new SelectPlayer();
        anteriorView.setOnAction((event) -> {
            try {
                anterior.start(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //HASTA AQUÍ

        Scene view = new Scene(layout, 470, 500);

        stage.setScene(view);
        stage.show();

    }
}
