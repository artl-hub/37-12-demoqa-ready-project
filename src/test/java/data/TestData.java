package data;

import com.github.javafaker.Faker;
import data.enums.Subjects;
import utils.RandomUtils;

import java.util.List;

import static utils.RandomUtils.*;

public class TestData {
    private static final Faker faker = new Faker();

    public final String firstName = getFirstName();
    public final String lastName = getLastName();
    public final String email = getUserEmail();
    public final String gender = getGender();
    public final String userNumber = getUserNumber();
    public final String hobby = getHobby();
    public final String uploadFile = getUploadFile();
    public final String address = getAddress();

    public final String birthDay = getBirthDay();
    public final String birthMonth = getBirthMonth();
    public final String birthYear = getBirthYear();
    public final String checkDateOfBirth =
            String.format("%s %s,%s", birthDay, birthMonth, birthYear);

    public final String state = getState();
    public final String city = getCity(state);

    ///////////////////////////////////////////////

    // один предмет сразу как строка — удобно для теста и PageObject
    public final String subject = RandomUtils.getRandomSubjects(1).get(0).name();

    // несколько предметов (enum + строка для проверки)
    public final List<Subjects> subjectsList = RandomUtils.getRandomSubjects(3);
    public final String subjectsString = RandomUtils.convertSubjectsToString(subjectsList);

}
