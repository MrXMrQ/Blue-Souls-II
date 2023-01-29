package Figures;

public class Monster extends Figur {
    protected int schaden;
    protected String type;
    protected boolean weapon;
    protected boolean weapondrop;
    protected int souls;

    public Monster(String name, int healthpoints, int staminapoints, int schaden, String type, boolean weapon, boolean weapondrop, int souls) {
        super(name, healthpoints, staminapoints);
        this.schaden = schaden;
        this.type = type;
        this.weapon = weapon;
        this.weapondrop = weapondrop;
        this.souls = souls;
    }

    public int getSchaden() {
        return schaden;
    }

    public void setSchaden(int schaden) {
        this.schaden = schaden;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWeapon() {
        return weapon;
    }

    public void setWeapon(boolean weapon) {
        this.weapon = weapon;
    }

    public boolean isWeapondrop() {
        return weapondrop;
    }

    public void setWeapondrop(boolean weapondrop) {
        this.weapondrop = weapondrop;
    }

    public int getSouls() {
        return souls;
    }

    public void setSouls(int souls) {
        this.souls = souls;
    }
}
