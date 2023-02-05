package PlayerInventorys;

import GUI.LabelWithIcons;
import GUI.MyFrame;
import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;

public class Equip {
    //Frames
    MyFrame equipWindow;

    //Panels
    JPanel panelCENTER;
    JPanel panelSOUTH;

    //Buttons
    JButton backButton;

    Thread equipThread;
    public Equip() {
        equipThread = new Thread(this::equipFrame);
        equipThread.start();
    }

    public void equipFrame() {
        equipWindow = new MyFrame();
        equipWindow.setLayout(new BorderLayout());
        equipWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        LabelWithIcons[] labelWithIconsArray = new LabelWithIcons[GameLauncher.characterArray[0].getRingslots()];
        panelCENTER = new JPanel(new FlowLayout());

        for (int i = 0; i < GameLauncher.characterArray[0].getRingslots(); i++) {
            LabelWithIcons labelWithIcons = new LabelWithIcons();
            labelWithIconsArray[i] = labelWithIcons;
            panelCENTER.add(labelWithIconsArray[i]);
        }

        labelWithIconsArray[0].setText("Ring");
        equipWindow.add(panelCENTER, BorderLayout.CENTER);


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