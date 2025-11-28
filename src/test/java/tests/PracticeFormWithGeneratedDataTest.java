package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import data.TestData;

import static io.qameta.allure.Allure.step;

public class PracticeFormWithGeneratedDataTest extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Tag("positive")
    @Epic("DemoQA Form Tests")
    @Feature("Practice Form")
    @Story("Successful form submission")
    @Owner("Zuckerberg")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify successful registration in the form")
    @Description("Check that the user can successfully submit the registration form with valid data")
    @Test

    void successfulRegistrationTest() {
        TestData data = new TestData();

        step("Open the form page", () -> {
            practiceFormPage
                    .openPage();
        });

        step("Fill in all fields", () -> {
            practiceFormPage
                    .removeBanners()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                    .setSubject(data.subject)
                    .setHobbies(data.hobby)
                    .uploadFile(data.uploadFile)
                    .setAddress(data.address)
                    .scrollToBottom()
                    .stateClick()
                    .setState(data.state)
                    .cityClick()
                    .setCity(data.city);
        });

        step("Click the Submit button", () -> {
            practiceFormPage
                    .submitClick();
        });

        step("Check that the modal window is filled", () -> {
            practiceFormPage
                    .checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.userNumber)
                    .checkResult("Date of Birth", data.checkDateOfBirth)
                    .checkResult("Subjects", data.subject)
                    .checkResult("Hobbies", data.hobby)
                    .checkResult("Picture", data.uploadFile)
                    .checkResult("Address", data.address)
                    .checkResult("State and City", data.state + " " + data.city);
        });

        step("Click the close modal window button", () -> {
            practiceFormPage
                    .closeModalWindow();
        });

        step("Check that the modal window has disappeared", () -> {
            practiceFormPage
                    .modalWindowShouldNotExist();
        });

    }

    @Tag("positive")
    @Epic("DemoQA Form Tests")
    @Feature("Practice Form")
    @Story("Successful registration with minimal data")
    @Owner("Zuckerberg")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify successful registration with minimal data")
    @Description("Check that the user can successfully submit the registration form when only required fields are filled")
    @Test
    void successfulRegistrationMinimalDataTest() {
        TestData data = new TestData();

        step("Open the form page", () -> {
            practiceFormPage
                    .openPage();
        });

        step("Fill in the required fields", () -> {
            practiceFormPage
                    .removeBanners()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                    .setAddress(data.address)
                    .setHobbies(data.hobby);
        });

        step("Scroll to bottom", () -> {
            practiceFormPage
                    .scrollToBottom();
        });

        step("Click the Submit button", () -> {
            practiceFormPage
                    .submitClick();
        });

        step("Check that the modal window is filled", () -> {
            practiceFormPage
                    .checkResult("Student Name", data.firstName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.userNumber)
                    .checkResult("Date of Birth", data.birthDay)
                    .checkResult("Hobbies", data.hobby)
                    .checkResult("Address", data.address);
        });

        step("Click the close modal window button", () -> {
            practiceFormPage
                    .closeModalWindow();
        });

        step("Check that the modal window has disappeared", () -> {
            practiceFormPage
                    .modalWindowShouldNotExist();
        });
    }

    @Tag("negative")
    @Epic("DemoQA Form Tests")
    @Feature("Practice Form")
    @Story("Registration without phone number")
    @Owner("Zuckerberg")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify that registration fails without a phone number")
    @Description("Check that the user cannot submit the registration form when the phone number field is empty")
    @Test
    void shouldNotRegisterWithoutPhoneNumberTest() {
        TestData data = new TestData();

        step("Open the form page", () -> {
            practiceFormPage
                    .openPage();
        });

        step("Fill required fields without phone number", () -> {
            practiceFormPage
                    .removeBanners()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber("")
                    .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                    .setAddress(data.address)
                    .setHobbies(data.hobby);
            ;
        });

        step("Scroll to bottom", () -> {
            practiceFormPage
                    .scrollToBottom();
        });

        step("Click the Submit button", () -> {
            practiceFormPage
                    .submitClick();
        });

        step("Check that the modal window has disappeared", () -> {
            practiceFormPage
                    .modalWindowShouldNotExist();
        });
    }

    @Tag("positive")
    @Epic("DemoQA Form Tests")
    @Feature("Practice Form")
    @Story("Selecting multiple subjects in the form")
    @Owner("Zuckerberg")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify that user can select multiple subjects")
    @Description("Check that the user can select several subjects and they appear in the result table")
    @Test
    void multipleSubjectsTest() {
        TestData data = new TestData();

        step("Open the form page", () -> {
            practiceFormPage.openPage();
        });

        step("Fill in required fields", () -> {
            practiceFormPage
                    .removeBanners()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                    .setAddress(data.address)
                    .setHobbies(data.hobby);
        });

        step("Select multiple subjects", () -> {
            practiceFormPage.setSubjects(data.subjectsList);

        });

        step("Scroll and submit", () -> {
            practiceFormPage.scrollToBottom();
            practiceFormPage.submitClick();
        });

        step("Check the modal window results", () -> {
            practiceFormPage
                    .checkResult("Subjects", data.subjectsString);
        });

        step("Close modal", () -> {
            practiceFormPage.closeModalWindow()
                    .modalWindowShouldNotExist();
        });
    }

    @Tag("negative")
    @Epic("DemoQA Form Tests")
    @Feature("Practice Form")
    @Story("Phone validation: too short number")
    @Owner("Zuckerberg")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify that user cannot submit form with short phone number")
    @Description("Check that the form does not submit when phone number is shorter than 10 digits")
    @Test
    void shouldNotRegisterWithShortPhoneNumber() {
        TestData data = new TestData();

        step("Open the form page", () -> {
            practiceFormPage.openPage();
        });

        step("Fill in required fields with short phone number", () -> {
            practiceFormPage
                    .removeBanners()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber("12345") // слишком короткий номер
                    .setDateOfBirth(data.birthDay, data.birthMonth, data.birthYear)
                    .setAddress(data.address)
                    .setHobbies(data.hobby);
        });

        step("Scroll", () -> {
            practiceFormPage.scrollToBottom();
        });

        step("Click Submit", () -> {
            practiceFormPage.submitClick();
        });

        step("Verify that modal did NOT appear", () -> {
            practiceFormPage.modalWindowShouldNotExist();
        });
    }



}

