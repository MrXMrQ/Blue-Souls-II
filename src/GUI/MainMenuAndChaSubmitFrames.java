package GUI;

import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainMenuAndChaSubmitFrames extends JFrame {
    //windows
    MyFrame mainMenuWindow;
    MyFrame chaSelectWindow;

    //panels
    JPanel panelNORTH;
    JPanel panelCENTER;
    JPanel panelSOUTH;
    JPanel holder;

    //labels
    JLabel headline;
    JLabel subHeadline;
    JLabel creatorText;

    LabelWithIcons knightPicture;
    LabelWithIcons warriorPicture;
    LabelWithIcons wizardPicture;
    LabelWithIcons confessorPicture;

    //buttons
    JButton submitButton;
    JButton knightButton;
    JButton warriorButton;
    JButton wizardButton;
    JButton confessorButton;

    //icons
    public static Icon confessor;
    public static Icon warrior;
    public static Icon wizard;
    public static Icon knight;

    //other components or variables
    JTextField textFieldUsername;
    String playerName;
    JTextArea textAreaStats;
    JScrollPane textAreaStatsPane;
    int i;


    public MainMenuAndChaSubmitFrames() {
        mainMenuFrame();
    }

    public void mainMenuFrame() {
        mainMenuWindow = new MyFrame();
        mainMenuWindow.setLayout(new BorderLayout());

        //NORTH panel for headline and subhead line
        panelNORTH = new JPanel(new BorderLayout());

        headline = new JLabel("Blue Souls II", SwingConstants.CENTER);
        headline.setFont(new Font("Inter", Font.BOLD, 101));
        panelNORTH.add(headline, BorderLayout.NORTH);

        subHeadline = new JLabel("please enter your name", SwingConstants.CENTER);
        subHeadline.setFont(new Font("Inter", Font.BOLD, 20));
        panelNORTH.add(subHeadline, BorderLayout.CENTER);

        mainMenuWindow.add(panelNORTH, BorderLayout.NORTH); //add panelNORTH

        //CENTER panel for text field and submit button
        panelCENTER = new JPanel(new FlowLayout());

        textFieldUsername = new JTextField();
        textFieldUsername.setPreferredSize(new Dimension(200, 30));
        panelCENTER.add(textFieldUsername);

        submitButton = new JButton("submit");
        submitButton.setPreferredSize(new Dimension(200, 30));
        submitButton.addActionListener(event -> {
            if (textFieldUsername.getText().equals("")) {
                textFieldUsername.setText("please try again");

            } else {
                playerName = textFieldUsername.getText();
                mainMenuWindow.dispose();

                characterSelectionFrame();
            }
        });
        panelCENTER.add(submitButton);

        mainMenuWindow.add(panelCENTER, BorderLayout.CENTER); //add panelCENTER

        //SOUTH panel for creator Text
        panelSOUTH = new JPanel();

        creatorText = new JLabel("art by pascal, code by mrx in 100% java, supported by Kenneth, Blue Souls II was created on {20.01.2023}, Warning This game is addictive");
        panelSOUTH.add(creatorText);

        mainMenuWindow.add(panelSOUTH, BorderLayout.SOUTH); //add panelSOUTH
    }

    public void characterSelectionFrame() {
        chaSelectWindow = new MyFrame();
        chaSelectWindow.setLayout(new BorderLayout());

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignOnBaseline(true);
        flowLayout.setHgap(100);

        panelNORTH.removeAll();
        panelNORTH.setLayout(flowLayout);
        panelNORTH.setPreferredSize(new Dimension(0,512));

        knight = new ImageIcon(Objects.requireNonNull(getClass().getResource("Knight.png")));
        knightPicture = new LabelWithIcons();
        knightPicture.setIcon(knight);
        panelNORTH.add(knightPicture);

        warrior = new ImageIcon(Objects.requireNonNull(getClass().getResource("Warrior.png")));
        warriorPicture = new LabelWithIcons();
        warriorPicture.setIcon(warrior);
        panelNORTH.add(warriorPicture);

        wizard = new ImageIcon(Objects.requireNonNull(getClass().getResource("Wizard.png")));
        wizardPicture = new LabelWithIcons();
        wizardPicture.setIcon(wizard);
        panelNORTH.add(wizardPicture);

        confessor = new ImageIcon(Objects.requireNonNull(getClass().getResource("Confessor.png")));
        confessorPicture = new LabelWithIcons();
        confessorPicture.setIcon(confessor);
        panelNORTH.add(confessorPicture);

        //Chat Area for stats printing
        textAreaStats = new JTextArea(15, 20);
        textAreaStats.setEditable(false);
        textAreaStats.setLineWrap(true);
        textAreaStats.setWrapStyleWord(true);
        textAreaStats.setFont(new Font("Inter", Font.PLAIN, 13));
        textAreaStatsPane = new JScrollPane(textAreaStats);

        holder = new JPanel();
        holder.setPreferredSize(new Dimension(256, 256));
        holder.setOpaque(true);
        holder.add(textAreaStatsPane);

        panelNORTH.add(holder);

        chaSelectWindow.add(panelNORTH, BorderLayout.NORTH);

        //button for the classes and stats of each class + submit button for select your class you want to play with
        panelCENTER.removeAll();
        panelCENTER.setLayout(flowLayout);
        panelCENTER.setPreferredSize(new Dimension(0, 100));

        knightButton = new JButton(GameLauncher.characterArray[1].getName());
        knightButton.setPreferredSize(new Dimension(256, 64));
        knightButton.addActionListener(e -> {
            i = 1;
            printer(i);
        });
        panelCENTER.add(knightButton);

        warriorButton = new JButton(GameLauncher.characterArray[2].getName());
        warriorButton.setPreferredSize(new Dimension(256, 64));
        warriorButton.addActionListener(e -> {
            i = 2;
            printer(i);
        });
        panelCENTER.add(warriorButton);

        wizardButton = new JButton(GameLauncher.characterArray[3].getName());
        wizardButton.setPreferredSize(new Dimension(256, 64));
        wizardButton.addActionListener(e -> {
            i = 3;
            printer(i);
        });
        panelCENTER.add(wizardButton);

        confessorButton = new JButton(GameLauncher.characterArray[4].getName());
        confessorButton.setPreferredSize(new Dimension(256, 64));
        confessorButton.addActionListener(e -> {
            i = 4;
            printer(i);
        });
        panelCENTER.add(confessorButton);

        submitButton = new JButton("submit");
        submitButton.setPreferredSize(new Dimension(256, 64));
        submitButton.addActionListener(e -> {
            if (i > 0) {
                GameLauncher.characterArray[0] = GameLauncher.characterArray[i];
                GameLauncher.characterArray[0].setName(playerName);
                chaSelectWindow.dispose();
                GameLauncher.gameWindowLauncher();

            } else {
                textAreaStats.setText("");
                textAreaStats.append("Error please select a class");

            }
        });

        panelCENTER.add(submitButton);

        chaSelectWindow.add(panelCENTER, BorderLayout.CENTER); //add the panelSOUTH with all buttons



    }

    public void printer(int i) {
        textAreaStats.setText("");
        textAreaStats.append("Name: " + GameLauncher.characterArray[i].getName() + "\nHealthpoints: " + GameLauncher.characterArray[i].getHealthpoints() + "\nStaminapoints: " + GameLauncher.characterArray[i].getStaminapoints() + "\nDamage: " + GameLauncher.characterArray[i].getDamage() + "\nRingslots: " + GameLauncher.characterArray[i].getRingslots() + "\nHealthpotion: " + GameLauncher.characterArray[i].getRingslots() + "\nFist: " + GameLauncher.characterArray[i].getFist());
    }
}