package KE5.aufgabe1;

import java.sql.SQLOutput;

public class Threads {
    public static void main (String[] args) {
        ThreadA thread1 = new ThreadA();
        ThreadA thread2 = new ThreadA();
        ThreadA thread3 = new ThreadA();
        ThreadB thread4 = new ThreadB();
        Thread stellvertreter1 = new Thread(thread4);
        Thread stellvertreter2 = new Thread(thread4);
        Thread stellvertreter3 = new Thread(thread4);
        thread1.start();
        thread2.start();
        thread3.start();
        stellvertreter1.start();
        stellvertreter2.start();
        stellvertreter3.start();
        new ThreadA().start();

    }
}

