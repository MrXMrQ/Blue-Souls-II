package PlayerInventorys;

import GUI.LabelWithIcons;
import GUI.MainMenuAndChaSubmitFrames;
import GUI.MyFrame;
import Items.LabelWithItemIcons;
import Launcher.GameLauncher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Equip {
    //Frames
    public static MyFrame equipWindow;

    //Panels
    JPanel panelNORTH;
    JPanel panelWEAST;
    JPanel panelWEAST_WEST;
    JPanel panelEAST;
    JPanel panelCENTER;
    JPanel panelSOUTH;

    //Buttons
    JButton backButton;
    JButton removeButton;
    JButton equipButton;
    JButton upgradeInventoryButton;

    //Labels
    LabelWithIcons playerIcon;
    JLabel headlineButtons;
    JLabel headlineRings;
    JLabel headlineForInventory;

    public static Thread equipThread;

    public Equip() {
        equipThread = new Thread(this::equipFrame);
        equipThread.start();
    }

    public void equipFrame() {
        equipWindow = new MyFrame();
        equipWindow.setLayout(new BorderLayout());
        equipWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        equipWindow.setTitle("Equipment");

        //North side
        panelNORTH = new JPanel();

        headlineForInventory = new JLabel("EQUIP INVENTORY", SwingConstants.CENTER);
        headlineForInventory.setFont(new Font("Inter" , Font.BOLD, 45));
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

        panelWEAST_WEST = new JPanel(new GridLayout(4,1));
        panelWEAST_WEST.setBorder(new LineBorder(Color.BLACK));

        headlineButtons = new JLabel("EQUIP INVENTORY");
        headlineButtons.setFont(new Font("Inter" , Font.BOLD, 27));
        panelWEAST_WEST.add(headlineButtons);

        JPanel buttonPanel1 = new JPanel(new FlowLayout());
        removeButton = new JButton("Remove");
        buttonPanel1.add(removeButton);
        panelWEAST_WEST.add(buttonPanel1);

        JPanel buttonPanel2 = new JPanel(new FlowLayout());
        equipButton = new JButton("Equip");
        buttonPanel2.add(equipButton);
        panelWEAST_WEST.add(buttonPanel2);

        JPanel buttonPanel3 = new JPanel(new FlowLayout());
        upgradeInventoryButton = new JButton("Upgrade");
        buttonPanel3.add(upgradeInventoryButton);
        panelWEAST_WEST.add(buttonPanel3);

        panelWEAST.add(panelWEAST_WEST, BorderLayout.WEST);
        equipWindow.add(panelWEAST, BorderLayout.WEST);

        //East side
        panelEAST = new JPanel(new GridLayout(GameLauncher.characterArray[0].getRingslots()+1, 1));
        panelEAST.setBorder(new LineBorder(Color.BLACK));

        LabelWithItemIcons[] labelWithItemIconsArray = new LabelWithItemIcons[GameLauncher.characterArray[0].getRingslots()];

        headlineRings = new JLabel("RINGS", SwingConstants.CENTER);
        headlineRings.setFont(new Font("Inter" , Font.BOLD, 38));
        panelEAST.add(headlineRings);

        for (int i = 0; i < GameLauncher.characterArray[0].getRingslots(); i++) {
            LabelWithItemIcons labelWithItemIcons = new LabelWithItemIcons();
            JPanel panel = new JPanel(new FlowLayout());
            labelWithItemIconsArray[i] = labelWithItemIcons;
            panel.add(labelWithItemIconsArray[i]);
            panelEAST.add(panel);
        }

        equipWindow.add(panelEAST, BorderLayout.EAST);

        //Center side
        panelCENTER = new JPanel(new FlowLayout());

        //South side
        panelSOUTH = new JPanel(new FlowLayout());

        backButton = new JButton("CLOSE");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(event -> {
            equipWindow.dispose();
            //noinspection deprecation
            equipThread.stop();
        });
        panelSOUTH.add(backButton);

        equipWindow.add(panelSOUTH, BorderLayout.SOUTH);
    }
}