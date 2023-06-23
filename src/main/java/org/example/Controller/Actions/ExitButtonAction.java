package org.example.Controller.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    public static ActionListener getAction() {
        return new ExitButtonAction();
    }
}
