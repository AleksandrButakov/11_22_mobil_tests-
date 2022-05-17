package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase {

    @Test
    void searchTest() {
        /*
        step("Type search", () -> {
            // $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("ru.anbn.testapplication:id/editText1")).setValue("12");

            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .setValue("BrowserStack");

            $(AppiumBy.id("ru.anbn.testapplication:id/editText2")).setValue("5");
            $(AppiumBy.id("ru.anbn.testapplication:id/button1")).click();
        });
         */
        step("Checking the opening of the main page", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/" +
                    "android.view.ViewGroup/android.widget.TextView")).shouldHave(text("Распиновка разъемов"));
        });

        step("Pressing the button without the selected parameters", () -> {
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Выберите интересующий тип"));
        });

        step("Checking Main menu, About", () -> {
            $(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]")).click();
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/" +
                    "android.widget.RelativeLayout/android.widget.TextView")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView3")).shouldHave(text("О ПРОГРАММЕ"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Выберите интересующий тип"));
        });

        step("Checking Main menu, Search", () -> {
            $(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]")).click();

            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/" +
                    "android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/" +
                    "android.widget.RelativeLayout/android.widget.TextView")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Для поиска необходимого оборудо"));
            $(AppiumBy.id("android:id/search_button")).click();
            $(AppiumBy.id("android:id/search_src_text")).setValue("asr");
            $$(AppiumBy.id("android:id/text1")).findBy(text("CWDM")).click();

        });

        sleepMethod();

        /*
        step("Verify content found", () ->
                $$(AppiumBy.className("android.widget.TextView"))
                        .shouldHave(sizeGreaterThan(0)));
         */
        /*
        step("Verify content found", () ->
                $(AppiumBy.id("ru.anbn.testapplication:id/textView2")).shouldHave(Condition.text("17"))
        );
         */

    }

    void sleepMethod() {
        sleep(1000);
    }

}
