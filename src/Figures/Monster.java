package Figures;

import Items.Weapon;

public class Monster extends Figur {
    protected int damage;
    protected String type;
    protected boolean itemDrop;
    protected int souls;
    protected Weapon weapon;

    public Monster(String name, int healthpoints, int staminapoints, int damage, String type, boolean itemDrop, int souls, Weapon weapon) {
        super(name, healthpoints, staminapoints);
        this.damage = damage;
        this.type = type;
        this.itemDrop = itemDrop;
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

    public boolean isItemDrop() {
        return itemDrop;
    }

    public void setItemDrop(boolean itemDrop) {
        this.itemDrop = itemDrop;
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