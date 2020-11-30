package sample.pokemon;

public class Pokemon {
    private String namePokemon;
    private String typePokemon;

    public Pokemon(String name, String type){
        this.namePokemon = name;
        this.typePokemon = type;
    }

    public String getNamePokemon() {
        return namePokemon;
    }

    public String getTypePokemon() {
        return typePokemon;
    }

    public void setNamePokemon(String namePokemon) {
        this.namePokemon = namePokemon;
    }

    public void setTypePokemon(String typePokemon) {
        this.typePokemon = typePokemon;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "namePokemon='" + namePokemon + '\'' +
                ", typePokemon='" + typePokemon + '\'' +
                '}';
    }
}
