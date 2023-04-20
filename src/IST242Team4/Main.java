
package IST242Team4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;

public class Main {

    private static DatabaseConnection dbConnection;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome To the Refurb Used Laptop Store\n");

        ProductCatalogGUI productCatalogGUI = new ProductCatalogGUI();
        JTable table = productCatalogGUI.table;
        DefaultTableModel model = productCatalogGUI.model;

        // Display the GUI
        SwingUtilities.invokeLater(() -> productCatalogGUI.setVisible(true));

        // Ask user to select a laptop
        int selectedRow = -1;
        while (selectedRow == -1) {
            String input = JOptionPane.showInputDialog("Enter the ID of the laptop you want to buy:");
            if (input == null) {
                System.exit(0); // Exit the program if the user cancels or closes the dialog
            }
            try {
                int selectedId = Integer.parseInt(input);
                for (int i = 0; i < model.getRowCount(); i++) {
                    int rowId = (int) model.getValueAt(i, 0);
                    if (selectedId == rowId) {
                        selectedRow = i;
                        break;
                    }
                }
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "No laptop found with ID " + selectedId);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }

        // Display the selected laptop's details
        String brand = (String) model.getValueAt(selectedRow, 1);
        String modelStr = (String) model.getValueAt(selectedRow, 2);
        String processor = (String) model.getValueAt(selectedRow, 3);
        int ram = (int) model.getValueAt(selectedRow, 4);
        String storage = (String) model.getValueAt(selectedRow, 5);
        double price = (double) model.getValueAt(selectedRow, 6);
        String condition = (String) model.getValueAt(selectedRow, 7);

        String selectedLaptopMsg = String.format(
                "You have selected:\nBrand: %s\nModel: %s\nProcessor: %s\nRAM: %d GB\nStorage: %s\nPrice: $%f\nCondition: %s",
                brand, modelStr, processor, ram, storage, price, condition);
        JOptionPane.showMessageDialog(null, selectedLaptopMsg);

        // Ask the user if they want to continue shopping
        boolean shopping = true;

        do {
            // Ask the user if they want to continue shopping
            System.out.print("Do you want to continue shopping? (Y/N) ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("n")) {
                shopping = false;
            } else if (input.equalsIgnoreCase("y")) {
                // Ask user to select another laptop
                selectedRow = -1;

                while (selectedRow == -1) {
                    input = JOptionPane.showInputDialog("Enter the ID of the laptop you want to buy:");

                    if (input == null) {
                        System.exit(0); // Exit the program if the user cancels the input dialog
                    }

                    try {
                        selectedRow = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid ID.");
                    }
                }
            } 
        } while (shopping);

        // Display the selected laptop's details
            System.out.println("You have selected the following laptop:");
            System.out.println("ID = " + model.getValueAt(selectedRow, 0) + ", " + brand + "\n======\n" + "Model = " +
                    modelStr + ", " + "Processor = " + processor + ", " + "RAM = " + ram
                    + ", " + " Storage = " + storage + ", " + " Price = " + price + ", " + " Condition = " +
                    condition + "\n");

                     double totalPrice = price;
                     System.out.println("Total Price: " + price);


        while (true) {
            System.out.println("\nEnter CRUD operation (create, read, update, delete or exit:");
            String operation = scanner.nextLine().toLowerCase();

            switch (operation) {
                case "create":
                    System.out.println("\nEnter customer id:");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.println("\nEnter customer first name:");
                    String firstName = scanner.nextLine();

                    System.out.println("\nEnter customer last name:");
                    String lastName = scanner.nextLine();

                    System.out.println("\nEnter customer email:");
                    String email = scanner.nextLine();

                    System.out.println("\nEnter customer phone number:");
                    String phoneNumber = scanner.nextLine();

                    Customer customer = new Customer(id, firstName, lastName, email, phoneNumber);
                    dbConnection.createSQL(id, customer);
                    System.out.println("Customer created successfully.");
                    break;
                case "read":

                    dbConnection.readAllSQL();
                    break;

                case "update":
                    System.out.println("\nEnter customer id:");
                    id = Integer.parseInt(scanner.nextLine());

                    System.out.println("\nEnter customer first name:");
                    firstName = scanner.nextLine();

                    System.out.println("\nEnter customer last name:");
                    lastName = scanner.nextLine();

                    System.out.println("\nEnter customer email:");
                    email = scanner.nextLine();

                    System.out.println("\nEnter customer phone number:");
                    phoneNumber = scanner.nextLine();

                    customer = new Customer(id, firstName, lastName, email, phoneNumber);
                    dbConnection.updateSQL(id, customer);
                    System.out.println("Customer updated successfully.");
                    break;
                case "delete":
                    System.out.println("\nEnter customer id:");
                    id = Integer.parseInt(scanner.nextLine());

                    dbConnection.deleteSQL(id);
                    System.out.println("Customer deleted successfully.");
                    break;
                default:
                    System.out.println("Invalid operation. Please enter create, read, update, delete or exit.");
                    break;
            }
            if (operation.equals("exit")) {
                System.out.println("Profile Created.");
                break;
            }
        }


        // Calculate the tax
        System.out.print("Enter state code (PA, NJ, GA, NY): ");
        StateCode state = StateCode.valueOf(scanner.nextLine());

        double tax = Sale.getTax(price, state);

        // Add the tax to the total price
        totalPrice += tax;

        // Display the total price
        System.out.println("Total price: $" + totalPrice);

        // Ask the user for a payment method
        System.out.println("How would you like to pay? Enter 1 for cash, 2 for credit card, 3 for Check.");
        int paymentType = scanner.nextInt();

        if (paymentType == 1) {
            // Process cash payment
            System.out.println("Enter the dollar amount of the payment:");
            int dollars = scanner.nextInt();
            System.out.println("Enter the cent amount of the payment:");
            int cents = scanner.nextInt();
            Cash cashPayment = new Cash(dollars, cents);
            double paymentCharge = cashPayment.getDollars() + (cashPayment.getCents() / 100.0);
            Payment payment = new Payment(paymentCharge) {
                public double handlePayment(double pay) {
                    System.out.println("Payment of $" + pay + " received in cash.");
                    return pay;
                }
            };
            payment.handlePayment(paymentCharge);

        } else if (paymentType == 2) {
            // Process credit card payment
            System.out.println("Enter the bank that issued the card:");
            String bank = scanner.next();
            System.out.println("Enter the name on the card:");
            String cardName = scanner.next();
            System.out.println("Enter the credit card number:");
            String cardNumber = scanner.next();
            if (Luhn.Check(cardNumber)) {
                System.out.println("Enter card Expire Date");
                String expireDate = scanner.next();
                System.out.println("Enter CVV Code");
                String cvvCode = scanner.next();

            } else {
                System.out.println("Invalid credit card number entered.");
            }

        } else if (paymentType == 3) {
            // Process check payment
            System.out.println("Enter the check number:");
            String checkNumber = scanner.next();
            System.out.println("Enter the bank name:");
            String bankName = scanner.next();
            System.out.println("Enter the account number:");
            String accountNumber = scanner.next();
            System.out.println("Enter the routing number:");
            String routingNumber = scanner.next();

            // Create a Check object
            Check check = new Check(checkNumber, bankName, accountNumber, routingNumber, totalPrice);

            // Process the check payment
            try {
                check.processPayment();
                System.out.println("Payment of $" + totalPrice + " received by check.");
            } catch (Exception e) {
                System.out.println("Error processing check payment: " + e.getMessage());
            }

        } else {
            // Invalid payment type entered
            System.out.println("Invalid payment type entered.");
        }

        System.out.println("\n Thank you for Shopping!");
        scanner.close();
    }
}