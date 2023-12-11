import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAddService extends Remote {
    AddResponse addition(AddRequest request) throws RemoteException;
}
