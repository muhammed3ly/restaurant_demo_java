import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    private JPanel rootPanel;
    private JButton addOrderButton;

    HomePage(User user)
    {
        setTitle("Home Page");
        setSize(400, 500);
        add(rootPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddOrderScreen form = new AddOrderScreen();
                form.setVisible(true);
                setVisible(false);
            }
        });
    }
}
