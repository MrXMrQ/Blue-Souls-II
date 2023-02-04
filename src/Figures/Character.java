package Figures;

public class Character extends Figur {
    protected int damage;
    protected int ringslots;
    protected int healthpotion;
    protected int healthpotionDealHealth;
    protected int fist;
    protected int souls;
    protected String chaClass;
    protected int maxHealth;
    protected int maxStamina;

    public Character(String name, int healthpoints, int staminapoints, int damage, int ringslots, int healthpotion, int healthpotionDealHealth, int fist, int souls, String chaClass, int maxHealth, int maxStamina) {
        super(name, healthpoints, staminapoints);
        this.damage = damage;
        this.ringslots = ringslots;
        this.healthpotion = healthpotion;
        this.healthpotionDealHealth = healthpotionDealHealth;
        this.fist = fist;
        this.souls = souls;
        this.chaClass = chaClass;
        this.maxHealth = maxHealth;
        this.maxStamina = maxStamina;
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

    public int getHealthpotionDealHealth() {
        return healthpotionDealHealth;
    }

    public void setHealthpotionDealHealth(int healthpotionDealHealth) {
        this.healthpotionDealHealth = healthpotionDealHealth;
    }

    public int getFist() {
        return fist;
    }

    public void setFist(int fist) {
        this.fist = fist;
    }

    public int getSouls() {
        return souls;
    }

    public void setSouls(int souls) {
        this.souls = souls;
    }

    public String getChaClass() {
        return chaClass;
    }

    public void setChaClass(String chaClass) {
        this.chaClass = chaClass;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }
}
