import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    protected ServerSocket server;        //服务器套接口
    protected Socket socket;              //客户机套接口

    void start() {                       //启动服务器
        try {
            server = new ServerSocket(8998);
            System.out.println("服务器已经创建成功！");
            while (true) {
                System.out.println("等待客户机的连接");
                socket = server.accept();//服务器监听客户机的连接
                //根据套接字字节流创建字符串流
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {//循环接受信息
                    String s = bufferedReader.readLine();//读取一行文本
                    if ("exit".equals(s))//如果客户机发来“exit”
                    {
                        System.out.println("客户机退出");
                        break;//停止接受信息
                    }
                    System.out.println("客户机" + s);
                }
                bufferedReader.close();//关闭流
                socket.close();//关闭套接字
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyServer tcp = new MyServer();
        tcp.start();
    }
}
