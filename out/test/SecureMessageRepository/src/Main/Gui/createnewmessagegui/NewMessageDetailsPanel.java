package Gui.createnewmessagegui;

import Main.AccessControl;
import Main.CurrentUser;
import Main.SecureDocument;
import Main.XMLParse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by nschell
 */
public class NewMessageDetailsPanel extends JPanel{
    private JList listread;
    private JList listwrite;
    private JList listcontrol;
    private DefaultListModel ListRead;
    private DefaultListModel ListWrite;
    private DefaultListModel ListControl;
    private JTextField read;
    private JTextField write;
    private JTextField control;
    private String filedirectory;
    public NewMessageDetailsPanel() {


        CurrentUser c = new CurrentUser();
        c = XMLParse.AccessControlXMLToObj("c:\\Java\\Secure\\curr.xml");
        //logged in as:
        final String Username = c.getUsername();

        //setting size and title
        Dimension size = getPreferredSize();
        size.height = 503;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("New Secure Message: Logged In as: " + Username));

        //main message text area properties
        JTextArea textArea = new JTextArea("Please enter text here:  ");
        textArea = new JTextArea(12, 55);
        JScrollPane scrollPane = new JScrollPane( textArea );
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(true);

        //subject text area properties
        final JTextArea sub = new JTextArea("Subject:  ");
        sub.setFont(new Font("Serif", Font.BOLD, 13));
        sub.setLineWrap(true);
        sub.setWrapStyleWord(true);
        sub.setEditable(true);

        //buttons defined
        JButton save = new JButton("Save");
        JButton clear = new JButton("Clear");
        JButton close = new JButton("Close/NoSave");

        //Access control lists are created and customized
        ListRead = new DefaultListModel();
        ListWrite = new DefaultListModel();
        ListControl = new DefaultListModel();
        listread = new JList(ListRead);
        listwrite = new JList(ListWrite);
        listcontrol = new JList(ListControl);

        listread.setVisibleRowCount(10);
        listread.setFixedCellHeight(15);
        listread.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listwrite.setVisibleRowCount(10);
        listwrite.setFixedCellHeight(15);
        listwrite.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        listcontrol.setVisibleRowCount(10);
        listcontrol.setFixedCellHeight(15);
        listcontrol.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        //Labels for various metadata
        JLabel location = new JLabel("File Location: ");
        JLabel subject = new JLabel("Message Subject: ");
        JLabel filename = new JLabel("Filename: ");

        //checkboxes to enable/disable access controls
        final JCheckBox raccess = new JCheckBox();
        final JCheckBox waccess = new JCheckBox();
        final JCheckBox caccess = new JCheckBox();

        //set access control properties
        //users can input usernames and save them to list
        read = new JTextField(20);
        write = new JTextField(20);
        control = new JTextField(20);
        final JTextField loc = new JTextField(20);
        final JTextField fn = new JTextField(20);
        JButton addread = new JButton("Add to ReadList");
        JButton addwrite = new JButton("Add to WriteList");
        JButton addcontrol = new JButton("Add to ControlList");

        //Adds contents of read JTextField to list, clears field
        addread.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        ListRead.addElement(read.getText());
                        read.setText(null);
                    }
                }
        );

        //Adds contents of write JTextField to list, clears field
        addwrite.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        ListWrite.addElement(write.getText());
                        write.setText(null);
                    }
                }
        );

        //Adds contents of control JTextField to list, clears field
        addcontrol.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        ListControl.addElement(control.getText());
                        control.setText(null);
                    }
                }
        );


        //controls the actions of checking/unchecking the boxes for various access controls
        //checking the box will disable access controls.
        raccess.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        if(raccess.isSelected()) {
                            read.setEditable(false);
                            ListRead.removeAllElements();
                            ListRead.addElement("nschell");
                        }
                        else {
                            read.setEditable(true);
                            ListRead.removeAllElements();
                        }
                    }
                }
        );

        waccess.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        if(waccess.isSelected()) {
                            write.setEditable(false);
                            raccess.setSelected(true);
                            ListWrite.removeAllElements();
                            ListWrite.addElement("nschell");
                            read.setEditable(false);
                            ListRead.removeAllElements();
                            ListRead.addElement("nschell");
                        }
                        else {
                            write.setEditable(true);
                            ListWrite.removeAllElements();
                        }
                    }
                }
        );

        caccess.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        if(caccess.isSelected()) {
                            control.setEditable(false);
                            ListControl.removeAllElements();
                            ListControl.addElement("nschell");
                        }
                        else {
                            control.setEditable(true);
                            ListControl.removeAllElements();
                        }
                    }
                }
        );



        //Setup GUI using GBC

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

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(location, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        add(loc, gbc);

        gbc.gridx = 3;
        gbc.gridy = 3;
        add(subject, gbc);

        gbc.gridx = 4;
        gbc.gridy = 4;
        add(sub, gbc);

        gbc.gridx = 5;
        gbc.gridy = 5;
        add(filename, gbc);

        gbc.gridx = 6;
        gbc.gridy = 6;
        add(fn, gbc);

        gbc.gridx = 7;
        gbc.gridy = 7;
        add(addcontrol, gbc);

        gbc.gridx = 8;
        gbc.gridy = 8;
        add(read, gbc);

        gbc.gridx = 9;
        gbc.gridy = 9;
        add(write, gbc);


        gbc.gridx = 10;
        gbc.gridy = 10;
        add(control, gbc);

        gbc.gridx = 11;
        gbc.gridy = 11;
        add(addread, gbc);

        gbc.gridx = 12;
        gbc.gridy = 12;
        add(addwrite, gbc);

        gbc.gridx = 13;
        gbc.gridy = 13;
        add(listread, gbc);

        gbc.gridx = 14;
        gbc.gridy = 14;
        add(listwrite, gbc);

        gbc.gridx = 15;
        gbc.gridy = 15;
        add(listcontrol, gbc);


        gbc.gridx = 17;
        gbc.gridy = 17;
        add(raccess, gbc);


        gbc.gridx = 18;
        gbc.gridy = 18;
        add(waccess, gbc);


        gbc.gridx = 19;
        gbc.gridy = 19;
        add(caccess, gbc);


        //Dictates properties of close button
        close.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {


                       System.exit(0);
                    }
                });

        final JTextArea finalTextArea = textArea;
        final JTextArea finalTextArea1 = textArea;

        //Clears the textareas
        clear.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        finalTextArea1.setText("");

                    }
                }
        );

        //Saves the newly created message
        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {


                        int listreadSize = listread.getModel().getSize();
                        String[] item = new String[listreadSize];

                        for(int i=0; i < listreadSize; i++) {
                            item[i] = listread.getModel().getElementAt(i).toString();
                        }

                        int listwriteSize = listwrite.getModel().getSize();
                        String[] itemw = new String[listwriteSize];

                        for(int x=0; x < listwriteSize; x++) {
                            itemw[x] = listwrite.getModel().getElementAt(x).toString();
                        }

                        int listcontrolSize = listcontrol.getModel().getSize();
                        String[] itemc = new String[listcontrolSize];

                        for(int y=0; y < listcontrolSize; y++) {
                            itemc[y] = listcontrol.getModel().getElementAt(y).toString();
                        }

                        //Determines if access control is enabled.  If the box is checked, ac is disabled, and will return false
                        //Note:  The list still defaults to a single username for each property
                        Boolean r = true, w = true, c = true;
                        if(raccess.isSelected()) {
                            r = false;
                        }

                        if(waccess.isSelected()) {
                            w = false;
                        }

                        if(caccess.isSelected()) {
                            c = false;
                        }
                      String msg = finalTextArea.getText();
                      String subject = sub.getText();
                      Date date = new java.util.Date();
                      Date curDate = new Timestamp(date.getTime());
                      Date modifyDate = new Timestamp(date.getTime());
                      String name = Username;
                      Boolean AccCon = true;
                        String filename = fn.getText();
                        String directoryLocation = loc.getText();



                        SecureDocument d = new SecureDocument();
                        AccessControl a = new AccessControl();
                        d.setAccessControl(AccCon);
                        d.setCreateDate(curDate);
                        d.setModifiedDate(modifyDate);
                        d.setInformation(msg);
                        d.setSubject(subject);
                        d.setUsername(name);
                        a.setReadControl(r);
                        a.setWriteControl(w);
                        a.setOwnControl(c);
                        a.setReadControlList(item);
                        a.setWriteControlList(itemw);
                        a.setOwnControlList(itemc);
                        String filedirectory = directoryLocation + "\\" + filename + "accesscontrol" + ".xml";
                        String objectfilename = directoryLocation + "\\" + filename + ".xml";

                        try {
                            XMLParse.SecureobjectToXML(a,filedirectory);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        try {
                            XMLParse.objectToXML(d, objectfilename);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                });



    }
}
