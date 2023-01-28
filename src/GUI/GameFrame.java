package GUI;

import Dungeons.Dungeons;
import Figures.Monster;
import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameFrame {
    //Buttons
    JButton button1;
    JButton button2;
    JButton button3;

    JButton attackButton;
    JButton healButton;
    JButton inventoryButton;
    JButton equipButton;

    //Buttons
    LabelWithIcons cave1;
    LabelWithIcons cave2;
    LabelWithIcons cave3;
    LabelWithIcons monster;

    //Panels
    JPanel panelNORTH;
    JPanel panelCENTER;

    //Layouts
    FlowLayout flowLayout;

    //Windows
    MyFrame gameFightWindow;

    Monster bot = new Monster("BOT", 999, 999, 999, "BOT", false, false);

    Dungeons chooseDungeon;
    int layers;
    boolean newWindow;
    Monster[] dungeonMonster;

    public GameFrame() {
        gameDungeonSelection();
    }

    public void gameDungeonSelection() {
        MyFrame gameDungeonWindow = new MyFrame();
        gameDungeonWindow.setLayout(new BorderLayout());

        randomDungeons();

        flowLayout = new FlowLayout();
        flowLayout.setHgap(25);

        JPanel panelNORTH = new JPanel(flowLayout);

        cave1 = new LabelWithIcons();
        cave1.setText(GameLauncher.dungeonsArray[0].getName());

        cave2 = new LabelWithIcons();
        cave2.setText(GameLauncher.dungeonsArray[1].getName());

        cave3 = new LabelWithIcons();
        cave3.setText(GameLauncher.dungeonsArray[2].getName());

        panelNORTH.add(cave1);
        panelNORTH.add(cave2);
        panelNORTH.add(cave3);

        gameDungeonWindow.add(panelNORTH, BorderLayout.NORTH);


        panelCENTER = new JPanel(flowLayout);

        button1 = new JButton(GameLauncher.dungeonsArray[0].getName());
        button1.setPreferredSize(new Dimension(256, 64));
        button1.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[0];
            gameFight();
            gameDungeonWindow.dispose();
        });

        button2 = new JButton(GameLauncher.dungeonsArray[1].getName());
        button2.setPreferredSize(new Dimension(256, 64));
        button2.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[1];
            gameFight();
            gameDungeonWindow.dispose();
        });

        button3 = new JButton(GameLauncher.dungeonsArray[2].getName());
        button3.setPreferredSize(new Dimension(256, 64));
        button3.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[2];
            gameFight();
            gameDungeonWindow.dispose();
        });

        panelCENTER.add(button1);
        panelCENTER.add(button2);
        panelCENTER.add(button3);

        gameDungeonWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    public void gameFight() {
        layers = (int) (Math.random() * (chooseDungeon.getHighLevel() - chooseDungeon.getLowLevel() + 1)) + chooseDungeon.getLowLevel();
        randomMonster();

    }

    public void ahh() {
        int counter = 0;
        bot = dungeonMonster[counter];
        counter++;

        gameFightWindow = new MyFrame();
        gameFightWindow.setLayout(new BorderLayout());

        panelNORTH = new JPanel();
        panelNORTH.setLayout(flowLayout);

        monster = new LabelWithIcons();
        monster.setText(bot.getName());
        panelNORTH.add(monster);

        gameFightWindow.add(panelNORTH, BorderLayout.NORTH);


        panelCENTER.removeAll();
        panelCENTER.setLayout(flowLayout);

        attackButton = new JButton("Attack");
        attackButton.setPreferredSize(new Dimension(256, 64));
        attackButton.addActionListener(e -> {
            bot.setHealthpoints(bot.getHealthpoints() - GameLauncher.characterArray[1].getDamage());
            ifPLayerDead();
        });
        panelCENTER.add(attackButton);

        healButton = new JButton("Heal");
        healButton.setPreferredSize(new Dimension(256, 64));
        panelCENTER.add(healButton);

        inventoryButton = new JButton("Inventory");
        inventoryButton.setPreferredSize(new Dimension(256, 64));
        panelCENTER.add(inventoryButton);

        equipButton = new JButton("Equipment");
        equipButton.setPreferredSize(new Dimension(256, 64));
        panelCENTER.add(equipButton);

        gameFightWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    public void randomDungeons() {
        List<Dungeons> list = Arrays.asList(GameLauncher.dungeonsArray);
        Collections.shuffle(list);
        list.toArray(GameLauncher.dungeonsArray);

    }

    public void randomMonster() {
        List<Monster> list = Arrays.asList(GameLauncher.monsterArray);
        Collections.shuffle(list);
        list.toArray(GameLauncher.monsterArray);
    }

    public void ifPLayerDead() {
        if (GameLauncher.characterArray[0].getHealthpoints() <= 0) {
            System.out.println("You Died");
            System.exit(1);
        }
    }
}