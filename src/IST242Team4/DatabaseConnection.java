package IST242Team4;

/**
 * @Author : Dhruvesh
 * Class : IST242
 * Version : 1
 * date : 02/19/2023
 */

import java.sql.*;
import java.util.*;

public class DatabaseConnection {

    public DatabaseConnection() {

        //Perform the CRUD create, read, update, delete records with the database

        readAllSQL();
        readByIdSQL(1000);
        Customer cust = new Customer(1,"Dhruvesh", "Patel", "patel.d@gmail.com", "123-456-0568");
        createSQL(3, cust);
        updateSQL(3, cust);
        deleteSQL(3);
        readAllSQL();
    }

    public static void readAllSQL() {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Custome", "root", "Computer@23");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cust");
            while (rs.next()) {
                Customer cust = new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone_number"));
                customers.add(cust);
            }
            for (Customer cust : customers) {
                System.out.println(cust.getId() + ", " + cust.getFirstName() + ", " + cust.getLastName() + ", " +
                        cust.getEmail() + ", " + cust.getPhoneNumber());
            }
        } catch (Exception e) {
            //System.out.println(e);
        }
    }

    public static void readByIdSQL(int id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Custome", "root", "Computer@23");
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cust WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer cust = new Customer(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"),
                        rs.getString("email"), rs.getString("phone_number"));
                /**System.out.println(cust.getId() + ", " + cust.getFirstName() + ", " + cust.getLastName() + ", " +
                 cust.getEmail() + ", " + cust.getPhoneNumber());
                 **/
            }
        } catch (Exception e) {
            //  System.out.println(e);
        }
    }

    public static void createSQL(int id, Customer cust) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Custome", "root", "Computer@23");
            PreparedStatement ps = con.prepareStatement("INSERT INTO cust (id, first_name, last_name, email, phone_number) " +
                    "VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, cust.getFirstName());
            ps.setString(3, cust.getLastName());
            ps.setString(4, cust.getEmail());
            ps.setString(5, cust.getPhoneNumber());
            ps.executeUpdate();
            System.out.println("Customer created successfully.");
        }
        catch (Exception e) {
            // System.out.println(e);
        }
    }
    public static void updateSQL(int id, Customer cust) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Custome", "root", "Computer@23");
            PreparedStatement ps = con.prepareStatement("UPDATE cust SET first_name = ?, last_name = ?, email = ?, " +
                    "phone_number = ? WHERE id = ?");
            ps.setString(1, cust.getFirstName());
            ps.setString(2, cust.getLastName());
            ps.setString(3, cust.getEmail());
            ps.setString(4, cust.getPhoneNumber());
            ps.setInt(5, id);


            ps.executeUpdate();
        } catch (Exception e) {
            // System.out.println(e);
        }
    }

    public static void deleteSQL(int id) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Custome", "root", "Computer@23");
            PreparedStatement ps = con.prepareStatement("DELETE FROM cust WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            //  System.out.println(e);
        }
    }

}
