package NPCS;

public class NPC {
    protected String name;
    protected int healthpoints;
    protected String politeness;
    protected String type;

    public NPC(String name, int healthpoints, String politeness, String type) {
        this.name = name;
        this.healthpoints = healthpoints;
        this.politeness = politeness;
        this.type = type;
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

    public String getPoliteness() {
        return politeness;
    }

    public void setPoliteness(String politeness) {
        this.politeness = politeness;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}