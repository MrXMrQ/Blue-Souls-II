package Figures;

public class Monster extends Figur {
    protected int schaden;
    protected String kind;
    protected boolean weapon;
    protected boolean weapondrop;

    public Monster(String name, int healthpoints, int staminapoints, int schaden, String kind, boolean weapon, boolean weapondrop) {
        super(name, healthpoints, staminapoints);
        this.schaden = schaden;
        this.kind = kind;
        this.weapon = weapon;
        this.weapondrop = weapondrop;
    }

    public int getSchaden() {
        return schaden;
    }

    public void setSchaden(int schaden) {
        this.schaden = schaden;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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
}
