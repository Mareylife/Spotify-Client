package org.example.View;

import org.example.Controller.Actions.ExitButtonAction;
import org.example.Controller.Actions.PlayButtonAction;
import org.example.Controller.Actions.RefreshButtonAction;
import org.example.Controller.Connection;
import org.example.Models.Tools;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HomeView extends JFrame {
    private JLabel label;
    private JLabel Spotify;
    private JLabel vals;
    private JSlider slider;
    private JButton refresh_btn;
    private JButton play_btn;
    private JButton exit_btn;
    private JComboBox comboBox;

    private static HomeView homeView;
    public static HomeView getInstance() {
        if (homeView == null) {
            homeView = new HomeView();
        }
        return homeView;
    }

    public void run() {
        setVisible(true);
    }

    public void RefreshSongs(ArrayList<String> songs) {
        comboBox.removeAllItems();
        for (String song : songs) {
            comboBox.addItem(song);
        }
    }

    public HomeView() {
        Connection.getConnection();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 0));
        setSize(400, 300);

        initialize();
        setActions();
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setBackground(new Color(30, 215, 96));
    }

    private void initialize() {
//        labels
        JPanel panel = new JPanel();
        Spotify = new JLabel("Spotify");
        Spotify.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(Spotify);
        panel.setBackground(Color.WHITE);
        label = new JLabel("You Can Choose a Song:");
        label.setFont(new Font("Arial", Font.CENTER_BASELINE, 12));
        vals =  new JLabel("null, 00:00");
        vals.setFont(new Font("Arial", Font.CENTER_BASELINE, 10));

//        buttons
        refresh_btn = new JButton("REFRESH");
        refresh_btn.setBackground(new Color(30, 215, 96));
        play_btn = new JButton("PLAY");
        play_btn.setBackground(new Color(30, 215, 96));
        exit_btn = new JButton("EXIT!");
        exit_btn.setBackground(new Color(30, 215, 96));

//        comboBox
        comboBox = new JComboBox();
        comboBox.setBackground(new Color(30, 215, 96));
        comboBox.addItem("none");

//        slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setEnabled(false);
        slider.setMaximum(0);
        slider.setMaximum(163);
        slider.setBackground(new Color(30, 215, 96));

//        added items
        add(panel);
        add(label);
        add(comboBox);
        add(slider);
        add(vals);
        add(play_btn);
        add(refresh_btn);
        add(exit_btn);
    }

    private void setActions() {
        play_btn.addActionListener(PlayButtonAction.getAction());
        refresh_btn.addActionListener(RefreshButtonAction.getAction());
        exit_btn.addActionListener(ExitButtonAction.getAction());
    }

    public String getSelectedSong() {
        return (String) comboBox.getSelectedItem();
    }

    public JLabel getVals() {
        return vals;
    }

    public JLabel getLabel() {
        return label;
    }

    public JLabel getSpotify() {
        return Spotify;
    }

    public JSlider getSlider() {
        return slider;
    }

    public JButton getRefresh_btn() {
        return refresh_btn;
    }

    public JButton getPlay_btn() {
        return play_btn;
    }

    public JButton getExit_btn() {
        return exit_btn;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public static HomeView getHomeView() {
        return homeView;
    }
}

