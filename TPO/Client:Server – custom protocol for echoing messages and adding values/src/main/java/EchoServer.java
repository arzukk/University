import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.net.InetSocketAddress;
import java.util.Iterator;
import java.util.Set;

public class EchoServer {

    final static int ECHO_PORT = 12345;

    private static void acceptClient(Selector sel, ServerSocketChannel ss) throws IOException {
        SocketChannel ch = ss.accept();
        ch.configureBlocking(false);
        ch.register(sel, SelectionKey.OP_READ);
        System.out.println("Client connected");
    }

    private static void sum(ByteBuffer buf, SelectionKey skey) throws IOException {
        SocketChannel channel = (SocketChannel) skey.channel();
        int bufferRead = channel.read(buf);

        if (bufferRead == -1) {
            System.out.println("Client disconnected");
            channel.close();
        } else {
            buf.flip();
            String message = new String(buf.array(), 0, bufferRead).trim();
            System.out.println("Received: " + message);
            buf.clear();

            String[] parts = message.split(" ");
            if (parts.length == 3) {
                try {
                    int num1 = Integer.parseInt(parts[1]);
                    int num2 = Integer.parseInt(parts[2]);
                    String str = parts[0];
                    int sum = num1 + num2;
                    String response = "The message is " + str + "\nThe sum is: " + String.valueOf(sum);
                    channel.write(ByteBuffer.wrap(response.getBytes()));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid integer format.");
                }
            } else {
                System.err.println("Invalid message format.");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.bind(new InetSocketAddress("localhost", ECHO_PORT));
        System.out.println("Server listening");

        ss.configureBlocking(false);

        Selector selector = Selector.open();
        ss.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buf = ByteBuffer.allocate(256);

        while (true) {
            selector.select();

            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            Iterator<SelectionKey> iter = selectedKeys.iterator();

            while (iter.hasNext()) {
                SelectionKey key = iter.next();

                if (key.isAcceptable()) {
                    acceptClient(selector, ss);
                }

                if (key.isReadable()) {
                    sum(buf, key);
                }

                iter.remove();
            }
        }
    }
}
