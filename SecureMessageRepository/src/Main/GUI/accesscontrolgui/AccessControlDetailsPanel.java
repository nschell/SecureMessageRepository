package Gui.accesscontrolgui;

import Main.AccessControl;
import Main.XMLParse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

/**
 * Created by nschell
 */
public class AccessControlDetailsPanel extends JPanel {
    private JList listread;
    private JList listwrite;
    private JList listcontrol;
    private DefaultListModel ListRead;
    private DefaultListModel ListWrite;
    private DefaultListModel ListControl;
    private JTextField read;
    private JTextField write;
    private JTextField control;

    public AccessControlDetailsPanel() {
        Dimension size = getPreferredSize();
        size.height = 280;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Metadata for New Secure Message: "));

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

        JLabel location = new JLabel("File Location: ");
        JLabel subject = new JLabel("Message Subject: ");
        JLabel filename = new JLabel("Filename: ");

        final JCheckBox raccess = new JCheckBox();
        final JCheckBox waccess = new JCheckBox();
        final JCheckBox caccess = new JCheckBox();

        read = new JTextField(20);
        write = new JTextField(20);
        control = new JTextField(20);
        final JTextField loc = new JTextField(20);
        final JTextField sub = new JTextField(20);
        final JTextField fn = new JTextField(20);
        JButton addread = new JButton("Add to ReadList");
        JButton addwrite = new JButton("Add to WriteList");
        JButton addcontrol = new JButton("Add to ControlList");
        JButton save = new JButton("Save");

        addread.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                            ListRead.addElement(read.getText());
                            read.setText(null);
                    }
                }
        );
        addwrite.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        ListWrite.addElement(write.getText());
                        write.setText(null);
                    }
                }
        );
        addcontrol.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        ListControl.addElement(control.getText());
                        control.setText(null);
                    }
                }
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weightx = 3;
        gbc.weighty = 3;

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


        gbc.gridx = 16;
        gbc.gridy = 16;
        add(save, gbc);


        gbc.gridx = 17;
        gbc.gridy = 17;
        add(raccess, gbc);


        gbc.gridx = 18;
        gbc.gridy = 18;
        add(waccess, gbc);


        gbc.gridx = 19;
        gbc.gridy = 19;
        add(caccess, gbc);

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
                            ListWrite.removeAllElements();
                            ListWrite.addElement("nschell");
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




        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {

                        //Begin Converting JLists to String Array

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
                        Boolean r = false, w = false, c = false;
                        if(raccess.isSelected()) {
                            r = true;
                        }

                        if(waccess.isSelected()) {
                            w = true;
                        }

                        if(caccess.isSelected()) {
                            c = true;
                        }

                        String filename = fn.getText();
                        String directoryLocation = loc.getText();

                        AccessControl accessControl = new AccessControl();
                        accessControl.setReadControl(r);
                        accessControl.setWriteControl(w);
                        accessControl.setOwnControl(c);
                        accessControl.setReadControlList(item);
                        accessControl.setWriteControlList(itemw);
                        accessControl.setOwnControlList(itemc);
                        String filedirectory = directoryLocation + "\\" + filename + "accesscontrol" + ".xml";

                        try {
                            XMLParse.SecureobjectToXML(accessControl,filedirectory);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }


                        //End Converting JLists to String Array


                        }

                }
        );

    }
}
