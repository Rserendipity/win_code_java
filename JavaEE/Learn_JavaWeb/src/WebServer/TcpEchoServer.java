package WebServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer {
    private final ServerSocket serverSocket;

    public TcpEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("TCP server start...");

        ExecutorService threadPool = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            threadPool.submit(() -> {
               processConnection(socket);
            });

//            Thread t = new Thread(() -> {
//                processConnection(socket);
//            });
//            t.start();
        }
    }

    private void processConnection(Socket socket) {
        System.out.printf("[%s:%d] linked...\n", socket.getInetAddress(), socket.getPort());
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            while (true) {
                Scanner cin = new Scanner(inputStream);
                if (!cin.hasNext()) {
                    System.out.printf("[%s:%d] unlinked\n", socket.getInetAddress(), socket.getPort());
                    break;
                }
                String request = cin.next();
                String response = process(request);

                PrintWriter printWriter = new PrintWriter(outputStream);
                printWriter.println(response);
                printWriter.flush();

                System.out.printf("[%s:%d] [req:%s] [res:%s]\n",
                        socket.getInetAddress(),
                        socket.getPort(),
                        request,
                        response
                );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(20427);
        tcpEchoServer.start();

    }
}
