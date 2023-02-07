package PlayerInventorys;

import GUI.MyFrame;
import Items.LabelWithItemIcons;
import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;

public class Equip {
    //Frames
    public static MyFrame equipWindow;

    //Panels
    JPanel panelEAST;
    JPanel panelSOUTH;

    //Buttons
    JButton backButton;

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


        LabelWithItemIcons[] labelWithItemIconsArray = new LabelWithItemIcons[GameLauncher.characterArray[0].getRingslots()];
        panelEAST = new JPanel(new FlowLayout());

        for (int i = 0; i < GameLauncher.characterArray[0].getRingslots(); i++) {
            LabelWithItemIcons labelWithItemIcons = new LabelWithItemIcons();
            labelWithItemIconsArray[i] = labelWithItemIcons;
            panelEAST.add(labelWithItemIconsArray[i]);
        }

        labelWithItemIconsArray[0].setText("Ring");
        equipWindow.add(panelEAST, BorderLayout.EAST);


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