package com.demoqa.utils;

import com.github.javafaker.Faker;
import io.netty.util.internal.ThreadLocalRandom;

import java.security.SecureRandom;

public class RandomUtils {
    static Faker faker = new Faker();

    public static void main(String[] args) {


        System.out.println(getRandomMonth());
    }

    public static String getRandomString(int len) {
        String AB = "01234567890QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        SecureRandom sr = new SecureRandom();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(sr.nextInt(AB.length())));
        }
        return sb.toString();
    }


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }



    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return faker.options().option(genders);
    }


    public static String getRandomFirstName() {
        return new Faker().name().firstName();
    }

    public static String getRandomLastName() {
        return new Faker().name().lastName();
    }

    public static String getRandomUserEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return new Faker().phoneNumber().subscriberNumber(10);
    }

    public static String getRandomDay() {
        int day = faker.number().numberBetween(1, 28);
        if (day < 10) {
            return "0" + day;
        } else {
            return day + "";
        }
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return new Faker().options().option(months);
    }


}