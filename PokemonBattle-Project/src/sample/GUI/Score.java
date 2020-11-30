package sample.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Score extends Application {
    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";


    @Override
    public void start(Stage window){
        SelectPlayer selectPlayer = new SelectPlayer();
        BorderPane thirdScreen = new BorderPane();
        Label title = new Label("POO");
        Label title2 = new Label(" BATTLE PRO");
        Label text = new Label(
                "Arduinod234" + ".........................." + "90" + " Victorias" + "\n" +
                        "Arduinod234" + ".........................." + "80" + " Victorias" + "\n" +
                        "Arduinod123" + ".........................." + "55" + " Victorias" + "\n" +
                        "Arduinod222" + ".........................." + "43" + " Victorias" + "\n" +
                        "Arduinod333" + ".........................." + "23" + " Victorias" + "\n" +
                        "Arduinod432" + ".........................." + "12" + " Victorias" + "\n" +
                        "Arduinod332" + ".........................." + "09" + " Victorias" + "\n");

        Button endButton = new Button("Seleccionar los personajes");

        endButton.setStyle(Button_Style);
        endButton.setOnMouseEntered(e -> endButton.setStyle(Button_Style_Hover));
        endButton.setOnMouseExited(e -> endButton.setStyle(Button_Style));
        Button finish = new Button("Salir");
        finish.setStyle(Button_Style);
        finish.setOnMouseEntered(e -> finish.setStyle(Button_Style_Hover));
        finish.setOnMouseExited(e -> finish.setStyle(Button_Style));

        text.setFont(Font.font("Arial", 18));
        title.setFont(Font.font("Curlz MT", 44));
        title2.setFont(Font.font("Curlz MT", 44));

        VBox componentsGroup = new VBox();

        componentsGroup.getChildren().add(title);
        componentsGroup.getChildren().add(title2);
        componentsGroup.getChildren().add(text);
        componentsGroup.getChildren().add(endButton);
        componentsGroup.getChildren().add(finish);
        componentsGroup.setSpacing(30);
        componentsGroup.setAlignment(Pos.CENTER);
        thirdScreen.setCenter(componentsGroup);
        thirdScreen.setStyle(BorderPane_Style);
        thirdScreen.setPrefSize(900, 580);
        thirdScreen.setPadding(new Insets(20, 20, 20, 20));
        Scene thirdScene = new Scene(thirdScreen, 900, 700);
        thirdScene.setFill(Color.TRANSPARENT);

        endButton.setOnAction((ActionEvent event) -> {
            try {
                selectPlayer.start(window);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        finish.setOnAction((ActionEvent event) -> window.close());

        window.setScene(thirdScene);
        window.show();
    }
}
