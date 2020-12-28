package ea6.Warum;

import java.io.IOException;

public class Warum {
    public static void main(String[] argv) throws InterruptedException {
        Test t = new Test();
        t.start();
        t.dotry();
        t.anhalten();
    }
}

class Test extends Thread {
    Boolean anhalten = false;

    @Override
    public void run() {
        while (!anhalten) {
            System.out.println("Hallo, ich komme.");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Sollte nicht geschehen, zur Sicherheit Ausgabemeldung
                interrupt();
                System.out.println("Beim Schlafen unterbrochen");
            }
        }
    }

    public Boolean anhalten() {
        return anhalten = true;
    }

    // Zum Beenden Enter-Taste druecken
    void dotry() {
        try {
            System.in.read(); // Blockiert bis Zeile eingegeben
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ich gehe. Auf Wiedersehen!");
    }
}