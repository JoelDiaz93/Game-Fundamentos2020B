package sample;

import sample.GUI.InitialWindow;
import sample.pokemon.PokemonsList;

import static javafx.application.Application.launch;

public class Main{

    public static void main(String[] args) {
        PokemonsList list = new PokemonsList();
        System.out.println(list.toString());;

        launch(InitialWindow.class);
    }
}
