package com.example.roomie.LocalDB;

public class User {
    String Us_id;
    String name;
    String surname;
    String mr;
    String age;
    String IDNumber;
    String telephone;
    String email;
    String gender;
    String occupation;
    String aboutMe;

    public String getAboutMe() {
        return aboutMe;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMr() {
        return mr;
    }

    public String getAge() {
        return age;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public User(String name, String surname, String mr, String age, String IDNumber,
                String telephone, String email, String gender, String occupation, String aboutMe) {
        this.name = name;
        this.surname = surname;
        this.mr = mr;
        this.age = age;
        this.IDNumber = IDNumber;
        this.telephone = telephone;
        this.email = email;
        this.gender = gender;
        this.occupation = occupation;
        this.aboutMe = aboutMe;
    }

}
