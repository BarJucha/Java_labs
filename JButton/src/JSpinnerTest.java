import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class JSpinnerTest implements ChangeListener {
    JFrame frame;
    JSpinner spinner;
    public void setGUI(){
        frame = new JFrame("JSpinner TEST");
        JPanel panel = new JPanel();

        String[] monthStrings = {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec", "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};
        SpinnerModel monthModel = new SpinnerDateModel();
        spinner = new JSpinner(monthModel);

        spinner.addChangeListener(this);

        panel.add(spinner);
        frame.getContentPane().add(panel);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        JSpinnerTest test = new JSpinnerTest();
        test.setGUI();
    }
    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();
        Date date  = (Date) source.getValue();
        System.out.println("Spinner Value: " + date);
    }
}
