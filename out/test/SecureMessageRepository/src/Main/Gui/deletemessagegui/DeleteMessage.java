package Gui.deletemessagegui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 */
public class DeleteMessage {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new DeleteMessageMainFrame("Please input the Path and Filename: ");
                frame.setSize(350, 120);
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
