package repositories;

import entities.Meal;

import java.sql.*;

public class MealRepository {

    private Connection connection;

    public MealRepository(Connection connection) {
        this.connection = connection;
    }


    public void addMeal(Meal meal) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO meals (mealname, price, description) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, meal.getMealName());
            preparedStatement.setDouble(2, meal.getPrice());
            preparedStatement.setString(3, meal.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {

                }
                System.out.println(" Meal added successfully!");
            } else {
                System.out.println("Failed to add meal. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMeal(Meal meal) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE meals SET price=?, description=? WHERE mealname=?")) {

            preparedStatement.setDouble(1, meal.getPrice());
            preparedStatement.setString(2, meal.getDescription());
            preparedStatement.setString(3, meal.getMealName());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Meal updated successfully!");
            } else {
                System.out.println("Failed to update meal. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeal(String mealName) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM meals WHERE mealname=?")) {

            preparedStatement.setString(1, mealName);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Meal deleted successfully!");
            } else {
                System.out.println("Failed to delete meal. Please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllMeals() {
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM meals");

            while (resultSet.next()) {
                String mealName = resultSet.getString("mealName");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");

                System.out.println("Name: " + mealName + ", Price: " + price + ", Description: " + description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
