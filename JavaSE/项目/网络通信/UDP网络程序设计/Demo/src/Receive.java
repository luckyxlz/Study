import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receive{
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(12345);
        while(true) {

            byte[] bys = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bys, bys.length);

            datagramSocket.receive(packet);

            System.out.println(new String(packet.getData(), 0, packet.getLength()));
        }

    }



}