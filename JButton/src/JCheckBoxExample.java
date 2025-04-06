import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class JCheckBoxExample implements ItemListener {
    JCheckBox checkBox = new JCheckBox("Check me!");

    public void setGUI() {
        JFrame frame = new JFrame("JCheckBox Example");
        JPanel panel = new JPanel();

        checkBox.addItemListener(this);
        panel.add(checkBox);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JCheckBoxExample example = new JCheckBoxExample();
        example.setGUI();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (checkBox.isSelected()) {
            System.out.println("CheckBox Checked!");
        } else {
            System.out.println("CheckBox Unchecked!");
        }
    }
}

