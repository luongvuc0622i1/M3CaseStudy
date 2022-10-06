package model;

public class Client {

    private int id;
    private String code;
    private String name;
    private String phone;
    private String address;
    private String email;
    private String account;
    private String password;
    private int status;

    public Client() {
    }

    public Client(int id, String code, String name, String phone, String address, String email, String account, String password, int status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.status = status;
    }

    public Client(String code, String name, String phone, String address, String email, String account, String password, int status) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
