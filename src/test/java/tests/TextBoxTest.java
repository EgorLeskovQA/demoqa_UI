package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase {
    private final TextBoxPage textBoxPage = new TextBoxPage();

    String fullName = "Egor Egorich",
            userEmail = "1111@111.ru",
            currentAddress = "Kutuzovskaya",
            permanentAddress = "Moscow";

    @Test

    void textBoxTest() {
        textBoxPage.openPage()
                .setFullName(fullName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .clickSubmit();

        textBoxPage.checkResult("Name:", fullName)
                .checkResult("Email:", userEmail)
                .checkResult("Current Address :", currentAddress)
                .checkResult("Permananet Address :", permanentAddress);

    }
}
