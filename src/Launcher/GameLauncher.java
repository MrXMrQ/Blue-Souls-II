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
        new MainMenuAndChaSubmitFrames();
    }

    public static void gameWindowLauncher() {
        new GameFrame();
    }

    public static Character[] characters() {
        Character player = new Character("PLAYER", 999, 999, 999, 999, 999, 999, 0, 0, "PLAYER", 999, 989);

        Character knight = new Character("Knight", 1000, 100, 20, 4, 5, 250, 0, 0, "Knight", 1000, 100);
        Character warrior = new Character("Warrior", 900, 120, 30, 2, 6, 250, 0, 0, "Warrior", 900, 100);
        Character wizard = new Character("Wizard", 500, 50, 10, 5, 1, 250, 0, 0, "Wizard", 500, 100);
        Character confessor = new Character("Confessor", 650, 70, 40, 1, 1, 250, 0, 0, "Confessor", 650, 100);

        return new Character[]{player, knight, warrior, wizard, confessor};
    }

    public static Monster[] monsters() {
        Monster golem = new Monster("Golem", 200, 100, 3, "cave", true, 4, null);
        Monster caveSpider = new Monster("Cave Spider", 30, 100, 30, "cave", true, 10, null);
        Monster gargoyle = new Monster("Gargoyle", 150, 100, 40, "cave", true, 10, null);
        Monster skeleton = new Monster("Skeleton", 145, 100, 20, "cave", true, 10, null);

        return new Monster[]{golem, caveSpider, gargoyle, skeleton};
    }

    public static Dungeons[] dungeons() {
        Dungeons caveSystem = new Dungeons("Cave System", 2, 5, false, "cave");
        Dungeons mineshaft = new Dungeons("Mineshaft", 5, 12, false, "cave");
        Dungeons deepDark = new Dungeons("Deep dark", 8, 14, false, "cave");
        Dungeons lavaTube = new Dungeons("Lava Tube", 10, 15, false, "cave");


        return new Dungeons[]{caveSystem, mineshaft, deepDark, lavaTube};
    }
}