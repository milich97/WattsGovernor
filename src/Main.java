/**
 * Created by Миша on 27.02.2017.
 */

import dessolver.math.RungeKutta;

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;


public class Main {

    public static void main(String[] args) {


        int k = 2;                       //количество знаков после запятой
        double Xo, Yo, Y1, Zo, Z1;
        double k1, k2, k4, k3, h;
        double q1, q2, q4, q3;
        ArrayList<Integer> arrayX = new ArrayList<>();
        ArrayList<Integer> arrayY = new ArrayList<>();
        Xo = 0;
        Yo = 0.8;        // Начальные условия
        Zo = 2;
        h = 0.1; // шаг
        double to = r(Xo, k) + 1;
        arrayX.add((int) (100 * r(Xo, k)));
        arrayY.add((int) (100 * r(Yo, k)));
        //System.out.println("\tX\t\tY\t\tZ");
        for (; r(Xo, k) < to; Xo += h) {

            k1 = h * f(Xo, Yo, Zo);
            q1 = h * Zo;

            k2 = h * f(Xo + h / 2.0, Yo + q1 / 2.0, Zo + k1 / 2.0);
            q2 = h * (Zo + k1 / 2.0);

            k3 = h * f(Xo + h / 2.0, Yo + q2 / 2.0, Zo + k2 / 2.0);
            q3 = h * (Zo + k2 / 2.0);

            k4 = h * f(Xo + h, Yo + q3, Zo + k3);
            q4 = h * (Zo + k3);

            Z1 = Zo + (k1 + 2.0 * k2 + 2.0 * k3 + k4) / 6.0;
            Y1 = Yo + (q1 + 2.0 * q2 + 2.0 * q3 + q4) / 6.0;
            //System.out.println("\t" + r(Xo + h, k) + "\t\t" + r(Y1, k) + "\t\t" + r(Z1, k));
            arrayX.add((int) (100 * r(Xo + h, k)));
            arrayY.add((int) (100 * r(Y1, k)));
            Yo = Y1;
            Zo = Z1;
        }
        Draw draw = new Draw();
        draw.giveArr(arrayX, arrayY);

    }


    public static double r(double value, int k) {                 // функция для округления
        return (double) Math.round((Math.pow(10, k) * value)) / Math.pow(10, k);
    }

    public static double f(double x, double y, double z) {
        return (Math.cos(3 * x) - 4 * y);
    }
}




