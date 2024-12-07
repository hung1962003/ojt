package in.tum.de;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserJdbcTest {
    private UserJdbc userJdbc;

    @BeforeEach
    public void setUp() {
        userJdbc = new UserJdbc();
        userJdbc.createTable();
        userJdbc.insertUser("John Doe", "123 Elm Street", "555-1234", "johndoe@example.com", "12345");
        userJdbc.insertUser("Jane Smith", "456 Maple Avenue", "555-5678", "janesmith@example.com", "67890");
        userJdbc.insertUser("Alice Johnson", "789 Oak Road", "555-8765", "alicejohnson@example.com", "54321");
        userJdbc.insertUser("Bob Brown", "321 Pine Lane", "555-4321", "bobbrown@example.com", "98765");
        userJdbc.insertUser("Chris Evans", "135 Cedar Blvd", "555-2468", "chrisevans@example.com", "11223");
        userJdbc.insertUser("Diana Prince", "246 Birch Road", "555-9753", "dianaprince@example.com", "33445");
        userJdbc.insertUser("Ethan Hunt", "357 Fir Lane", "555-3697", "ethanhunt@example.com", "55667");
        userJdbc.insertUser("Fiona Glenanne", "468 Palm Street", "555-8520", "fionaglenanne@example.com", "77889");
        userJdbc.insertUser("Gina Torres", "579 Cypress Ave", "555-1472", "ginatorres@example.com", "99001");
        userJdbc.insertUser("Hank Moody", "681 Redwood Blvd", "555-3219", "hankmoody@example.com", "22334");
    }

    @Test
    public void testUser() {
        // Kiểm tra truy vấn đếm số người dùng theo mã bưu điện
        Exercise exercise = new Exercise();
        String query = exercise.result();
        String result = userJdbc.getUserGroupByZipCode(query);

        String expectedOutput = "Zip Code: 11223, User Count: 1\n"
                + "Zip Code: 12345, User Count: 1\n"
                + "Zip Code: 22334, User Count: 1\n"
                + "Zip Code: 33445, User Count: 1\n"
                + "Zip Code: 54321, User Count: 1\n"
                + "Zip Code: 55667, User Count: 1\n"
                + "Zip Code: 67890, User Count: 1\n"
                + "Zip Code: 77889, User Count: 1\n"
                + "Zip Code: 98765, User Count: 1\n"
                + "Zip Code: 99001, User Count: 1\n";

        assertEquals(expectedOutput, result);
    }
}
