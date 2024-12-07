package in.tum.de;

import java.sql.*;

public class Exercise {

    //write your code here
    public void insertTable(Connection connectionInput) {

    }

    //write your code here
    public void insertUser(String name, String address, String phoneNumber, String email, String zipCode, Connection connectionInput) {
    }

    //write your code here
    /*
    Make sure that will following the format:
    "ID: 1, Name: Alice Cooper, Address: 101 Orchid Way, Phone Number: 555-0001, Email: alicecooper@example.com, Zip Code: 10001"
     */
    public String selectUserByName(String name, Connection connectionInput) {


        return "";
    }

    //write your code here
    public void updateUser(int userId, String newName, Connection connectionInput) {

    }

    /*
        Make sure that will following the format:
        "ID: 1, Name: Alice Cooper, Address: 101 Orchid Way, Phone Number: 555-0001, Email: alicecooper@example.com, Zip Code: 10001,
         ID: 2, Name: Demo User, Address: 101 Orchid Way, Phone Number: 555-0001, Email: alicecooper@example.com, Zip Code: 10001"
         */
    public String getAllUsers(Connection connectionInput) {
        return "";
    }

    public void deleteUser(int userId, Connection connectionInput) {

    }

    /*
    Make sure that will following the format:
    "ID: 1, Name: Alice Cooper, Address: 101 Orchid Way, Phone Number: 555-0001, Email: alicecooper@example.com, Zip Code: 10001"
     */
    public String getUserById(int userId, Connection connectionInput) {

        return "";
    }

    //DO NOT TOUCH THIS METHOD
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
