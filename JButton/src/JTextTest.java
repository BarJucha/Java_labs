import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JTextTest implements ActionListener{
    JFrame frame;
    JTextField textField;

    public void setGUI(){
        frame = new JFrame("Text Field");
        JPanel panel = new JPanel();
        textField = new JTextField("Wpisz tekst", 20);
        panel.add(textField);

        JButton submitButton = new JButton("Zatwierdź");
        submitButton.addActionListener(this);
        panel.add(submitButton);

        textField.addActionListener(this);

        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        JTextTest test = new JTextTest();
        test.setGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Zatwierdź")) {
            String text = textField.getText();
            System.out.println("Entered Text: " + text);
        }
        else {
            String currentText = e.getActionCommand();
            System.out.println("Current text: " + currentText);
        }
    }
}
