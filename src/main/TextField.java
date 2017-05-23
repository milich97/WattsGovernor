package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Миша on 01.04.2017.
 */
public class TextField {
    JTextField text;
    JTextField textWhatToDo;
    int a = 0;
    double[] mas11;

    public TextField() {
        textWhatToDo = new JTextField("Input mass", 10);
        mas11 = new double[11];
        text = new JTextField("m=", 10);
        //text.setLocation(startX + 100, 100 + startY);
        text.setSize(200, 50);
        TextFieldHandler textHandler = new TextFieldHandler();
        text.addActionListener(textHandler);


    }

    public JTextField getTextField() {
        return text;
    }

    public JTextField getWhatToDoMessages() {
        return textWhatToDo;
    }


    private class TextFieldHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            switch (a) {
                case 0:
                    mas11[0] = parser(text.getText());
                    text.setText("α=");
                    textWhatToDo.setText("Input positive alfa");
                    break;
                case 1:
                    mas11[1] = parser(text.getText());
                    text.setText("γ=");
                    textWhatToDo.setText("Input positive gamma");
                    break;
                case 2:
                    mas11[2] = parser(text.getText());
                    text.setText("β=");
                    textWhatToDo.setText("Input positive beta");
                    break;
                case 3:
                    mas11[3] = parser(text.getText());
                    text.setText("ω0=");
                    textWhatToDo.setText("Input rotation speed ");
                    break;
                case 4:
                    mas11[4] = parser(text.getText());
                    text.setText("f0=");
                    textWhatToDo.setText("Input f0");
                    break;
                case 5:
                    mas11[5] = parser(text.getText());
                    text.setText("F0=");
                    textWhatToDo.setText("Input F0");
                    break;
                case 6:
                    mas11[6] = parser(text.getText());
                    text.setText("J=");
                    textWhatToDo.setText("Input J");
                    break;
                case 7:
                    mas11[7] = parser(text.getText());
                    text.setText("x0=");
                    textWhatToDo.setText("Input x0");
                    break;
                case 8:
                    mas11[8] = parser(text.getText());
                    text.setText("y0=");
                    textWhatToDo.setText("Input y0");
                    break;
                case 9:
                    mas11[9] = parser(text.getText());
                    text.setText("z0=");
                    textWhatToDo.setText("Input z0");
                    break;
                case 10:
                    mas11[10] = parser(text.getText());
                    Solver solver=new Solver();
                    try {
                        solver.solve(mas11);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            a++;
        }
    }

    public double parser(String s) {
        for (String val : s.split("=")) {
            try {
                return Double.parseDouble(val);
            } catch (Exception e) {
            }
        }
        for (String val : s.split("=")) {
            try {
                return Double.parseDouble(val.substring(0, val.length() - 1));
            } catch (Exception e) {
            }
        }
        return 142857;
    }
}