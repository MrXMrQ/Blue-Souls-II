package PlayerInventorys;

import GUI.MyFrame;
import Launcher.GameLauncher;

import javax.swing.*;
import java.awt.*;

public class Inventory {

    public static void inventoryWindow() {
        MyFrame invWindow = new MyFrame();
        invWindow.setLayout(new BorderLayout());

        JPanel panelSOUTH = new JPanel(new FlowLayout());

        JButton backButton = new JButton("BACK");
        backButton.setPreferredSize(new Dimension(200,50));
        backButton.addActionListener(event -> invWindow.dispose());
        panelSOUTH.add(backButton);

        invWindow.add(panelSOUTH, BorderLayout.SOUTH);

        JPanel panelEAST = new JPanel(new FlowLayout());
        panelEAST.setBackground(Color.YELLOW);

        JLabel labelONeast = new JLabel();
        labelONeast.setText("<html><body> " + GameLauncher.characterArray[0].getName() + " <br> " + GameLauncher.characterArray[0].getSouls() +"</body></html>");
        panelEAST.add(labelONeast);

        invWindow.add(panelEAST, BorderLayout.EAST);

    }
}
