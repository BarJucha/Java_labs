import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SimpleBrowser extends JFrame {

    private JTabbedPane tabbedPane;
    private int tabCount = 0;

    public SimpleBrowser() {
        setTitle("Browser");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        tabbedPane = new JTabbedPane();
        addNewTab();
        JButton newTabButton = new JButton("NEW TAB");
        newTabButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewTab();
            }
        });
        JPanel newTabButtonPanel = new JPanel();
        newTabButtonPanel.add(newTabButton);
        getContentPane().add(newTabButtonPanel, BorderLayout.NORTH);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }

    private void addNewTab() {
        JPanel panel = new JPanel(new BorderLayout());

        JTextField urlTextField = new JTextField();
        JButton goButton = new JButton("GO");
        JButton closeButton = new JButton("CLOSE");
        JTextPane content = new JTextPane();
        content.setContentType("text/html");
        content.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(content);

        goButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myPage = urlTextField.getText();
                try {
                    content.setPage(myPage);
                } catch (IOException ex) {
                    content.setContentType("text/html");
                    content.setText("<html>Could not load webpage</html>");
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = tabbedPane.getSelectedIndex();
                if(tabCount > 1){
                    tabbedPane.remove(index);
                    tabCount--;
                }
            }
        });

        content.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED){
                    String myPage = e.getURL().toString();
                    try {
                        content.setPage(myPage);
                        urlTextField.setText(myPage);
                    } catch (IOException ex) {
                        content.setContentType("text/html");
                        content.setText("<html>Could not load webpage</html>");
                    }
                }
            }
        });
        JPanel urlPanel = new JPanel(new BorderLayout());
        JPanel buttonsPanel = new JPanel(new GridLayout(1,2));
        buttonsPanel.add(goButton);
        buttonsPanel.add(closeButton);
        urlPanel.add(urlTextField, BorderLayout.CENTER);
        urlPanel.add(buttonsPanel, BorderLayout.EAST);
        panel.add(urlPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        tabbedPane.addTab("Karta " + tabCount, panel);
        tabCount++;
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpleBrowser().setVisible(true);
            }
        });
    }
}
