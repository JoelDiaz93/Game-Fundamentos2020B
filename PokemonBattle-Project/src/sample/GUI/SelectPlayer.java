package sample.GUI;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.animation.AnimationImage;
import sample.animation.LoadImage;
import sample.animation.SpriteAnimation;
import sample.playerRegister.PlayerRegister;
import sample.pokemon.PokemonsList;
import sample.pokemon.Teams;
import sample.pokemon.Type;

public class SelectPlayer extends Application {



    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";

    private PokemonsList list = new PokemonsList();
    private PlayerRegister listPlayer = new PlayerRegister();

    @Override
    public void start(Stage window) throws Exception{
        BattlePokemon battlePokemon = new BattlePokemon();
        RegisterPlayer registerPlayer = new RegisterPlayer();
        Label playerLabelOne = new Label("Select your name: ");
        Label pokemonLabelOne = new Label("Select your pokemon: ");
        Label selectOne = new Label("");
        Label selectTwo = new Label("");
        Label playerLabelTwo = new Label("Select your name: ");
        Label pokemonLabelTwo = new Label("Select your pokemon: ");
        VBox playerOne = new VBox();
        ComboBox namePlayerOne = new ComboBox();
        ComboBox selectPokemonOne = new ComboBox();
        namePlayerOne.getItems().addAll(listPlayer.getNameAndLastNamePlayer());
        selectPokemonOne.getItems().addAll(list.getPokemonList());

        ImageView player1View = new ImageView();
        LoadImage loadImage = new LoadImage();
        AnimationImage animationImage = new AnimationImage();
        EventHandler<ActionEvent> eventHandler1 =
                e -> {
                    selectOne.setText(selectPokemonOne.getValue() + " selected");
                    player1View.setImage(loadImage.getImage((String) selectPokemonOne.getValue()));
                    Animation animation = animationImage.animationPokemon(player1View);
                    animation.setCycleCount(Animation.INDEFINITE);
                    animation.play();
                    Type pokemon1 = list.enumPokemon(list.getTypePokemon((String) selectPokemonOne.getValue()));
                    System.out.println(pokemon1);
                };
        selectPokemonOne.setOnAction(eventHandler1);

        playerOne.getChildren().addAll(playerLabelOne, namePlayerOne, pokemonLabelOne, selectPokemonOne, selectOne, player1View);
        VBox.setMargin(playerLabelOne, new Insets(150, 10, 10, 30));
        VBox.setMargin(namePlayerOne, new Insets(10, 10, 10, 30));
        VBox.setMargin(pokemonLabelOne, new Insets(10, 10, 10, 30));
        VBox.setMargin(selectPokemonOne, new Insets(10, 10, 10, 30));
        VBox.setMargin(selectOne, new Insets(10, 10, 10, 30));
        VBox.setMargin(player1View, new Insets(10,10,10,30));

        VBox playerTwo = new VBox();
        ComboBox namePlayerTwo = new ComboBox();
        ComboBox selectPokemonTwo = new ComboBox();
        namePlayerTwo.getItems().addAll(listPlayer.getNameAndLastNamePlayer());
        selectPokemonTwo.getItems().addAll(list.getPokemonList());


        ImageView player2View = new ImageView();
        EventHandler<ActionEvent> eventHandler2 =
                e -> {
                    selectTwo.setText(selectPokemonTwo.getValue() + " selected");
                    player2View.setImage(loadImage.getImage((String) selectPokemonTwo.getValue()));
                    Animation animation = animationImage.animationPokemon(player2View);
                    animation.setCycleCount(Animation.INDEFINITE);
                    animation.play();
                    Type pokemon2 = list.enumPokemon(list.getTypePokemon((String) selectPokemonTwo.getValue()));
                    System.out.println(pokemon2);
                };
        selectPokemonTwo.setOnAction(eventHandler2);

        playerTwo.getChildren().addAll(playerLabelTwo, namePlayerTwo, pokemonLabelTwo, selectPokemonTwo, selectTwo, player2View);
        VBox.setMargin(playerLabelTwo, new Insets(150, 30, 10, 10));
        VBox.setMargin(namePlayerTwo, new Insets(10, 30, 10, 10));
        VBox.setMargin(pokemonLabelTwo, new Insets(10, 30, 10, 10));
        VBox.setMargin(selectPokemonTwo, new Insets(10, 30, 10, 10));
        VBox.setMargin(selectTwo, new Insets(10, 30, 10, 10));
        VBox.setMargin(player2View, new Insets(10, 30, 10, 10));

        BorderPane rootSelect = new BorderPane();
        rootSelect.setBorder(null);
        Label txt = new Label("POO" + "\n" + "BATTLE PRO");
        txt.setFont(Font.font("Arial", 44));
        Button firstButton = new Button("Empezar");
        firstButton.setStyle(Button_Style);
        firstButton.setOnMouseEntered(e -> firstButton.setStyle(Button_Style_Hover));
        firstButton.setOnMouseExited(e -> firstButton.setStyle(Button_Style));
        firstButton.setPrefSize(180,40);
        Button playerButton = new Button("Player");
        playerButton.setStyle(Button_Style);
        playerButton.setOnMouseEntered(e -> playerButton.setStyle(Button_Style_Hover));
        playerButton.setOnMouseExited(e -> playerButton.setStyle(Button_Style));
        playerButton.setPrefSize(180,40);
        VBox aux = new VBox();
        aux.getChildren().addAll(txt,playerButton, firstButton);
        StackPane centralPane = new StackPane();
        centralPane.getChildren().addAll(txt,playerButton, firstButton);
        StackPane.setAlignment(txt, Pos.TOP_CENTER);
        StackPane.setAlignment(playerButton, Pos.CENTER_LEFT);
        StackPane.setAlignment(firstButton, Pos.CENTER_RIGHT);
        StackPane.setMargin(txt, new Insets(150,0,0,0));
        StackPane.setMargin(playerButton, new Insets(10,10,10,50));
        StackPane.setMargin(firstButton, new Insets(10,50,10,10));
        rootSelect.setStyle(BorderPane_Style);
        rootSelect.setCenter(centralPane);
        rootSelect.setLeft(playerOne);
        rootSelect.setRight(playerTwo);
        BorderPane.setAlignment(playerButton, Pos.CENTER);
        BorderPane.setAlignment(txt, Pos.CENTER);
        BorderPane.setAlignment(playerOne, Pos.CENTER);
        BorderPane.setAlignment(playerTwo, Pos.CENTER);
        BorderPane.setMargin(firstButton, new Insets(15, 15, 15, 15));

        firstButton.setOnAction((ActionEvent event) -> {
            battlePokemon.setTeamsBattle((String) namePlayerOne.getValue(),(String) selectPokemonOne.getValue(), (String) namePlayerTwo.getValue(),(String) selectPokemonTwo.getValue());
            battlePokemon.start(window);
        });
        playerButton.setOnAction((ActionEvent) -> {
            try {
                registerPlayer.start(window);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene firstScene = new Scene(rootSelect, 900, 700);
        firstScene.setFill(Color.TRANSPARENT);
        window.setScene(firstScene);
        window.show();
    }
}
