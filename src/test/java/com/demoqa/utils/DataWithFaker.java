package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.*;

public class DataWithFaker {


    Faker faker = new Faker();
    public String subjects;

    {
        subjects = faker.options().option("English", "Physics", "Chemistry", "Computer Science",
                "Commerce", "Accounting", "Economics");
    }

    public String hobbies;

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
    public String year = sdfyear.format(myBirthday);
    SimpleDateFormat sdfmonthForRegistrationPage = new SimpleDateFormat("MM", Locale.ENGLISH);
    SimpleDateFormat sdfmonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    public String monthForRegistrationPage = Integer.toString(myBirthday.getMonth());
    public String month = sdfmonth.format(myBirthday);
    SimpleDateFormat sdfday = new SimpleDateFormat("dd");
    public String day = sdfday.format(myBirthday);

    public String pictureLocation = "sample.png";

    public String userAddress = faker.address().streetName();


    Map<String, String[]> mapStateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );
    public String state = faker.options().option(mapStateWithCity.keySet().toArray()).toString();
    public String usercity = faker.options().option(mapStateWithCity.get(state));


}

