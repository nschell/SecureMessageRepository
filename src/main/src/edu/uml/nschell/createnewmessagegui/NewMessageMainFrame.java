package edu.uml.nschell.createnewmessagegui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nschell
 */
public class NewMessageMainFrame extends JFrame {

    private NewMessageDetailsPanel detailsPanel;


    public NewMessageMainFrame(String title) {
        super(title);

        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea("\n Please enter the message that you wish to securely store.  Note that this system is for Business Confidential information only and shall not be available to those without a need to know. \n");
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        detailsPanel = new NewMessageDetailsPanel();

        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.SOUTH);

    }
}
