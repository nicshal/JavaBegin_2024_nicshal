package nicshal.homework13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClient {

    public final static String IP_ADDRESS = "127.0.0.1";
    public final static int PORT_NUMBER = 9090;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String request = "start";
        while (!request.isEmpty()) {
            try (Socket socket = new Socket(IP_ADDRESS, PORT_NUMBER);
                 InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream();) {
                out.write((request).getBytes(StandardCharsets.UTF_8));
                handleResponse(in);
                request = getOperationString(scanner);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getOperationString(Scanner scanner) {
        System.out.println("Введите выражение:");
        return scanner.nextLine().trim();
    }

    public static void handleResponse(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        int readBytes = 0;
        readBytes = in.read(buffer);
        String response = new String(buffer, 0, readBytes, StandardCharsets.UTF_8);
        System.out.println("Ответ = " + response);
    }

}