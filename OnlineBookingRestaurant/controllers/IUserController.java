package controllers;

import java.util.Scanner;

public interface IUserController {
    void addUser(Scanner scanner);
    void getAllUsers();
    void updateUser(Scanner scanner);
    void deleteUser(Scanner scanner);
}