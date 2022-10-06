package model;

public class Services {

private int food_id;
private int views = 100;
private int orderr = 200;

    public Services(int food_id, int views, int orderr) {
        this.food_id = food_id;
        this.views = views;
        this.orderr = orderr;
    }

    public int getFood_id() {
        return food_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getOrderr() {
        return orderr;
    }

    public void setOrderr(int orderr) {
        this.orderr = orderr;
    }
}
