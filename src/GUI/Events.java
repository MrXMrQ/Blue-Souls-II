package GUI;

public class Events {
    public void eventCalculator() {
        int probability = (int) (Math.random() * 100);

        if (probability > 50) {
            trader();
        } else if (probability < 50) {
            npc();
        }
    }

    public void trader() {

    }

    public void npc() {

    }
}
