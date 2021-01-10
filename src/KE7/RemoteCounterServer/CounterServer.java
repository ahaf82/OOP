package KE7.RemoteCounterServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class CounterServer {
    public static void main(String args[]) throws RemoteException, MalformedURLException {
        java.rmi.registry.LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://127.0.0.1/count", new BackEndImpl(50));
    }
}
