package ea6.Warum;

class Konto {
    int kontoStand = 0;

    public synchronized void einzahlen(int betrag) {
        synchronized (this) {
            int hilfsvariable = kontoStand;
            hilfsvariable = hilfsvariable + betrag;
            kontoStand = hilfsvariable;
        }
    }
}
class EinThread extends Thread {
    static int nummer = 0;
    String name;
    Konto meinKonto;

    public EinThread(String s, Konto k) {
        nummer++;
        name = s;
        meinKonto = k;
    }
    public void run() {
        boolean bv = true;
        while (bv) {
            meinKonto.einzahlen(20);
            yield();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

class NochEinThread extends EinThread {
    public NochEinThread(String s, Konto k) {
        super(s, k);
    }
    public void run() {
        while (true) {
            /*** 1 ***/
                System.out.println("Kontoname: " + name);
                System.out.println("Kontonummer: " + meinKonto);
                System.out.println("Konstostand " + meinKonto.kontoStand + "Euro");
                System.out.println("EinThreadNummer " + EinThread.nummer);
                meinKonto.einzahlen(30);
                System.out.println("Ich habe 30 Euro eingezahlt, jetzt ist der Konstostand: " + meinKonto.kontoStand + "Euro");
            yield();
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
            }
        }
    }
}
public class GemeinsameVariablen {
    public static void main(String[] args) {
        Konto k1 = new Konto();
        Konto k2 = new Konto();
        Thread threadPit = new EinThread("Pit", k1);
        Thread threadTom = new EinThread("Tom", k2);
        Thread threadEva = new NochEinThread("Eva", k1);
        threadPit.start();
        threadTom.start();
        threadEva.start();
    }
}