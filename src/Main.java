/**
 * Created by Миша on 27.02.2017.
 */

import javax.swing.*;
import java.awt.Graphics;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {


        int k = 2;                       //количество знаков после запятой
        double To, Xo, X1, Yo, Y1, Zo, Z1;
        double k1, k2, k3, k4, q1, q2, q3, q4, l1, l2, l3, l4, h;
        ArrayList<Integer> arrayX = new ArrayList<>();
        ArrayList<Integer> arrayY = new ArrayList<>();
        To = 0;
        Xo = 1;
        Yo = -2;        // Начальные условия
        Zo = 2;
        h = 0.1; // шаг
        double to = r(To, k) + 2;
        arrayX.add((int) (100 * r(To, k)));
        arrayY.add((int) (100 * r(Xo, k)));
        System.out.println("\tT\t\tX\t\tY\t\tZ");
        for (; r(To, k) < to; To += h) {

            k1 = Yo;
            q1 = Zo;
            l1 = f(Xo, Yo, Zo);

            k2 = Yo + h / 2 * k1;
            q2 = Zo + h / 2 * q1;
            l2 = f(Xo + h / 2 * k1, Yo + h / 2 * q1, Zo + h / 2 * l1);

            k3 = Yo + h / 2 * k2;
            q3 = Zo + h / 2 * q2;
            l3 = f(Xo + h / 2 * k2, Yo + h / 2 * q2, Zo + h / 2 * l2);

            k4 = Yo + h * k3;
            q4 = Zo + h * q3;
            l4 = f(Xo + h * k3, Yo + h * q3, Zo + h * l3);

            X1 = Xo + h * (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
            Y1 = Yo + h * (q1 + 2 * q2 + 2 * q3 + q4) / 6.0;
            Z1 = Zo + h * (l1 + 2 * l2 + 2 * l3 + l4) / 6.0;
            System.out.println("\t" + r(To + h, k) + "\t\t" + r(X1, k) + "\t\t" + r(Y1, k) + "\t\t" + r(Z1, k));
            arrayX.add((int) (100 * r(To + h, k)));
            arrayY.add((int) (100 * r(X1, k)));
            Xo = X1;
            Yo = Y1;
            Zo = Z1;
        }

        int[] res1 = new int[arrayX.size()];
        for (int i = 0; i < arrayX.size(); i++) {
            res1[i] = (int) arrayX.get(i);
        }
        int[] res2 = new int[arrayY.size()];
        for (int i = 0; i < arrayY.size(); i++) {
            res2[i] = (int) arrayY.get(i);
        }

        Draw draw = new Draw();
        draw.giveArr(res1, res2);
        draw.addValues();
    }

    public static double r(double value, int k) {                 // функция для округления
        return (double) Math.round((Math.pow(10, k) * value)) / Math.pow(10, k);
    }

    public static double f(double x, double y, double z) {
        double a = 2000, m = 100, j = 2000, b = 3, w0 = 2, f0 = 1, F0 = -2, J = 0.001;
        return (-a / m * z - (j - b * m * w0 * w0) / m * y + (f0 * F0) / (J * m) * x);
        //return 0;
    }
}




