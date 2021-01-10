package KE7.RemoteCounterServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BackEndImpl extends UnicastRemoteObject implements KE7.RemoteCounter.Backend {

    private int startValue;
    private int value;
    private int min = 0;
    private int max = 99;

    protected BackEndImpl(int start) throws RemoteException {
        startValue = start;
        value = start;
    }

    public int increment() {
        if (value < max) {
            value++;
        }
        System.out.println(value);
        return value;
    }

    public int decrement() {
        if (value > min) {
            value--;
        }
        System.out.println(value);
        return value;
    }

    public int reset() {
        value = startValue;
        System.out.println(value);
        return value;
    }
}
