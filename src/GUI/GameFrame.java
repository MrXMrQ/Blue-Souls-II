package GUI;

import Dungeons.Dungeons;
import Figures.Monster;
import Launcher.GameLauncher;
import PlayerInventorys.Inventory;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameFrame extends Thread {
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
    JPanel panelSOUTH;
    JPanel holder;

    //Layouts
    FlowLayout flowLayout;

    //Windows
    MyFrame gameFightWindow;
    MyFrame gameDungeonWindow;

    //Progressbar
    public static JProgressBar progressBarHealth;

    //Other stuff
    Monster bot;
    Dungeons chooseDungeon;
    int layers;
    int counter;
    JTextArea textAreaFight;
    JScrollPane textAreaFightPane;
    String playerName = GameLauncher.characterArray[0].getName();
    Thread gameFightThread;

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
        counter = 0;
        gameDungeonWindow.dispose();

        progressBarHealth = new JProgressBar();
        progressBarHealth.setPreferredSize(new Dimension(600, 25));
        progressBarHealth.setMaximum(GameLauncher.characterArray[0].getMaxHealth());
        progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
        progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
        progressBarHealth.setStringPainted(true);
        progressBarHealth.setBackground(Color.BLACK);
        progressBarHealth.setForeground(Color.BLUE);
        progressBarHealth.setBorderPainted(false);


        //gameFight();
        gameFightWindow = new MyFrame();
        gameFightThread = new Thread(this::gameFight);
        gameFightThread.start();

    }

    public void randomDungeons() {
        List<Dungeons> list = Arrays.asList(GameLauncher.dungeonsArray);
        Collections.shuffle(list);
        list.toArray(GameLauncher.dungeonsArray);

    }

    public void gameFight() {
        if (counter == layers) {
            gameFightWindow.dispose();
            gameDungeonSelection();
            textAreaFight.append("Dungeon: " + chooseDungeon.getName() + " Counter: " + counter + " Layers: " + layers + "\n");

        } else {

            gameFightWindow.setLayout(new BorderLayout());


            panelNORTH = new JPanel();
            panelNORTH.setLayout(flowLayout);

            textAreaFight = new JTextArea(15, 20);
            textAreaFight.setEditable(false);
            textAreaFight.setLineWrap(true);
            textAreaFight.setWrapStyleWord(true);
            textAreaFight.setFont(new Font("Inter", Font.PLAIN, 15));
            textAreaFightPane = new JScrollPane(textAreaFight);

            holder = new JPanel();
            holder.setPreferredSize(new Dimension(260, 256));
            holder.setOpaque(true);
            holder.add(textAreaFightPane);

            panelNORTH.add(holder);

            textAreaFight.append("Dungeon: " + chooseDungeon.getName() + " Layers: " + layers + "\nOn Layer: " + counter + "\n\n");

            monster = new LabelWithIcons();
            monster.setText(bot.getName());
            panelNORTH.add(monster);

            gameFightWindow.add(panelNORTH, BorderLayout.NORTH);


            panelCENTER.removeAll();
            panelCENTER.setLayout(flowLayout);

            attackButton = new JButton("Attack");
            attackButton.setPreferredSize(new Dimension(256, 64));
            attackButton.addActionListener(e -> {
                int playerAttack = (int) (Math.random() * 100) + 1;
                if (playerAttack >= 90) {
                    bot.setHealthpoints(bot.getHealthpoints() - GameLauncher.characterArray[0].getDamage() * 2);
                    textAreaFight.append(playerName + " Crit damage: " + GameLauncher.characterArray[0].getDamage() * 2 + "\n");

                } else {
                    bot.setHealthpoints(bot.getHealthpoints() - GameLauncher.characterArray[0].getDamage());
                    textAreaFight.append(playerName + " damage: " + GameLauncher.characterArray[0].getDamage() + "\n");

                }
                ifBotDead();

            });
            panelCENTER.add(attackButton);

            healButton = new JButton("Heal: " + GameLauncher.characterArray[0].getHealthpotion());
            healButton.setPreferredSize(new Dimension(256, 64));
            healButton.addActionListener(event -> {
                if (GameLauncher.characterArray[0].getHealthpotion() == 0) {
                    textAreaFight.append("no heal potion\n\n");
                } else if (GameLauncher.characterArray[0].getHealthpoints() + GameLauncher.characterArray[0].getHealthpotionDealHealth() > GameLauncher.characterArray[0].getMaxHealth()) {
                    textAreaFight.append("You cant over heal\n\n");
                } else {
                    GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() + GameLauncher.characterArray[0].getHealthpotionDealHealth());
                    GameLauncher.characterArray[0].setHealthpotion(GameLauncher.characterArray[0].getHealthpotion() - 1);
                    textAreaFight.append(playerName + " healthpotion: " + GameLauncher.characterArray[0].getHealthpotion() + " healing: " + GameLauncher.characterArray[0].getHealthpotionDealHealth() + "\n");
                    healButton.setText("Heal: " + GameLauncher.characterArray[0].getHealthpotion());
                    ifBotDead();
                }
            });
            panelCENTER.add(healButton);

            inventoryButton = new JButton("Inventory");
            inventoryButton.setPreferredSize(new Dimension(256, 64));
            inventoryButton.addActionListener(event -> new Inventory());
            panelCENTER.add(inventoryButton);

            equipButton = new JButton("Equipment");
            equipButton.setPreferredSize(new Dimension(256, 64));
            panelCENTER.add(equipButton);

            gameFightWindow.add(panelCENTER, BorderLayout.CENTER);

            panelSOUTH = new JPanel(new FlowLayout());
            panelSOUTH.add(progressBarHealth);

            gameFightWindow.add(panelSOUTH, BorderLayout.SOUTH);

            //playerHealthBar();
        }
    }

    public void randomMonster() {
        List<Monster> list = Arrays.asList(GameLauncher.monsterArray);
        Collections.shuffle(list);
        list.toArray(GameLauncher.monsterArray);

        if (GameLauncher.monsterArray[0].getType().equals(chooseDungeon.getType())) {
            bot = new Monster(GameLauncher.monsterArray[0].getName(), GameLauncher.monsterArray[0].getHealthpoints(), GameLauncher.monsterArray[0].getStaminapoints(), GameLauncher.monsterArray[0].getSchaden(), GameLauncher.monsterArray[0].getType(), GameLauncher.monsterArray[0].isWeapon(), GameLauncher.monsterArray[0].isWeapondrop(), GameLauncher.monsterArray[0].getSouls());
        } else {
            randomMonster();
        }
    }

    public void ifBotDead() {
        if (bot.getHealthpoints() <= 0) {
            GameLauncher.characterArray[0].setSouls(GameLauncher.characterArray[0].getSouls() + bot.getSouls());
            int randomGetHeal = (int) (Math.random() * 100) + 1;

            if (randomGetHeal >= 99) {
                GameLauncher.characterArray[0].setHealthpotion(GameLauncher.characterArray[0].getHealthpotion() + 2);

            }

            gameFightWindow.getContentPane().removeAll();
            gameFightWindow.repaint();
            gameFightWindow.setSize(781, 480);
            gameFightWindow.setSize(780, 480);
            randomMonster();
            counter++;
            gameFight();

        } else {
            botTurn();

        }
    }

    public void botTurn() {
        int botAttack = (int) (Math.random() * 100) + 1;


        if (botAttack >= 97) {
            //lifeSteal

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getSchaden() * 2));
            bot.setHealthpoints((int) (bot.getSchaden() * 1.5));
            textAreaFight.append(bot.getName() + " life steal attack: " + bot.getSchaden() * 2 + "\n");
            progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
            progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
            ifPlayerDead();

        } else if (botAttack >= 90) {
            //critical

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getSchaden() * 2));
            textAreaFight.append(bot.getName() + " crit attack: " + bot.getSchaden() * 2 + "\n");
            progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
            progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
            ifPlayerDead();

        } else if (botAttack >= 50) {
            //missed attack

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (int) (bot.getSchaden() * 0.5));
            textAreaFight.append(bot.getName() + " missed attack: " + (int) (bot.getSchaden() * 0.5) + "\n");
            progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
            progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
            ifPlayerDead();

        } else {
            //normal attack

            GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - bot.getSchaden());
            textAreaFight.append(bot.getName() + " attack: " + bot.getSchaden() + "\n");
            progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
            progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
            ifPlayerDead();

        }
    }

    public void ifPlayerDead() {
        if (GameLauncher.characterArray[0].getHealthpoints() <= 0) {
            gameFightWindow.dispose();
            System.exit(1);
        }

        textAreaFight.append(playerName + " Health: " + GameLauncher.characterArray[0].getHealthpoints() + "\n" + bot.getName() + " Health: " + bot.getHealthpoints() + "\n\n");
    }
}