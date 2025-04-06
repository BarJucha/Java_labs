import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JComboBoxTest implements ActionListener {
    JComboBox<String> comboBox;

    public void setGUI() {
        JFrame frame = new JFrame("JComboBox Example");
        JPanel panel = new JPanel();
        String[] options = {"Pies", "Kot", "Kaczka"};
        comboBox = new JComboBox<>(options);
        comboBox.addActionListener(this);
        panel.add(comboBox);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JComboBoxTest example = new JComboBoxTest();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) comboBox.getSelectedItem();
        System.out.println("Selected Option: " + selectedOption);
    }
}
