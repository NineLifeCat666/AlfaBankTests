import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AlfaBanksTests {
    @Test
    void archivedDipositesTest(){
        Configuration.startMaximized=true;
        open("https://alfabank.ru/");
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Накопительные продукты"));
        $(byText("Архивные счета и депозиты")).scrollTo().click();
        $("#filter").$$("[data-widget-name = CatalogCard]").shouldHaveSize(9);
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Вклады")).click();

    }
    @Test
    void depositInsuranceTestSibling(){
        Configuration.startMaximized=true;
        open("https://alfabank.ru/");
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Накопительные продукты"));
        $("#good-to-know [data-test-id=\"tabs-list-tabTitle-0\"]").sibling(0).click();
        $("[data-test-id=\"accordion-header-0\"]").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));

    }
    @Test
    void depositInsuranceTestClosest(){
        Configuration.startMaximized=true;
        open("https://alfabank.ru/");
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Что такое вклад?"));
        $("#good-to-know [data-test-id=\"tabs-list-tabTitle-1\"] span").closest("button").click();
        $("[data-test-id=\"accordion-header-2\"]").shouldHave(text("Страхованию подлежат"));

        $("body").shouldHave(text("Накопительные продукты"));

    }

    @Test
    void depositInsuranceTestPreceding(){
        Configuration.startMaximized=true;
        open("https://alfabank.ru/");
        $(byText("Вклады")).click();
        $("body").shouldHave(text("Описание"));
        $("#good-to-know [data-test-id=\"tabs-list-tabTitle-2\"]").preceding(0).click();
        $("[data-test-id=\"accordion-header-3\"]").shouldHave(text("Как происходит возмещение средств?"));

    }
}
