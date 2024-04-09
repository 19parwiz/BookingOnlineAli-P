package controllers;

import entities.OrdinaryUser;
import entities.User;
import entities.UserType;
import entities.VIPUser;
import repositories.UserRepository;
import java.util.Scanner;

public class UserController implements IUserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(Scanner scanner) {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter userName: ");
        String name = scanner.nextLine();

        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();

        UserType userType = chooseUserType(scanner);
        User newUser = new User.Builder()
                .id(id)
                .name(name)
                .balance(balance)
                .userType(userType)
                .build();


        userRepository.addUser(newUser);
    }

    private UserType chooseUserType(Scanner scanner) {
        System.out.println("Choose user type : (1) VIP, (2) Ordinary");
        int userTypeChoice = scanner.nextInt();
        if (userTypeChoice == 1) {
            return new VIPUser();
        } else {
            return new OrdinaryUser();
        }
    }

    public void getAllUsers() {
        userRepository.getAllUsers();
    }
    public void updateUser(Scanner scanner) {
        System.out.print("Enter user ID for the user to update: ");
        int userIdToUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();

        System.out.print("Enter new balance: ");
        double newBalance = scanner.nextDouble();
        scanner.nextLine();

        User updatedUser = new User.Builder()
                .id(userIdToUpdate)
                .name(newUsername)
                .balance(newBalance)
                .build();

        userRepository.updateUser(updatedUser);
    }

    public void deleteUser(Scanner scanner) {

        System.out.print("Enter user ID for the user to delete: ");
        int userIdToDelete = scanner.nextInt();
        scanner.nextLine();
        userRepository.deleteUser(userIdToDelete);
    }
}