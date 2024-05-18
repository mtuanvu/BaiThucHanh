package baiThucHanh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/AddressBookDB";
    private static final String USER = "root"; // Thay bằng tên người dùng MySQL của bạn
    private static final String PASS = ""; // Thay bằng mật khẩu MySQL của bạn

    public static Connection getMySQLConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }
}