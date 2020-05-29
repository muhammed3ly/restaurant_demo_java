import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Portal extends JFrame {
    private JPanel rootPanel;
    private JTabbedPane tabbedPane1;
    private JTextField loginMobileTF;
    private JPasswordField loginPasswordTF;
    private JButton loginButton;
    private JTextField registerMobileNumberTF;
    private JTextField nameTF;
    private JTextField BNSTF;
    private JPasswordField registerPasswordTF;
    private JPasswordField confirmPasswordTF;
    private JRadioButton customerRadioButton;
    private JRadioButton emloyeeRadioButton;
    private JButton registerButton;
    private JLabel bnsLabel;

    Portal(Restaurant restaurant)
    {
        setTitle("Route");
        setSize(400, 500);
        add(rootPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customerRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bnsLabel.setText("Block Number");
            }
        });
        emloyeeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bnsLabel.setText("Salary");
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(customerRadioButton.isSelected() == true)
                {
                    Customer newCustomer = new Customer(String.valueOf(registerMobileNumberTF.getText()), String.valueOf(nameTF.getName()),
                            String.valueOf(registerPasswordTF.getPassword()), Integer.parseInt(String.valueOf(BNSTF.getText())));
                    try
                    {
                        restaurant.addUser(newCustomer);
                    }
                    catch (IllegalArgumentException e2)
                    {
                        JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else
                {
                    Employee newEmployee = new Employee(String.valueOf(registerMobileNumberTF.getText()), String.valueOf(nameTF.getName()),
                            String.valueOf(registerPasswordTF.getPassword()), Double.parseDouble(String.valueOf(BNSTF.getText())));
                    try
                    {
                        restaurant.addUser(newEmployee);
                    }
                    catch (IllegalArgumentException e2)
                    {
                        JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    User user = restaurant.login(String.valueOf(loginMobileTF.getText()), String.valueOf(loginPasswordTF.getPassword()));
                    System.out.print("Logged In");
                    HomePage form = new HomePage(user);
                    form.setVisible(true);
                    setVisible(false);
                }
                catch (Exception e2)
                {
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
