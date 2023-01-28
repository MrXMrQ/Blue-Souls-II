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
    MyFrame gameDungeonWindow;

    //Other stuff
    Monster bot;
    Dungeons chooseDungeon;
    int layers;
    int counter;

    public GameFrame() {
        gameDungeonSelection();
    }

    public void gameDungeonSelection() {
        gameDungeonWindow = new MyFrame();
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
            prepareGameFight();
        });

        button2 = new JButton(GameLauncher.dungeonsArray[1].getName());
        button2.setPreferredSize(new Dimension(256, 64));
        button2.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[1];
            prepareGameFight();
        });

        button3 = new JButton(GameLauncher.dungeonsArray[2].getName());
        button3.setPreferredSize(new Dimension(256, 64));
        button3.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[2];
            prepareGameFight();
        });

        panelCENTER.add(button1);
        panelCENTER.add(button2);
        panelCENTER.add(button3);

        gameDungeonWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    private void prepareGameFight() {
        randomMonster();
        layers = (int) ((Math.random() * (chooseDungeon.getHighLevel() - chooseDungeon.getLowLevel())) + chooseDungeon.getLowLevel());
        counter = 1;
        gameDungeonWindow.dispose();

        gameFight();

    }

    public void randomDungeons() {
        List<Dungeons> list = Arrays.asList(GameLauncher.dungeonsArray);
        Collections.shuffle(list);
        list.toArray(GameLauncher.dungeonsArray);

    }

    public void gameFight() {
        if (counter == layers) {
            gameDungeonSelection();
            System.out.println("Dungeon: " + chooseDungeon.getName() + " Counter: " + counter + " Layers: " + layers);

        } else {
            System.out.println("Dungeon: " + chooseDungeon.getName() + " Counter: " + counter + " Layers: " + layers);
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
                System.out.println(bot.getHealthpoints() + " " + GameLauncher.characterArray[0].getHealthpoints());
                ifBotDead();
            });
            panelCENTER.add(attackButton);

            healButton = new JButton("Heal");
            healButton.setPreferredSize(new Dimension(256, 64));
            healButton.addActionListener(event -> {
                if(GameLauncher.characterArray[0].getHealthpotion() == 0) {
                    System.out.println("no Heal");
                } else {
                    GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() + GameLauncher.characterArray[0].getHealthpotionDealHealth());
                    GameLauncher.characterArray[0].setHealthpotion(GameLauncher.characterArray[0].getHealthpotion() - 1);
                    System.out.println(bot.getHealthpoints() + " " + GameLauncher.characterArray[0].getHealthpoints() + " " + GameLauncher.characterArray[0].getHealthpotion());
                    ifBotDead();
                }
            });
            panelCENTER.add(healButton);

            inventoryButton = new JButton("Inventory");
            inventoryButton.setPreferredSize(new Dimension(256, 64));
            panelCENTER.add(inventoryButton);

            equipButton = new JButton("Equipment");
            equipButton.setPreferredSize(new Dimension(256, 64));
            panelCENTER.add(equipButton);

            gameFightWindow.add(panelCENTER, BorderLayout.CENTER);
        }
    }

    public void randomMonster() {
        List<Monster> list = Arrays.asList(GameLauncher.monsterArray);
        Collections.shuffle(list);
        list.toArray(GameLauncher.monsterArray);

        if (GameLauncher.monsterArray[0].getType().equals(chooseDungeon.getType())) {
            bot = new Monster(GameLauncher.monsterArray[0].getName(), GameLauncher.monsterArray[0].getHealthpoints(), GameLauncher.monsterArray[0].getStaminapoints(), GameLauncher.monsterArray[0].getSchaden(), GameLauncher.monsterArray[0].getType(), GameLauncher.monsterArray[0].isWeapon(), GameLauncher.monsterArray[0].isWeapondrop());
        } else {
            randomMonster();
        }
    }

    public void ifBotDead() {
        if (bot.getHealthpoints() <= 0) {
            gameFightWindow.dispose();
            randomMonster();
            counter++;
            gameFight();
        } else {
            botTurn();
        }
    }

    public void botTurn() {
        int botAttack = (int) (Math.random() * 100) + 1;
        System.out.println(botAttack);

        if (botAttack >= 97) {
            //lifeSteal

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getSchaden() * 2));
            bot.setHealthpoints((int) (bot.getSchaden() * 1.5));
            ifPlayerDead();
        } else if (botAttack >= 90) {
            //critical

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getSchaden() * 2));
            ifPlayerDead();
        } else if (botAttack >= 50) {
            //missed attack

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (int) (bot.getSchaden() * 0.5));
            ifPlayerDead();
        } else {
            //normal attack

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - bot.getSchaden());
            ifPlayerDead();
        }
    }

    public void ifPlayerDead() {
        if (GameLauncher.characterArray[0].getHealthpoints() <= 0) {
            System.out.println("Dead");
            gameFightWindow.dispose();
            System.exit(1);
        }
    }
}