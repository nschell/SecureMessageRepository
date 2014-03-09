package Gui.createnewmessagegui;

import javax.swing.*;

/**
 * Created by nschell
 */
public class NewMessage {
    public NewMessage() {

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new NewMessageMainFrame("Create New Secure Message");
                frame.setSize(950,700);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                JMenuBar menubar = new JMenuBar();
                frame.setJMenuBar(menubar);

                JMenu file = new JMenu("File");
                menubar.add(file);
                JMenuItem exit = new JMenuItem("Exit");
                file.add(exit);

                JMenu edit = new JMenu("Edit");
                menubar.add(edit);

                JMenu about = new JMenu("About");
                menubar.add(about);


            }
        });

    }

}

