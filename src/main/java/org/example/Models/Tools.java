package org.example.Models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.Controller.Connection;
import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;

public class Tools {
    private static Tools tools;
    public static Tools getInstance()
    {
        if (tools == null) {
            tools = new Tools();
        }
        return tools;
    }

    public Response gsonToResponse(String gson) {
        Response response = new Gson().fromJson(gson, Response.class);
        return response;
    }

    public void showInfoMessage(String text, String title) {
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
    }


    public void showErrorMessage(String text, String title) {
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.ERROR_MESSAGE);
    }

    public ArrayList<String> getListOfSongs(String json) {
        ArrayList<String>songs =
                new Gson().fromJson(json, new TypeToken<ArrayList<String>>(){}.getType());
        return songs;
    }

//    public void receivedSong(String name) throws IOException {
//        Socket socket = Connection.getConnection().getSocket();
//        InputStream is = new DataInputStream(socket.getInputStream());
//        FileOutputStream fos = new FileOutputStream(new File(name));
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//
//        byte[] buffer = new byte[1024];
//        int bytesRead = 0;
//
//        while ((bytesRead = is.read(buffer)) != -1) {
//            bos.write(buffer, 0, bytesRead);
//        }
//        System.out.println("done!");
////        Tools.getInstance().showInfoMessage("Audio Downloaded successfully!", "");
//    }

    public void receivedSong(String jsonString, String name) throws IOException {

    }
}