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
        Character player = new Character("PLAYER", 999, 999, 999, 999, 999, 999);

        Character knight = new Character("Knight", 1000, 100, 10, 4, 4, 0);
        Character warrior = new Character("Warrior", 100, 100, 100, 4, 4, 0);
        Character wizard = new Character("Wizard", 100, 100, 100, 4, 4, 0);
        Character confessor = new Character("Confessor", 100, 100, 100, 4, 4, 0);

        return new Character[]{player, knight, warrior, wizard, confessor};
    }

    public static Monster[] monsters() {
        Monster golem = new Monster("Golem", 50, 50, 50, "cave", false, false);
        Monster caveSpider = new Monster("Cave Spider", 50, 50, 50, "cave", false, false);
        Monster gargoyle = new Monster("Gargoyle", 50,50,50,"cave", false,false);

        Monster raptor = new Monster("Raptor", 50,50,50,"jungle", false,false);

        return new Monster[]{golem, caveSpider, gargoyle, raptor};
    }

    public static Dungeons[] dungeons() {
        Dungeons caveSystem = new Dungeons("Cave System", 1,5,false,"cave");
        Dungeons mineshaft = new Dungeons("Mineshaft", 5,12,false,"cave");
        Dungeons deepDark = new Dungeons("Deep dark", 8,14,false,"cave");
        Dungeons lavaTube = new Dungeons("Lava Tube", 10, 15, false, "cave");


        return new Dungeons[]{caveSystem, mineshaft, deepDark, lavaTube};
    }
}