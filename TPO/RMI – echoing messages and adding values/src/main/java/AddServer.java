import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class AddServer extends UnicastRemoteObject implements IAddService {

    protected AddServer() throws RemoteException {
        super();
    }

    @Override
    public AddResponse addition(AddRequest request) throws RemoteException {
        System.out.println("Received Add request: " + request.getNum1() + " + " + request.getNum2());
        return new AddResponse(request.getNum1() + request.getNum2());
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.rebind("rmi://localhost:1100/AddService", new AddServer());

            System.out.println("Add RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
