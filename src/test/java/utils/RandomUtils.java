package utils;

import com.github.javafaker.Faker;
import data.enums.Subjects;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class RandomUtils {

    private static final Faker faker = new Faker(new Locale("en-GB"));

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getUserEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String getUserNumber() {
        return faker.phoneNumber().subscriberNumber(10);    }

    public static String getHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String getUploadFile() {
        return faker.options().option("picture_1.png", "picture_2.png");
    }

    public static String getAddress() {
        return faker.address().streetAddress();
    }

    private static final Date birthDate = faker.date().birthday(18, 70);
    private static final SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.ENGLISH);
    private static final SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
    private static final SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);

    public static String getBirthDay() {
        return dayFormat.format(birthDate);
    }

    public static String getBirthMonth() {
        return monthFormat.format(birthDate);
    }

    public static String getBirthYear() {
        return yearFormat.format(birthDate);
    }

    public static String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }


    public static List<Subjects> getRandomSubjects(int count) {
        List<Subjects> all = new ArrayList<>(List.of(Subjects.values()));
        Collections.shuffle(all);
        return all.subList(0, count);
    }

    public static String convertSubjectsToString(List<Subjects> subjects) {
        return subjects.stream()
                .map(Enum::name)
                .collect(Collectors.joining(", "));
    }




}
