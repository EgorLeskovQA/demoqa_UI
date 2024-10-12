package tests;

import org.junit.jupiter.api.Test;
import pages.QaGuruPage;

public class QaGuruLE extends TestBase{

    private final QaGuruPage qaGuruPage = new QaGuruPage();
    String firstName = "Egor",
            lastName = "Egorich",
            userEmail = "1111@111.ru",
            gender = "Male",
            userNumber = "1111111111",
            negativeUserNumber = "dfsgassdf",
            dayOfBirth = "13",
            monthOfBirth = "August",
            yearOfBirth = "2000",
            subjects = "English",
            hobbies = "Sports",
            pictureName = "tst.jpg",
            address = "Kutuzovskaya",
            state = "NCR",
            city = "Delhi";




    @Test
    void fullFormTest() {
        qaGuruPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subjects)
                .setHobby(hobbies)
                .uploadPicture(pictureName)
                .setCurrentAddress(address)
                .setUserState(state)
                .setUserCity(city)
                .clickSubmit();


        qaGuruPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                .checkSuccessResult ("Student Email", userEmail)
                .checkSuccessResult ("Gender", gender)
                .checkSuccessResult ("Mobile", userNumber)
                .checkSuccessResult ("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkSuccessResult ("Subjects", subjects)
                .checkSuccessResult ("Hobbies", hobbies)
                .checkSuccessResult ("Picture", pictureName)
                .checkSuccessResult ("Address", address)
                .checkSuccessResult ("State and City", state + " " + city);
    }

    @Test
    void minFormTest() {
        qaGuruPage.openPage()
                .removeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit();

        qaGuruPage.checkSuccessResult("Student Name", firstName + " " + lastName)
                .checkSuccessResult("Student Email", userEmail)
                .checkSuccessResult("Gender", gender)
                .checkSuccessResult("Mobile", userNumber);
    }

    @Test
    void negativeFormTest() {
        qaGuruPage.openPage()
                .removeBanner()
                .setUserNumber(negativeUserNumber)
                .clickSubmit();

        qaGuruPage.checkNegativeResult();
    }
}