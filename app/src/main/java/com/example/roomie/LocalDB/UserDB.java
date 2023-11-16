package com.example.roomie.LocalDB;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Tom", "Hank", "Mr", "22","1234567890", "2771523648", "example@mail.com", "male", "student", "I am zulu. And like music"));
        users.add(new User("Smith", "Lee", "Mr", "25","1021579536", "2771532444", "example3@mail.com", "male", "worker", "I am khoi san, and like art"));
        users.add(new User("Getty", "Sharlok", "Miss", "23","2012553678", "2771059745", "example3@mail.com", "Female", "worker", "I am blue, and I like juice."));
        users.add(new User("Luis", "Homles", "Miss", "25","7984563615", "2771523648", "example3@mail.com", "Female", "student", "I am lazy, and sleep all day"));
    }

    public static void addUser(User user){
        users.add(user);
    }

    public static List<User> getUsers(){
        return users;
    }
}
