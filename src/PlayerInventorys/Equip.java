package PlayerInventorys;

import GUI.GameFrame;
import GUI.LabelWithIcons;
import GUI.MainMenuAndChaSubmitFrames;
import GUI.MyFrame;
import Items.*;
import Launcher.GameLauncher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Equip {
    //Frames
    public static MyFrame equipWindow;

    //Panels
    JPanel panelNORTH;
    JPanel panelWEAST;
    JPanel panelWEAST_WEST;
    JPanel panelEAST;
    JPanel panelCENTER;
    JPanel panelCENTER_WEST;
    JPanel panelCENTER_CENTER;
    JPanel panelSOUTH;

    //Buttons
    JButton backButton;
    JButton removeButton;
    JButton equipButton;
    JButton useButton;

    //Labels
    LabelWithIcons playerIcon;
    public static LabelWithItemIcons weaponLabel;
    JLabel headlineButtons;
    JLabel headlineRings;
    JLabel headlineForInventory;
    LabelWithItemIcons itemLabel;
    LabelWithItemIcons[] labelWithItemIconsArray;

    //Other
    public static Thread equipThread;
    public static Thread mouseThread;
    int itemCounter = 0;
    int index = 0;
    public static ArrayList<Item> allPlayerItems = new ArrayList<>();
    ArrayList<LabelWithItemIcons> labelListe;
    int currentElement;
    int currentRing;
    public static boolean isWeaponEquipped;
    public static Weapon tempWeapon;


    public Equip() {
        equipThread = new Thread(this::equipFrame);
        equipThread.start();
        mouseThread = new Thread();
    }

    public void equipFrame() {
        equipWindow = new MyFrame();
        equipWindow.setLayout(new BorderLayout());
        equipWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        equipWindow.setTitle("Equipment");

        //East side
        panelEAST = new JPanel(new GridLayout(GameLauncher.characterArray[0].getRingslots() + 1, 1));
        panelEAST.setBorder(new LineBorder(Color.BLACK));

        labelWithItemIconsArray = new LabelWithItemIcons[GameLauncher.characterArray[0].getRingslots()];

        headlineRings = new JLabel("RINGS", SwingConstants.CENTER);
        headlineRings.setFont(new Font("Inter", Font.BOLD, 38));
        panelEAST.add(headlineRings);

        for (int i = 0; i < GameLauncher.characterArray[0].getRingslots(); i++) {
            LabelWithItemIcons labelWithItemIcons = new LabelWithItemIcons();
            JPanel panel = new JPanel(new FlowLayout());
            labelWithItemIconsArray[i] = labelWithItemIcons;
            labelWithItemIcons.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    for (LabelWithItemIcons withItemIcons : labelWithItemIconsArray)
                        withItemIcons.setBackground(Color.GRAY);

                    for (int j = 0; j < labelWithItemIconsArray.length; j++) {
                        if (e.getSource() == labelWithItemIconsArray[j]) {
                            labelWithItemIconsArray[j].setBackground(Color.RED);
                            currentRing = j;
                        }
                    }
                }
            });

            panel.add(labelWithItemIconsArray[i]);
            panelEAST.add(panel);
        }

        equipWindow.add(panelEAST, BorderLayout.EAST);

        //North side
        panelNORTH = new JPanel();

        headlineForInventory = new JLabel("EQUIP INVENTORY", SwingConstants.CENTER);
        headlineForInventory.setFont(new Font("Inter", Font.BOLD, 45));
        panelNORTH.add(headlineForInventory);

        equipWindow.add(panelNORTH, BorderLayout.NORTH);

        //West side
        panelWEAST = new JPanel(new BorderLayout());

        playerIcon = new LabelWithIcons();
        String playerName = GameLauncher.characterArray[0].getChaClass();

        switch (playerName) {
            case "Knight" -> playerIcon.setIcon(MainMenuAndChaSubmitFrames.knight);
            case "Warrior" -> playerIcon.setIcon(MainMenuAndChaSubmitFrames.warrior);
            case "Wizard" -> playerIcon.setIcon(MainMenuAndChaSubmitFrames.wizard);
            case "Confessor" -> playerIcon.setIcon(MainMenuAndChaSubmitFrames.confessor);
        }

        panelWEAST.add(playerIcon, BorderLayout.NORTH);

        panelWEAST_WEST = new JPanel(new GridLayout(4, 1));
        panelWEAST_WEST.setBorder(new LineBorder(Color.BLACK));

        headlineButtons = new JLabel("EQUIP INVENTORY");
        headlineButtons.setFont(new Font("Inter", Font.BOLD, 28));
        panelWEAST_WEST.add(headlineButtons);

        JPanel buttonPanel1 = new JPanel(new FlowLayout());
        removeButton = new JButton("Remove");
        removeButton.addActionListener(event -> {
            if (labelListe.size() > 0 && labelListe.get(currentElement).getBackground() == Color.YELLOW) {
                listManager();
            }
        });
        buttonPanel1.add(removeButton);
        panelWEAST_WEST.add(buttonPanel1);

        JPanel buttonPanel2 = new JPanel(new FlowLayout());
        equipButton = new JButton("Equip");
        equipButton.addActionListener(event -> {
            if (labelListe.size() > 0 && labelListe.get(currentElement).getBackground() == Color.YELLOW) {
                if (allPlayerItems.get(currentElement).getType().equals("weapon") && !isWeaponEquipped) {
                    isWeaponEquipped = true;
                    weaponLabel.setText(allPlayerItems.get(currentElement).getName());
                    SwingUtilities.updateComponentTreeUI(weaponLabel);
                    tempWeapon = new Weapon((allPlayerItems.get(currentElement)).getName(), (allPlayerItems.get(currentElement)).getType(), ((Weapon) (allPlayerItems.get(currentElement))).getDamage(), ((Weapon) (allPlayerItems.get(currentElement))).getDurability());
                    GameLauncher.characterArray[0].setFist(tempWeapon.getDamage());

                    listManager();
                } else if (allPlayerItems.get(currentElement).getType().equals("ring") && labelWithItemIconsArray[currentRing].getBackground() == Color.RED && ringChecker()) {
                    labelWithItemIconsArray[currentRing].setText(allPlayerItems.get(currentElement).getName());
                    switch (((Ring) (allPlayerItems.get(currentElement))).getKind()) {
                        case "heal" -> System.out.println("Heal");
                        case "damage" -> System.out.println("Damage");
                        case "souls" -> System.out.println("souls");
                        case "critDamage" -> System.out.println("critDamage");
                        case "lifeSteal" -> System.out.println("lifeSteal");
                        case "resistant" -> System.out.println("resistant");
                        default -> System.out.println("Default");
                    }

                    listManager();
                }
            }
        });
        buttonPanel2.add(equipButton);
        panelWEAST_WEST.add(buttonPanel2);

        JPanel buttonPanel3 = new JPanel(new FlowLayout());
        useButton = new JButton("Use");
        useButton.addActionListener(event -> {
            if (labelListe.size() > 0 && labelListe.get(currentElement).getBackground() == Color.YELLOW) {
                if (allPlayerItems.get(currentElement).getType().equals("HealUse")) {
                    int healItem = ((UseItems) (allPlayerItems.get(currentElement))).getDealHeal();
                    GameLauncher.characterArray[0].setHealthpoints((GameLauncher.characterArray[0].getHealthpoints() + healItem));

                    GameFrame.progressBarHealth.setValue(GameLauncher.characterArray[0].getHealthpoints());
                    GameFrame.progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
                    GameFrame.progressBarHealth.setStringPainted(true);
                    listManager();


                } else if (allPlayerItems.get(currentElement).getType().equals("DamageUse")) {
                    int damageItem = ((UseItems) (allPlayerItems.get(currentElement))).getDamage();
                    GameFrame.bot.setHealthpoints(GameFrame.bot.getHealthpoints() - damageItem);

                    GameFrame.textAreaFight.append(allPlayerItems.get(currentElement).getName() + "  deal damage: " + damageItem + "\n");
                    GameFrame.textAreaFight.append(GameFrame.bot.getName() + " healthpoints: " + GameFrame.bot.getHealthpoints() + "\n\n");
                    listManager();
                }
            }
        });
        buttonPanel3.add(useButton);
        panelWEAST_WEST.add(buttonPanel3);

        panelWEAST.add(panelWEAST_WEST, BorderLayout.WEST);
        equipWindow.add(panelWEAST, BorderLayout.WEST);

        //Center side
        panelCENTER = new JPanel(new BorderLayout());
        panelCENTER.setBorder(new LineBorder(Color.BLACK));

        panelCENTER_WEST = new JPanel(new FlowLayout());
        panelCENTER_WEST.setBorder(new LineBorder(Color.GRAY));

        weaponLabel = new LabelWithItemIcons();
        panelCENTER_WEST.add(weaponLabel);

        panelCENTER_CENTER = new JPanel(new FlowLayout());

        labelListe = new ArrayList<>();

        panelCENTER.add(panelCENTER_CENTER, BorderLayout.CENTER);
        panelCENTER.add(panelCENTER_WEST, BorderLayout.WEST);
        equipWindow.add(panelCENTER);

        //South side
        panelSOUTH = new JPanel(new FlowLayout());

        backButton = new JButton("CLOSE");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(event -> equipWindow.setVisible(false));
        panelSOUTH.add(backButton);

        equipWindow.add(panelSOUTH, BorderLayout.SOUTH);

        update();
    }

    public void update() {
        while (equipThread.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (allPlayerItems.size() != itemCounter) {
                itemLabel = new LabelWithItemIcons();
                itemLabel.setText(allPlayerItems.get(index).getName());
                labelListe.add(itemLabel);

                itemLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        for (int i = 0; i < labelListe.size(); i++) {
                            labelListe.get(i).setBackground(Color.GRAY);
                        }

                        for (int i = 0; i < labelListe.size(); i++) {
                            if (e.getSource() == labelListe.get(i)) {
                                labelListe.get(i).setBackground(Color.YELLOW);
                                currentElement = i;
                            }
                        }
                    }
                });

                panelCENTER_CENTER.add(labelListe.get(index));
                SwingUtilities.updateComponentTreeUI(panelCENTER_CENTER);

                itemCounter++;
                index++;
            }
        }
    }

    public void listManager() {
        itemCounter--;
        allPlayerItems.remove(currentElement);
        panelCENTER_CENTER.remove(labelListe.get(currentElement));
        labelListe.remove(currentElement);
        SwingUtilities.updateComponentTreeUI(panelCENTER_CENTER);
        index--;
    }

    public boolean ringChecker() {
        for (LabelWithItemIcons labelWithItemIcons : labelWithItemIconsArray) {
            if (labelWithItemIcons.getText().equals(allPlayerItems.get(currentElement).getName())) {
                return false;
            }
        }
        return true;
    }


}