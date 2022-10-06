package model;

import java.util.Date;

public class Bill {

    private int id;
    private String code;
    private Date date;
    private double totalCost;
    private int client_id;
    private int shop_id;
    private int status;

    public Bill() {
    }

    public Bill(int id, String code, Date date, double totalCost, int client_id, int shop_id, int status) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.totalCost = totalCost;
        this.client_id = client_id;
        this.shop_id = shop_id;
        this.status = status;
    }

    public Bill(int id, String code, double totalCost, int client_id, int shop_id, int status) {
        this.id = id;
        this.code = code;
        this.totalCost = totalCost;
        this.client_id = client_id;
        this.shop_id = shop_id;
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

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
