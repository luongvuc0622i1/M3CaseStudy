package model;

import java.util.Date;

public class Bill {

    private int id;
    private String code;
    private Date date;
    private double totalCost;
    private Client client;
    private Shop shop;
    private int status;

    public Bill(String code, java.sql.Date date, Double totalCost, Client client, Shop shop, int status) {
        this.code=code;
        this.date=date;
        this.totalCost=totalCost;
        this.client=client;
        this.shop=shop;
        this.status=status;

    }

    public Bill(int id, String code, Date date, double totalCost, Client client, Shop shop, int status) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.totalCost = totalCost;
        this.client = client;
        this.shop = shop;
        this.status = status;
    }

    public Bill(int id, String code, double totalCost, Client client, Shop shop, int status) {
        this.id = id;
        this.code = code;
        this.totalCost = totalCost;
        this.client = client;
        this.shop = shop;
        this.status = status;
    }

    public Bill(String code, double totalCost, Client client, Shop shop, int status) {
        this.code = code;
        this.totalCost = totalCost;
        this.client = client;
        this.shop = shop;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
