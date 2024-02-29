package org.example;

import java.lang.reflect.*;
import java.util.Random;

import org.apache.commons.lang3.*;

class RandomObjectGenerator {
    private static final Random random = new Random();
    <T> T fullRandomObjectGenerate(Class<T> targetClass) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        try {
            Constructor<T> constructor = targetClass.getConstructor();
            T returner = constructor.newInstance();
            Field[] fields = targetClass.getDeclaredFields();
            for (Field fld : fields) {
                fld.setAccessible(true);
                if (fld.getType().equals(String.class)) {
                    fld.set(returner, getRandomString());
                }
                else if (fld.getType().isEnum()) {
                    fld.set(returner, getRandomEnum(fld.getType()));
                }
                else if (fld.getType().equals(Integer.class)) {
                    fld.set(returner, getRandomInt());
                }
                else if (fld.getType().equals(Double.class)) {
                    fld.set(returner, getRandomDouble());
                }
                else if (fld.getType().equals(Short.class)) {
                    fld.set(returner, getRandomShort());
                }
                else if (fld.getType().equals(Character.class)) {
                    fld.set(returner, getRandomChar());
                }
                else if (fld.getType().equals(Boolean.class)) {
                    fld.set(returner, getRandomBoolean());
                }
                else if (fld.getType().equals(Byte.class)) {
                    fld.set(returner, getRandomByte());
                }
                else if (fld.getType().equals(Long.class)) {
                    fld.set(returner, getRandomLong());
                }
                else if (fld.getType().equals(Float.class)) {
                    fld.set(returner, getRandomFloat());
                }
                else{
                    System.out.println("Такой тип данных не обрабатывается");
                }
                fld.setAccessible(false);
            }
            return returner;
        }
        catch (NoSuchMethodException e){
            System.out.println("Нет конструкторов в классе(нужно создать хотя бы пустой самому)");
            return null;
        }
    }
    <T> T nullFieldsRandomObjectGenerate(T informationObject, Class<T> targetClass) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        try {
            Constructor<T> constructor = targetClass.getConstructor();
            T returner = constructor.newInstance();
            Field[] fields = targetClass.getDeclaredFields();
            for (Field fld : fields) {
                fld.setAccessible(true);
                if (fld.get(informationObject) == null) {
                    if (fld.getType().equals(String.class)) {
                        fld.set(returner, getRandomString());
                    }
                    else if (fld.getType().isEnum()) {
                        fld.set(returner, getRandomEnum(fld.getType()));
                    }
                    else if (fld.getType().equals(Integer.class)) {
                        fld.set(returner, getRandomInt());
                    }
                    else if (fld.getType().equals(Double.class)) {
                        fld.set(returner, getRandomDouble());
                    }
                    else if (fld.getType().equals(Short.class)) {
                        fld.set(returner, getRandomShort());
                    }
                    else if (fld.getType().equals(Character.class)) {
                        fld.set(returner, getRandomChar());
                    }
                    else if (fld.getType().equals(Boolean.class)) {
                        fld.set(returner, getRandomBoolean());
                    }
                    else if (fld.getType().equals(Byte.class)) {
                        fld.set(returner, getRandomByte());
                    }
                    else if (fld.getType().equals(Long.class)) {
                        fld.set(returner, getRandomLong());
                    }
                    else if (fld.getType().equals(Float.class)) {
                        fld.set(returner, getRandomFloat());
                    }
                    else{
                        System.out.println("Такой тип данных не обрабатывается");
                    }
                }
                else {
                    fld.set(returner, fld.get(informationObject));
                }
                fld.setAccessible(false);
            }
            return returner;
        }
        catch (NoSuchMethodException e){
            System.out.println("Нет конструкторов в классе(нужно создать хотя бы пустой самому)");
            return null;
        }
    }

    String getRandomString(){
        int length = 24;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    char getRandomChar(){
        int length = 1;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers).charAt(0);
    }

    <T> T getRandomEnum(Class<T> e)  {
        return e.getEnumConstants()[random.nextInt(e.getEnumConstants().length)];
    }

    int getRandomInt() {
        return random.nextInt();
    }

    long getRandomLong() {
        return random.nextLong();
    }

    float getRandomFloat() {
        return random.nextFloat();
    }

    boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    byte getRandomByte() {
        int minValue = -128;
        int maxValue = 127;
        return (byte) (minValue + (int) (Math.random() * (maxValue - minValue + 1)));
    }

    short getRandomShort() {
        int minValue = -32768;
        int maxValue = 32767;
        return (short) (minValue + (int) (Math.random() * (maxValue - minValue + 1)));
    }

    double getRandomDouble() {
        return random.nextDouble();
    }
}