package PlayerInventorys;

import GUI.MyFrame;
import Launcher.GameLauncher;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static javax.swing.SwingConstants.*;

public class Inventory {
    public static void inventoryWindow() {
        MyFrame invWindow = new MyFrame();
        invWindow.setTitle("Inventory");
        invWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        invWindow.setLayout(new BorderLayout());

        JPanel panelSOUTH = new JPanel(new FlowLayout());

        JButton backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(event -> invWindow.dispose());
        panelSOUTH.add(backButton);

        invWindow.add(panelSOUTH, BorderLayout.SOUTH);


        JPanel panelEAST = new JPanel(new BorderLayout());

        JLabel labelONEAST_NORTH = new JLabel("STATS", CENTER);
        labelONEAST_NORTH.setFont(new Font("Inter", Font.BOLD, 50));
        panelEAST.add(labelONEAST_NORTH, BorderLayout.NORTH);


        JPanel panelONEAST_WEST = new JPanel(new GridLayout(3,1));

        JPanel pan1 = new JPanel(new FlowLayout());
        JLabel labelHealth = new JLabel("Healthpoints: " + GameLauncher.characterArray[0].getHealthpoints());
        labelHealth.setFont(new Font("Inter", Font.PLAIN, 15));
        pan1.add(labelHealth);
        panelONEAST_WEST.add(pan1);

        JPanel pan2 = new JPanel(new FlowLayout());
        JLabel labelStamina = new JLabel("Staminapoints: " + GameLauncher.characterArray[0].getStaminapoints());
        labelStamina.setFont(new Font("Inter", Font.PLAIN, 15));
        pan2.add(labelStamina);
        panelONEAST_WEST.add(pan2);

        JPanel pan3 = new JPanel(new FlowLayout());
        JLabel labelDamage = new JLabel("Damage: " + GameLauncher.characterArray[0].getDamage());
        labelDamage.setFont(new Font("Inter", Font.PLAIN, 15));
        pan3.add(labelDamage);
        panelONEAST_WEST.add(pan3);

        panelEAST.add(panelONEAST_WEST, BorderLayout.WEST);


        JPanel panelONEAST_EAST = new JPanel(new GridLayout(3, 1));
        panelONEAST_EAST.setPreferredSize(new Dimension(100, 0));

        JPanel buttonPanel1 = new JPanel(new FlowLayout());
        JButton button1 = new JButton("Level Up");
        button1.setPreferredSize(new Dimension(100, 25));
        buttonPanel1.add(button1);

        JPanel buttonPanel2 = new JPanel(new FlowLayout());
        JButton button2 = new JButton("Level Up");
        button2.setPreferredSize(new Dimension(100, 25));
        buttonPanel2.add(button2);

        JPanel buttonPanel3 = new JPanel(new FlowLayout());
        JButton button3 = new JButton("Level Up");
        button3.setPreferredSize(new Dimension(100, 25));
        buttonPanel3.add(button3);

        panelONEAST_EAST.add(buttonPanel1);
        panelONEAST_EAST.add(buttonPanel2);
        panelONEAST_EAST.add(buttonPanel3);

        panelEAST.add(panelONEAST_EAST, BorderLayout.EAST);


        invWindow.add(panelEAST, BorderLayout.EAST);
    }
}
