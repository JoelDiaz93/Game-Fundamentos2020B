package sample.GUI;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.animation.AnimationImage;
import sample.animation.LoadImage;
import sample.pokemon.BattleLogic;
import sample.pokemon.Teams;

public class BattlePokemon extends Application {
    final String BorderPane_Style = "-fx-background-color:rgb(242,242,238,0.95); -fx-background-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;";
    final String Button_Style = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #212121; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #212121;-fx-background-color: transparent";
    final String Button_Style_Hover = "-fx-border-radius: 15 15 15 15, 15 15 15 15, 15 15 15 15;-fx-text-fill: #303F9F; -fx-font-size: 30; -fx-font-weight: bold; -fx-border-color: #ffffff;-fx-background-color: transparent";

    Teams teamsBattle = new Teams();
    BattleLogic pokemonBattle1;
    BattleLogic pokemonBattle2;

    @Override
    public void start(Stage window) {
        Score score = new Score();
        BorderPane secondScreen = new BorderPane();
        Button secondButton = new Button("Scores");
        secondButton.setStyle(Button_Style);
        secondButton.setOnMouseEntered(e -> secondButton.setStyle(Button_Style_Hover));
        secondButton.setOnMouseExited(e -> secondButton.setStyle(Button_Style));

        LoadImage loadImage = new LoadImage();
        AnimationImage animationImage = new AnimationImage();

        TextField historialAtaques = new TextField("Jugador 1: Uso garra de fuego");
        secondScreen.setCenter(secondButton);
        //BOTONES A-D-C-AF

        GridPane jugador1 = new GridPane();
        Button ataque1 = new Button("Ataque");
        Button ataqueFinal1 = new Button("Ataque Final");
        Button defensa1 = new Button("Defensa");
        Button curar1 = new Button("Curar");

        ataque1.setPrefSize(110, 25);
        curar1.setPrefSize(110, 25);
        defensa1.setPrefSize(110, 25);
        ataqueFinal1.setPrefSize(110, 25);

        ImageView player1View = new ImageView();
        player1View.setImage(loadImage.getImage(teamsBattle.getTeam1().get(1)));
        Animation animation1 = animationImage.animationPokemon(player1View);
        animation1.setCycleCount(Animation.INDEFINITE);
        animation1.play();

        jugador1.add(ataque1, 0, 0);
        jugador1.add(ataqueFinal1, 1, 0);
        jugador1.add(defensa1, 0, 1);
        jugador1.add(curar1, 1, 1);

        jugador1.setVgap(0);
        jugador1.setHgap(0);
        jugador1.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane jugador2 = new GridPane();


        Button ataque2 = new Button("Ataque");
        Button ataqueFinal2 = new Button("Ataque Final");
        Button defensa2 = new Button("Defensa");
        Button curar2 = new Button("Curar");

        ataque2.setPrefSize(110, 25);
        curar2.setPrefSize(110, 25);
        defensa2.setPrefSize(110, 25);
        ataqueFinal2.setPrefSize(110, 25);

        Label nombreJugador2 = new Label(teamsBattle.getTeam2().get(0));
        Label personajeJugador2 = new Label(teamsBattle.getTeam2().get(1));
        Label sVida = new Label("Vida:");
        Label sEstamina = new Label("Estamina:");
        TextField vida2 = new TextField(pokemonBattle2.getLife() + " / " + teamsBattle.getType2().getLife());
        TextField estamina2 = new TextField(pokemonBattle2.getStamina() + " / " + teamsBattle.getType2().getStamina());

        nombreJugador2.setFont(Font.font("Arial", 19));
        personajeJugador2.setFont(Font.font("Arial", 18));

//********************************************************************************
        GridPane gamer2 = new GridPane();
        ImageView player2View = new ImageView();
        player2View.setImage(loadImage.getImage(teamsBattle.getTeam2().get(1)));
        Animation animation2 = animationImage.animationPokemon(player2View);
        animation2.setCycleCount(Animation.INDEFINITE);
        animation2.play();

        gamer2.add(player2View, 0,0);
        gamer2.add(nombreJugador2, 0, 1);
        gamer2.add(personajeJugador2, 0, 2);
        gamer2.add(sVida, 0, 3);
        gamer2.add(vida2, 1, 3);
        gamer2.add(sEstamina, 0, 4);
        gamer2.add(estamina2, 1, 4);

        gamer2.setAlignment(Pos.CENTER_RIGHT);

        GridPane botones2 = new GridPane();
        botones2.add(ataque2, 0, 0);
        botones2.add(ataqueFinal2, 1, 0);
        botones2.add(defensa2, 0, 1);
        botones2.add(curar2, 1, 1);

        botones2.setPadding(new Insets(25, 5, 0, 120));

        jugador2.add(gamer2, 0, 0);
        jugador2.add(botones2, 0, 1);

        jugador2.setVgap(0);
        jugador2.setHgap(0);
        jugador2.setAlignment(Pos.BOTTOM_RIGHT);

        historialAtaques.setAlignment(Pos.BOTTOM_LEFT);

        secondScreen.setRight(jugador2);
        secondScreen.setLeft(jugador1);

        jugador1.setPadding(new Insets(5, 1, 10, 1));
        jugador2.setPadding(new Insets(5, 1, 10, 1));

        historialAtaques.setPadding(new Insets(1, 1, 30, 1));

        secondScreen.setPadding(new Insets(5, 5, 5, 5));
        secondScreen.setBottom(historialAtaques);
//----------------------------------------------------------------------------------
        //Jugadores - Vida - Estamina
        Label nombreJugador1 = new Label(teamsBattle.getTeam1().get(0));
        Label personajeJugador1 = new Label(teamsBattle.getTeam1().get(1));
        Label xVida = new Label("Vida");
        Label xEstamina = new Label("Estamina");
        TextField vida1 = new TextField(pokemonBattle1.getLife() + " / " + teamsBattle.getType1().getLife());
        TextField estamina1 = new TextField(pokemonBattle1.getStamina() + " / " + teamsBattle.getType1().getStamina());

        nombreJugador1.setFont(Font.font("Arial", 19));
        personajeJugador1.setFont(Font.font("Arial", 18));

        GridPane gamer1 = new GridPane();
        gamer1.add(nombreJugador1, 0, 0);
        gamer1.add(personajeJugador1, 0, 1);
        gamer1.add(xVida, 0, 2);
        gamer1.add(vida1, 1, 2);
        gamer1.add(xEstamina, 0, 3);
        gamer1.add(estamina1, 1, 3);
        gamer1.add(player1View, 0,4);

        secondScreen.setTop(gamer1);

        //--------------------------------------------------------------------------------

        ataque1.setOnMouseClicked((event -> {
            pokemonBattle2.setLife(pokemonBattle1.setAttack());
            vida2.setText(pokemonBattle2.getLife() + " / " + teamsBattle.getType2().getLife());
            estamina1.setText(pokemonBattle1.getStamina() + " / " + teamsBattle.getType1().getStamina());
        }));

        ataque2.setOnMouseClicked((event -> {
            pokemonBattle1.setLife(pokemonBattle2.setAttack());
            vida1.setText(pokemonBattle1.getLife() + " / " + teamsBattle.getType1().getLife());
            estamina2.setText(pokemonBattle2.getStamina() + " / " + teamsBattle.getType2().getStamina());
        }));

        ataqueFinal1.setOnMouseClicked((event -> {
            pokemonBattle2.setLife(pokemonBattle1.setFinalAttack());
            vida2.setText(pokemonBattle2.getLife() + " / " + teamsBattle.getType2().getLife());
            estamina1.setText(pokemonBattle1.getStamina() + " / " + teamsBattle.getType1().getStamina());
        }));

        ataqueFinal2.setOnMouseClicked((event -> {
            pokemonBattle1.setLife(pokemonBattle2.setFinalAttack());
            vida1.setText(pokemonBattle1.getLife() + " / " + teamsBattle.getType1().getLife());
            estamina2.setText(pokemonBattle2.getStamina() + " / " + teamsBattle.getType2().getStamina());
        }));

        secondScreen.setPrefSize(900, 580);
        secondScreen.setStyle(BorderPane_Style);
        Scene secondScene = new Scene(secondScreen, 900, 700);
        secondScene.setFill(Color.TRANSPARENT);

        secondButton.setOnAction((ActionEvent event) -> score.start(window));

        window.setScene(secondScene);
        window.show();
    }

    public void setTeamsBattle(String player1, String pokemon1, String player2, String pokemon2) {
        //this.teamsBattle = new Teams();
        this.teamsBattle.setTeam1(player1, pokemon1);
        this.teamsBattle.setTeam2(player2, pokemon2);
        pokemonBattle1 = new BattleLogic(teamsBattle.getType1().getLife(), teamsBattle.getType1().getAttack(), teamsBattle.getType1().getStamina(), teamsBattle.getType1().getFinalAttack());
        pokemonBattle2 = new BattleLogic(teamsBattle.getType2().getLife(), teamsBattle.getType2().getAttack(), teamsBattle.getType2().getStamina(), teamsBattle.getType2().getFinalAttack());
    }
}
