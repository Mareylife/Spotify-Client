package org.example.Controller.Actions;

import javazoom.jl.player.Player;
import org.example.Controller.Connection;
import org.example.Controller.Exchange;
import org.example.Models.*;
import org.example.View.HomeView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.*;

import org.example.Models.FileTransferProcessor;

public class PlayButtonAction implements ActionListener {

    public boolean stop = false;

    @Override
    public void actionPerformed(ActionEvent e2 ) {
        if (HomeView.getInstance().getPlay_btn().getText().equals("STOP!")) {
            stop = true;
            return;
        }
        String song = HomeView.getInstance().getSelectedSong();
        if (song.equals("none")) {
            Tools.getInstance().
                    showErrorMessage("please press Refresh button to load song list!", "Error");
            return;
        }
        if (!checkExist(song)) {
            Tools.getInstance().showInfoMessage(song + " not exist in memory. now downloading...", "");
            Request request = new Request();
            request.setAction(RequestType.Play);
            request.addData("name", song);
            Exchange.getInstance().Send(request);
            FileTransferProcessor f = new FileTransferProcessor(Connection.getConnection().getSocket());
            f.receiveFile(song);
            try {
                Connection.getConnection().reConnect();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        new Thread(()->{
            try {
                FileInputStream fileInputStream = new FileInputStream(song);
                Player player = new Player((fileInputStream));

                new Thread(()-> {
                    while (!player.isComplete()) {
                        if (stop) {
                            player.close();
                            HomeView.getInstance().getPlay_btn().setText("PLAY");
                            HomeView.getInstance().getComboBox().setEnabled(true);
                            HomeView.getInstance().getSlider().setValue(0);
                            stop = false;
                            break;
                        }
                        int ms = player.getPosition();
                        int s = ms / 1000;
                        int m = s / 60;
                        s = s % 60;
                        HomeView.getInstance().getPlay_btn().setText("STOP!");
                        HomeView.getInstance().getComboBox().setEnabled(false);
                        HomeView.getInstance().getVals().setText(song + " " + m + ":" + s);
                        HomeView.getInstance().getSlider().setValue(s);
                    }
                    player.close();
                    HomeView.getInstance().getVals().setText("none 00:00");
                    HomeView.getInstance().getPlay_btn().setText("PLAY");
                    HomeView.getInstance().getComboBox().setEnabled(true);
                    HomeView.getInstance().getSlider().setValue(0);
                    stop = false;
                }).start();
                player.play();
            } catch (Exception e) {
                System.out.println(e);
            }
        }).start();
    }

    public static ActionListener getAction() {
        return new PlayButtonAction();
    }

    private boolean checkExist(String name) {
        File f = new File(name);
        return f.exists();
    }

}
