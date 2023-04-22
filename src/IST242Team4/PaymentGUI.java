package IST242Team4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame {

    private JPanel mainPanel;
    private JComboBox<String> paymentMethodComboBox;
    private JLabel paymentMethodLabel;
    private JButton submitButton;
    private JPanel paymentMethodPanel;
    private CardLayout paymentMethodLayout;

    private JPanel cardInfoPanel;
    private JLabel cardNameLabel;
    private JTextField cardNameTextField;
    private JLabel cardNumberLabel;
    private JTextField cardNumberTextField;
    private JLabel cvvLabel;
    private JTextField cvvTextField;
    private JLabel expiryDateLabel;
    private JTextField expiryDateTextField;

    private JPanel checkInfoPanel;
    private JLabel bankNameLabel;
    private JTextField bankNameTextField;
    private JLabel accountIdLabel;
    private JTextField accountIdTextField;
    private JLabel routingNumberLabel;
    private JTextField routingNumberTextField;

    private JPanel cashInfoPanel;
    private JLabel inputMoneyLabel;
    private JTextField inputMoneyTextField;

    public PaymentGUI(double productPrice) {
        setTitle("Payment Method");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(mainPanel);

        String[] paymentMethods = {"Credit Card", "Cash", "Check"};
        paymentMethodLabel = new JLabel("Payment Method:");
        paymentMethodLabel.setFont(new Font("Arial", Font.BOLD, 14));
        paymentMethodComboBox = new JComboBox<>(paymentMethods);
        paymentMethodComboBox.addActionListener(new ComboBoxListener());
        JPanel comboBoxPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        comboBoxPanel.add(paymentMethodLabel);
        comboBoxPanel.add(paymentMethodComboBox);
        mainPanel.add(comboBoxPanel, BorderLayout.NORTH);

        JLabel productPriceLabel = new JLabel("Price: $" + productPrice);
        productPriceLabel.setFont(new Font("Arial", Font.BOLD, 14));
        comboBoxPanel.add(productPriceLabel);

        paymentMethodLayout = new CardLayout();
        paymentMethodPanel = new JPanel(paymentMethodLayout);
        mainPanel.add(paymentMethodPanel, BorderLayout.CENTER);

        createCardInfoPanel();
        createCashInfoPanel();
        createCheckInfoPanel();
        paymentMethodPanel.add(cardInfoPanel, "Credit Card");
        paymentMethodPanel.add(cashInfoPanel, "Cash");
        paymentMethodPanel.add(checkInfoPanel, "Check");

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.BOLD, 14));
        submitButton.addActionListener(new SubmitButtonListener());
        mainPanel.add(submitButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void createCardInfoPanel() {
        cardInfoPanel = new JPanel(new GridLayout(4, 2, 5, 10));

        cardNameLabel = new JLabel("Card Name:");
        cardNameTextField = new JTextField();
        cardNumberLabel = new JLabel("Card Number:");
       // Luhn.Check(String.valueOf(cardNumberTextField));
        cardNumberTextField = new JTextField();
        cvvLabel = new JLabel("CVV:");
        cvvTextField = new JTextField();
        expiryDateLabel = new JLabel("Expiry Date (MM/YY):");
        expiryDateTextField = new JTextField();


        cardInfoPanel.add(cardNameLabel);
        cardInfoPanel.add(cardNameTextField);
        cardInfoPanel.add(cardNumberLabel);
        cardInfoPanel.add(cardNumberTextField);
        cardInfoPanel.add(cvvLabel);
        cardInfoPanel.add(cvvTextField);
        cardInfoPanel.add(expiryDateLabel);
        cardInfoPanel.add(expiryDateTextField);
    }

    private void createCashInfoPanel() {
        cashInfoPanel = new JPanel(new GridLayout(1, 2, 5, 10));

        inputMoneyLabel = new JLabel("Input Money:");
        inputMoneyLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        inputMoneyTextField = new JTextField();

        cashInfoPanel.add(inputMoneyLabel);
        cashInfoPanel.add(inputMoneyTextField);
    }

    private void createCheckInfoPanel() {
        checkInfoPanel = new JPanel(new GridLayout(3, 2, 5, 10));

        bankNameLabel = new JLabel("Bank Name:");
        bankNameLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        bankNameTextField = new JTextField();
        accountIdLabel = new JLabel("Account ID:");
        accountIdLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        accountIdTextField = new JTextField();
        routingNumberLabel = new JLabel("Routing Number:");
        routingNumberLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        routingNumberTextField = new JTextField();

        checkInfoPanel.add(bankNameLabel);
        checkInfoPanel.add(bankNameTextField);
        checkInfoPanel.add(accountIdLabel);
        checkInfoPanel.add(accountIdTextField);
        checkInfoPanel.add(routingNumberLabel);
        checkInfoPanel.add(routingNumberTextField);
    }

    public boolean isBuyButtonClicked() {
        return false;
    }

    private class ComboBoxListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            JComboBox<String> comboBox = (JComboBox<String>) event.getSource();
            String selectedMethod = (String) comboBox.getSelectedItem();
            paymentMethodLayout.show(paymentMethodPanel, selectedMethod);
        }
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String selectedMethod = (String) paymentMethodComboBox.getSelectedItem();

            if (selectedMethod.equals("Credit Card")) {
                // Add your credit card processing logic here
                JOptionPane.showMessageDialog(PaymentGUI.this, "Thank you for your purchase! Your credit card transaction was successful.");
                dispose();
            } else if (selectedMethod.equals("Check")) {
                // Add your check processing logic here
                JOptionPane.showMessageDialog(PaymentGUI.this, "Thank you for your purchase! Your check transaction was successful.");
                dispose();
            } else {
                // Cash payment selected
                JOptionPane.showMessageDialog(PaymentGUI.this, "Thank you for your purchase! Your cash transaction was successful.");
                dispose();
            }
        }
    }


}


