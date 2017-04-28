package Domain.Model;

public class Room {
    private double price;
    private String name;
    private int number;
    private int bedCount;
    private String description;


    public Room(double price, String name, int number, int bedCount, String description) {
        this.price = price;
        this.name = name;
        this.number = number;
        this.bedCount = bedCount;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
