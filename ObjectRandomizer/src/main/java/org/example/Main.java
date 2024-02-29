package org.example;

import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Account randomAccount1 = randomObjectGenerator.<Account>fullRandomObjectGenerate(Account.class);
        Account man = new Account();
        man.setFirstName("Man");
        Account randomAccount2 = randomObjectGenerator.<Account>nullFieldsRandomObjectGenerate(man, Account.class);
        randomAccount2.Show();
    }
}

enum Gender {
    Male,
    Female;
}

class Account {
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;

    public Account() {
    }

    public void Show() {
        System.out.println(this.firstName);
        System.out.println(this.lastName);
        System.out.println(this.middleName);
        System.out.println(this.gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
