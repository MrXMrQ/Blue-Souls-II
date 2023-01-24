package GUI;

import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    JButton button1;
    JButton button2;
    JButton button3;

    public GameFrame() {
        gameFrame();
    }

    public void gameFrame() {
        MyFrame gameWindow = new MyFrame();
        gameWindow.setLayout(new BorderLayout());

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(25);

        JPanel panelNORTH = new JPanel(flowLayout);

        LabelWithIcons cave1 = new LabelWithIcons();
        cave1.setText(randomDungeons());

        LabelWithIcons cave2 = new LabelWithIcons();
        cave2.setText(randomDungeons());

        LabelWithIcons cave3 = new LabelWithIcons();
        cave3.setText(randomDungeons());

        panelNORTH.add(cave1);
        panelNORTH.add(cave2);
        panelNORTH.add(cave3);

        gameWindow.add(panelNORTH, BorderLayout.NORTH);


        JPanel panelCENTER = new JPanel(flowLayout);

        button1 = new JButton();
        button1.setPreferredSize(new Dimension(256,64));

        button2 = new JButton();
        button2.setPreferredSize(new Dimension(256,64));

        button3 = new JButton();
        button3.setPreferredSize(new Dimension(256,64));

        panelCENTER.add(button1);
        panelCENTER.add(button2);
        panelCENTER.add(button3);

        gameWindow.add(panelCENTER, BorderLayout.CENTER);
    }

    public static String randomDungeons() {
        int dungeonsArrayLength = GameLauncher.dungeonsArray.length;
        int randomDungeonNumber = (int)(Math.random()*dungeonsArrayLength);
        
        return GameLauncher.dungeonsArray[randomDungeonNumber].getName();
    }
}
