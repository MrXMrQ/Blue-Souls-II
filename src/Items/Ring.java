package Items;

public class Ring extends Item {
    double multiplier;

    public Ring(String name, String type, double multiplier) {
        super(name, type);
        this.multiplier = multiplier;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public String toString() {
        return "Ring{" +
                "multiplier=" + multiplier +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}