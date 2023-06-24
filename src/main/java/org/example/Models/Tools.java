package org.example.Models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import java.util.ArrayList;

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


}