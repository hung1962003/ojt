package in.tum.de;

import java.sql.SQLException;
import java.util.Scanner;

public class Service {

    private Exercise exercise = new Exercise();

    private ConnectionUtils connectionUtils = new ConnectionUtils();


    public void initService() throws SQLException {
        Exercise exercise = new Exercise();
        exercise.insertTable(connectionUtils.getConnection());
        exercise.insertUser("Alice Cooper", "101 Orchid Way", "555-0001", "alicecooper@example.com", "10001", connectionUtils.getConnection());
        exercise.insertUser("Bob Marley", "102 Rose Street", "555-0002", "bobmarley@example.com", "10002", connectionUtils.getConnection());
        exercise.insertUser("Charlie Brown", "103 Tulip Lane", "555-0003", "charliebrown@example.com", "10003", connectionUtils.getConnection());
        exercise.insertUser("David Bowie", "104 Lily Avenue", "555-0004", "davidbowie@example.com", "10004", connectionUtils.getConnection());
        exercise.insertUser("Eva Green", "105 Daffodil Drive", "555-0005", "evagreen@example.com", "10005", connectionUtils.getConnection());
        exercise.insertUser("Frank Sinatra", "106 Sunflower Boulevard", "555-0006", "franksinatra@example.com", "10006", connectionUtils.getConnection());
        exercise.insertUser("Grace Kelly", "107 Marigold Road", "555-0007", "gracekelly@example.com", "10007", connectionUtils.getConnection());
        System.out.println(exercise.getAllUsers(connectionUtils.getConnection()));
    }

    public int getChoice() {
        int result = 0;
        System.out.print("Welcome To JDBC Exercise \n 1.Create Table \n 2.Select User By Name \n 3.Update Name Of User By Id \n 4.Test Delete User By Id \n 5.Exit \n Your Choice: ");
        Scanner scanner = new Scanner(System.in);

        try {
            result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
        }

        return result;
    }

    public void testExercise() throws SQLException {
        int choice = 0;
        initService();
        do {
            choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.println(exercise.getAllUsers(connectionUtils.getConnection()));
                    break;
                case 2:
                    System.out.println("Enter name to search: ");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    System.out.println(exercise.selectUserByName(name,connectionUtils.getConnection()));
                    break;
                case 3:
                    System.out.println("Enter id to update: ");
                    Scanner scanner1 = new Scanner(System.in);
                    int id = Integer.parseInt(scanner1.nextLine());
                    String oldUser = exercise.getUserById(id,connectionUtils.getConnection());
                    System.out.println("Enter new name: ");
                    String newName = scanner1.nextLine();
                    exercise.updateUser(id, newName,connectionUtils.getConnection());
                    System.out.println("Before Change: " + oldUser);
                    System.out.println("After Change: " + exercise.getUserById(id,connectionUtils.getConnection()));
                    break;
                case 4:
                    System.out.println("Enter id to delete: ");
                    Scanner scanner2 = new Scanner(System.in);
                    int id1 = Integer.parseInt(scanner2.nextLine());
                    exercise.deleteUser(id1,connectionUtils.getConnection());
                    System.out.println(exercise.getAllUsers(connectionUtils.getConnection()));
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.err.println("Invalid choice");
            }
        } while (choice < 1 || choice > 5);
    }

}
