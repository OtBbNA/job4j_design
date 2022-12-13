package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("msg=")) {
                            String msg;
                            String[] buf = str.split("msg=", 2);
                            String[] buf1 = buf[1].split(" ", 2);
                            msg = buf1[0];
                            switch (msg) {
                                case "Exit" -> server.close();
                                case "Hello" -> out.write("Hello.".getBytes());
                                case "What" -> out.write("What.".getBytes());
                                default -> out.write(msg.getBytes());
                            }
                        }
                        System.out.println(str);
                    }
                    out.flush();
                }
            }
        }
    }
}