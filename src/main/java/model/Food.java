package model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Food {

    private int id, status;

    private int shop_id;
    private int tag_id;
    private int deal_id;
    private String name, description, image;
    private double price;
    private Time cookTime;
    private Date dayCreate, lastUpdate;
    private List<Tag> tag;
    private int quantity;

    public Food() {
    }

    public Food(int id, int status, String name, String description, String image, double price, Time cookTime, Date dayCreate, Date lastUpdate, List<Tag> tag, int quantity) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.cookTime = cookTime;
        this.dayCreate = dayCreate;
        this.lastUpdate = lastUpdate;
        this.tag = tag;
        this.quantity = quantity;
    }

    public Food(int status, int shop_id, int tag_id, int deal_id, String name, String description, String image, double price, Time cookTime, Date dayCreate, Date lastUpdate, List<Tag> tag, int quantity) {
        this.status = status;
        this.shop_id = shop_id;
        this.tag_id = tag_id;
        this.deal_id = deal_id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.cookTime = cookTime;
        this.dayCreate = dayCreate;
        this.lastUpdate = lastUpdate;
        this.tag = tag;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Time getCookTime() {
        return cookTime;
    }

    public void setCookTime(Time cookTime) {
        this.cookTime = cookTime;
    }

    public Date getDayCreate() {
        return dayCreate;
    }

    public void setDayCreate(Date dayCreate) {
        this.dayCreate = dayCreate;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getShop_id() {
        return shop_id;
    }

    public void setShop_id(int shop_id) {
        this.shop_id = shop_id;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public int getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(int deal_id) {
        this.deal_id = deal_id;
    }
}
