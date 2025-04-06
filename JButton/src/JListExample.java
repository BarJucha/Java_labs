import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JListExample implements ActionListener {
    JList<String> list;

    public void setGUI() {
        JFrame frame = new JFrame("JList Example");
        JPanel panel = new JPanel();

        String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14"};
        list = new JList<>(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(list);
        panel.add(scrollPane);

        JButton button = new JButton("Get Selected Item");
        button.addActionListener(this);
        panel.add(button);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JListExample example = new JListExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Get Selected Item")) {
            String selectedValue = list.getSelectedValue();
            System.out.println("Selected Item: " + selectedValue);
        }
    }
}
