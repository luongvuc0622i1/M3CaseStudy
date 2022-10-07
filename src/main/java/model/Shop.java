package model;

import java.sql.Time;

public class Shop {
    private int id, status;
    private Time open, close;
    private String code, name, email, phone, address, account, password, image, description;
    private Service service;

    public Shop() {
    }

    public Shop(int status, Time open, Time close, String code, String name, String email, String phone, String address, String account, String password, String image, String description, Service service) {
        this.status = status;
        this.open = open;
        this.close = close;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.account = account;
        this.password = password;
        this.image = image;
        this.description = description;
        this.service = service;
    }

    public Shop(int id, int status, Time open, Time close, String code, String name, String email, String phone, String address, String account, String password, String image, String description, Service service) {
        this.id = id;
        this.status = status;
        this.open = open;
        this.close = close;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.account = account;
        this.password = password;
        this.image = image;
        this.description = description;
        this.service = service;
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

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Service getService() {
        return service;
    }
    public int getServiceId() {
        return service.getId();
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", status=" + status +
                ", open=" + open +
                ", close=" + close +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", service=" + service +
                '}';
    }
}
