package com.co.examples.funciones;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class Calculadora {

    private final JTextField display = new JTextField("0");
    private double currentValue = 0.0;
    private String pendingOp = null;
    private boolean startNewNumber = true;
    private boolean errorState = false;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Calculadora().show());
    }

    private void show() {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(8, 8));

        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setFont(new Font("SansSerif", Font.PLAIN, 24));
        display.setPreferredSize(new Dimension(240, 50));

        frame.add(display, BorderLayout.NORTH);
        frame.add(createButtonsPanel(), BorderLayout.CENTER);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 4, 6, 6));
        String[] labels = {
                "C", "Back", "/", "*",
                "7", "8", "9", "-",
                "4", "5", "6", "+",
                "1", "2", "3", "=",
                "0", ".", "", ""
        };

        for (String label : labels) {
            JButton button = new JButton(label.isEmpty() ? " " : label);
            button.setFont(new Font("SansSerif", Font.PLAIN, 18));
            button.setFocusPainted(false);
            if (label.isEmpty()) {
                button.setEnabled(false);
            } else {
                button.addActionListener(e -> handleInput(label));
            }
            panel.add(button);
        }

        return panel;
    }

    private void handleInput(String input) {
        if ("C".equals(input)) {
            clearAll();
            return;
        }

        if ("Back".equals(input)) {
            backspace();
            return;
        }

        if (isDigitOrDot(input)) {
            appendDigit(input);
            return;
        }

        if ("=".equals(input)) {
            evaluate();
            return;
        }

        applyOperator(input);
    }

    private void clearAll() {
        currentValue = 0.0;
        pendingOp = null;
        startNewNumber = true;
        errorState = false;
        display.setText("0");
    }

    private void backspace() {
        if (errorState) {
            clearAll();
            return;
        }
        if (startNewNumber) {
            return;
        }
        String text = display.getText();
        if (text.length() <= 1) {
            display.setText("0");
            startNewNumber = true;
            return;
        }
        display.setText(text.substring(0, text.length() - 1));
    }

    private void appendDigit(String digit) {
        if (errorState) {
            clearAll();
        }
        String text = display.getText();
        if (startNewNumber) {
            text = "0";
        }

        if (".".equals(digit) && text.contains(".")) {
            return;
        }

        if (startNewNumber) {
            display.setText(digit.equals(".") ? "0." : digit);
            startNewNumber = false;
        } else {
            if ("0".equals(text) && !".".equals(digit)) {
                display.setText(digit);
            } else {
                display.setText(text + digit);
            }
        }
    }

    private void applyOperator(String op) {
        if (errorState) {
            return;
        }
        double inputValue = parseDisplay();
        if (pendingOp == null) {
            currentValue = inputValue;
        } else if (!startNewNumber) {
            if (!applyPendingOperation(inputValue)) {
                return;
            }
        }
        pendingOp = op;
        startNewNumber = true;
    }

    private void evaluate() {
        if (errorState) {
            return;
        }
        double inputValue = parseDisplay();
        if (pendingOp != null && !applyPendingOperation(inputValue)) {
            return;
        }
        pendingOp = null;
        startNewNumber = true;
    }

    private boolean applyPendingOperation(double inputValue) {
        switch (pendingOp) {
            case "+":
                currentValue += inputValue;
                break;
            case "-":
                currentValue -= inputValue;
                break;
            case "*":
                currentValue *= inputValue;
                break;
            case "/":
                if (inputValue == 0.0) {
                    setError();
                    return false;
                }
                currentValue /= inputValue;
                break;
            default:
                currentValue = inputValue;
                break;
        }

        display.setText(formatNumber(currentValue));
        return true;
    }

    private void setError() {
        errorState = true;
        display.setText("Error");
    }

    private double parseDisplay() {
        String text = display.getText();
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            setError();
            return 0.0;
        }
    }

    private String formatNumber(double value) {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            return "Error";
        }
        long asLong = (long) value;
        if (value == asLong) {
            return Long.toString(asLong);
        }
        return Double.toString(value);
    }

    private boolean isDigitOrDot(String input) {
        return input.length() == 1 && (Character.isDigit(input.charAt(0)) || ".".equals(input));
    }
}
