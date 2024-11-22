import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DatabaseHelper {

    public void saveScore(String username, int score) {
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/game", "user", "password")) {
            String sql = "INSERT INTO scores (username, score) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setInt(2, score);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
