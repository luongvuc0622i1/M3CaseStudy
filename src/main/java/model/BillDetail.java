package model;

public class BillDetail {

    private int id;
    private int bill_id;
    private int food_id;
    private int quantity;
    private double price;
    private int status;

    public BillDetail() {
    }

    public BillDetail(int id, int bill_id, int food_id, int quantity, double price, int status) {
        this.id = id;
        this.bill_id = bill_id;
        this.food_id = food_id;
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

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
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
