import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonExample implements ActionListener {
    JFrame frame;
    JRadioButton radioButton1, radioButton2, radioButton3;
    ButtonGroup buttonGroup;

    public void setGUI() {
        frame = new JFrame("JRadioButton Example");
        JPanel panel = new JPanel();

        radioButton1 = new JRadioButton("Option 1");
        radioButton2 = new JRadioButton("Option 2");
        radioButton3 = new JRadioButton("Option 3");

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        buttonGroup.add(radioButton3);

        radioButton1.addActionListener(this);
        radioButton2.addActionListener(this);
        radioButton3.addActionListener(this);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JRadioButtonExample example = new JRadioButtonExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
        System.out.println("Selected Radio Button: " + selectedRadioButton.getText());
    }
}

