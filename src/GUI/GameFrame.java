package GUI;

import Dungeons.Dungeons;
import Figures.Monster;
import Items.Weapon;
import Launcher.GameLauncher;
import Launcher.ItemLauncher;
import PlayerInventorys.Equip;
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

    //Progressbar
    public static JProgressBar progressBarHealth;

    //Other stuff
    Monster bot;
    Dungeons chooseDungeon;
    int layers;
    int counter;
    int index = 0;
    JTextArea textAreaFight;
    JScrollPane textAreaFightPane;
    String playerName = GameLauncher.characterArray[0].getName();
    Thread gameFightThread;

    public GameFrame() {
        gameDungeonSelection();
    }

    public void gameDungeonSelection() {
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

        MainMenuAndChaSubmitFrames.mainWindow.add(panelNORTH, BorderLayout.NORTH);


        panelCENTER = new JPanel(flowLayout);

        button1 = new JButton(GameLauncher.dungeonsArray[0].getName());
        button1.setPreferredSize(new Dimension(256, 64));
        button1.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[0];
            remover();
            prepareGameFight();
        });

        button2 = new JButton(GameLauncher.dungeonsArray[1].getName());
        button2.setPreferredSize(new Dimension(256, 64));
        button2.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[1];
            remover();
            prepareGameFight();
        });

        button3 = new JButton(GameLauncher.dungeonsArray[2].getName());
        button3.setPreferredSize(new Dimension(256, 64));
        button3.addActionListener(event -> {
            chooseDungeon = GameLauncher.dungeonsArray[2];
            remover();
            prepareGameFight();
        });

        panelCENTER.add(button1);
        panelCENTER.add(button2);
        panelCENTER.add(button3);

        MainMenuAndChaSubmitFrames.mainWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    private void prepareGameFight() {
        randomMonster();
        layers = (int) ((Math.random() * (chooseDungeon.getHighLevel() - chooseDungeon.getLowLevel())) + chooseDungeon.getLowLevel());
        counter = 0;

        progressBarHealth = new JProgressBar();
        progressBarHealth.setPreferredSize(new Dimension(600, 25));
        progressBarHealth.setMaximum(GameLauncher.characterArray[0].getMaxHealth());
        progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
        progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
        progressBarHealth.setStringPainted(true);
        progressBarHealth.setBackground(Color.BLACK);
        progressBarHealth.setForeground(Color.BLUE);
        progressBarHealth.setBorderPainted(false);


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
            gameDungeonSelection();
            textAreaFight.append("Dungeon: " + chooseDungeon.getName() + " Counter: " + counter + " Layers: " + layers + "\n");

        } else {
            panelNORTH = new JPanel();
            panelNORTH.setLayout(flowLayout);

            textAreaFight = new JTextArea(15, 20);
            textAreaFight.setEditable(false);
            textAreaFight.setLineWrap(false);
            textAreaFight.setWrapStyleWord(true);
            textAreaFight.setFont(new Font("Inter", Font.PLAIN, 15));

            textAreaFightPane = new JScrollPane(textAreaFight);
            textAreaFightPane.setAutoscrolls(true);

            holder = new JPanel();
            holder.setPreferredSize(new Dimension(260, 256));
            holder.setOpaque(true);
            holder.add(textAreaFightPane);

            panelNORTH.add(holder);

            textAreaFight.append("Dungeon: " + chooseDungeon.getName() + " Layers: " + layers + "\nOn Layer: " + counter + "\n\n");

            monster = new LabelWithIcons();
            monster.setText(bot.getName());
            panelNORTH.add(monster);

            if (bot.getWeapon() != null) {
                monster.setText(bot.getName() + " " + bot.getWeapon().getDamage());
            }

            MainMenuAndChaSubmitFrames.mainWindow.add(panelNORTH, BorderLayout.NORTH);


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
            inventoryButton.addActionListener(event -> {
                if (Inventory.inventoryThread == null || !Inventory.inventoryThread.isAlive()) {
                    new Inventory();
                } else {
                    Inventory.invWindow.toFront();
                }
            });
            panelCENTER.add(inventoryButton);

            equipButton = new JButton("Equipment");
            equipButton.setPreferredSize(new Dimension(256, 64));
            equipButton.addActionListener(event -> {
                if (Equip.equipThread == null || !Equip.equipThread.isAlive()) {
                    new Equip();
                } else {
                    Equip.equipWindow.toFront();
                }
            });
            panelCENTER.add(equipButton);

            MainMenuAndChaSubmitFrames.mainWindow.add(panelCENTER, BorderLayout.CENTER);

            panelSOUTH = new JPanel(new FlowLayout());
            panelSOUTH.add(progressBarHealth);

            MainMenuAndChaSubmitFrames.mainWindow.add(panelSOUTH, BorderLayout.SOUTH);

            SwingUtilities.updateComponentTreeUI(MainMenuAndChaSubmitFrames.mainWindow);
        }
    }

    public void randomMonster() {
        List<Monster> randomBotList = Arrays.asList(GameLauncher.monsterArray);
        Collections.shuffle(randomBotList);
        randomBotList.toArray(GameLauncher.monsterArray);

        if (GameLauncher.monsterArray[0].getType().equals(chooseDungeon.getType())) {
            bot = new Monster(GameLauncher.monsterArray[0].getName(), GameLauncher.monsterArray[0].getHealthpoints(), GameLauncher.monsterArray[0].getStaminapoints(), GameLauncher.monsterArray[0].getDamage(), GameLauncher.monsterArray[0].getType(), GameLauncher.monsterArray[0].isItemDrop(), GameLauncher.monsterArray[0].getSouls(), GameLauncher.monsterArray[0].getWeapon());
        } else {
            randomMonster();
        }

        if (bot.isItemDrop()) {
            int weaponForBot = (int) (Math.random() * 100) + 1;

            if (weaponForBot >= 70) {
                List<Weapon> randomWeaponList = Arrays.asList(ItemLauncher.weaponsArray);
                Collections.shuffle(randomWeaponList);
                randomWeaponList.toArray(ItemLauncher.weaponsArray);
                bot.setWeapon(ItemLauncher.weaponsArray[0]);
            }
        }
    }

    public void ifBotDead() {
        if (bot.getHealthpoints() <= 0) {
            int randomForHeal = (int) (Math.random() * 100) + 1;
            int randomForWeapon = (int) (Math.random() * 100) + 1;
            int randomForItem = (int) (Math.random() * 100) + 1;

            if (randomForHeal >= 99) {  //1%
                GameLauncher.characterArray[0].setHealthpotion(GameLauncher.characterArray[0].getHealthpotion() + 2);

            }

            if (bot.getWeapon() != null && randomForWeapon >= 0) { //100%
                ItemLauncher.allPlayerItems.add(bot.getWeapon());
                index += 1;

            }

            if (bot.isItemDrop() && randomForItem >= 0) { //100%
                List<Object> randomItem = Arrays.asList(ItemLauncher.allItems);
                Collections.shuffle(randomItem);
                randomItem.toArray(ItemLauncher.allItems);

                Object[] temp = new Object[]{ItemLauncher.allItems[0]};

                List<Object> randomItem_Item = Arrays.asList(temp);
                Collections.shuffle(randomItem_Item);
                randomItem_Item.toArray(temp);

                ItemLauncher.allPlayerItems.add(temp[0]);
                index += 1;

            }

            GameLauncher.characterArray[0].setSouls(GameLauncher.characterArray[0].getSouls() + bot.getSouls());
            textAreaFight.append("Bot dead");
            remover();
            randomMonster();
            counter++;
            gameFight();

        } else {
            botTurn();

        }
    }

    public void botTurn() {
        int botAttack = (int) (Math.random() * 100) + 1;

        if (bot.getWeapon() != null) {
            if (botAttack >= 97) {
                //lifeSteal

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - ((bot.getDamage() * 2) + (bot.getWeapon().getDamage() * 2)));
                bot.setHealthpoints((int) ((bot.getDamage() * 1.5) + bot.getWeapon().getDamage() * 1.5));
                textAreaFight.append(bot.getName() + " life steal attack: " + bot.getDamage() * 2 + " bonus damage: " + ItemLauncher.weaponsArray[0].getDamage() * 2 + "\n");


            } else if (botAttack >= 90) {
                //critical

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - ((bot.getDamage() * 2) + (bot.getWeapon().getDamage() * 2)));
                textAreaFight.append(bot.getName() + " crit attack: " + bot.getDamage() * 2 + " bonus damage: " + ItemLauncher.weaponsArray[0].getDamage() * 2 + "\n");


            } else if (botAttack >= 50) {
                //missed attack

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (int) ((bot.getDamage() * 0.5) + (bot.getWeapon().getDamage() * 0.5)));
                textAreaFight.append(bot.getName() + " missed attack: " + (int) (bot.getDamage() * 0.5) + " bonus damage: " + (int) (ItemLauncher.weaponsArray[0].getDamage() * 0.5) + "\n");


            } else {
                //normal attack

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getDamage() + bot.getWeapon().getDamage()));
                textAreaFight.append(bot.getName() + " attack: " + bot.getDamage() + " bonus damage: " + ItemLauncher.weaponsArray[0].getDamage() + "\n");


            }
        } else {
            if (botAttack >= 97) {
                //lifeSteal

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getDamage() * 2));
                bot.setHealthpoints((int) (bot.getDamage() * 1.5));
                textAreaFight.append(bot.getName() + " life steal attack: " + bot.getDamage() * 2 + "\n");

            } else if (botAttack >= 90) {
                //critical

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (bot.getDamage() * 2));
                textAreaFight.append(bot.getName() + " crit attack: " + bot.getDamage() * 2 + "\n");


            } else if (botAttack >= 50) {
                //missed attack

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - (int) (bot.getDamage() * 0.5));
                textAreaFight.append(bot.getName() + " missed attack: " + (int) (bot.getDamage() * 0.5) + "\n");


            } else {
                //normal attack

                GameLauncher.characterArray[0].setHealthpoints(GameLauncher.characterArray[0].getHealthpoints() - bot.getDamage());
                textAreaFight.append(bot.getName() + " attack: " + bot.getDamage() + "\n");


            }
        }
        progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
        progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
        ifPlayerDead();

    }

    public void ifPlayerDead() {
        if (GameLauncher.characterArray[0].getHealthpoints() <= 0) {
            MainMenuAndChaSubmitFrames.mainWindow.dispose();
            System.exit(1);
        }

        textAreaFight.append(playerName + " Health: " + GameLauncher.characterArray[0].getHealthpoints() + "\n" + bot.getName() + " Health: " + bot.getHealthpoints() + "\n\n");
    }

    public void remover() {
        MainMenuAndChaSubmitFrames.mainWindow.getContentPane().removeAll();
        MainMenuAndChaSubmitFrames.mainWindow.repaint();
        SwingUtilities.updateComponentTreeUI(MainMenuAndChaSubmitFrames.mainWindow);
    }
}