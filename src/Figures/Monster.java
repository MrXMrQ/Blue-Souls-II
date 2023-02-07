package Figures;

import Items.Weapon;

public class Monster extends Figur {
    protected int damage;
    protected String type;
    protected boolean haveWeapon;
    protected boolean weapondrop;
    protected int souls;
    protected Weapon weapon;

    public Monster(String name, int healthpoints, int staminapoints, int damage, String type, boolean haveWeapon, boolean weapondrop, int souls, Weapon weapon) {
        super(name, healthpoints, staminapoints);
        this.damage = damage;
        this.type = type;
        this.haveWeapon = haveWeapon;
        this.weapondrop = weapondrop;
        this.souls = souls;
        this.weapon = weapon;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int schaden) {
        this.damage = schaden;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHaveWeapon() {
        return haveWeapon;
    }

    public void setHaveWeapon(boolean haveWeapon) {
        this.haveWeapon = haveWeapon;
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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}