package sample.pokemon;

import java.util.ArrayList;

public class Teams {
    private ArrayList<String> team1;
    private ArrayList<String> team2;

    Type type1;
    Type type2;

    private PokemonsList list = new PokemonsList();

    public Teams() {
        this.team1 = new ArrayList<>();
        this.team2 = new ArrayList<>();
    }

    public void setTeam1(String player, String pokemon) {
        this.team1.add(player);
        this.team1.add(pokemon);
        type1 = list.enumPokemon(list.getTypePokemon(pokemon));
    }

    public void setTeam2(String player, String pokemon) {
        this.team2.add(player);
        this.team2.add(pokemon);
        type2 = list.enumPokemon(list.getTypePokemon(pokemon));
    }

    public ArrayList<String> getTeam1() {
        return this.team1;
    }

    public ArrayList<String> getTeam2() {
        return this.team2;
    }

    public Type getType1() {
        return this.type1;
    }

    public Type getType2() {
        return this.type2;
    }
}
