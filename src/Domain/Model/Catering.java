package Domain.Model;

import java.util.Date;


public class Catering {
    private int numberOfMeals;
    private String foodType;
    private String location;
    private Date date;
    private int id;
    private double price;
    private Customer customer;

    public Catering(int numberOfMeals, String foodType, String location, Date date, int id, double price, Customer customer) {
        this.numberOfMeals = numberOfMeals;
        this.foodType = foodType;
        this.location = location;
        this.date = date;
        this.id = id;
        this.price = price;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(int numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
