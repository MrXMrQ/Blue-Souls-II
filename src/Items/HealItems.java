package Items;

public class HealItems extends Item{
    protected int dealHeal;

    public HealItems(String name, String type, int dealHeal) {
        super(name, type);
        this.dealHeal = dealHeal;
    }

    public int getDealHeal() {
        return dealHeal;
    }

    public void setDealHeal(int dealHeal) {
        this.dealHeal = dealHeal;
    }

    @Override
    public String toString() {
        return "HealItems{" +
                "dealHeal=" + dealHeal +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
