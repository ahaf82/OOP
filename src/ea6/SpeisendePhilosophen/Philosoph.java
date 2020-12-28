package ea6.SpeisendePhilosophen;

import static ea6.SpeisendePhilosophen.Philosoph.Status.*;

public class Philosoph extends Thread {
    String name;
    Status state;
    ChopStick leftChopStick;
    ChopStick rightChopStick;

    public Philosoph (String name, ChopStick leftChopStick, ChopStick rightChopStick) {
        super(name);
        this.state = THINKING;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
    }

    enum Status {
        THINKING,
        HUNGRY,
        EATING;
    }

    @Override
    public void run () {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + " philosophiert...");
                sleep((long) (Math.random()*15000));
                state = HUNGRY;

                // Kette der Methodenaufrufe
                // nimmt linkes Stäbchen auf - wartet auf linkes Stäbchen - setzt Stäbchen[i] auf false (betritt dessen Monitor?)
                leftChopStick.use();
                System.out.println(getName() + "nimmt linkes Stäbchen auf");
                sleep((long) (Math.random()*15000));
                // nimmt rechtes Stäbchen auf  - wartet auf rechtes Stäbchen - setzt Stäbchen[i+1] auf false (betritt dessen Monitor?)
                rightChopStick.use();
                System.out.println(getName() + "nimmt rechtes Stäbchen auf");
                // wenn beide Stäbchen aufgenommen sind (false) - isst - Zustand EATING
                state = EATING;
                System.out.println(Thread.currentThread().getName() + " isst.");
                sleep((long) (Math.random()*15000));
                // legt linkes Stäbchen zurück free = true notifyAll -> philosophiert wieder außerdem sleep
                leftChopStick.release();
                System.out.println(getName() + "legt linkes Stäbchen ab");
                sleep((long) (Math.random()*15000));
                // legt rechtes Stäbchen zurück free = true notifyAll
                rightChopStick.release();
                System.out.println(getName() + "legt rechtes Stäbchen ab");
                state = THINKING;
            } catch (InterruptedException e) {
                interrupted();
            }
        }
    }
}



