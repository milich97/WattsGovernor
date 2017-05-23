package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Миша on 01.04.2017.
 */
public class FirstWindow  {
    int startX = 600, startY = 200, sizeX = 900, sizeY = 600;
    public FirstWindow() {

        JFrame frame1 = new JFrame("First window");
        frame1.setLocation(startX, startY);
        frame1.setMinimumSize(new Dimension(sizeX, sizeY));
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        main.TextField textField = new main.TextField();


        panel.add(textField.getWhatToDoMessages());
        panel.add(textField.getTextField());
        frame1.add(panel);
        frame1.setVisible(true); // last!!!!
    }
}
