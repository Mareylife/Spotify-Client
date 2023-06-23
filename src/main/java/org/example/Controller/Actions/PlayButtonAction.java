package org.example.Controller.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "full", "Inf", JOptionPane.INFORMATION_MESSAGE);
    }

    public static ActionListener getAction() {
        return new PlayButtonAction();
    }

}
