package PlayerInventorys;

import GUI.GameFrame;
import GUI.LabelWithIcons;
import GUI.MainMenuAndChaSubmitFrames;
import GUI.MyFrame;
import Launcher.GameLauncher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Objects;

import static javax.swing.SwingConstants.*;

public class Inventory {
    //Frames
    public static MyFrame invWindow;

    //Panels
    JPanel panelSOUTH;
    JPanel panelEAST;
    JPanel pan1;
    JPanel pan2;
    JPanel pan3;
    JPanel panelONEAST_EAST;
    JPanel panelONEAST_WEST;
    JPanel buttonPanel1;
    JPanel buttonPanel2;
    JPanel buttonPanel3;
    JPanel panelWEST;
    JPanel panelWEST_CENTER;

    //Buttons
    JButton backButton;
    JButton levelUPHealthButton;
    JButton levelUPStaminaButton;
    JButton LevelUPDamageButton;


    //Labels
    JLabel labelONEAST_NORTH;
    JLabel labelHealth;
    JLabel labelStamina;
    JLabel labelDamage;
    JLabel levelingHeadline;
    JLabel level;
    JLabel souls;
    JLabel availableLevels;

    //Other
    LabelWithIcons playerIcon;
    int actuallyLevel = 0;
    public static Thread inventoryThread;
    int cost = 10;
    int maxHealth = 200;
    int maxStamina = 20;
    int damageMultiplier = 10;
    int availableLevel = 0;

    public Inventory() {
        inventoryThread = new Thread(this::inventoryWindow);
        inventoryThread.start();

    }

    public void inventoryWindow() {
        invWindow = new MyFrame();
        invWindow.setTitle("Inventory");
        invWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        invWindow.setLayout(new BorderLayout());

        panelSOUTH = new JPanel(new FlowLayout());

        backButton = new JButton("CLOSE");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(event -> {
            invWindow.dispose();
            //noinspection deprecation
            inventoryThread.stop();
        });
        panelSOUTH.add(backButton);

        invWindow.add(panelSOUTH, BorderLayout.SOUTH);


        panelEAST = new JPanel(new BorderLayout());
        panelEAST.setBorder(new LineBorder(Color.BLACK));

        labelONEAST_NORTH = new JLabel("STATS", CENTER);
        labelONEAST_NORTH.setFont(new Font("Inter", Font.BOLD, 50));
        panelEAST.add(labelONEAST_NORTH, BorderLayout.NORTH);


        panelONEAST_WEST = new JPanel(new GridLayout(3, 1));

        pan1 = new JPanel(new FlowLayout());
        labelHealth = new JLabel("Healthpoints: " + GameLauncher.characterArray[0].getMaxHealth());
        labelHealth.setFont(new Font("Inter", Font.PLAIN, 15));
        pan1.add(labelHealth);
        panelONEAST_WEST.add(pan1);

        pan2 = new JPanel(new FlowLayout());
        labelStamina = new JLabel("Staminapoints: " + GameLauncher.characterArray[0].getMaxStamina());
        labelStamina.setFont(new Font("Inter", Font.PLAIN, 15));
        pan2.add(labelStamina);
        panelONEAST_WEST.add(pan2);

        pan3 = new JPanel(new FlowLayout());
        labelDamage = new JLabel("Damage: " + GameLauncher.characterArray[0].getDamage());
        labelDamage.setFont(new Font("Inter", Font.PLAIN, 15));
        pan3.add(labelDamage);
        panelONEAST_WEST.add(pan3);

        panelEAST.add(panelONEAST_WEST, BorderLayout.WEST);


        panelONEAST_EAST = new JPanel(new GridLayout(3, 1));
        panelONEAST_EAST.setPreferredSize(new Dimension(100, 0));

        buttonPanel1 = new JPanel(new FlowLayout());
        levelUPHealthButton = new JButton("Level Up");
        levelUPHealthButton.setPreferredSize(new Dimension(100, 25));
        levelUPHealthButton.addActionListener(event -> {
            if (availableLevel > 0) {
                GameLauncher.characterArray[0].setMaxHealth(GameLauncher.characterArray[0].getMaxHealth() + maxHealth);
                labelHealth.repaint();
                availableLevel = availableLevel - 1;
                availableLevels.setText("Available Levels: " + availableLevel);
                maxHealth *=1.1;
            }
        });
        buttonPanel1.add(levelUPHealthButton);
        panelONEAST_EAST.add(buttonPanel1);

        buttonPanel2 = new JPanel(new FlowLayout());
        levelUPStaminaButton = new JButton("Level Up");
        levelUPStaminaButton.setPreferredSize(new Dimension(100, 25));
        levelUPStaminaButton.addActionListener(event -> {
            if (availableLevel > 0) {
                GameLauncher.characterArray[0].setMaxStamina(GameLauncher.characterArray[0].getMaxStamina() + maxStamina);
                labelStamina.repaint();
                availableLevel = availableLevel - 1;
                availableLevels.setText("Available Levels: " + availableLevel);
                maxStamina *=1.1;
            }
        });
        buttonPanel2.add(levelUPStaminaButton);
        panelONEAST_EAST.add(buttonPanel2);

        buttonPanel3 = new JPanel(new FlowLayout());
        LevelUPDamageButton = new JButton("Level Up");
        LevelUPDamageButton.setPreferredSize(new Dimension(100, 25));
        LevelUPDamageButton.addActionListener(event -> {
            if (availableLevel > 0) {
                GameLauncher.characterArray[0].setDamage(GameLauncher.characterArray[0].getDamage() + damageMultiplier);
                labelDamage.repaint();
                availableLevel = availableLevel - 1;
                availableLevels.setText("Available Levels: " + availableLevel);
                damageMultiplier *=1.5;
            }
        });
        buttonPanel3.add(LevelUPDamageButton);
        panelONEAST_EAST.add(buttonPanel3);


        panelEAST.add(panelONEAST_EAST, BorderLayout.EAST);


        invWindow.add(panelEAST, BorderLayout.EAST);


        panelWEST = new JPanel(new BorderLayout());

        playerIcon = new LabelWithIcons();

        if (Objects.equals(GameLauncher.characterArray[0].getChaClass(), GameLauncher.characterArray[1].getChaClass())) {
            playerIcon.setIcon(MainMenuAndChaSubmitFrames.knight);

        } else if (Objects.equals(GameLauncher.characterArray[0].getChaClass(), GameLauncher.characterArray[2].getChaClass())) {
            playerIcon.setIcon(MainMenuAndChaSubmitFrames.warrior);

        } else if (Objects.equals(GameLauncher.characterArray[0].getChaClass(), GameLauncher.characterArray[3].getChaClass())) {
            playerIcon.setIcon(MainMenuAndChaSubmitFrames.wizard);

        } else if (Objects.equals(GameLauncher.characterArray[0].getChaClass(), GameLauncher.characterArray[4].getChaClass())) {
            playerIcon.setIcon(MainMenuAndChaSubmitFrames.confessor);

        }

        panelWEST.add(playerIcon, BorderLayout.NORTH);

        invWindow.add(panelWEST, BorderLayout.WEST);


        panelWEST_CENTER = new JPanel(new GridLayout(4, 1));
        panelWEST_CENTER.setBorder(new LineBorder(Color.BLACK));

        levelingHeadline = new JLabel("LEVELING", CENTER);
        levelingHeadline.setFont(new Font("Inter", Font.BOLD, 50));
        panelWEST_CENTER.add(levelingHeadline);

        level = new JLabel("Player Level: " + actuallyLevel);
        level.setFont(new Font("Inter", Font.PLAIN, 15));
        panelWEST_CENTER.add(level);

        souls = new JLabel("Souls: " + GameLauncher.characterArray[0].getSouls());
        souls.setFont(new Font("Inter", Font.PLAIN, 15));
        panelWEST_CENTER.add(souls);

        availableLevels = new JLabel("Available Levels: " + availableLevel);
        availableLevels.setFont(new Font("Inter", Font.PLAIN, 15));
        panelWEST_CENTER.add(availableLevels);

        panelWEST.add(panelWEST_CENTER, BorderLayout.CENTER);

        updater();
    }

    public void updater() {
        while (inventoryThread.isAlive()) {
            if (GameLauncher.characterArray[0].getSouls() >= cost) {
                availableLevel = availableLevel + 1;
                GameLauncher.characterArray[0].setSouls(GameLauncher.characterArray[0].getSouls() - cost);
                cost *=1.5;
                availableLevels.setText("Available Levels: " + availableLevel);

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            GameFrame.progressBarHealth.setMaximum(GameLauncher.characterArray[0].getMaxHealth());
            GameFrame.progressBarHealth.setString(GameLauncher.characterArray[0].getHealthpoints() + " / " + GameLauncher.characterArray[0].getMaxHealth());
            souls.setText("Souls: " + GameLauncher.characterArray[0].getSouls());
            labelHealth.setText("Healthpoints: " + GameLauncher.characterArray[0].getMaxHealth());
            labelStamina.setText("Staminapoints: " + GameLauncher.characterArray[0].getMaxStamina());
            labelDamage.setText("Damage: " + GameLauncher.characterArray[0].getDamage());
        }
    }
}