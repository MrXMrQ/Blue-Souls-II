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
    JPanel panelCENTER_CENTER;
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
    Icon confessor;
    Icon warrior;

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
                panelRemover();

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


        //button for the classes and stats of each class + submit button for select your class you want to play with
        panelSOUTH.setLayout(flowLayout);
        panelSOUTH.setPreferredSize(new Dimension(0, 100));

        knightButton = new JButton(GameLauncher.characterArray[1].getName());
        knightButton.setPreferredSize(new Dimension(256, 64));
        knightButton.addActionListener(e -> {
            i = 1;
            printer(i);
        });
        panelSOUTH.add(knightButton);

        warriorButton = new JButton(GameLauncher.characterArray[2].getName());
        warriorButton.setPreferredSize(new Dimension(256, 64));
        warriorButton.addActionListener(e -> {
            i = 2;
            printer(i);
        });
        panelSOUTH.add(warriorButton);

        wizardButton = new JButton(GameLauncher.characterArray[3].getName());
        wizardButton.setPreferredSize(new Dimension(256, 64));
        wizardButton.addActionListener(e -> {
            i = 3;
            printer(i);
        });
        panelSOUTH.add(wizardButton);

        confessorButton = new JButton(GameLauncher.characterArray[4].getName());
        confessorButton.setPreferredSize(new Dimension(256, 64));
        confessorButton.addActionListener(e -> {
            i = 4;
            printer(i);
        });
        panelSOUTH.add(confessorButton);

        submitButton = new JButton("submit");
        submitButton.setPreferredSize(new Dimension(256, 64));
        submitButton.addActionListener(e -> {
            if (i > 0) {
                GameLauncher.characterArray[0] = GameLauncher.characterArray[i];
                GameLauncher.characterArray[0].setName(playerName);
                chaSelectWindow.dispose();
                GameFrame.gameFrame();

            } else {
                textAreaStats.setText("");
                textAreaStats.append("   Error please select a class");

            }
        });

        panelSOUTH.add(submitButton);

        chaSelectWindow.add(panelSOUTH, BorderLayout.SOUTH); //add the panelSOUTH with all buttons


        panelCENTER.setLayout(new BorderLayout());

        panelCENTER_CENTER = new JPanel(flowLayout);
        panelCENTER_CENTER.setPreferredSize(new Dimension(0, 400));

        knightPicture = new LabelWithIcons();
        knightPicture.setText("Knight");

        warrior = new ImageIcon(Objects.requireNonNull(getClass().getResource("Warrior.png")));
        warriorPicture = new LabelWithIcons();
        warriorPicture.setIcon(warrior);

        wizardPicture = new LabelWithIcons();
        wizardPicture.setText("wizard");

        confessor = new ImageIcon(Objects.requireNonNull(getClass().getResource("Confessor.png")));
        confessorPicture = new LabelWithIcons();
        confessorPicture.setIcon(confessor);

        panelCENTER_CENTER.add(knightPicture);
        panelCENTER_CENTER.add(warriorPicture);
        panelCENTER_CENTER.add(wizardPicture);
        panelCENTER_CENTER.add(confessorPicture);
        panelCENTER_CENTER.add(holder);


        headline.setText("choose your class");
        headline.setFont(new Font("Inter", Font.BOLD, 50));

        panelCENTER.add(headline, BorderLayout.NORTH);

        panelCENTER.add(panelCENTER_CENTER, BorderLayout.CENTER);
        chaSelectWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    public void printer(int i) {
        textAreaStats.setText("");
        textAreaStats.append("            Name: " + GameLauncher.characterArray[i].getName() + "\n            Healthpoints: " + GameLauncher.characterArray[i].getHealthpoints() + "\n            Staminapoints: " + GameLauncher.characterArray[i].getStaminapoints() + "\n            Damage: " + GameLauncher.characterArray[i].getDamage() + "\n            Ringslots: " + GameLauncher.characterArray[i].getRingslots() + "\n            Healthpotion: " + GameLauncher.characterArray[i].getRingslots() + "\n            Fist: " + GameLauncher.characterArray[i].getFist());
    }

    public void panelRemover() {
        panelNORTH.removeAll();
        panelCENTER.removeAll();
        panelSOUTH.removeAll();
    }
}