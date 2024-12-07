package in.tum.de;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public final class Client {
    public static void main(String[] args) throws SQLException {
        Service service = new Service();
        service.testExercise();
    }
}