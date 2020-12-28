package ea5.Rechner;

import javafx.geometry.NodeOrientation;

import javax.swing.*;
import javax.xml.soap.Node;
import java.awt.*;
import java.awt.event.*;

public class Rechner extends Frame {
    private BorderLayout borderLayout1 = new BorderLayout();
    String display = "0";
    int operand = 0;
    String operate = "";
    TextField tf = new TextField(display, 40);

    /*
     * AWT-Komponenten fuer Eingabetextfeld, Zifferntasten, Operatortasten sowie
     * Ziffernpanel und Operatorpanel deklarieren und soweit moeglich bereits
     * zugehoerige Objekte erzeugen
     */
    private class MyButton extends Button {
        public MyButton(int i) {
            String text = String.valueOf(i);
            setBackground(Color.gray);
            setForeground(Color.blue);
            setLabel(text);
        }

        public MyButton(String text) {
            setBackground(Color.green);
            setForeground(Color.black);
            setLabel(text);
        }

    }

    public Rechner() {
        /* Ggf. lokale Variablen deklarieren */

        /* Layout fuer Frame festlegen */
        this.setLayout(borderLayout1);
        this.setSize(400, 500);
        this.setLocation(100, 100);
        this.setBackground(Color.gray);

        /* FlowLayout fuer Ziffern- und Operatorpanel setzen */
        Panel anzeige = new Panel();

        anzeige.add(tf);
        anzeige.setSize(400,70);
        tf.setEditable(false);
        tf.setFocusable(false);

        Panel zahlen = new Panel();
        zahlen.setLayout(new BorderLayout());
        Panel zahlenOben = new Panel();
        zahlenOben.setLayout(new FlowLayout());
        Panel zahlenUnten = new Panel();
        zahlenUnten.setLayout(new FlowLayout());
        Panel operators = new Panel();
        operators.setLayout(new FlowLayout());
        zahlen.setBackground(Color.BLUE);

        /* Zifferntasten ggf. erzeugen und in Ziffernpanel einfuegen */
        MyButton number0 = new MyButton(0);
        zahlenOben.add(number0);
        number0.addActionListener(new ZiffernListener());
        MyButton number1 = new MyButton(1);
        zahlenOben.add(number1);
        number1.addActionListener(new ZiffernListener());
        MyButton number2 = new MyButton(2);
        zahlenOben.add(number2);
        number2.addActionListener(new ZiffernListener());
        MyButton number3 = new MyButton(3);
        zahlenOben.add(number3);
        number3.addActionListener(new ZiffernListener());
        MyButton number4 = new MyButton(4);
        zahlenOben.add(number4);
        number4.addActionListener(new ZiffernListener());
        MyButton number5 = new MyButton(5);
        zahlenUnten.add(number5);
        number5.addActionListener(new ZiffernListener());
        MyButton number6 = new MyButton(6);
        zahlenUnten.add(number6);
        number6.addActionListener(new ZiffernListener());
        MyButton number7 = new MyButton(7);
        zahlenUnten.add(number7);
        number7.addActionListener(new ZiffernListener());
        MyButton number8 = new MyButton(8);
        zahlenUnten.add(number8);
        number8.addActionListener(new ZiffernListener());
        MyButton number9 = new MyButton(9);
        zahlenUnten.add(number9);
        number9.addActionListener(new ZiffernListener());
        zahlen.add(zahlenOben, BorderLayout.NORTH);
        zahlen.add(zahlenUnten, BorderLayout.SOUTH);

        /* Operatortasten ggf. erzeugen und in Operatorpanel einfuegen */
        MyButton operatePlus = new MyButton("+");
        operators.add(operatePlus);
        operatePlus.addActionListener(new OperatorListener("+"));
        MyButton operateMinus = new MyButton("-");
        operators.add(operateMinus);
        operateMinus.addActionListener(new OperatorListener("-"));
        MyButton operateMulti = new MyButton("*");
        operators.add(operateMulti);
        operateMulti.addActionListener(new OperatorListener("*"));
        MyButton operateIs = new MyButton("=");
        operators.add(operateIs);
        operateIs.addActionListener(new OperatorListener("="));


        /* Objekte in Frame plazieren */
        this.add(anzeige);
        this.add(zahlen);
        this.add(operators, borderLayout1.SOUTH);
        /* ... */
    }

    public class ZiffernListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getSource().toString());
            System.out.println(e.getActionCommand());
            if (display == "0") {
                display = e.getActionCommand();
            } else if (operate == "1") {
                display = e.getActionCommand();
                operate = "";
            } else {
                display = display + e.getActionCommand();
            }
            tf.setText(display);
            System.out.println(tf.getText());
        };
    }

    public class OperatorListener implements ActionListener {
        public OperatorListener(String e) {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand()!="=") {
                if (operate == "" || operate == "1") {
                    operand = Integer.valueOf(display);
                    operate = e.getActionCommand();
                } else if (operate == "+") {
                    operand = Integer.valueOf(display) + Integer.valueOf(operand);
                    operate = e.getActionCommand();
                    System.out.println("Plus");
                } else if (operate == "-") {
                    operand = Integer.valueOf(display) - operand;
                    operate = e.getActionCommand();
                    System.out.println("Minus");
                } else if (operate == "*") {
                    operand = Integer.valueOf(display) * operand;
                    operate = e.getActionCommand();
                    System.out.println("Multi");
                }
                display = "";
                tf.setText("");
            }
            if (e.getActionCommand()=="=") {
                if (operate == "" || operate == "1") {
                    operand = Integer.valueOf(display);
                    operate = e.getActionCommand();
                } else if (operate == "+") {
                    operand = Integer.valueOf(display) + operand;
                    operate = e.getActionCommand();
                    System.out.println("Plus");
                } else if (operate=="-") {
                    operand = operand - Integer.valueOf(display);
                    operate = e.getActionCommand();
                    System.out.println("Minus");
                } else if (operate=="*") {
                    operand = Integer.valueOf(display) * operand;
                    operate = e.getActionCommand();
                    System.out.println("Multi");
                }
                display = String.valueOf(operand);
                tf.setText(display);
                operate="1";
            }
        }
    }

    /* ... */
    public static void main(String argv[]) {
        Rechner rechner = new Rechner();
        rechner.setLayout(new FlowLayout());
        rechner.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        rechner.setVisible(true);
    }
}

