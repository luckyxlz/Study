import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;
//import java.net.MulticastSocket;


public class Notification extends Thread{

    public static void main(String[] args) throws IOException {

        //创建发送端对象
        DatagramSocket socket = new DatagramSocket();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(((line = bufferedReader.readLine())!=null)){
            if("886".equals(line)){
                break;
            }
            byte[] bys = line.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet = new DatagramPacket(bys, bys.length, InetAddress.getLocalHost(), 12345);
            socket.send(packet);
        }
        socket.close();

    }


}
