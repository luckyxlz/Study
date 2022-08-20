import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame {
    protected PrintWriter writer;
    protected Socket socket;
    protected JTextArea area = new JTextArea();
    protected JTextField text = new JTextField();

    public MyClient(){
        setTitle("向服务器发送数据");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(area);
        getContentPane().add(jScrollPane, BorderLayout.CENTER);
        contentPane.add(text,"South");
        text.addActionListener(e -> {
            writer.println(text.getText().trim());
            area.append(text.getText()+"\n");
            text.setText("");
        });
    }

    private void connect(){
        area.append("尝试连接\n");
        try {
            socket = new Socket("localhost",8998);
            writer = new PrintWriter(socket.getOutputStream(),true);
            area.append("完成连接\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyClient client = new MyClient();
        client.setSize(200,200);
        client.setVisible(true);
        client.connect();
    }

}

