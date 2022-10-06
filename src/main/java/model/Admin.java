package model;

public class Admin {

    private int id;
    private String name;
    private String account;
    private String password;
    private String image;

    public Admin() {
    }

    public Admin(int id, String name, String account, String password, String image) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
        this.image = image;
    }

    public Admin(String name, String account, String password, String image) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
