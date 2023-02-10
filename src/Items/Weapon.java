package Items;

public class Weapon extends Item {
    protected int damage;
    protected int durability;

    public Weapon(String name, String type, int damage, int durability) {
        super(name, type);
        this.damage = damage;
        this.durability = durability;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
