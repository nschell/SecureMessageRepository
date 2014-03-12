package edu.uml.nschell.deletemessagegui;

import edu.uml.nschell.AccessControl;
import edu.uml.nschell.CurrentUser;
import edu.uml.nschell.XMLParse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.List;

/**
 * Created by
 */
public class DeleteMessageMainFrame extends JFrame {

    public DeleteMessageMainFrame(String title) {
        super(title);

        setLayout(new BorderLayout());
        final JTextField path = new JTextField("Path: ", 20);
        final JTextField fn = new JTextField("Filename: ", 20);
        JButton deleteFile = new JButton("Delete File");

        path.selectAll();
        fn.selectAll();
        Container c = getContentPane();
        c.add(path, BorderLayout.NORTH);
        c.add(fn, BorderLayout.LINE_START);
        c.add(deleteFile, BorderLayout.AFTER_LAST_LINE);

        //Actions to take when delete button pressed

        deleteFile.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {

                        //Combine path and filename to get full path

                        String filepath = path.getText() + "\\" + fn.getText() + ".xml";
                        String accesscontrol = path.getText() + "\\" + fn.getText() + "accesscontrol.xml";

                        //create file objects to be deleted

                        File msg = new File(filepath);
                        File accCntrl = new File(accesscontrol);

                        //parse xml to compare username to list

                        AccessControl a = new AccessControl();
                        CurrentUser c = new CurrentUser();
                        c = XMLParse.AccessControlXMLToObj("c:\\Java\\Secure\\curr.xml");
                        String username = c.getUsername();
                        a = XMLParse.SecureXMLToObject(accesscontrol);
                        String[] control = a.getOwnControlList();
                        List<String> cntrl = Arrays.asList(control);

                        //if username is on the list, files will successfully delete

                        if(cntrl.contains(username)) {
                            if(msg.exists() && accCntrl.exists()) {
                                msg.delete();
                                accCntrl.delete();
                            } else {
                                path.setText("FILE DOES NOT EXIST");
                            }
                        }
                        else{
                            path.setText("ERROR DELETING FILE");
                            fn.setText("NO ACCESS ALLOWED");
                        }


                    }
                }
        );
    }


}
