
package IST242Team4;
import javax.swing.*;
import java.util.Scanner;

    public class Main {

        private static DatabaseConnection dbConnection;
        private static CustomerGUI customerGUI;
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {

            // Display the CustomerGUI
            customerGUI = new CustomerGUI();
            customerGUI.setVisible(true);

            // Wait for the customer to be created before displaying the ProductCatalogGUI
            while (customerGUI.isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Display the ProductCatalogGUI
            ProductCatalogGUI productCatalogGUI = new ProductCatalogGUI();
            productCatalogGUI.setVisible(true);

            // Wait for the user to select a product
            while (productCatalogGUI.isVisible() && productCatalogGUI.getSelectedProduct() == null) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Display the PaymentGUI
            PaymentGUI paymentGUI = new PaymentGUI(0);

            // Wait for the user to click the Buy button
            while (paymentGUI.isVisible() && !paymentGUI.isBuyButtonClicked()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            paymentGUI.setVisible(true);

            // Wait for the user to complete the payment
            while (paymentGUI.isVisible()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Display the "Thank you for shopping" message
            JOptionPane.showMessageDialog(null, "Thank you for shopping with us!");
        }
    }


