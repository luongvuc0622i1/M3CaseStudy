package model;


import java.util.Date;

public class Deal {
    private int id, status;
    private double percent;
    private String code, name, description, image;
    private Date startDate, endDate;

    public Deal() {
    }

    public Deal(int id, int status, double percent, String code, String name, String description, String image, Date startDate, Date endDate) {
        this.id = id;
        this.status = status;
        this.percent = percent;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Deal(int status, double percent, String code, String name, String description, String image, Date startDate, Date endDate) {
        this.status = status;
        this.percent = percent;
        this.code = code;
        this.name = name;
        this.description = description;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", status=" + status +
                ", percent=" + percent +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
