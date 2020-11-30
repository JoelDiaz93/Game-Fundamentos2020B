package sample.pokemon;

public class BattleLogic {
    private int life;
    private int attack;
    private int stamina;
    private int finalAttack;
    private int defensa;
    private int contDefensa=0;
    private boolean defensaActiva = false;

    public BattleLogic(int life, int attack, int stamina, int finalAttack) {
        this.life = life;
        this.attack = attack;
        this.stamina = stamina;
        this.finalAttack = finalAttack;
    }

    public int getLife() {
        return this.life;
    }

    public int getStamina() {
        return this.stamina;
    }

    public void setLife(int damage){
        this.life -= damage;
    }

    //aumenta siempre el 10% en cada turno
    public void estamina(){
        this.stamina= (int) (this.stamina*(1.1));
    }

    //ataque normal y gastara un 5% de estamina
    public int setAttack(){
        double percentageDecreasing=(this.stamina*0.05);
        this.stamina= (int) (this.stamina-percentageDecreasing);
        return this.attack;
    }


    //ataque más fuerte y este consumirá el 50% de la estamina
    public int setFinalAttack(){
        double percentageDecreasing=(this.stamina*0.5);
        this.stamina= (int) (this.stamina-percentageDecreasing);
        return this.finalAttack;
    }

    //activar defensa cada ataque del jugador contrario solo será efectivo en un 75% por 3
    //turnos y cuesta 25% de estamina
    public void setDefensa(){
        this.defensaActiva = true;
        double percentageDecreasing=(this.stamina*0.25);
        this.stamina = (int) (this.stamina - percentageDecreasing);
    }

    // activar curar la vida del jugador aumenta en un 20% pero consume 20% de estamina
    public void setCurar(int life){
        if (this.life+(1.2*life) <= life ){
            Double porcentage = life*0.2;
            this.life = (int) (this.life + porcentage);
        }else if (this.life < life){

        }
    }


    @Override
    public String toString() {
        return "Jugador 1: Uso de garra de fuego";
    }
}
