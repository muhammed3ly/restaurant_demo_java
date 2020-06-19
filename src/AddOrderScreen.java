import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AddOrderScreen extends JFrame{
    private JPanel rootPanel;
    private JButton addOrderButton;
    private JComboBox mealsListCB;
    private JComboBox selectedMealsCB;
    private Vector<Meal> selectedMeals;
    AddOrderScreen()
    {
        selectedMeals = new Vector<>();
        setTitle("Home Page");
        setSize(400, 500);
        add(rootPanel);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Vector<Meal> meals = Restaurant.getOurRestaurant().getMeals();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for(int i = 0 ; i < meals.size() ; i++)
            mealsListCB.addItem(meals.elementAt(i).getName());

        mealsListCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = mealsListCB.getSelectedIndex();
                selectedMealsCB.addItem(meals.elementAt(index).getName());
                selectedMeals.add(meals.elementAt(index));
            }
        });
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Restaurant.getOurRestaurant().addOrder(selectedMeals);
            }
        });
    }
}
