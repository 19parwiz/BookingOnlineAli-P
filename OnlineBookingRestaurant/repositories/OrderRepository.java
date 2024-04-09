package repositories;

import entities.Order;

import java.sql.*;

public class OrderRepository {
    private Connection connection;

    public OrderRepository(Connection connection) {

        this.connection = connection;
    }


    public void addOrder(Order order) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO orders (userId, mealname, quantity) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, order.getUserId());
            preparedStatement.setString(2, order.getMealName());
            preparedStatement.setDouble(3, order.getQuantity());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    order.setOrderId(generatedKeys.getInt(1));
                }
                System.out.println("Order added successfully!");
            } else {
                System.out.println("Failed to add Order. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOrder(Order order) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE orders SET quantity=? WHERE userid=? AND mealname=?")) {

            preparedStatement.setDouble(1, order.getQuantity());
            preparedStatement.setInt(2, order.getUserId());
            preparedStatement.setString(3, order.getMealName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Order updated successfully!");
            } else {
                System.out.println("Failed to update order. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(int userId, String mealName) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM orders WHERE userid=? AND mealname=?")) {

            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, mealName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Order deleted successfully!");
            } else {
                System.out.println("Failed to delete order. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllOrders() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            while (resultSet.next()) {
                int userId = resultSet.getInt("userid");
                String mealname = resultSet.getString("mealname");
                double quantity = resultSet.getDouble("quantity");

                System.out.println("UserID: " + userId + ", MealName: " + mealname + ", Quantity: " + quantity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


