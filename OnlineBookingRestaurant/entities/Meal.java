package entities;

public class Meal {
    private String mealName;
    private double price;
    private String description;
    private Meal(Builder builder){
        this.mealName = builder.mealName;
        this.price = builder.price;
        this.description = builder.description;

    }
    public static class Builder{
        private String mealName;
        private double price;
        private String description;
        public Builder mealName(String mealName){
            this.mealName = mealName;
            return this;
        }
        public Builder price(double price){
            this.price = price;
            return this;
        }
        public Builder description(String description){
            this.description = description;
            return this;
        }
        public Meal build(){
            return new Meal(this);
        }

    }


    public Meal(String mealName, double price, String description) {
        this.mealName = mealName;
        this.price = price;
        this.description = description;
    }

    public String getMealName() {
        return mealName;
    }
    public void setMealNameName(String name){
        this.mealName = mealName;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}