package KE7.RemoteCounter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteCounter extends Frame {
    private Button incrementButton = new Button(">");
    private Button decrementButton = new Button ("<");
    private Button resetButton = new Button ("Reset");

    private TextField valueDisplay = new TextField();

    public RemoteCounter(Backend counter) throws RemoteException, InterruptedException {
        valueDisplay.setEditable(false);
        valueDisplay.setText(displayString(counter.reset()));

        incrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valueDisplay.setText(displayString(counter.increment()));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            }
        });

        decrementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valueDisplay.setText(displayString(counter.decrement()));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    valueDisplay.setText(displayString(counter.reset()));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                } catch (RemoteException remoteException) {
                    remoteException.printStackTrace();
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        Panel centerPanel = new Panel(new FlowLayout());
        centerPanel.add(decrementButton);
        centerPanel.add(valueDisplay);
        centerPanel.add(incrementButton);

        add(centerPanel, BorderLayout.CENTER);
        add(resetButton, BorderLayout.SOUTH);

        setSize(200,100);
    }

    public String displayString(int value) {
        return "" + value;
    }

    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, InterruptedException {
        Backend counterBackend = (Backend) Naming.lookup("rmi://127.0.0.1/count");
        RemoteCounter counterWindow = new RemoteCounter(counterBackend);
        counterWindow.setVisible(true);
    }

}


