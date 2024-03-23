package nicshal.homework13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TCPServer {

    public final static int PORT_NUMBER = 9090;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT_NUMBER)) {
            while (true) {
                try (Socket socket = serverSocket.accept();
                     InputStream in = socket.getInputStream();
                     OutputStream out = socket.getOutputStream();) {
                    handleRequest(getRequest(in), out);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getRequest(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        int read = in.read(buffer);
        String request = new String(buffer, 0, read, StandardCharsets.UTF_8);
        System.out.println("request = " + request);
        return request;
    }

    public static void handleRequest(String request, OutputStream out) throws IOException {
        if (request.equals("start")) {
            out.write(Calculator.getOperators().getBytes(StandardCharsets.UTF_8));
        } else {
            String response;
            try {
                response = Calculator.calculate(request);
            } catch (RuntimeException ex) {
                response = ex.getMessage();
            }
            out.write(response.getBytes(StandardCharsets.UTF_8));
        }
    }

}