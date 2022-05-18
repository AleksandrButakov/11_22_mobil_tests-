package guru.qa.tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AndroidSelenideTests extends TestBase {

    @Test
    void searchTest() {
        step("Checking the opening of the main page", () -> {
            $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/" +
                    "android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/" +
                    "android.view.ViewGroup/android.widget.TextView")).shouldHave(text("Распиновка разъемов"));
        });

        step("Pressing the button without the selected parameters", () -> {
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Выберите интересующий тип"));
        });

        step("Checking Main menu, Search", () -> {
            $(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]")).click();
            $$(AppiumBy.id("com.anbn.pinout:id/title")).findBy(text("Строка")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Для поиска необходимого оборудо"));
            $(AppiumBy.id("android:id/search_button")).click();
        });

        step("Search 'SMK-30 MUX'", () -> {
            $(AppiumBy.id("android:id/search_src_text")).setValue("СМК-30");
            $$(AppiumBy.id("android:id/text1")).findBy(text("СМК-30 (MUX)")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView")).shouldHave(text("СМК-30 (MUX)"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Search 'CMA'", () -> {
            $(AppiumBy.id("android:id/search_src_text")).setValue("СМА");
            $$(AppiumBy.id("android:id/text1")).findBy(text("СМА-2-4")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView")).shouldHave(text("СМА-2-4"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Search 'MDK'", () -> {
            $(AppiumBy.id("android:id/search_src_text")).setValue("МДК");
            $$(AppiumBy.id("android:id/text1")).findBy(text("МДК-М1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView")).shouldHave(text("МДК-М1"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Search 'ASR-920'", () -> {
            $(AppiumBy.id("android:id/search_src_text")).setValue("ASR-920");
            $$(AppiumBy.id("android:id/text1")).findBy(text("ASR-920")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView")).shouldHave(text("ASR-920"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/button")).click();
        });

        step("Checking Main menu, About", () -> {
            $(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Ещё\"]")).click();
            $$(AppiumBy.id("com.anbn.pinout:id/title")).findBy(text("О программе")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView3")).shouldHave(text("О ПРОГРАММЕ"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView1")).shouldHave(text("Выберите интересующий тип"));
        });

        step("Manual selection of equipment Cisco", () -> {
            $(AppiumBy.id("com.anbn.pinout:id/spinner1")).click();
            $$(AppiumBy.id("android:id/text1")).findBy(text("Оборудование Cisco, ВСТСПД")).click();
            $(AppiumBy.id("com.anbn.pinout:id/spinner2")).click();
            $$(AppiumBy.id("android:id/text1")).findBy(text("RJ-45 connector Ethernet")).click();
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView")).shouldHave(text("RJ-45 connector Ethernet"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
        });

        step("Manual selection of equipment VSTSPD", () -> {
            $(AppiumBy.id("com.anbn.pinout:id/spinner1")).click();
            $$(AppiumBy.id("android:id/text1")).findBy(text("Оборудование Cisco, ВСТСПД")).click();
            $(AppiumBy.id("com.anbn.pinout:id/spinner2")).click();
            $$(AppiumBy.id("android:id/text1")).findBy(text("Оборудование ВСТСПД")).click();
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
            $(AppiumBy.id("com.anbn.pinout:id/textView")).shouldHave(text("Оборудование ВСТСПД"));
            $(AppiumBy.id("com.anbn.pinout:id/button1")).click();
        });
    }

}

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