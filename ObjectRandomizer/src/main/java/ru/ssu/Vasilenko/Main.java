package ru.ssu.Vasilenko;

import java.lang.reflect.InvocationTargetException;

public class Main {
    private static final RandomObjectGenerator randomObjectGenerator = new RandomObjectGenerator();

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Account randomAccount1 = randomObjectGenerator.<Account>fullRandomObjectGenerate(Account.class);
        Account man = new Account();
        man.setFirstName("MAN");
        Account randomAccount2 = randomObjectGenerator.<Account>nullFieldsRandomObjectGenerate(man, Account.class);
        System.out.println(randomAccount2.toString());
    }
}

