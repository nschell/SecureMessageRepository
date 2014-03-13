package edu.uml.nschell.openfilegui;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created
 */
public class OpenMessageMainFrame extends JFrame {

    private OpenMessageDetailsPanel detailsPanel;

    public OpenMessageMainFrame(String title) throws Exception {
    super(title);

    setLayout(new BorderLayout());

    JTextArea textArea = new JTextArea("\n Please input the path and filename of the secure message you wish to view:  \n");
    textArea.setFont(new Font("Serif", Font.BOLD, 13));
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);

    detailsPanel = new OpenMessageDetailsPanel();

    Container c = getContentPane();
    c.add(textArea, BorderLayout.CENTER);
    c.add(detailsPanel, BorderLayout.SOUTH);
    }
}
