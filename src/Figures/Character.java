package Figures;

public class Character extends Figur {
    protected int damage;
    protected int ringslots;
    protected int healthpotion;
    protected int fist;

    public Character(String name, int healthpoints, int staminapoints, int damage, int ringslots, int healthpotion, int fist) {
        super(name, healthpoints, staminapoints);
        this.damage = damage;
        this.ringslots = ringslots;
        this.healthpotion = healthpotion;
        this.fist = fist;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRingslots() {
        return ringslots;
    }

    public void setRingslots(int ringslots) {
        this.ringslots = ringslots;
    }

    public int getHealthpotion() {
        return healthpotion;
    }

    public void setHealthpotion(int healthpotion) {
        this.healthpotion = healthpotion;
    }

    public int getFist() {
        return fist;
    }

    public void setFist(int fist) {
        this.fist = fist;
    }
}
