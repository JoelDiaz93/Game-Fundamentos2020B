package sample.pokemon;

public enum Type {
    Fire(1300,500,110,230),
    Water(1200, 600, 100, 210),
    Air(950, 400, 140, 200),
    Ground(1400, 700, 95, 156);

    private int life;
    private int stamina;
    private int attack;
    private int finalAttack;

    private Type(int life, int stamina, int attack, int finalAttack){
        this.life = life;
        this.stamina = stamina;
        this.attack = attack;
        this.finalAttack =finalAttack;
    }

    public int getLife() {
        return life;
    }

    public int getStamina() {
        return stamina;
    }

    public int getAttack() {
        return attack;
    }

    public int getFinalAttack() {
        return finalAttack;
    }
}
