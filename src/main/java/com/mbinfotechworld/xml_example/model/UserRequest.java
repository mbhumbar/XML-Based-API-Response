package com.mbinfotechworld.xml_example.model;

public class UserRequest {

    private int userId;
    private String name;
    private int age;
    private String email;

    public UserRequest() {}

    public UserRequest(int userId, String name, int age, String email) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
