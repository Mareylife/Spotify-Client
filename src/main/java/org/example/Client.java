package org.example;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 1234);

        // Receive the audio file from the server
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("received.mp3"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = is.read(buffer)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }
        bos.flush();
        System.out.println("Audio file received from server");

        bos.close();
        socket.close();
    }
}
