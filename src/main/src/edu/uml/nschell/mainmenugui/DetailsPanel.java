package edu.uml.nschell.mainmenugui;

import edu.uml.nschell.createnewmessagegui.NewMessageMainFrame;
import edu.uml.nschell.deletemessagegui.DeleteMessageMainFrame;
import edu.uml.nschell.openfilegui.OpenMessageMainFrame;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by nschell
 */
public class DetailsPanel extends JPanel {
    public DetailsPanel() {
        Dimension size = getPreferredSize();
        size.height = 250;
        setPreferredSize(size);

        setBorder(BorderFactory.createTitledBorder("Please Choose An Action to Take:"));

        JLabel createDocument = new JLabel("Create New Secure Message  ");
        JLabel deleteDocument = new JLabel("Delete Existing Secure Message  ");
        JLabel openDocument = new JLabel("Open Existing Secure Message  ");

        JButton create = new JButton("Create New Message");
        JButton delete = new JButton("Delete Existing Message");
        JButton open = new JButton("Open Existing Message");

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.weighty = 10;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(createDocument, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(create, gbc);

        gbc.weighty = 10;
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(openDocument, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(open, gbc);

        gbc.weighty = 10;
        gbc.gridx = 2;
        gbc.gridy = 0;
        add(deleteDocument, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        add(delete, gbc);

        /* Action listeners to handle button clicks */

        create.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                NewMessageMainFrame n = null;
                try {
                    n = new NewMessageMainFrame("Create your new message");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                n.setVisible(true);
                n.setSize(950, 700);

            }

        });
        open.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                OpenMessageMainFrame n = null;
                try {
                    n = new OpenMessageMainFrame("Open message");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                n.setVisible(true);
                n.setSize(950, 700);

            }

        });

        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DeleteMessageMainFrame d = new DeleteMessageMainFrame("Delete Message");
                d.setVisible(true);
                d.setSize(350, 120);
            }
        });
    }
}
