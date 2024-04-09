package entities;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private double balance;
    private ArrayList<Order> orderHistory;
    private UserType userType;

    private User(Builder builder){
        this.id = builder.id;
        this.name = builder.name;
        this.balance = builder.balance;
        this.orderHistory = builder.oderHistory;
        this.userType = builder.userType;

    }
    public static class Builder{
        private int id;
        private String name;
        private double balance;
        private ArrayList<Order> oderHistory;
        private UserType userType;
        public Builder id(int id){
            this.id = id;
            return this;
        }
        public Builder name(String name){
            this.name= name;
            return this;
        }
        public Builder balance(double balance){
            this.balance = balance;
            return this;
        }
        public Builder orderHistory(ArrayList<Order> oderHistory){
            this.oderHistory = oderHistory;
        return this;
        }
        public Builder userType(UserType userType){
            this.userType = userType;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addToOrderHistory(Order order) {
        orderHistory.add(order);
    }

    public UserType getUserType() {
        return userType;}

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
}