package org.example.Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.example.Models.Request;
import org.example.Models.Response;
import org.example.Models.Tools;

import com.google.gson.*;
public class Exchange {
    private static Exchange exchange;
    public static Exchange getInstance() {
        if (exchange == null) {
            exchange = new Exchange();
        }
        return exchange;
    }

    public void Send(Request request) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(Connection.getConnection().getSocket().getOutputStream());
            dataOutputStream.writeUTF(new Gson().toJson(request));
            dataOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Response read() {
        try {
            DataInputStream dataInputStream = new DataInputStream(Connection.getConnection().getSocket().getInputStream());
            String gson = dataInputStream.readUTF();
            return Tools.getInstance().gsonToResponse(gson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}