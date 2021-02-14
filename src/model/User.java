package model;

public class User {
    private String name;
    private String id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }



    public User(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String  getId() {
        return id;
    }
}
