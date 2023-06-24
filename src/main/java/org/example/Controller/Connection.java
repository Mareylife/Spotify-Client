package org.example.Controller;

import org.example.Models.Tools;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    public static final int PORT = 7778;
    private Socket socket;

    public Connection() {
        try {
            socket = new Socket("localhost", PORT);
            Tools.getInstance().showInfoMessage("we connected to Server!", "");
        } catch (IOException ex) {
            Tools.getInstance().showErrorMessage(ex.getMessage(), "Error");
            System.exit(-1);
        }
    }

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) {
            connection = new Connection();
        }
        return connection;
    }

    public Socket getSocket() {
        return socket;
    }

    public void reConnect() throws IOException {
        socket = new Socket("localhost", PORT);
    }
}
