package KE5.aufgabe1;

public class ThreadB implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            System.out.println("Who is working? " + Thread.currentThread().getName());
        }
    }
}
