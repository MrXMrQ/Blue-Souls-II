package GUI;

import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GameFrame {
    public static void gameFrame() {
        MyFrame gameWindow = new MyFrame();
        gameWindow.setLayout(new BorderLayout());

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setHgap(25);

        JPanel panelCENTER = new JPanel(flowLayout);

        LabelWithIcons cave1 = new LabelWithIcons();
        cave1.setPreferredSize(new Dimension(200,200));
        cave1.setBackground(Color.GRAY);
        cave1.setText(randomDungeons());

        LabelWithIcons cave2 = new LabelWithIcons();
        cave2.setPreferredSize(new Dimension(200,200));
        cave2.setBackground(Color.GRAY);
        cave2.setText(randomDungeons());

        LabelWithIcons cave3 = new LabelWithIcons();
        cave3.setPreferredSize(new Dimension(200,200));
        cave3.setBackground(Color.GRAY);
        cave3.setText(randomDungeons());

        panelCENTER.add(cave1);
        panelCENTER.add(cave2);
        panelCENTER.add(cave3);

        gameWindow.add(panelCENTER, BorderLayout.CENTER);
        System.out.println(GameLauncher.characterArray[0].getName() + GameLauncher.characterArray[0].getHealthpoints());
    }

    public static String randomDungeons() {
        int dungeonsArrayLength = GameLauncher.dungeonsArray.length;
        int randomDungeonNumber = (int)(Math.random()*dungeonsArrayLength);

        return GameLauncher.dungeonsArray[randomDungeonNumber].getName();
    }
}
