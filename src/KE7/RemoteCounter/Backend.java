package KE7.RemoteCounter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Backend extends Remote {

    public int increment() throws InterruptedException, RemoteException;

    public int decrement() throws InterruptedException, RemoteException;

    public int reset() throws InterruptedException, RemoteException;
}

