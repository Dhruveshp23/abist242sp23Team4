package IST242Team4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ProductCatalogGUI extends JFrame {
    public JTable table;
    public DefaultTableModel model;

    public ProductCatalogGUI() {
        setTitle("Product Catalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);

        model = new DefaultTableModel(new Object[]{"ID", "Brand", "Model", "Processor", "RAM", "Storage", "Price", "Condition"}, 0);
        table = new JTable(model);

        // Add products to the table
        ProductCatalog catalog = new ProductCatalog();
        for (Product product : catalog.getAllProducts()) {
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

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setVisible(true);
    }

    public JTable getTable() {
        return table;
    }
}
