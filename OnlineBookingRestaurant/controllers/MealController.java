package controllers;

import entities.Meal;
import repositories.MealRepository;

import java.util.Scanner;

public class MealController {
    private MealRepository mealRepository;
    public MealController (MealRepository mealRepository){
        this.mealRepository = mealRepository;
    }

    public void addMeals(Scanner scanner) {
        System.out.println("Enter MealName");
        String mealName = scanner.nextLine();

        System.out.println("Enter Meal price");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Enter meal description");
        String description = scanner.nextLine();

        Meal newMeal = new Meal.Builder()
                .mealName(mealName)
                .price(price)
                .description(description)
                .build();

        mealRepository.addMeal(newMeal);
    }
    public void updateMeal(Scanner scanner) {
        System.out.print("Enter meal name for the meal to update: ");
        String mealnameToUpdate = scanner.nextLine();

        System.out.print("Enter new price: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter new description: ");
        String newDescription = scanner.nextLine();


        Meal updatedMeal = new Meal.Builder()
                .mealName(mealnameToUpdate)
                .price(newPrice)
                .description(newDescription)
                .build();


        mealRepository.updateMeal(updatedMeal);
    }

    public void deleteMeal(Scanner scanner) {
        System.out.print("Enter meal name for the meal to delete: ");
        String mealnameToDelete = scanner.nextLine();


        mealRepository.deleteMeal(mealnameToDelete);
    }
    public void getALLMeals(){
        mealRepository.getAllMeals();
    }
}
