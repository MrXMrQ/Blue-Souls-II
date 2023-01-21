package Figures;

public abstract class Figur {
    protected String name;
    protected int healthpoints;
    protected int staminapoints;

    public Figur(String name, int healthpoints, int staminapoints) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.staminapoints = staminapoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthpoints() {
        return healthpoints;
    }

    public void setHealthpoints(int healthpoints) {
        this.healthpoints = healthpoints;
    }

    public int getStaminapoints() {
        return staminapoints;
    }

    public void setStaminapoints(int staminapoints) {
        this.staminapoints = staminapoints;
    }
}