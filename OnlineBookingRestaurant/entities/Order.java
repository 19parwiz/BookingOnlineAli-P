package entities;

public class Order {
    private int userId;
    private String mealName;
    private double quantity;
    private int orderId;
    private Order(Builder builder){
        this.userId = builder.userId;
        this.mealName = builder.mealName;
        this.quantity = builder.quantity;
        this.orderId = builder.orderId;

    }
    public static class Builder{
        private int userId;
        private String mealName;
        private double quantity;
        private int orderId;
        public Builder userId(int userId){
            this.userId = userId;
            return this;
        }
        public Builder mealName(String mealName){
            this.mealName = mealName;
            return this;
        }
        public Builder quantity(double quantity){
            this.quantity = quantity;
            return this;
        }
        public Builder  orderId(int orderId){
            this.orderId = orderId;
            return this;
        }
        public Order build() {
            return new Order(this);
        }
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(){this.userId = userId;}
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMealName() {
        return mealName;
    }

    public double getQuantity() {
        return quantity;
    }

}