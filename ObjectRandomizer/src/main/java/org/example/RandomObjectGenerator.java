package org.example;

import java.lang.reflect.*;
import java.util.Random;

import org.apache.commons.lang3.*;

class RandomObjectGenerator {
    private static final Random random = new Random();
    <T> T fullRandomObjectGenerate(Class object) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = object.getConstructor();
        T returner = constructor.newInstance();
        Field[] fields = object.getDeclaredFields();
        for(Field fld:fields){
            fld.setAccessible(true);
            if(fld.getType() == String.class){
                fld.set(returner, generateRandomString());
            }
            if(fld.getType().isEnum()) {
                fld.set(returner, generateRandomEnum(fld.getType()));
            }
            if(fld.getType() == Integer.class){
                fld.set(returner, getRandomInt());
            }
            if(fld.getType() == Double.class){
                fld.set(returner, getRandomDouble());
            }
            fld.setAccessible(false);
        }
        return returner;
    }
    <T> T nullFieldsRandomObjectGenerate(T object, Class clazz) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = clazz.getConstructor();
        T returner = constructor.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for(Field fld:fields){
            fld.setAccessible(true);
            if(fld.get(object) ==null) {
                if(fld.getType() == String.class){
                    fld.set(returner, generateRandomString());
                }
                if(fld.getType().isEnum()) {
                    fld.set(returner, generateRandomEnum(fld.getType()));
                }
                if(fld.getType() == Integer.class){
                    fld.set(returner, getRandomInt());
                }
                if(fld.getType() == Double.class){
                    fld.set(returner, getRandomDouble());
                }
            }
            else {
                fld.set(returner,fld.get(object));
            }
            fld.setAccessible(false);
        }
        return returner;
    }

    String generateRandomString(){
        int length = 24;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    <T> T generateRandomEnum(Class<T> e)  {
        return e.getEnumConstants()[random.nextInt(e.getEnumConstants().length)];
    }

    public int getRandomInt() {
        return random.nextInt();
    }

    public double getRandomDouble() {
        return random.nextDouble();
    }
}