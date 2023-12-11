import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IEchoService extends Remote{
    EchoResponse echoMessage(EchoRequest request) throws RemoteException;

}
