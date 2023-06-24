package org.example.Controller.Actions;

import org.example.Controller.Exchange;
import org.example.Models.Request;
import org.example.Models.RequestType;
import org.example.Models.Response;
import org.example.Models.Tools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Request request = new Request();
        request.setAction(RequestType.Logout);
        Exchange.getInstance().Send(request);
        System.exit(0);
    }

    public static ActionListener getAction() {
        return new ExitButtonAction();
    }
}
