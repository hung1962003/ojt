package in.tum.de;

public class Exercise {
    public String result() {
        return "SELECT zip_code, COUNT(*) AS user_count FROM \"user\" GROUP BY zip_code";
    }
}
