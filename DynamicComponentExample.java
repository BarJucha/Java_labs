import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DynamicComponentExample implements ActionListener {
    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu componentMenu;
    JMenuItem buttonItem, checkBoxItem, comboBoxItem, listMenuItem, menuMenuItem,
            radioButtonItem, sliderItem, spinnerItem, textFieldItem, passwordFieldItem;

    public void setGUI() {
        frame = new JFrame("Dynamic Component Example");
        panel = new JPanel();
        menuBar = new JMenuBar();
        componentMenu = new JMenu("Components");

        buttonItem = new JMenuItem("JButton");
        checkBoxItem = new JMenuItem("JCheckBox");
        comboBoxItem = new JMenuItem("JComboBox");
        listMenuItem = new JMenuItem("JList");
        radioButtonItem = new JMenuItem("JRadioButton");
        sliderItem = new JMenuItem("JSlider");
        spinnerItem = new JMenuItem("JSpinner");
        textFieldItem = new JMenuItem("JTextField");
        passwordFieldItem = new JMenuItem("JPasswordField");

        buttonItem.addActionListener(this);
        checkBoxItem.addActionListener(this);
        comboBoxItem.addActionListener(this);
        listMenuItem.addActionListener(this);
        radioButtonItem.addActionListener(this);
        sliderItem.addActionListener(this);
        spinnerItem.addActionListener(this);
        textFieldItem.addActionListener(this);
        passwordFieldItem.addActionListener(this);

        componentMenu.add(buttonItem);
        componentMenu.add(checkBoxItem);
        componentMenu.add(comboBoxItem);
        componentMenu.add(listMenuItem);
        componentMenu.add(radioButtonItem);
        componentMenu.add(sliderItem);
        componentMenu.add(spinnerItem);
        componentMenu.add(textFieldItem);
        componentMenu.add(passwordFieldItem);

        menuBar.add(componentMenu);

        frame.setJMenuBar(menuBar);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        DynamicComponentExample example = new DynamicComponentExample();
        example.setGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String componentName = e.getActionCommand();
        System.out.println("Component: " + componentName);
        createComponent(componentName);
    }

    private void createComponent(String componentName) {
        switch (componentName) {
            case "JButton":
                JButton button = new JButton("Click me!");
                panel.removeAll();
                panel.add(button);
                frame.getContentPane().add(panel);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("JButton Clicked!");
                    }
                });
                break;
            case "JCheckBox":
                JCheckBox checkBox = new JCheckBox("Check me!");
                panel.removeAll();
                panel.add(checkBox);
                frame.getContentPane().add(panel);
                checkBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("JCheckBox Checked: " + checkBox.isSelected());
                    }
                });
                break;
            case "JComboBox":
                JComboBox<String> comboBox = new JComboBox<>(new String[]{"Pies", "Kot", "Kaczka"});
                panel.removeAll();
                panel.add(comboBox);
                frame.getContentPane().add(panel);
                comboBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("JComboBox Selected: " + comboBox.getSelectedItem());
                    }
                });
                break;
            case "JList":
                String[] data = {"Item 1", "Item 2", "Item 3", "Item 4", "Item5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14"};
                JList<String> list = new JList<>(data);
                list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                JScrollPane scrollPane = new JScrollPane(list);
                JButton buttonList = new JButton("Get Selected Item");
                buttonList.addActionListener(this);
                panel.removeAll();
                panel.add(scrollPane);
                panel.add(buttonList);
                frame.getContentPane().add(panel);
                buttonList.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getActionCommand().equals("Get Selected Item")) {
                            String selectedValue = list.getSelectedValue();
                            System.out.println("Selected Item: " + selectedValue);
                        }
                    }
                });
                break;
            case "JRadioButton":
                JRadioButton radioButton1, radioButton2, radioButton3;
                ButtonGroup buttonGroup;
                radioButton1 = new JRadioButton("Option 1");
                radioButton2 = new JRadioButton("Option 2");
                radioButton3 = new JRadioButton("Option 3");

                buttonGroup = new ButtonGroup();
                buttonGroup.add(radioButton1);
                buttonGroup.add(radioButton2);
                buttonGroup.add(radioButton3);

                panel.removeAll();
                panel.add(radioButton1);
                panel.add(radioButton2);
                panel.add(radioButton3);

                frame.getContentPane().add(panel);
                radioButton1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                        System.out.println("Selected Radio Button: " + selectedRadioButton.getText());
                    }
                });
                radioButton2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                        System.out.println("Selected Radio Button: " + selectedRadioButton.getText());
                    }
                });
                radioButton3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JRadioButton selectedRadioButton = (JRadioButton) e.getSource();
                        System.out.println("Selected Radio Button: " + selectedRadioButton.getText());
                    }
                });
            case "JSlider":
                JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
                slider.setMajorTickSpacing(20);
                slider.setMinorTickSpacing(5);
                slider.setPaintTicks(true);
                slider.setPaintLabels(true);
                panel.removeAll();
                panel.add(slider);
                frame.getContentPane().add(panel);
                slider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider) e.getSource();
                        if (!source.getValueIsAdjusting()) {
                            int sliderValue = source.getValue();
                            System.out.println("Slider Value: " + sliderValue);
                        }
                    }
                });


        }
    }
}
