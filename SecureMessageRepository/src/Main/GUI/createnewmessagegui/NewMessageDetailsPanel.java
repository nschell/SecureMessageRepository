package Gui.createnewmessagegui;

import Gui.accesscontrolgui.AccessControlDetailsPanel;
import Main.SecureDocument;
import Main.XMLParse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nschell
 */
public class NewMessageDetailsPanel extends JPanel{
    public NewMessageDetailsPanel() {
        Dimension size = getPreferredSize();
        final String Username = "Temp";
        size.height = 280;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("New Secure Message: Logged In as: " + Username));
        JTextArea textArea = new JTextArea("Please enter text here:  ");
        textArea = new JTextArea(12, 55);
        JScrollPane scrollPane = new JScrollPane( textArea );
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);
        final JTextArea sub = new JTextArea("Subject:  ");
        sub.setFont(new Font("Serif", Font.BOLD, 13));
        sub.setLineWrap(true);
        sub.setWrapStyleWord(true);
        sub.setEditable(true);

        JButton save = new JButton("Save");
        JButton clear = new JButton("Clear");
        JButton close = new JButton("Close/NoSave");



        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(sub, gbc);

        gbc.gridx = 5;
        gbc.gridy = 5;
        add(textArea, gbc);

        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.weightx = 1;
        gbc.weighty = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(save, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(clear, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(close, gbc);

        final JTextArea finalTextArea = textArea;
        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                      String msg = finalTextArea.getText();
                      String subject = sub.getText();
                      Date date = new java.util.Date();
                      Date curDate = new Timestamp(date.getTime());
                      Date modifyDate = new Timestamp(date.getTime());
                      String name = Username;
                      Boolean AccCon = true;
                      String filename = "C:\\Java\\bbbbbbb.xml";

                        SecureDocument d = new SecureDocument();
                        d.setAccessControl(AccCon);
                        d.setCreateDate(curDate);
                        d.setModifiedDate(modifyDate);
                        d.setInformation(msg);
                        d.setSubject(subject);
                        d.setUsername(name);
                        try {
                            XMLParse.objectToXML(d, filename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });



    }
}
