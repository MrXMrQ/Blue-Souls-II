package Launcher;

import Figures.Character;
import Figures.Monster;
import GUI.GameFrames;

public class GameLauncher {
    static Character player = new Character("PLAYER", 999, 999, 999, 999, 999, 999);

    static Character knight = new Character("Knight", 100, 100, 100, 4, 4, 0);
    static Character warrior = new Character("Warrior", 999, 999, 999, 999, 999, 999);
    static Character wizard = new Character("Wizard", 100, 100, 100, 4, 4, 0);
    static Character confessor = new Character("Confessor", 999, 999, 999, 999, 999, 999);

    static Monster golem = new Monster("Golem", 50, 50, 50, "cave", false, false);

    public static Character[] characterArray = new Character[]{player, knight, warrior, wizard, confessor};
    public static Monster[] monsterArray = new Monster[]{golem};

    public static void gameLauncher() {
        GameFrames theGame = new GameFrames();
    }
}
