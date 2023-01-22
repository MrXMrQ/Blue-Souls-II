package GUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public static void gameFrame() {
        MyFrame gameWindow = new MyFrame();
        gameWindow.setLayout(new BorderLayout());

        JPanel panelNORTH = new JPanel();
        panelNORTH.setBackground(Color.BLUE);

        JPanel panelEAST = new JPanel();
        panelEAST.setBackground(Color.GRAY);

        FlowLayout layout = new FlowLayout();
        layout.setAlignOnBaseline(true);

        JPanel panelSOUTH = new JPanel(layout);
        panelSOUTH.setPreferredSize(new Dimension(0, 200));
        panelSOUTH.setBackground(Color.BLUE);

        JButton button1 = new JButton();
        button1.setPreferredSize(new Dimension(100, 50));

        JButton button2 = new JButton();
        button2.setPreferredSize(new Dimension(100, 50));

        JButton button3 = new JButton();
        button3.setPreferredSize(new Dimension(100, 50));

        JButton button4 = new JButton();
        button4.setPreferredSize(new Dimension(100, 50));


        panelSOUTH.add(button1);
        panelSOUTH.add(button2);
        panelSOUTH.add(button3);
        panelSOUTH.add(button4);

        JPanel panelWEST = new JPanel();
        panelWEST.setBackground(Color.GRAY);


        gameWindow.add(panelNORTH, BorderLayout.NORTH);
        gameWindow.add(panelEAST, BorderLayout.EAST);
        gameWindow.add(panelSOUTH, BorderLayout.SOUTH);
        gameWindow.add(panelWEST, BorderLayout.WEST);


        JPanel panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBackground(Color.RED);

        JPanel panelCenterNorth = new JPanel();
        panelCenterNorth.setBackground(Color.BLACK);

        JPanel panelCenterSouth = new JPanel();
        panelCenterSouth.setBackground(Color.BLACK);

        panelCenter.add(panelCenterNorth, BorderLayout.NORTH);
        panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);


        gameWindow.add(panelCenter, BorderLayout.CENTER);
    }
}
