package GUI;

import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

import static java.awt.Color.*;

public class GameFrames extends JFrame implements ActionListener {
    MyFrame mainMenuWindow;
    JPanel northPanel;
    JPanel northPanel2;
    JPanel centerPanel;
    JPanel centerPanel2;
    JLabel headline;
    JLabel bodyText;
    JTextField textField;
    JButton submitButton;
    String playerName;

    JPanel southPanel;
    JPanel southPanel2;
    JButton knightSub;
    JButton warriorSub;
    JButton wizardSub;
    JButton confessorSub;
    Boolean knightBoolean = false;
    Boolean warriorBoolean = false;
    Boolean wizardBoolean = false;
    Boolean confessorBoolean = false;
    JButton characterSubmit;
    JPanel knightPicture;
    JPanel warriorPicture;
    JPanel wizardPicture;
    JPanel confessorPicture;
    JTextArea stats;
    JScrollPane statsPane;


    public GameFrames() {
        mainMenuFrame();
    }

    public void mainMenuFrame() {
        mainMenuWindow = new MyFrame();
        Container containerMainMenu = this.getContentPane();


        northPanel = new JPanel(new FlowLayout());
        northPanel2 = new JPanel(new BorderLayout());
        northPanel.add(northPanel2);

        centerPanel = new JPanel(new FlowLayout());
        centerPanel2 = new JPanel(new BorderLayout());
        centerPanel.add(centerPanel2);

        southPanel = new JPanel(new FlowLayout());
        southPanel2 = new JPanel(new FlowLayout());
        southPanel.add(southPanel2);


        headline = new JLabel(" BLUE SOULS II ", SwingConstants.CENTER);
        headline.setFont(new Font("Inter", Font.BOLD, 60));
        northPanel2.add(headline, BorderLayout.NORTH);

        bodyText = new JLabel(" Please enter your name", SwingConstants.CENTER);
        bodyText.setFont(new Font("Inter", Font.BOLD, 30));
        northPanel2.add(bodyText, BorderLayout.CENTER);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(30, 20));
        centerPanel2.add(textField, BorderLayout.CENTER);

        submitButton = new JButton("submit");
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.addActionListener(this);
        centerPanel2.add(submitButton, BorderLayout.SOUTH);


        containerMainMenu.add(northPanel, BorderLayout.NORTH);
        containerMainMenu.add(centerPanel, BorderLayout.CENTER);
        mainMenuWindow.add(containerMainMenu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (textField.getText().equals("")) {
            System.out.println("Pleas try again");
        } else {
            playerName = textField.getText();
            mainMenuWindow.dispose();
            panelRemover();
            characterSelectionFrame();

        }
    }

    public void characterSelectionFrame() {
        MyFrame characterSelectionWindow = new MyFrame();
        characterSelectionWindow.setResizable(false);
        Container containerChaSelection = this.getContentPane();
        northPanel.add(northPanel2);
        northPanel.setBackground(YELLOW);
        centerPanel.add(centerPanel2);
        southPanel.add(southPanel2);
        centerPanel2.setLayout(new FlowLayout());


        knightSub = new JButton(GameLauncher.characterArray[1].getName());
        knightSub.setPreferredSize(new Dimension(200, 50));
        knightSub.addActionListener(event -> {
            stats.append("\n\nName: " + GameLauncher.characterArray[1].getName() + "\nHealthpoints: " + GameLauncher.characterArray[1].getHealthpoints() + "\nStaminapoints: " + GameLauncher.characterArray[1].getStaminapoints() + "\nDamage: " + GameLauncher.characterArray[1].getDamage() + "\nRingslots: " + GameLauncher.characterArray[1].getRingslots() + "\nHealthpotion: " + GameLauncher.characterArray[1].getRingslots() + "\nFist: " + GameLauncher.characterArray[1].getFist());
            knightBoolean = true;
            warriorBoolean = false;
            wizardBoolean = false;
            confessorBoolean = false;
        });
        southPanel2.add(knightSub, BorderLayout.SOUTH);

        warriorSub = new JButton(GameLauncher.characterArray[2].getName());
        warriorSub.setPreferredSize(new Dimension(200, 50));
        warriorSub.addActionListener(event -> {
            stats.append("\n\nName: " + GameLauncher.characterArray[2].getName() + "\nHealthpoints: " + GameLauncher.characterArray[2].getHealthpoints() + "\nStaminapoints: " + GameLauncher.characterArray[2].getStaminapoints() + "\nDamage: " + GameLauncher.characterArray[2].getDamage() + "\nRingslots: " + GameLauncher.characterArray[2].getRingslots() + "\nHealthpotion: " + GameLauncher.characterArray[2].getRingslots() + "\nFist: " + GameLauncher.characterArray[2].getFist());
            knightBoolean = false;
            warriorBoolean = true;
            wizardBoolean = false;
            confessorBoolean = false;
        });
        southPanel2.add(warriorSub, BorderLayout.SOUTH);

        wizardSub = new JButton(GameLauncher.characterArray[3].getName());
        wizardSub.setPreferredSize(new Dimension(200, 50));
        wizardSub.addActionListener(event -> {
            stats.append("\n\nName: " + GameLauncher.characterArray[3].getName() + "\nHealthpoints: " + GameLauncher.characterArray[3].getHealthpoints() + "\nStaminapoints: " + GameLauncher.characterArray[3].getStaminapoints() + "\nDamage: " + GameLauncher.characterArray[3].getDamage() + "\nRingslots: " + GameLauncher.characterArray[3].getRingslots() + "\nHealthpotion: " + GameLauncher.characterArray[3].getRingslots() + "\nFist: " + GameLauncher.characterArray[3].getFist());
            knightBoolean = false;
            warriorBoolean = false;
            wizardBoolean = true;
            confessorBoolean = false;
        });
        southPanel2.add(wizardSub, BorderLayout.SOUTH);

        confessorSub = new JButton(GameLauncher.characterArray[4].getName());
        confessorSub.setPreferredSize(new Dimension(200, 50));
        confessorSub.addActionListener(event -> {
            stats.append("\n\nName: " + GameLauncher.characterArray[4].getName() + "\nHealthpoints: " + GameLauncher.characterArray[4].getHealthpoints() + "\nStaminapoints: " + GameLauncher.characterArray[4].getStaminapoints() + "\nDamage: " + GameLauncher.characterArray[4].getDamage() + "\nRingslots: " + GameLauncher.characterArray[4].getRingslots() + "\nHealthpotion: " + GameLauncher.characterArray[4].getRingslots() + "\nFist: " + GameLauncher.characterArray[4].getFist());
            knightBoolean = false;
            warriorBoolean = false;
            wizardBoolean = false;
            confessorBoolean = true;
        });
        southPanel2.add(confessorSub, BorderLayout.SOUTH);

        characterSubmit = new JButton("Submit");
        characterSubmit.setPreferredSize(new Dimension(200, 50));
        characterSubmit.addActionListener(event -> {
            if (knightBoolean) {
                System.out.println("Knight");
                characterSelectionWindow.dispose();

            } else if (warriorBoolean) {
                System.out.println("Warrior");
                characterSelectionWindow.dispose();

            } else if (wizardBoolean) {
                System.out.println("Wizard");
                characterSelectionWindow.dispose();

            } else if (confessorBoolean) {
                System.out.println("Confessor");
                characterSelectionWindow.dispose();

            }
        });
        southPanel2.add(characterSubmit, BorderLayout.SOUTH);


        knightPicture = new JPanel();
        knightPicture.setPreferredSize(new Dimension(200, 200));
        knightPicture.setBackground(BLUE);
        centerPanel2.add(knightPicture, BorderLayout.CENTER);

        warriorPicture = new JPanel();
        warriorPicture.setPreferredSize(new Dimension(200, 200));
        warriorPicture.setBackground(BLACK);
        centerPanel2.add(warriorPicture, BorderLayout.CENTER);

        wizardPicture = new JPanel();
        wizardPicture.setPreferredSize(new Dimension(200, 200));
        wizardPicture.setBackground(BLUE);
        centerPanel2.add(wizardPicture, BorderLayout.CENTER);

        confessorPicture = new JPanel();
        confessorPicture.setPreferredSize(new Dimension(200, 200));
        confessorPicture.setBackground(BLACK);
        centerPanel2.add(confessorPicture, BorderLayout.CENTER);

        stats = new JTextArea(13, 22);
        stats.setEditable(false);
        stats.setLineWrap(true);
        stats.setWrapStyleWord(true);
        stats.setFont(new Font("Inter", Font.PLAIN, 12));
        statsPane = new JScrollPane(stats);
        centerPanel2.add(statsPane, BorderLayout.CENTER);


        northPanel.setPreferredSize(new Dimension(0, 100));
        containerChaSelection.add(northPanel, BorderLayout.NORTH);
        containerChaSelection.add(centerPanel, BorderLayout.CENTER);
        containerChaSelection.add(southPanel, BorderLayout.SOUTH);
        characterSelectionWindow.add(containerChaSelection);
    }

    public void panelRemover() {
        northPanel.removeAll();
        northPanel2.removeAll();
        centerPanel.removeAll();
        centerPanel2.removeAll();
        southPanel.removeAll();
        southPanel2.removeAll();
    }
}