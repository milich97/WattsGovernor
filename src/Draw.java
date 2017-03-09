import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Миша on 07.03.2017.
 */
public class Draw extends JPanel {
    int startX = 600, startY = 200, sizeX = 900, sizeY = 600;
    int[] arrayX;
    int[] arrayY;

    public Draw() {

        JFrame frame = new JFrame("Window");
        frame.setLocation(startX, startY);
        frame.setMinimumSize(new Dimension(sizeX, sizeY));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);
        //frame.pack();
        frame.setVisible(true);

    }


    public void giveArr(int[] a1, int[] a2) {
        arrayX = new int[a1.length];
        arrayY = new int[a2.length];
        arrayX = a1;
        arrayY = a2;
    }
    public void addValues() {
        for (int i = 0; i < arrayX.length; i++) {
            arrayX[i] = arrayX[i] + sizeX / 2;
            arrayY[i] = sizeY / 2 - arrayY[i];
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(sizeX / 2, 0, sizeX / 2, sizeY);
        g.drawLine(0, sizeY / 2, sizeX, sizeY / 2);

        g.setColor(Color.blue);
        g.drawPolyline(arrayX, arrayY, arrayX.length);
        g.drawString("1", sizeX/2+100, sizeY/2);
        g.drawString("2", sizeX/2+200, sizeY/2);
        g.drawString("3", sizeX/2+300, sizeY/2);
        g.drawString("1", sizeX/2, sizeY/2-100);
        g.drawString("2", sizeX/2, sizeY/2-200);
    }


}


