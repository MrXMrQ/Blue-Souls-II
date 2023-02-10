import Launcher.GameLauncher;
import Launcher.ItemLauncher;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GameLauncher.gameMainMenuAndChaSubmitWindowLauncher();
        test();
        //sad
    }

    public static void test() {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        System.out.println(arrayList);
        System.out.println(arrayList.size());

        arrayList.remove(1);

        System.out.println(arrayList);
        System.out.println(arrayList.size());


    }
}