

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer extends UnicastRemoteObject implements IEchoService {

    protected EchoServer() throws RemoteException {
        super();
    }

    @Override
    public EchoResponse echoMessage(EchoRequest request) throws RemoteException {
        System.out.println("Received Echo request: " + request.getMessage());
        return new EchoResponse(request.getMessage());
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("rmi://localhost:1099/EchoService", new EchoServer());

            System.out.println("Echo RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
