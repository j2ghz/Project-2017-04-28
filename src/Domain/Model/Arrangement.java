package Domain.Model;

import java.util.Date;

public class Arrangement {
    private Date date;
    private int id;
    private double price;
    private int customerId;
    private int participantNo;
    private String name;
    private String description;
    private Customer customer;

    public Arrangement(Date date, int id, double price, int customerId, String name, String description, Customer customer, int participantNo) {
        this.date = date;
        this.id = id;
        this.price = price;
        this.customerId = customerId;
        this.participantNo = participantNo;
        this.name = name;
        this.description = description;
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParticipantNo() {
        return participantNo;
    }

    public void setParticipantNo(int participantNo) {
        this.participantNo = participantNo;
    }
}
