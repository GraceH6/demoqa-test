package com.demoqa.utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class RandomUtils {
    static Faker faker = new Faker(new Locale("en-IND"));
    static SimpleDateFormat date = new SimpleDateFormat("yyy MMMM dd", Locale.ENGLISH);
    static String str = date.format(faker.date().birthday());
    static String[] splitDate = str.split(" ");
    static String[] gender = {"Male", "Female", "Other"},
                    subjects = {"Maths", "Computer Science", "History", "Chemistry",
                    "Economics", "Commerce", "Hindi", "English", "History", "Physics"},
                    hobby = {"Sports", "Reading", "Music"},
                    states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
                    citiesOfNCR = {"Delhi", "Gurgaon", "Noida"},
                    citiesOfUttarPradesh = {"Agra", "Lucknow", "Merrut"},
                    citiesOfHaryana = {"Karnal", "Panipat"},
                    citiesOfRajasthan = {"Jaipur", "Jaiselmer"};

    public static String getRandomGender() {
        return faker.options().option(gender);
    }

    public static String getRandomSubject() {
        return faker.options().option(subjects);
    }

    public static String getRandomHobby() {
        return faker.options().option(hobby);
    }

    public static String setRandomYear() {
        return splitDate[0];
    }
    public static String setRandomMonth() {
        return splitDate[1];
    }
    public static String setRandomDay() {
        return splitDate[2];
    }

    public static String getRandomState() {
        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                return faker.options().option(citiesOfNCR);
            }
            case "Uttar Pradesh": {
                return faker.options().option(citiesOfUttarPradesh);
            }
            case "Haryana": {
                return faker.options().option(citiesOfHaryana);
            }
            case "Rajasthan": {
                return faker.options().option(citiesOfRajasthan);
            }
        }
        return null;
    }
    public static String userName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userNumber = faker.number().digits(10).toString(),
            year = RandomUtils.setRandomYear(),
            month = RandomUtils.setRandomMonth(),
            day = RandomUtils.setRandomDay(),
            userAddress = faker.address().streetAddress(),
            userState = getRandomState(),
            userCity = getRandomCity(userState),
            genderIs = RandomUtils.getRandomGender(),
            subjectIs = RandomUtils.getRandomSubject(),
            hobbyIs = RandomUtils.getRandomHobby();
}
