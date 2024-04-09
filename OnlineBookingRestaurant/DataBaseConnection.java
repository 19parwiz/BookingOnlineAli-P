import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "4321";

    private static Connection instance;

    private DataBaseConnection() {
    }

    public static Connection getConnection() {
        if (instance == null) {
            synchronized (DataBaseConnection.class) {
                if (instance == null) {
                    try {
                        Class.forName("org.postgresql.Driver");
                        instance = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    } catch (ClassNotFoundException | SQLException e) {
                        throw new RuntimeException("Failed to establish a database connection.", e);
                    }
                }
            }
        }
        return instance;
    }

    private static void createUsersTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS users("
                    + "id SERIAL PRIMARY KEY,"
                    + "name VARCHAR(50) NOT NULL,"
                    + "balance DOUBLE PRECISION NOT NULL,"
                    + "user_type VARCHAR(20) NOT NULL)";

            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static void createOrderTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS orders("
                    + "userid SERIAL PRIMARY KEY,"
                    + "mealName VARCHAR(50) NOT NULL,"
                    + "quantity DOUBLE PRECISION NOT NULL)";
            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createMealsTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS meals ("
                    + "mealName VARCHAR(50) PRIMARY KEY,"
                    + "price DOUBLE PRECISION NOT NULL,"
                    + "description VARCHAR(255) NOT NULL)";

            statement.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void createTables(Connection connection) throws SQLException {
        createUsersTable(connection);
        createOrderTable(connection);
        createMealsTable(connection);

    }
}