import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

public class Main {
    String fname = "test";
    FileChannel channel;
    Random random;
    int iterations;

    public Main() throws IOException {
        this.channel = new RandomAccessFile(fname, "rw").getChannel();
        this.random = new Random();
        this.iterations = 0;
        init();
    }
    public void init() throws IOException {
        write();
    }

    public void write() throws IOException {

                MappedByteBuffer buf = channel.map(
                        FileChannel.MapMode.READ_WRITE,
                        0,
                        8
                );
                IntBuffer ibuf = buf.asIntBuffer();

                int data1 = random.nextInt(100);;
                int data2 = random.nextInt(100);;

                ibuf.clear();
                ibuf.put(data1);
                ibuf.put(data2);
                buf.force();

                System.out.println("Writer: Wrote data " + data1 + " and " + data2);
                read();
    }

    public void read() throws IOException {
                MappedByteBuffer buf = channel.map(
                        FileChannel.MapMode.READ_ONLY,
                        0,
                        8
                );
                IntBuffer ibuf = buf.asIntBuffer();

                int data1 = ibuf.get();
                int data2 = ibuf.get();

//                System.out.println("Reader: Read data " + data1 + " and " + data2);
                System.out.println("Sum of the numbers: " + (data1 + data2));
        iterations++;
        if (iterations < 5) {
            write();
        }
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
