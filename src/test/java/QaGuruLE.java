import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class QaGuruLE {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulSearchTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Egor");
        $("#lastName").setValue("Egorich");
        $("#userEmail").setValue("1111@111.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1111111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").$("option[value='2000']").click();
        $(".react-datepicker__month-select").$("option[value='7']").click();
        $(".react-datepicker__day--013").click();
        $("#subjectsInput").setValue("E").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("tst.jpg");
        $("#currentAddress").setValue("Kutuzovskaya");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Del").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Egor Egorich"));
        $(".table-responsive").shouldHave(text("1111@111.ru"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1111111111"));
        $(".table-responsive").shouldHave(text("13 August,2000"));
        $(".table-responsive").shouldHave(text("English"));
        $(".table-responsive").shouldHave(text("Sport"));
        $(".table-responsive").shouldHave(text("tst.jpg"));
        $(".table-responsive").shouldHave(text("Kutuzovskaya"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}