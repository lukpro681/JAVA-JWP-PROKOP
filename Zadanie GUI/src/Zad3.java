import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TemperatureConverter extends JPanel {

    private JLabel inputLabel;
    private JLabel outputLabel;
    private JTextField inputField;
    private JTextField outputField;
    private JComboBox<String> inputScaleBox;
    private JComboBox<String> outputScaleBox;
    private JButton convertButton;

    public TemperatureConverter() {
        setLayout(new GridLayout(3, 2, 5, 5)); //swoją drogą fajne do robienia layoutu

        inputLabel = new JLabel("Temperatura:");
        add(inputLabel);

        inputField = new JTextField();
        add(inputField);

        inputScaleBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        add(inputScaleBox);

        outputLabel = new JLabel("Wynik:");
        add(outputLabel);

        outputField = new JTextField();
        outputField.setEditable(false);
        add(outputField);

        outputScaleBox = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});
        add(outputScaleBox);

        convertButton = new JButton("Konwertuj");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertTemperature();
            }
        });
        add(convertButton);
    }

    private void convertTemperature() {
        try {
            double temperature = Double.parseDouble(inputField.getText());
            int inputScaleIndex = inputScaleBox.getSelectedIndex();
            int outputScaleIndex = outputScaleBox.getSelectedIndex();
            double result;

            if (inputScaleIndex == outputScaleIndex) {
                result = temperature;
            } else if (inputScaleIndex == 0 && outputScaleIndex == 1) {
                result = (temperature * 1.8) + 32;
            } else if (inputScaleIndex == 0 && outputScaleIndex == 2) {
                result = temperature + 273.15;
            } else if (inputScaleIndex == 1 && outputScaleIndex == 0) {
                result = (temperature - 32) / 1.8;
            } else if (inputScaleIndex == 1 && outputScaleIndex == 2) {
                result = (temperature + 459.67) * 5 / 9;
            } else if (inputScaleIndex == 2 && outputScaleIndex == 0) {
                result = temperature - 273.15;
            } else {
                result = (temperature * 1.8) - 459.67;
            }

            outputField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Niepoprawne dane!!!.", "BŁĄD", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                init();
            }
        });
    }

    public static void init() {
        JFrame frame = new JFrame("Konwerter Temperatury");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TemperatureConverter converter = new TemperatureConverter();
        frame.add(converter);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
