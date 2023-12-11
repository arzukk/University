import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiClient {
    public static void main(String[] args) {
        try {
            Registry echoRegistry = LocateRegistry.getRegistry("localhost", 1099);
            IEchoService echoService = (IEchoService) echoRegistry.lookup("rmi://localhost:1099/EchoService");

            Registry addRegistry = LocateRegistry.getRegistry("localhost", 1100);
            IAddService addService = (IAddService) addRegistry.lookup("rmi://localhost:1100/AddService");

            EchoResponse echoResponse = echoService.echoMessage(new EchoRequest("Client Spekaing"));
            System.out.println("Echo response: " + echoResponse.getEchoMessage());

            AddResponse addResponse = addService.addition(new AddRequest(5, 7));
            System.out.println("Add response: " + addResponse.getSum());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
