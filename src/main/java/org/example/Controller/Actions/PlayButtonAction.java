package org.example.Controller.Actions;

import org.example.Controller.Connection;
import org.example.Controller.Exchange;
import org.example.Models.Request;
import org.example.Models.RequestType;
import org.example.Models.Response;
import org.example.Models.Tools;
import org.example.View.HomeView;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.ResourceBundle;

public class PlayButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String song = HomeView.getInstance().getSelectedSong();
        if (song.equals("none")) {
            Tools.getInstance().
                    showErrorMessage("please press Refresh button to load song list!", "Error");
            return;
        }
        Request request = new Request();
        request.setAction(RequestType.Play);
        request.addData("name", song);
        Exchange.getInstance().Send(request);
//TODO: smt
    }

    public static ActionListener getAction() {
        return new PlayButtonAction();
    }

}
