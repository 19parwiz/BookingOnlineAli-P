package controllers;

import entities.Order;
import repositories.OrderRepository;

import java.util.Scanner;

public class OrderController {
    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Scanner scanner) {
        System.out.print("Enter userId: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter mealName: ");
        String mealname = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        double quantity = scanner.nextDouble();

        Order newOrder = new Order.Builder()
                .userId(userId)
                .mealName(mealname)
                .quantity(quantity)
                .build();

        orderRepository.addOrder(newOrder);
    }

    public void updateOrder(Scanner scanner) {
        System.out.print("Enter user ID for the order to update: ");
        int userIdToUpdate = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter meal name for the order to update: ");
        String mealnameToUpdate = scanner.nextLine();

        System.out.print("Enter new quantity: ");
        double newQuantity = scanner.nextDouble();
        scanner.nextLine();

        Order updatedOrder = new Order.Builder()
                .orderId(userIdToUpdate)
                .mealName(mealnameToUpdate)
                .quantity(newQuantity)
                .build();

        orderRepository.updateOrder(updatedOrder);
    }

    public void deleteOrder(Scanner scanner) {
        System.out.print("Enter user ID for the order to delete: ");
        int userIdToDelete = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter meal name for the order to delete: ");
        String mealnameToDelete = scanner.nextLine();


        orderRepository.deleteOrder(userIdToDelete, mealnameToDelete);
    }
    public void getAllOrders(){
        orderRepository.getAllOrders();
    }
}