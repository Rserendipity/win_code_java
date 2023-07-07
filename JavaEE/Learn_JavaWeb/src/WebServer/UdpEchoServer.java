package WebServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private final DatagramSocket socket;

    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    public void start() throws IOException {
        System.out.println("Server start.....");
        while (true) {
            // 创建接收请求的packet
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096], 4096);
            // 接收请求
            socket.receive(requestPacket);
            // 把byte[]构造成string
            String request = new String(
                    requestPacket.getData(),
                    0,
                    requestPacket.getLength()
            );


            // 把得到的请求进行加工, 加工成响应
            String responseMsg = process(request);


            // 把响应构建成packet发回去
            DatagramPacket responsePacket = new DatagramPacket(
                    responseMsg.getBytes(),
                    responseMsg.getBytes().length,
                    requestPacket.getSocketAddress()
            );
            // 发送响应
            socket.send(responsePacket);

            // 打印一下此次的信息
            System.out.printf("[%s:%d] req:%s ; resp:%s\n",
                    responsePacket.getAddress().toString(),
                    responsePacket.getPort(),
                    request,
                    responseMsg
            );
        }
    }

    private String process(String request) {
        return request;
    }


    public static void main(String[] args) throws IOException {
        UdpEchoServer udpEchoServer = new UdpEchoServer(20427);
        udpEchoServer.start();

    }
}
