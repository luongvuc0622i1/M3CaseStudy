package model;

public class Tag {
    private int id, status;
    private String code, name, description;

    public Tag() {
    }

    public Tag(int id, String code, String name, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Tag(String code, String name, String description, int status) {
        this.status = status;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Tag(int id, int status, String code, String name, String description) {
        this.id = id;
        this.status = status;
        this.code = code;
        this.name = name;
        this.description = description;
    }

    public Tag(String code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", status=" + status +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
