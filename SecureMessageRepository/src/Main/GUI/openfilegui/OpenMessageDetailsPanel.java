package Gui.openfilegui;

import Main.AccessControl;
import Main.SecureDocument;
import Main.XMLParse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created
 */
public class OpenMessageDetailsPanel extends JPanel {
    private JTextField jSubject;
    private JTextField jDateCreated;
    private JTextField jModifyDate;
    private JTextField path;
    private JTextField filename;

    public OpenMessageDetailsPanel() {
        String username = "nschell";
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


        final JTextArea finalTextArea = textArea;
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
                        String[] write = a.getWriteControlList();
                        String[] control = a.getOwnControlList();

                        jModifyDate.setText(s.getModifiedDate().toString());
                        jDateCreated.setText(s.getCreateDate().toString());
                        jSubject.setText(s.getSubject());

                        if(rcon == false && wcon == false && ccon == false) {
                            finalTextArea.setText(s.getInformation());
                            finalTextArea.setEditable(true);

                        }



                    }
                }
        );
    }

}
