package org.example.View;

import org.example.Controller.Actions.ExitButtonAction;
import org.example.Controller.Actions.PlayButtonAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeView extends JFrame {
    private JLabel label;
    private JLabel Spotify;
    private JLabel vals;
    private JSlider slider;
    private JButton refresh_btn;
    private JButton play_btn;
    private JButton exit_btn;
    private JComboBox comboBox;

    public HomeView() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 0));
        setSize(400, 300);

        initialize();
        setActions();
        setLocationRelativeTo(null);
        setResizable(false);
        setUndecorated(true);
        getContentPane().setBackground(new Color(30, 215, 96));
        setVisible(true);
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

//        slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
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
        exit_btn.addActionListener(ExitButtonAction.getAction());
    }
}

