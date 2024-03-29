package client;

import client.users.UserData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LauncherController {

    private LauncherFrame view;

    public LauncherController(LauncherFrame view) {
        this.view = view;
    }

    public void init() {
        Main main = Main.getInstance();
        main.setProgramMode(ProgramMode.Offline);
        view.serverInfoPanel.setVisible(false);
        view.serverPortField.setText(Integer.toString(Main.serverPort));

        view.modeBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (view.modeBox.getSelectedIndex()) {
                    case 0:
                        main.setProgramMode(ProgramMode.Offline);
                        view.serverInfoPanel.setVisible(false);
                        break;
                    case 1:
                        main.setProgramMode(ProgramMode.Online);
                        view.serverInfoPanel.setVisible(true);
                        break;
                }
            }
        });

        view.startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main main = Main.getInstance();
                main.username = view.usernameField.getText();
                switch (main.mode) {
                    case Offline:
                        Main.getInstance().start(view.usernameField.getText());
                        break;
                    case Online:
                        main.serverAddress = view.serverAddressField.getText();
                        try {
                            main.serverPort = Integer.parseInt(view.serverPortField.getText());
                            Main.getInstance().start(view.usernameField.getText());
                        } catch (NumberFormatException ex) {
                            System.out.println("Invalid port number format");
                        }
                        break;
                }
            }
        });
    }

}
