package in.tum.de;

import java.sql.*;

public class Exercise {

    public void insertTable(Connection connectionInput) {
        String sql = "CREATE TABLE IF NOT EXISTS \"user\" (" + "id INT PRIMARY KEY AUTO_INCREMENT, " + "name VARCHAR(255), " + "address VARCHAR(255), " + "phone_number VARCHAR(20), " + "email VARCHAR(255), " + "zip_code VARCHAR(10))";
        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String name, String address, String phoneNumber, String email, String zipCode, Connection connectionInput) {
        String sql = "INSERT INTO \"user\" (name, address, phone_number, email, zip_code) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql)) {
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

    public String selectUserByName(String name, Connection connectionInput) {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM \"user\" WHERE name = ?";

        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result.append("ID: ").append(resultSet.getInt("id")).append(", Name: ").append(resultSet.getString("name")).append(", Address: ").append(resultSet.getString("address")).append(", Phone Number: ").append(resultSet.getString("phone_number")).append(", Email: ").append(resultSet.getString("email")).append(", Zip Code: ").append(resultSet.getString("zip_code")).append("\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving user: " + e.getMessage();
        }

        return result.length() > 0 ? result.toString().trim() : "No user found with the provided name.";
    }


    public void updateUser(int userId, String newName, Connection connectionInput) {
        String sql = "UPDATE \"user\" SET name = ? WHERE id = ?";

        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, newName);
            statement.setInt(2, userId);
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("User name updated successfully.");
            } else {
                System.out.println("No user found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getAllUsers(Connection connectionInput) {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM \"user\"";

        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                result.append("ID: ").append(resultSet.getInt("id")).append(", Name: ").append(resultSet.getString("name")).append(", Address: ").append(resultSet.getString("address")).append(", Phone Number: ").append(resultSet.getString("phone_number")).append(", Email: ").append(resultSet.getString("email")).append(", Zip Code: ").append(resultSet.getString("zip_code")).append("\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving users: " + e.getMessage();
        }

        return result.toString().trim();
    }

    public void deleteUser(int userId, Connection connectionInput) {
        String sql = "DELETE FROM \"user\" WHERE id = ?";

        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully.");
            } else {
                System.out.println("No user found with the provided ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getUserById(int userId, Connection connectionInput) {
        StringBuilder result = new StringBuilder();
        String sql = "SELECT * FROM \"user\" WHERE id = ?";

        try (Connection connection = connectionInput; PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result.append("ID: ").append(resultSet.getInt("id")).append(", Name: ").append(resultSet.getString("name")).append(", Address: ").append(resultSet.getString("address")).append(", Phone Number: ").append(resultSet.getString("phone_number")).append(", Email: ").append(resultSet.getString("email")).append(", Zip Code: ").append(resultSet.getString("zip_code")).append("\n");
            } else {
                return "No user found with the provided ID.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error retrieving user: " + e.getMessage();
        }

        return result.toString().trim();
    }

    public void clearTable(Connection connectionInput) {
        String dropTableSql = "DROP TABLE IF EXISTS \"user\"";
        String createTableSql = "CREATE TABLE \"user\" (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(255), " +
                "address VARCHAR(255), " +
                "phone_number VARCHAR(20), " +
                "email VARCHAR(255), " +
                "zip_code VARCHAR(10))";

        try (Statement statement = connectionInput.createStatement()) {
            statement.executeUpdate(dropTableSql);
            statement.executeUpdate(createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
