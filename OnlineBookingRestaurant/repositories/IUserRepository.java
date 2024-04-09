package repositories;

import entities.User;

public interface IUserRepository {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int userId);
    void getAllUsers();
}