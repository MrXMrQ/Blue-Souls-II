package Dungeons;

public class Dungeons {
    String name;
    int lowLevel;
    int highLevel;
    boolean loot;
    String type;

    public Dungeons(String difficulty, int lowLevel, int highLevel, boolean loot, String type) {
        this.name = difficulty;
        this.lowLevel = lowLevel;
        this.highLevel = highLevel;
        this.loot = loot;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLowLevel() {
        return lowLevel;
    }

    public void setLowLevel(int lowLevel) {
        this.lowLevel = lowLevel;
    }

    public int getHighLevel() {
        return highLevel;
    }

    public void setHighLevel(int highLevel) {
        this.highLevel = highLevel;
    }

    public boolean isLoot() {
        return loot;
    }

    public void setLoot(boolean loot) {
        this.loot = loot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
