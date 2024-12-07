package in.tum.de;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UserJdbcTest {
    private Exercise exercise;
    private ConnectionUtils connectionUtils;

    @BeforeEach
    public void setUp() throws SQLException {
        exercise = new Exercise();
        connectionUtils = new ConnectionUtils();
        exercise.clearTable(connectionUtils.getConnection());
        exercise.insertTable(connectionUtils.getConnection());
        exercise.insertUser("John Doe", "123 Elm Street", "555-1234", "johndoe@example.com", "12345", connectionUtils.getConnection());
        exercise.insertUser("Jane Smith", "456 Maple Avenue", "555-5678", "janesmith@example.com", "67890", connectionUtils.getConnection());
        exercise.insertUser("Alice Johnson", "789 Oak Road", "555-8765", "alicejohnson@example.com", "54321", connectionUtils.getConnection());
        exercise.insertUser("Bob Brown", "321 Pine Lane", "555-4321", "bobbrown@example.com", "98765", connectionUtils.getConnection());
        exercise.insertUser("Chris Evans", "135 Cedar Blvd", "555-2468", "chrisevans@example.com", "11223", connectionUtils.getConnection());
        exercise.insertUser("Diana Prince", "246 Birch Road", "555-9753", "dianaprince@example.com", "33445", connectionUtils.getConnection());
        exercise.insertUser("Ethan Hunt", "357 Fir Lane", "555-3697", "ethanhunt@example.com", "55667", connectionUtils.getConnection());
    }



    @Test
    public void testConnection() {
        String sql = "SELECT * FROM \"user\"";

        try {
            Connection connection = connectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                fail("Connection test failed");
            }
        } catch (SQLException e) {
            fail("Connection test failed");
        }
    }

    @Test
    public void testCreateTable() {
        try {
            exercise.insertUser("Create Table Demo", "123 Elm Street", "555-1234", "johndoe@example.com", "12345", connectionUtils.getConnection());
        } catch (SQLException e) {
            fail("Failed to create table");
        }
    }

    @Test
    public void testSelectUserByName() {
        try {
            String result = exercise.selectUserByName("Bob Brown", connectionUtils.getConnection());
            String aspect = "ID: 4, Name: Bob Brown, Address: 321 Pine Lane, Phone Number: 555-4321, Email: bobbrown@example.com, Zip Code: 98765";
            System.out.println(result);
            System.out.println(aspect);
            System.out.println(result.equals(aspect));
            if (result.trim().equals(aspect.trim())) {
                assertEquals(result, aspect);
            } else {
                fail("result: " + result + "\n" + " aspect: " + aspect);
            }
        } catch (SQLException e) {
            fail("Failed to select user by name");
        }
    }

    @Test
    public void testUpdateNameById() {
        try {
            exercise.updateUser(1, "Ann", connectionUtils.getConnection());
            String result = exercise.getUserById(1, connectionUtils.getConnection());
            String aspect = "ID: 1, Name: Ann, Address: 123 Elm Street, Phone Number: 555-1234, Email: johndoe@example.com, Zip Code: 12345";

            if (result.trim().equals(aspect.trim())) {
                assertEquals(result, aspect);
            } else {
                fail("Failed to update name of user by id");
            }

        } catch (SQLException e) {
            fail("Failed to select user by name");
        }
    }

    @Test
    public void testDeleteUserById() {
        try {
            exercise.deleteUser(3, connectionUtils.getConnection());
            String result = exercise.getAllUsers(connectionUtils.getConnection());
            String aspect = "ID: 1, Name: John Doe, Address: 123 Elm Street, Phone Number: 555-1234, Email: johndoe@example.com, Zip Code: 12345\n" +
                    "ID: 2, Name: Jane Smith, Address: 456 Maple Avenue, Phone Number: 555-5678, Email: janesmith@example.com, Zip Code: 67890\n" +
                    "ID: 4, Name: Bob Brown, Address: 321 Pine Lane, Phone Number: 555-4321, Email: bobbrown@example.com, Zip Code: 98765\n" +
                    "ID: 5, Name: Chris Evans, Address: 135 Cedar Blvd, Phone Number: 555-2468, Email: chrisevans@example.com, Zip Code: 11223\n" +
                    "ID: 6, Name: Diana Prince, Address: 246 Birch Road, Phone Number: 555-9753, Email: dianaprince@example.com, Zip Code: 33445\n" +
                    "ID: 7, Name: Ethan Hunt, Address: 357 Fir Lane, Phone Number: 555-3697, Email: ethanhunt@example.com, Zip Code: 55667";

            if (result.trim().equals(aspect.trim())) {
                assertEquals(result, aspect);
            } else {
                fail("Failed to update name of user by id");
            }

        } catch (SQLException e) {
            fail("Failed to delete user by id");
        }
    }



}
