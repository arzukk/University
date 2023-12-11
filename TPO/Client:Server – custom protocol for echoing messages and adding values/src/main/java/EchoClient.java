import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.net.InetSocketAddress;

public class EchoClient {

    final static int ECHO_PORT = 12345;
    private SocketChannel channel;
    private ByteBuffer buffer;

    public EchoClient() {
        buffer = ByteBuffer.allocate(256);
    }

    public void connect(String host) throws IOException {
        try{
        channel = SocketChannel.open(new InetSocketAddress(host, ECHO_PORT));
        System.out.print("Connecting ...");
    } catch(
    UnknownHostException exc) {
        System.err.println(host);
    } catch(Exception exc) {
        exc.printStackTrace();
    }
        System.out.println("Connected to the server: ");
    }

    public String sendMessage(String str, int num1, int num2) throws IOException {
        String msg = str + " " + num1 + " " + num2;
        buffer.clear();
        buffer.put(msg.getBytes());
        buffer.flip();

        while (buffer.hasRemaining()) {
            channel.write(buffer);
        }
        buffer.clear();

        int bytesRead = channel.read(buffer);
        if (bytesRead != -1) {
            buffer.flip();

            String response = new String(buffer.array(), 0, bytesRead);
            System.out.println("Client wants to echo: " + str + " and sum: " + num1 + " and " + num2);
            System.out.println("Server: (Echo and calculated:) " + response);
            buffer.clear();
            return response;
        } else {
            System.out.println("Disconnected from server");
            return null;
        }
    }

    public void disconnect() throws IOException {
        channel.close();
    }

    public static void main(String[] args) {
        EchoClient ec = new EchoClient();

        try {
            ec.connect("localhost");
            String str = "hello";
            int num1 = 3;
            int num2 = 24;
            ec.sendMessage(str, num1, num2);
            ec.disconnect();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}

