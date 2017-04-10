package main;
//100,2000,2000,3,2,1,-2,0.001,1,-2,2.
import javafx.scene.chart.XYChart;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;

import javax.swing.*;
import java.io.IOException;

/**
 * Created by Миша on 07.03.2017.
 */
public class Draw extends JPanel {
    int startX = 600, startY = 200, sizeX = 900, sizeY = 600;
    double[] arrayX;
    double[] arrayY;



    public Draw(double[] a1, double[] a2) throws IOException {

        arrayX=new double[a1.length];
        arrayY=new double[a2.length];
        arrayX=a1;
        arrayY=a2;
        org.knowm.xchart.XYChart chart = QuickChart.getChart("Watt's Governor", "t", "ω(t)", "ω(t)", arrayX, arrayY);
        // Show it
        new SwingWrapper(chart).displayChart();
        BitmapEncoder.saveBitmapWithDPI(chart, "2", BitmapEncoder.BitmapFormat.PNG, 300);

    }


}


