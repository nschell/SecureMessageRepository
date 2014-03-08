package Gui.accesscontrolgui;

import javax.swing.*;

/**
 * Created by nschell
 */
public class AccessControlInfo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new AccessControlFrame("New Secure Message Metadata");
                frame.setSize(650,400);
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
