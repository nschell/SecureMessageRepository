package Gui.accesscontrolgui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nschell.
 */
public class AccessControlFrame extends JFrame {

    private AccessControlDetailsPanel detailsPanel;

    public AccessControlFrame(String title) {
        super(title);

        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea("\n Please enter the metadata for the Secure Message you wish to create: \n");
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        detailsPanel = new AccessControlDetailsPanel();

        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(detailsPanel, BorderLayout.SOUTH);


    }
}
