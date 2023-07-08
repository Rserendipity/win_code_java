package WebServer;

import com.sun.javaws.IconUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private final Socket socket;

    public TcpEchoClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void start() throws IOException {
        System.out.println("client start...");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            while (true) {
                System.out.print("~ ");
                String request = scanner.next();
                if (request.equals("exit")) {
                    break;
                }
                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(request);
                printWriter.flush();
                Scanner resScan = new Scanner(inputStream);
                String response = resScan.next();
                System.out.println(response);
            }
        }
    }


    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("127.0.0.1", 20427);
        tcpEchoClient.start();
    }
}
