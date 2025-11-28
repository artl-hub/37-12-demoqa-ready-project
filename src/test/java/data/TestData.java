package utils;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.RandomUtils.*;

public class TestData {
    private static final Faker faker = new Faker();

    public final String firstName = getFirstName();
    public final String lastName = getLastName();
    public final String email = getUserEmail();
    public final String gender = getGender();
    public final String userNumber = getUserNumber();
    public final String subject = getSubject();
    public final String hobby = getHobby();
    public final String uploadFile = getUploadFile();
    public final String address = getAddress();

    public final String birthDay = getBirthDay();
    public final String birthMonth = getBirthMonth();
    public final String birthYear = getBirthYear();
    public final String checkDateOfBirth = String.format("%s %s,%s", birthDay, birthMonth, birthYear);

    public final String state = getState();
    public final String city = getCity(state);

    ///////////////////////////////////////////////

    // 🔹 новые поля для предметов
    private static final List<String> SUBJECT_POOL = Arrays.asList(
            "Maths", "Physics", "Chemistry", "Biology", "English", "History"
    );

    // список выбранных предметов
    public List<String> subjectsList;

    // строка для проверки в модалке: "Maths, Physics, Chemistry"
    public String subjectsString;

    public TestData() {
        // здесь уже, скорее всего, есть твоя логика по датам, штату, городу и т.п.
        // просто добавь внутрь конструктора вот это:

        List<String> shuffled = new ArrayList<>(SUBJECT_POOL);
        Collections.shuffle(shuffled);

        // берём первые 3 предмета
        subjectsList = shuffled.subList(0, 3);

        // "Maths, Physics, Chemistry"
        subjectsString = String.join(", ", subjectsList);
    }


}