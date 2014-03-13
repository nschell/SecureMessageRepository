package edu.uml.nschell.openfilegui;

import edu.uml.nschell.*;

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
import java.util.*;
import java.util.List;

/**
 * Created
 */
public class OpenMessageDetailsPanel extends JPanel {
    private JTextField jSubject;
    private JTextField jDateCreated;
    private JTextField jModifyDate;
    private JTextField path;
    private JTextField filename;

    public OpenMessageDetailsPanel() throws Exception {
        CurrentUser c = new CurrentUser();
        c = XMLParse.AccessControlXMLToObj("c:\\Java\\Secure\\curr.xml");
        String usernametemp = c.getUsername();
        String username = Decryption.decryptText(usernametemp);
        Dimension size = getPreferredSize();
        size.height = 503;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("Open Secure Message"));
        JTextArea textArea = new JTextArea("File Content: ");
        textArea = new JTextArea(12, 55);
        JScrollPane scrollPane = new JScrollPane( textArea );
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JButton open = new JButton("Open File");
        JButton save = new JButton("Save Changes");
        JButton close = new JButton("Close/NoSave");
        jModifyDate = new JTextField(20);
        jSubject = new JTextField(20);
        jDateCreated = new JTextField(20);
        path = new JTextField("enter path");
        filename = new JTextField("enter filename");


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 0.5;
        gbc.weighty = 0.5;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(jModifyDate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(jDateCreated, gbc);

        gbc.gridx = 5;
        gbc.gridy = 5;
        add(jSubject, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(textArea, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(path, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(filename, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(open, gbc);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(save, gbc);


        final JTextArea finalTextArea = textArea;

        save.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String fn = filename.getText();
                        String p = path.getText();
                        String openfilename = p + "\\" + fn + ".xml";
                        String openaccesscontrolfilename = p + "\\" + fn + "accesscontrol" + ".xml";
                        AccessControl a = XMLParse.SecureXMLToObject(openaccesscontrolfilename);
                        SecureDocument s = XMLParse.XMLToObject(openfilename);
                        Boolean rcon = a.getReadControl();
                        Boolean wcon = a.getWriteControl();
                        Boolean ccon = a.getOwnControl();

                        String[] read = a.getReadControlList();
                        String[] readtemp = a.getReadControlList();
                        String[] write = a.getWriteControlList();
                        String[] writetemp = a.getWriteControlList();
                        String[] control = a.getOwnControlList();
                        String[] controltemp = a.getOwnControlList();
                        for(int i = 0; i < read.length; i++) {
                            try {
                                read[i] = Decryption.decryptText(readtemp[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        for(int i = 0; i < write.length; i++) {
                            try {
                                write[i] = Decryption.decryptText(writetemp[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        for(int i = 0; i < control.length; i++) {
                            try {
                                control[i] = Decryption.decryptText(controltemp[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        List<String> cntrl = Arrays.asList(control);
                        List<String> wrte = Arrays.asList(write);
                        List<String> rd = Arrays.asList(read);

                    }
                }
        );

        open.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String fn = filename.getText();
                        String p = path.getText();
                        String openfilename = p + "\\" + fn + ".xml";
                        String openaccesscontrolfilename = p + "\\" + fn + "accesscontrol" + ".xml";
                        AccessControl a = XMLParse.SecureXMLToObject(openaccesscontrolfilename);
                        SecureDocument s = XMLParse.XMLToObject(openfilename);
                        Boolean rcon = a.getReadControl();
                        Boolean wcon = a.getWriteControl();
                        Boolean ccon = a.getOwnControl();


                        String[] read = a.getReadControlList();
                        String[] readtemp = a.getReadControlList();
                        String[] write = a.getWriteControlList();
                        String[] writetemp = a.getWriteControlList();
                        String[] control = a.getOwnControlList();
                        String[] controltemp = a.getOwnControlList();
                        for(int i = 0; i < read.length; i++) {
                            try {
                                read[i] = Decryption.decryptText(readtemp[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        for(int i = 0; i < write.length; i++) {
                            try {
                                write[i] = Decryption.decryptText(writetemp[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        for(int i = 0; i < control.length; i++) {
                            try {
                                control[i] = Decryption.decryptText(controltemp[i]);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        List<String> cntrl = Arrays.asList(control);
                        List<String> wrte = Arrays.asList(write);
                        List<String> rd = Arrays.asList(read);

                        jModifyDate.setText(s.getModifiedDate().toString());
                        jDateCreated.setText(s.getCreateDate().toString());
                        jModifyDate.setEditable(false);
                        jDateCreated.setEditable(false);
                        String subtemp = s.getSubject();
                        String sub = null;
                        try {
                              sub = Decryption.decryptText(subtemp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        jSubject.setText(sub);
                        jSubject.setEditable(false);
                        String usrnmetemp = s.getUsername();
                        String usrnme = null;
                        try {
                            usrnme = Decryption.decryptText(usrnmetemp);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        Boolean del = false;
                        Boolean readfile = false;
                        Boolean writefile = false;

                        //If/Else statements to determine access rights


                        /*If no access controls were set*/
                        if(rcon == false && wcon == false && ccon == false) {
                            String infotemp = s.getInformation();
                            String info = null;
                            try {
                                  info = Decryption.decryptText(infotemp);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            finalTextArea.setText(info);
                            finalTextArea.setEditable(false);

                        }

                        /*If full control/delete access controls were set*/
                        else if(rcon == false && wcon == false && ccon == true) {

                            String infotemp = s.getInformation();
                            String info = null;
                            try {
                                info = Decryption.decryptText(infotemp);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            finalTextArea.setText(info);
                            finalTextArea.setEditable(true);
                            if(cntrl.contains(usrnme)) {
                                del = true;
                            }
                            else {
                                del = false;
                            }
                        }

                        /*If full control/delete access conrols and write controls were set*/
                        else if(rcon == false && wcon == true && ccon == true) {
                            String infotemp = s.getInformation();
                            String info = null;
                            try {
                                info = Decryption.decryptText(infotemp);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            finalTextArea.setText(info);
                            if(wrte.contains(usrnme)) {
                                finalTextArea.setEditable(true);
                            }
                            else {
                                finalTextArea.setEditable(false);
                            }
                            if(cntrl.contains(usrnme)) {
                                del = true;
                            }
                            else {
                                del = false;
                            }
                        }

                        /*If full control/delete access controls, write controls and read controls were set*/
                        else if(rcon == true && wcon == true && ccon == true) {
                            if(rd.contains(usrnme)) {
                                String infotemp = s.getInformation();
                                String info = null;
                                try {
                                    info = Decryption.decryptText(infotemp);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                finalTextArea.setText(info);
                            }
                            else {
                                finalTextArea.setText("Error:  Access Denied!");
                            }
                            if(wrte.contains(usrnme)) {
                                finalTextArea.setEditable(true);
                            }
                            else {
                                finalTextArea.setEditable(false);
                            }
                            if(cntrl.contains(usrnme)) {
                                del = true;
                                System.out.println("True");
                            }
                            else {
                                del = false;
                            }
                        }


                            }




                }
        );
    }

}
