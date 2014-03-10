package Gui.logingui;

/**
 * Created by
 */


    import Gui.mainmenugui.MainFrame;
    import Main.CurrentUser;
    import Main.UsernamePassword;
    import Main.XMLParse;

    import javax.swing.JButton;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.JPasswordField;
    import javax.swing.JTextField;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class Login{

        public static void main(String[] args) {
            JFrame frame = new JFrame("Demo application");
            frame.setSize(300, 150);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel);

            frame.setVisible(true);
        }

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

            JButton registerButton = new JButton("Create New User");
            registerButton.setBounds(180, 80, 80, 25);
            panel.add(registerButton);

            loginButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            UsernamePassword u = new UsernamePassword();
                            u.AuthenticationXMLtoObject;
                            String pw = u.getPassword();
                            String un = u.getUsername();
                            Boolean act = u.getActive();
                            CurrentUser c = new CurrentUser();

                            if((pw == passwordText.getText()) && (un == userText.getText()) && (act = true))
                            {
                                    MainFrame m = new MainFrame("Company Confidential Secure Message Repository");
                                    m.setVisible(true);
                                    m.setSize(650, 400);

                                    c.setUsername(un);
                                    XMLParse.AccessControlObjToXML(c, "c:\\Java\\Secure\\curr.xml");

                            }
                            else {
                                System.exit(0);
                            }
                    }
            )

        }

    }

