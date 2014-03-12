package edu.uml.nschell.mainmenugui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nschell
 */
public class MainFrame extends JFrame {

    private DetailsPanel detailsPanel;

    public MainFrame(String title) {
        super(title);

        //Layout Manager
        setLayout(new BorderLayout());

        //Components
        JTextArea textArea = new JTextArea("\n Welcome to our Secure Message Repository. " + "Please be aware that any actions taken are monitored and recorded for auditing purposes.  Use of this system contstitutes consent for said monitoring and recording. " + "For more information regarding policies and procedures, refer to Ins.100.571");
        textArea.setFont(new Font("Serif", Font.BOLD, 13));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        JButton button = new JButton("Open");
        JButton button2 = new JButton("Close");



        detailsPanel = new DetailsPanel();


        //Add to content pane
        Container c = getContentPane();
        c.add(textArea, BorderLayout.CENTER);
        c.add(button, BorderLayout.SOUTH);
        c.add(button2, BorderLayout.SOUTH);
        c.add(detailsPanel, BorderLayout.SOUTH);

        //Adding behavior
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
