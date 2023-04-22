package IST242Team4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JFrame implements ActionListener {
    private JTextField idField, firstNameField, lastNameField, emailField, phoneNumberField;
    private JButton createBtn, resetBtn, exitBtn;
    private JTextArea outputArea;
    private DatabaseConnection dbConnection;

    public CustomerGUI() {
        super("Customer Database");

        dbConnection = new DatabaseConnection();

        idField = new JTextField(10);
        firstNameField = new JTextField(10);
        lastNameField = new JTextField(10);
        emailField = new JTextField(10);
        phoneNumberField = new JTextField(10);

        createBtn = new JButton("Create");
        resetBtn = new JButton("Reset");
        exitBtn = new JButton("Exit");

        createBtn.addActionListener(this);
        resetBtn.addActionListener(this);
        exitBtn.addActionListener(this);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(firstNameField);
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(lastNameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(phoneNumberField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(createBtn);
        buttonPanel.add(resetBtn);
        buttonPanel.add(exitBtn);

        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        Container contentPane = getContentPane();
        contentPane.add(inputPanel, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        contentPane.add(scrollPane, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createBtn) {
            int id = Integer.parseInt(idField.getText());
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            String email = emailField.getText();
            String phoneNumber = phoneNumberField.getText();

            Customer customer = new Customer(id, firstName, lastName, email, phoneNumber);
            dbConnection.createSQL(id, customer);
            outputArea.append("Customer created successfully.\n");
            dispose(); // Exit the program after creating the customer
        } else if (e.getSource() == resetBtn) {
            idField.setText("");
            firstNameField.setText("");
            lastNameField.setText("");
            emailField.setText("");
            phoneNumberField.setText("");
        } else if (e.getSource() == exitBtn) {
            System.exit(0); // Exit the program if the Exit button is clicked
        }
    }

    public StateCode getStateCode() {
            return null;
    }
}
