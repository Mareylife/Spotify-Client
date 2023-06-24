package org.example.Controller.Actions;

import org.example.Controller.Exchange;
import org.example.Models.Request;
import org.example.Models.RequestType;
import org.example.Models.Response;
import org.example.Models.Tools;
import org.example.View.HomeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RefreshButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Request request = new Request();
        request.setAction(RequestType.ReFresh);
        Exchange.getInstance().Send(request);
        Response response = Exchange.getInstance().read();
        if (response.getStatus_code() == 200) {
            HomeView.getInstance().RefreshSongs(
                    Tools.getInstance().getListOfSongs(response.getMessage())
            );
            Tools.getInstance().showInfoMessage("Songs refreshed successfully!", "");
        }
        else {
            Tools.getInstance().showErrorMessage(response.getMessage(), "Error");
        }
    }

    public static ActionListener getAction() {
        return new RefreshButtonAction();
    }
}
