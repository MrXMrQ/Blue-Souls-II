package Items;

public class ConsumableWeapon extends Weapon {
    protected boolean stackable;
    protected int maxStack;

    public ConsumableWeapon(String name, String type, int damage, int durability, boolean stackable, int maxStack) {
        super(name, type, damage, durability);
        this.stackable = stackable;
        this.maxStack = maxStack;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    @Override
    public String toString() {
        return "ConsumableWeapon{" +
                "stackable=" + stackable +
                ", maxStack=" + maxStack +
                ", damage=" + damage +
                ", durability=" + durability +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
