package sample.GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.ImageView;
import sample.pokemon.PokemonsList;

public class InitialWindow extends Application {
    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";
    private PokemonsList list = new PokemonsList();

    @Override
    public void start(Stage window) throws Exception{
        SelectPlayer selectPlayerView = new SelectPlayer();
        //Ventana inicio
        Button startButton = new Button("START");
        startButton.setStyle(Button_Style);
        startButton.setOnMouseEntered(e -> startButton.setStyle(Button_Style_Hover));
        startButton.setOnMouseExited(e -> startButton.setStyle(Button_Style));
        ImageView gif = new ImageView();
        gif.setImage(new Image("file:IMG/first.gif"));
        gif.setFitHeight(200);
        gif.setFitWidth(400);
        BorderPane root = new BorderPane();
        root.setStyle(BorderPane_Style);
        root.setCenter(gif);
        root.setBottom(startButton);
        BorderPane.setAlignment(startButton, Pos.CENTER);
        BorderPane.setMargin(startButton, new Insets(15, 15, 15, 15));
        Scene scene = new Scene(root, 900, 700);
        scene.setFill(Color.TRANSPARENT);

        startButton.setOnAction((ActionEvent event) -> {
            try {
                selectPlayerView.start(window);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        window.setScene(scene);
        window.initStyle(StageStyle.TRANSPARENT);
        window.show();
    }
}
