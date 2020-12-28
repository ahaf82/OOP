package KE5.aufgabe2.Impfstoffentwicklung;

public class Impfstoffentwicklung {
    public static void main (String[] args) throws InterruptedException {
        CoronaCounter t = new CoronaCounter();
        t.start();
        Thread.sleep(7000);
        t.interrupt();
        System.out.println("Der Impfstoff ist da...");
    }
}

class CoronaCounter extends Thread{
    int counter = 2;
    @Override
    public void run() {
        System.out.println("Der Virus legt los...");
        while (!isInterrupted()) {
            System.out.println(counter++ + " Corona-Infizierte");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                interrupt();
                System.out.println("Wurde beim Schlafen unterbrochen...");
            }
        }
    }
}