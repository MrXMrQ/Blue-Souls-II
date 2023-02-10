package Items;

public class UseItems extends Item{
    protected int dealHeal;
    protected int damage;
    protected boolean stackable;
    protected int maxStack;

    public UseItems(String name, String type, int dealHeal, int damage, boolean stackable, int maxStack) {
        super(name, type);
        this.dealHeal = dealHeal;
        this.damage = damage;
        this.stackable = stackable;
        this.maxStack = maxStack;
    }

    public int getDealHeal() {
        return dealHeal;
    }

    public void setDealHeal(int dealHeal) {
        this.dealHeal = dealHeal;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
}
