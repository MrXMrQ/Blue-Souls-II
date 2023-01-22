package GUI;

import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;

public class MainMenuAndChaSubmitFrames extends JFrame {
    //windows
    MyFrame mainMenuWindow;
    MyFrame chaSelectWindow;

    //panels
    JPanel panelNORTH;
    JPanel panelCENTER;
    JPanel panelCENTER_SOUTH;
    JPanel panelSOUTH;
    JPanel holder;

    //labels
    JLabel headline;
    JLabel subHeadline;
    JLabel creatorText;

    ClassPictures knightPicture;
    ClassPictures warriorPicture;
    ClassPictures wizardPicture;
    ClassPictures confessorPicture;

    //buttons
    JButton submitButton;
    JButton knightButton;
    JButton warriorButton;
    JButton wizardButton;
    JButton confessorButton;

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
        holder.setPreferredSize(new Dimension(200, 200));
        holder.setOpaque(true);
        holder.add(textAreaStatsPane);


        //button for the classes and stats of each class + submit button for select your class you want to play with
        panelSOUTH.setLayout(flowLayout);
        panelSOUTH.setPreferredSize(new Dimension(0, 100));

        knightButton = new JButton(GameLauncher.characterArray[1].getName());
        knightButton.setPreferredSize(new Dimension(200, 50));
        knightButton.addActionListener(e -> {
            i = 1;
            printer(i);
        });
        panelSOUTH.add(knightButton);

        warriorButton = new JButton(GameLauncher.characterArray[2].getName());
        warriorButton.setPreferredSize(new Dimension(200, 50));
        warriorButton.addActionListener(e -> {
            i = 2;
            printer(i);
        });
        panelSOUTH.add(warriorButton);

        wizardButton = new JButton(GameLauncher.characterArray[3].getName());
        wizardButton.setPreferredSize(new Dimension(200, 50));
        wizardButton.addActionListener(e -> {
            i = 3;
            printer(i);
        });
        panelSOUTH.add(wizardButton);

        confessorButton = new JButton(GameLauncher.characterArray[4].getName());
        confessorButton.setPreferredSize(new Dimension(200, 50));
        confessorButton.addActionListener(e -> {
            i = 4;
            printer(i);
        });
        panelSOUTH.add(confessorButton);

        submitButton = new JButton("submit");
        submitButton.setPreferredSize(new Dimension(200, 50));
        submitButton.addActionListener(e -> {
            if (i > 0) {
                GameLauncher.characterArray[0] = GameLauncher.characterArray[i];
                GameLauncher.characterArray[0].setName(playerName);
                System.out.println(GameLauncher.characterArray[0].getName() + GameLauncher.characterArray[0].getHealthpoints());
                chaSelectWindow.dispose();
                GameFrame.gameFrame();

            } else {
                textAreaStats.setText("");
                textAreaStats.append("   Error pleas select a class");

            }
        });

        panelSOUTH.add(submitButton);

        chaSelectWindow.add(panelSOUTH, BorderLayout.SOUTH); //add the panelSOUTH with all buttons


        panelCENTER.setLayout(new BorderLayout());


        panelCENTER_SOUTH = new JPanel(flowLayout);
        panelCENTER_SOUTH.setPreferredSize(new Dimension(0, 400));


        knightPicture = new ClassPictures();
        knightPicture.setText("Knight");

        warriorPicture = new ClassPictures();
        warriorPicture.setText("Warrior");

        wizardPicture = new ClassPictures();
        wizardPicture.setText("wizard");

        confessorPicture = new ClassPictures();
        confessorPicture.setText("confessor");

        panelCENTER_SOUTH.add(knightPicture);
        panelCENTER_SOUTH.add(warriorPicture);
        panelCENTER_SOUTH.add(wizardPicture);
        panelCENTER_SOUTH.add(confessorPicture);
        panelCENTER_SOUTH.add(holder);


        headline.setText("BLUE SOULS II");
        headline.setFont(new Font("Inter", Font.BOLD, 101));

        subHeadline.setText("choose your class");
        subHeadline.setFont(new Font("Inter", Font.BOLD, 20));

        panelCENTER.add(headline, BorderLayout.NORTH);
        panelCENTER.add(subHeadline, BorderLayout.CENTER);


        panelCENTER.add(panelCENTER_SOUTH, BorderLayout.SOUTH);
        chaSelectWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    public void printer(int i) {
        textAreaStats.setText("");
        textAreaStats.append("   Name: " + GameLauncher.characterArray[i].getName() + "\n   Healthpoints: " + GameLauncher.characterArray[i].getHealthpoints() + "\n   Staminapoints: " + GameLauncher.characterArray[i].getStaminapoints() + "\n   Damage: " + GameLauncher.characterArray[i].getDamage() + "\n   Ringslots: " + GameLauncher.characterArray[i].getRingslots() + "\n   Healthpotion: " + GameLauncher.characterArray[i].getRingslots() + "\n   Fist: " + GameLauncher.characterArray[i].getFist());
    }

    public void panelRemover() {
        panelNORTH.removeAll();
        panelCENTER.removeAll();
        panelSOUTH.removeAll();
    }
}