package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class DataWithFaker {


    Faker faker = new Faker();
    String subjects;

    {
        subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
    }

    String hobbies;

    {
        hobbies = faker.options().option("Music", "Sports", "Reading");
    }

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();

    public String userEmail = faker.internet().emailAddress();

    public String gender = faker.options().option("Male", "Female", "Other");


    public String phoneNumber = 8 + faker.phoneNumber().subscriberNumber(9);
    Date myBirthday = faker.date().birthday();
    SimpleDateFormat sdfyear = new SimpleDateFormat("yyyy");
    public String year = sdfyear.format(myBirthday) ;
    SimpleDateFormat sdfmonth = new SimpleDateFormat("M",Locale.ENGLISH);
    public String month = sdfmonth.format(myBirthday) ;
    SimpleDateFormat sdfday = new SimpleDateFormat("dd");
    public String day = sdfday.format(myBirthday);



    String pictureLocation = "1.jpeg";

    String userAddress = faker.address().streetName();


    Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    String usercity = faker.options().option(mapStateWithCity.get(state));


}

