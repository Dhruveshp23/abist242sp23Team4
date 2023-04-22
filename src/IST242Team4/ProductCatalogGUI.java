package IST242Team4;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductCatalogGUI extends JFrame {
    private JScrollPane scrollPane;
    protected JTable table;
    protected DefaultTableModel model;
    private JButton buyBtn;

    public ProductCatalogGUI() {
        super("Product Catalog");

        // Create the table model and table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Brand");
        model.addColumn("Model");
        model.addColumn("Processor");
        model.addColumn("RAM (GB)");
        model.addColumn("Storage");
        model.addColumn("Price ($)");
        model.addColumn("Condition");
        table = new JTable(model);

        // Populate the table with products
        ProductCatalog productCatalog = new ProductCatalog();
        for (Product product : productCatalog.getAllProducts()) {
            model.addRow(new Object[]{
                    product.getid(),
                    product.getBrand(),
                    product.getModel(),
                    product.getProcessor(),
                    product.getRam(),
                    product.getStorage(),
                    product.getPrice(),
                    product.getCondition()
            });
        }

        // Add the table to a scroll pane
        scrollPane = new JScrollPane(table);

        // Create the Buy button
        buyBtn = new JButton("Buy");

        // Add an action listener to the Buy button
        buyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the selected row
                int row = table.getSelectedRow();

                // Check if a row is selected
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a product.");
                    return;
                }

                // Get the selected product's ID and price
                int productId = (int) model.getValueAt(row, 0);
                double productPrice = (double) model.getValueAt(row, 6);

                // Ask the user if they want to buy the selected product
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to buy this product?", "Buy Product", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    // Create and display the PaymentGUI
                    PaymentGUI paymentGUI = new PaymentGUI(productPrice);
                    paymentGUI.setVisible(true);
                    paymentGUI.setLocationRelativeTo(null);
                }
            }
        });

        // Create the content pane and add the components
        Container contentPane = getContentPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        contentPane.add(buyBtn, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public static Product getSelectedProduct() {
        return null;
    }
}
