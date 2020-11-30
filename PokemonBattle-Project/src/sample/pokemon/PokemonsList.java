package sample.pokemon;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PokemonsList {
    private List<Pokemon> pokemonList;

    public PokemonsList() {
        pokemonList = new ArrayList<>();

        try {
            Files.lines(Paths.get("pokemons.txt"))
                    .map(row -> row.split(";"))
                    .filter(parts -> parts.length >= 2)
                    .map(parts -> new Pokemon(parts[0], parts[1]))
                    .forEach(pokemon -> pokemonList.add(pokemon));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ArrayList<String> getPokemonList() {
        ArrayList pokemonList = new ArrayList();
        for (Pokemon one : this.pokemonList){
            pokemonList.add(one.getNamePokemon());
        }
        return pokemonList;
    }

    public String getTypePokemon(String pokemon){
        String type = "";
        for (Pokemon t: this.pokemonList){
            if (pokemon.equals(t.getNamePokemon())){
                type=t.getTypePokemon();
            }
        }
        System.out.println(type);
        return type;
    }

    public Type enumPokemon(String type){
        if (type.equals("Fire")){
            return Type.Fire;
        }
        if (type.equals("Air")){
            return Type.Air;
        }
        if (type.equals("Ground")){
            return Type.Ground;
        }
        if (type.equals("Water")){
            return Type.Water;
        }
        return null;
    }

    @Override
    public String toString() {
        String pokemons = "";
        for (Pokemon one : this.pokemonList) {
            pokemons+=one.getNamePokemon()+" is of type: "+one.getTypePokemon()+"\n";
        }
        return pokemons;
    }
}
