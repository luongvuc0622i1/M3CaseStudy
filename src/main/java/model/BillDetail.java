package model;

public class BillDetail {

    private int id;
    private Bill bill;
    private Food food;
    private int quantity;
    private double price;
    private int status;

    public BillDetail() {
    }

    public BillDetail(int id, Bill bill, Food food, int quantity, double price, int status) {
        this.id = id;
        this.bill = bill;
        this.food = food;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public BillDetail(Bill bill, Food food, int quantity, double price, int status) {
        this.bill = bill;
        this.food = food;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
