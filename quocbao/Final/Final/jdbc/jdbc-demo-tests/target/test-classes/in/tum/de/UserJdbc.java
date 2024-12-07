package in.tum.de;

import java.sql.*;

public class UserJdbc {
    // Thông tin kết nối tới cơ sở dữ liệu H2 trong bộ nhớ
    private static final String JDBC_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String JDBC_USER = "sa";
    private static final String JDBC_PASSWORD = "";

    // Tạo bảng "user" nếu chưa tồn tại
    public void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS \"user\" (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255), " +
                "address VARCHAR(255), " +
                "phone_number VARCHAR(20), " +
                "email VARCHAR(255), " +
                "zip_code VARCHAR(10))";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Chèn một người dùng vào bảng "user"
    public void insertUser(String name, String address, String phoneNumber, String email, String zipCode) {
        String sql = "INSERT INTO \"user\" (name, address, phone_number, email, zip_code) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, phoneNumber);
            statement.setString(4, email);
            statement.setString(5, zipCode);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy dữ liệu nhóm theo mã bưu điện và đếm số lượng người dùng
    public String getUserGroupByZipCode(String query) {
        StringBuilder result = new StringBuilder();
        try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                result.append("Zip Code: ").append(resultSet.getString("zip_code"))
                        .append(", User Count: ").append(resultSet.getInt("user_count"))
                        .append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error executing query: " + e.getMessage();
        }
        return result.toString();
    }
}
