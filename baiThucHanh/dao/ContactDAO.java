package baiThucHanh.model;

import baiThucHanh.dao.ConnectionDb;
import baiThucHanh.entity.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public ContactDAO() {
        try (Connection conn = ConnectionDb.getMySQLConnection()) {
            String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255) NOT NULL," +
                    "company VARCHAR(255)," +
                    "email VARCHAR(255)," +
                    "phone VARCHAR(20) NOT NULL)";
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(sql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addContact(Contact contact) {
        String sql = "INSERT INTO contacts (name, company, email, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionDb.getMySQLConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getCompany());
            pstmt.setString(3, contact.getEmail());
            pstmt.setString(4, contact.getPhone());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact findContactByName(String name) {
        String sql = "SELECT * FROM contacts WHERE name=?";
        try (Connection conn = ConnectionDb.getMySQLConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Contact(rs.getString("name"), rs.getString("company"),
                            rs.getString("email"), rs.getString("phone"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Contact> getAllContacts() {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contacts";
        try (Connection conn = ConnectionDb.getMySQLConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contacts.add(new Contact(rs.getString("name"), rs.getString("company"),
                        rs.getString("email"), rs.getString("phone")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}