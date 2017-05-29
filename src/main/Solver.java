package main;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Миша on 01.04.2017.
 */
public class Solver {
    double Xo, Yo, Zo, To, a, m, b, j, f0, F0, J, w0;

    public Solver() {
    }

    public void solve(double[] mas) throws IOException {
        int k = 4;                       //количество знаков после запятой
        m = mas[0];
        a = mas[1];
        j = mas[2];
        b = mas[3];
        w0 = mas[4];
        f0 = mas[5];
        F0 = mas[6];
        J = mas[7];
        To = 0;
        Xo = mas[8];
        Yo = mas[9];
        Zo = mas[10];
        double X1, Y1, Z1;
        double k1, k2, k3, k4, q1, q2, q3, q4, l1, l2, l3, l4, h;
        ArrayList<Double> arrayX = new ArrayList<>();
        ArrayList<Double> arrayY = new ArrayList<>();

        h = 0.01; // шаг
        double to = r(To, k) + 250;
        arrayX.add(To);
        arrayY.add(Xo);
        //System.out.println("\tT\t\tX");
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
            if (Math.abs(X1) > 100.223372036854776E300 ) {
                System.out.println(X1);
                break;
            }
            Y1 = Yo + h * (q1 + 2 * q2 + 2 * q3 + q4) / 6.0;
            Z1 = Zo + h * (l1 + 2 * l2 + 2 * l3 + l4) / 6.0;
           // System.out.println("\t" + r(To + h, k) + "\t\t" + r(X1, k));
            arrayX.add(r(To + h, k));
            arrayY.add(r(X1, k));
            Xo = X1;
            Yo = Y1;
            Zo = Z1;
        }
        double[] res1 = new double[arrayX.size()];
        for (int i = 0; i < arrayX.size(); i++) {
            res1[i] = arrayX.get(i);
        }
        double[] res2 = new double[arrayY.size()];
        for (int i = 0; i < arrayY.size(); i++) {
            res2[i] = arrayY.get(i);
        }

        boolean bool1 = ((a * (j - b * m * w0 * w0) * J + f0 * F0 * m) > 0);
        boolean bool2 = (a*m > 0);
        boolean bool3 = (m*(j-b*m*w0*w0) > 0);
        boolean bool4 = (f0*F0*J*m < 0);
        if (bool1&&bool2&bool3&bool4) System.out.println("Устойчив");
        else {
            System.out.println(bool1);
            System.out.println(bool2);
            System.out.println(bool3);
            System.out.println(bool4);
            System.out.println("Неустойчив");
            //JOptionPane.showMessageDialog(null, "Неустойчив!","Message", JOptionPane.ERROR_MESSAGE);
        }
        Draw draw = new Draw(res1, res2);
    }


    public double f(double x, double y, double z) {
        return (-a / m * z - (j - b * m * w0 * w0) / m * y + (f0 * F0) / (J * m) * (x -w0));
    }

    public static double r(double value, int k) {                 // функция для округления
        return (double) Math.round((Math.pow(10, k) * value)) / Math.pow(10, k);
    }

}
