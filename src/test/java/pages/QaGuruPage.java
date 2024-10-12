package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.TableComponents;
import tests.QaGuruLE;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class QaGuruPage {
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            userSubjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            userStateInput = $("#react-select-3-input"),
            userCityInput = $("#react-select-4-input"),
            submitInput = $("#submit");


    public QaGuruPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public QaGuruPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public QaGuruPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public QaGuruPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public QaGuruPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public QaGuruPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public QaGuruPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public QaGuruPage setBirthDay(String day, String month, String year) {
        calendarInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    public QaGuruPage setSubject(String value) {
        userSubjectInput.setValue(value).pressEnter();
        return this;
    }

    public QaGuruPage setHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public QaGuruPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public QaGuruPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public QaGuruPage setUserState(String value) {
        userStateInput.setValue(value).pressEnter();
        return this;
    }

    public QaGuruPage setUserCity(String value) {
        userCityInput.setValue(value).pressEnter();
        return this;
    }

    public void clickSubmit () {
        submitInput.click();
    }

    public QaGuruPage checkSuccessResult(String key, String value) {
        new TableComponents().checkSuccessResult(key, value);
        return this;
    }

    public void checkNegativeResult() {
        new TableComponents().checkNegativeResult();
    }
}
