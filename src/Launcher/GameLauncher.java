package Launcher;

import Dungeons.Dungeons;
import Figures.Character;
import Figures.Monster;
import GUI.GameFrame;
import GUI.MainMenuAndChaSubmitFrames;

public class GameLauncher {
    public static Character[] characterArray = characters();
    public static Monster[] monsterArray = monsters();

    public static Dungeons[] dungeonsArray = dungeons();

    public static void gameMainMenuAndChaSubmitWindowLauncher() {
        MainMenuAndChaSubmitFrames mainMenuAndChaSubmitFrame = new MainMenuAndChaSubmitFrames();
    }

    public static void gameWindowLauncher() {
        GameFrame gameFrame = new GameFrame();
    }

    public static Character[] characters() {
        Character player = new Character("PLAYER", 999, 999, 999, 999, 999, 999, 0, 0, "PLAYER", 999, 989);

        Character knight = new Character("Knight", 1000, 100, 20, 4, 5, 250, 0, 0, "Knight", 1000, 100);
        Character warrior = new Character("Warrior", 1000, 100, 30, 2, 6, 250, 0, 0, "Warrior", 1000, 100);
        Character wizard = new Character("Wizard", 1000, 100, 10, 6, 0, 250, 0, 0, "Wizard", 1000, 100);
        Character confessor = new Character("Confessor", 1000, 100, 40, 1, 1, 250, 0, 0, "Confessor", 1000, 100);

        return new Character[]{player, knight, warrior, wizard, confessor};
    }

    public static Monster[] monsters() {
        Monster golem = new Monster("Golem", 50, 50, 50, "cave", false, false, 10, null);
        Monster caveSpider = new Monster("Cave Spider", 50, 50, 50, "cave", false, false, 10, null);
        Monster gargoyle = new Monster("Gargoyle", 50, 50, 50, "cave", true, false, 10, null);
        Monster skeleton = new Monster("Skeleton", 50, 50, 50, "cave", true, false, 10, null);

        Monster raptor = new Monster("Raptor", 50, 50, 50, "jungle", false, false, 10, null);

        return new Monster[]{golem, caveSpider, gargoyle, skeleton, raptor};
    }

    public static Dungeons[] dungeons() {
        Dungeons caveSystem = new Dungeons("Cave System", 2, 5, false, "cave");
        Dungeons mineshaft = new Dungeons("Mineshaft", 5, 12, false, "cave");
        Dungeons deepDark = new Dungeons("Deep dark", 8, 14, false, "cave");
        Dungeons lavaTube = new Dungeons("Lava Tube", 10, 15, false, "cave");


        return new Dungeons[]{caveSystem, mineshaft, deepDark, lavaTube};
    }
}