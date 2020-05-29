import javax.swing.*;

public class HomePage extends JFrame{
    private JPanel rootPanel;
    HomePage(User user)
    {
        setTitle("Home Page");
        setSize(400, 500);
        add(rootPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
