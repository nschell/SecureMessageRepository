package Gui.mainmenugui;

import Gui.createnewmessagegui.NewMessage;
import Gui.createnewmessagegui.NewMessageMainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                NewMessageMainFrame n = new NewMessageMainFrame("Create your new message");
                n.setVisible(true);
                n.setSize(950, 700);

            }

        });

    }
}
