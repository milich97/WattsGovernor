import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Миша on 07.03.2017.
 */
public class Draw extends JPanel {
    int startX = 600, startY = 200, sizeX = 600, sizeY = 400;
    ArrayList<Integer> arrayX;
    ArrayList<Integer> arrayY;

    public Draw() {

        JFrame frame = new JFrame("Window");
        frame.setLocation(startX, startY);
        frame.setMinimumSize(new Dimension(sizeX, sizeY));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);
        //frame.pack();
        frame.setVisible(true);
        Graphics gg;
        gg = getGraphics();
        gg.setColor(Color.cyan);
        gg.drawLine(0, 0, 233, 234);
        gg.fillRect(0, 0, 300, 500);
    }


    public void giveArr(ArrayList a1, ArrayList a2) {
        arrayX = new ArrayList<>();
        arrayY = new ArrayList<>();
        arrayX = a1;
        arrayY = a2;
    }



    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.black);

//        for (int i = 0; i < ; i++) {
//            g.drawLine();
//        }

        g.drawLine(sizeX / 2, 0, sizeX / 2, sizeY);
        g.drawLine(0, sizeY / 2, sizeX, sizeY / 2);
        int[] xArray = {20, 40, 60, 80, 100, 120, 130, 140, 280, sizeX / 2};
        int[] yArray = {350, 345, 340, 310, 290, 280, 275, 273, 271, (int) 4.5};

        int nPoint = xArray.length;
        g.setColor(Color.blue);
        g.drawPolyline(xArray, yArray, nPoint);
    }
}


