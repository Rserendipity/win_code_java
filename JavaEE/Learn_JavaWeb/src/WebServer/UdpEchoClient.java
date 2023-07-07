package WebServer;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    private final DatagramSocket socket;
    private final int port;
    private final String serverIP;

    public UdpEchoClient(String ip, int port) throws SocketException {
        // 客户端不需要显式绑定, 让系统分配就好
        socket = new DatagramSocket();
        this.port = port;
        this.serverIP = ip;
    }

    public void start() throws IOException {
        System.out.println("Client start.....");
        Scanner cin = new Scanner(System.in);

        while (true) {
            // 1. 输入要发送的信息
            System.out.print(":>");
            String sendMsg = cin.nextLine();
            if (sendMsg.equals("exit")) {
                System.out.println("goodbye");
                break;
            }

            // 2. 构造UDP的网络包并发送
            DatagramPacket requestPacket = new DatagramPacket(
                    sendMsg.getBytes(),
                    sendMsg.getBytes().length,
                    InetAddress.getByName(serverIP),
                    port
            );
            socket.send(requestPacket);

            // 3. 读取服务器的响应, 并解析出来
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096], 4096);
            socket.receive(responsePacket);
            String receiveMsg = new String(
                    responsePacket.getData(),
                    0,
                    responsePacket.getLength()
            );

            // 4. 把解析的结果显示出来
            System.out.println("#>" + receiveMsg);
        }
    }


    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 20427);
        client.start();
    }
}
