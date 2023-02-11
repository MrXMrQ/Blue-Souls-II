package Items;

public class Ring extends Item {
    String kind;
    double multiplier;

    public Ring(String name, String type, String kind, double multiplier) {
        super(name, type);
        this.kind = kind;
        this.multiplier = multiplier;

    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}