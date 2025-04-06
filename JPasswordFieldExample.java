import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPasswordFieldExample implements ActionListener {
    JFrame frame;
    JPasswordField passwordField;

    public void setGUI() {
        frame = new JFrame("JPasswordField Example");
        JPanel panel = new JPanel();

        passwordField = new JPasswordField(20);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        panel.add(passwordField);
        panel.add(submitButton);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JPasswordFieldExample example = new JPasswordFieldExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Submit")) {
            char[] passwordChars = passwordField.getPassword();
            String password = new String(passwordChars);
            System.out.println("Entered Password: " + password);
        }
    }
}

