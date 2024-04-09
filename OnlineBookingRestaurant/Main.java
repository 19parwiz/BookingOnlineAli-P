import controllers.MealController;
import controllers.OrderController;
import controllers.UserController;
import repositories.MealRepository;
import repositories.OrderRepository;
import repositories.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DataBaseConnection.getConnection()) {

            UserRepository userRepository = new UserRepository(connection);
            UserController userController = new UserController(userRepository);

            MealRepository mealRepository = new MealRepository(connection);
            MealController mealController = new MealController(mealRepository);

            OrderRepository orderRepository = new OrderRepository(connection);
            OrderController orderController = new OrderController(orderRepository);

            runUserManagementApp(userController, mealController, orderController);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runUserManagementApp(UserController userController, MealController mealController,
                                             OrderController orderController) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Hello, Welcome to the online Restaurant. You have the following available options:");
            System.out.println("1) View all Meals");
            System.out.println("2) Add a new user;");
            System.out.println("3) Show All users");
            System.out.println("4) Update users");
            System.out.println("5) Delete users");
            System.out.println("6) Order a meal;");
            System.out.println("7) Add a new meal;");
            System.out.println("8) Update Meal;");
            System.out.println("9) Delete Meal;");
            System.out.println("10) view all orders");
            System.out.println("11) Update Order");
            System.out.println("12) Delete Order");
            System.out.println("13) Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    mealController.getALLMeals();
                    break;
                case 2:
                    userController.addUser(scanner);
                    break;
                case 3:
                    userController.getAllUsers();
                    break;
                case 4:
                    userController.updateUser(scanner);
                    break;
                case 5:
                    userController.deleteUser(scanner);
                    break;
                case 6:
                    orderController.addOrder(scanner);
                    break;
                case 7:
                    mealController.addMeals(scanner);
                    break;
                case 8:
                    mealController.updateMeal(scanner);
                    break;
                case 9:
                    mealController.deleteMeal(scanner);
                    break;
                case 10:
                    orderController.getAllOrders();
                    break;
                case 11:
                    orderController.updateOrder(scanner);
                    break;
                case 12:
                    orderController.deleteOrder(scanner);
                    break;
                case 13:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}