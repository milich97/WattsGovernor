package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by Миша on 07.03.2017.
 */
public class Draw extends JPanel {
    int startX = 600, startY = 200, sizeX = 900, sizeY = 600;
    int[] arrayX;
    int[] arrayY;
    JFrame frame;
    double scale;

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(sizeX / 2, 0, sizeX / 2, sizeY);
        g.drawLine(0, sizeY / 2, sizeX, sizeY / 2);

        g.setColor(Color.blue);

//        g.drawString("1", sizeX / 2 + scale, sizeY / 2);
//        g.drawString("5", sizeX / 2 + 5 * scale, sizeY / 2);
//        g.drawString("10", sizeX / 2 + 10 * scale, sizeY / 2);
//        g.drawString("30", sizeX / 2 + 30 * scale, sizeY / 2);
//        g.drawString("1", sizeX / 2, sizeY / 2 - scale);
//        g.drawString("5", sizeX / 2, sizeY / 2 - 5 * scale);
//        g.drawString("10", sizeX / 2, sizeY / 2 - 10 * scale);
//        g.drawString("25", sizeX / 2, sizeY / 2 - 25 * scale);

        g.drawPolyline(arrayX, arrayY, arrayX.length);
    }

    public Draw() {
        //JOptionPane.showMessageDialog(null, "Your message goes here!","Message", JOptionPane.ERROR_MESSAGE);
    }

    public Draw(double[] a1, double[] a2, double x0) {
        double ax = Math.abs(x0);
        if (ax < 40) scale = 10;
        else {
            if (ax < 400) scale = 1;
            else JOptionPane.showMessageDialog(null, "Increase x0!", "Message", JOptionPane.ERROR_MESSAGE);
        }
       // scale = 0.1;//Math.pow(10,1);
        int k = 2;                       //количество знаков после запятой
        arrayX = new int[a1.length];
        arrayY = new int[a2.length];

        for (int i = 0; i < arrayX.length; i++) {
            arrayX[i] = (int) (r(a1[i] * scale, k) + sizeX / 2);
            arrayY[i] = (int) (sizeY / 2 - r(a2[i] * scale, k));
        }
        frame = new JFrame("Governor");
        frame.setLocation(startX, startY);
        frame.setMinimumSize(new Dimension(sizeX, sizeY));
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    public static double r(double value, int k) {                 // функция для округления
        return (double) Math.round((Math.pow(10, k) * value)) / Math.pow(10, k);
    }

}


