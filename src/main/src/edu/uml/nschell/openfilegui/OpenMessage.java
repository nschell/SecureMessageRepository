package edu.uml.nschell.openfilegui;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created
 */
public class OpenMessage {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = null;
            try {
                frame = new OpenMessageMainFrame("Open New Secure Message");
            } catch (Exception e) {
                e.printStackTrace();
            }
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

