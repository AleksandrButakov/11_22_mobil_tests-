package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase {

    @Test
    void searchTest() {
        step("Type search", () -> {
            // $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("ru.anbn.testapplication:id/editText1")).setValue("12");
            /*
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("BrowserStack");
             */
            $(AppiumBy.id("ru.anbn.testapplication:id/editText2")).setValue("5");
            $(AppiumBy.id("ru.anbn.testapplication:id/button1")).click();
        });
        /*
        step("Verify content found", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(sizeGreaterThan(0)));
         */
        step("Verify content found", () ->
                $(AppiumBy.id("ru.anbn.testapplication:id/textView2")).shouldHave(Condition.text("17"))
                );
    }

}
