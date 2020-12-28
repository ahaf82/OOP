package ea6.SpeisendePhilosophen;

public class ChopStick {
    boolean inUse = false;

    public synchronized void use() {
        while (inUse) {
            try {
                wait();
            } catch (InterruptedException error) {
            }
        }
        inUse = true;
    }

    public synchronized void release() {
        inUse = false;
        notifyAll();
    }
}
