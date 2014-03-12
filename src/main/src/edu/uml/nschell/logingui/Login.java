package edu.uml.nschell.logingui;

/**
 * Created by nschell
 * This Login Class fulfills two functionalities:
 * The Create User functionality will allow for the creation of a new user, saving userdata xml file in given directory
 * There is a Master Password that only the "Security Manager" will have.  This password is required for all user creations.
 * The Login functionality parses the userdata xml file, ensures that user is active and entering the right info.
 * If username is wrong, error will pop up.  If password is wrong, program will terminate.
 */


    import edu.uml.nschell.mainmenugui.MainFrame;
    import edu.uml.nschell.CurrentUser;
    import edu.uml.nschell.UsernamePassword;
    import edu.uml.nschell.XMLParse;

    import javax.swing.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.io.File;
    import java.io.FileNotFoundException;

public class Login{


        public static void main(String[] args) {
            JFrame frame = new JFrame("Login");
            frame.setSize(500,450);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        }

        /* Setup Panel GUI*/

        private static void placeComponents(JPanel panel) {

            panel.setLayout(null);

            JLabel userLabel = new JLabel("User");
            userLabel.setBounds(10, 10, 80, 25);
            panel.add(userLabel);

            final JTextField userText = new JTextField(20);
            userText.setBounds(100, 10, 160, 25);
            panel.add(userText);

            JLabel passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(10, 40, 80, 25);
            panel.add(passwordLabel);

            final JPasswordField passwordText = new JPasswordField(20);
            passwordText.setBounds(100, 40, 160, 25);
            panel.add(passwordText);

            JButton loginButton = new JButton("login");
            loginButton.setBounds(10, 80, 80, 25);
            panel.add(loginButton);

            JLabel nuserLabel = new JLabel("New Username");
            nuserLabel.setBounds(210, 190, 100, 45);
            panel.add(nuserLabel);

            JLabel usr = new JLabel("OR Create New User (NOTE: Please Contact Program Security Officer): ");
            usr.setBounds(20, 140, 420, 45 );
            panel.add(usr);

            final JTextField nuserText = new JTextField("New User", 20);
            nuserText.setBounds(340, 200, 80, 25);
            nuserText.setEditable(true);
            nuserText.selectAll();
            panel.add(nuserText);

            JLabel npasswordLabel = new JLabel("New Password");
            npasswordLabel.setBounds(210, 230, 100, 45);
            panel.add(npasswordLabel);

            final JPasswordField npasswordText = new JPasswordField(20);
            npasswordText.setBounds(340, 240, 80, 25);
            npasswordText.setEditable(true);
            npasswordText.selectAll();
            panel.add(npasswordText);

            JLabel mPassword = new JLabel("Master Password: ");
            mPassword.setBounds(210, 270, 130, 45);
            panel.add(mPassword);

            final JTextField mPwText = new JTextField(20);
            mPwText.setBounds(340, 280, 80, 25);
            mPwText.setEditable(true);
            panel.add(mPwText);

            final JCheckBox active = new JCheckBox();
            active.setSelected(true);
            panel.add(active);

            JButton registerButton = new JButton("Create User");
            registerButton.setBounds(350, 320, 130, 45);
            panel.add(registerButton);

            /*listener for the login button*/

            loginButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            UsernamePassword u = new UsernamePassword();
                            String filename = "c:\\Java\\Secure\\User" + userText.getText() + ".xml";

                            //Check to ensure secure file directory was created.  An uncreated directory indicates that username is not found
                            //If so, parse XML to compare username/password with user inputs

                            File f = new File(filename);
                            if(f.exists() && !f.isDirectory()) {
                                u = XMLParse.AuthenticationXMLToObject("c:\\Java\\Secure\\User" + userText.getText() + ".xml");
                                String pw = u.getPassword();
                                String un = u.getUsername();
                                Boolean act = u.getActive();
                                CurrentUser c = new CurrentUser();

                                //Opens up main menu

                                if((pw.equals(passwordText.getText())) && (un.equals(userText.getText())) && (act = true))
                                {
                                    MainFrame m = new MainFrame("Company Confidential Secure Message Repository");
                                    m.setVisible(true);
                                    m.setSize(650, 400);

                                    c.setUsername(un);
                                    userText.setText("");
                                    passwordText.setText("");

                                    //Sets the current user file

                                    try {
                                        XMLParse.AccessControlObjToXML(c, "c:\\Java\\Secure\\curr.xml");
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }

                                }
                                else {
                                    System.exit(0);
                                }
                            } else {
                                userText.setText("BAD USERNAME!!");
                            }
                    }
                });

            /* Creates a new user */

            registerButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {

                            /*Passcode is the master password that allows for user creation */

                            String passcode = "123456";
                            UsernamePassword c = new UsernamePassword();
                            String mpw = mPwText.getText();
                            String usr = nuserText.getText();
                            String pw = npasswordText.getText();
                            c.setUsername(usr);
                            c.setPassword(pw);
                            if(active.isSelected()) {
                                c.setActive(true);
                            }
                            else {
                                c.setActive(false);
                            }

                            /* Check that directory structure created, create XML file for each new user */

                            if(mpw.equals(passcode)) {

                                try {
                                    String path = "c:\\Java\\Secure\\";
                                    File f = new File(path);
                                    if(!f.exists()) {
                                        try {
                                            f.mkdirs();
                                        }
                                        catch (SecurityException e) {

                                        }
                                    }
                                    XMLParse.AuthenticationObjectToXML(c, "c:\\Java\\Secure\\User" + nuserText.getText() + ".xml");
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }

                                nuserText.setText("");
                                npasswordText.setText("");
                                mPwText.setText("");
                            }

                            else {

                                System.exit(0);
                            }

                        }
                    }
            );
        }


    }


