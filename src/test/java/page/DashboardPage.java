package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {

    private static final String NAME_DASHBOARD_PAGE = "//p[contains(text(),'Your dashboard')]";
    private static final String RATING_SELECT = "//td//select";
    private static final String ADD_RATING_SELECT = "//td//*[contains(text(),'0 / 400 ')]/ancestor::tr/descendant::td//select";
    private static final String ADD_BUTTON = "//td//div[@class='buttons']//button[@class='button is-primary is-oudtlined is-rounded']";
    private static final String TEXTAREA = "//td//*[contains(text(),'0 / 400 ')]/preceding-sibling::*";
    private static final String UPDATE_BUTTON = "//button[@class='button is-primary is-outdlined is-rounded']";
    private static final String SUCCESS_UPDATE_MESSAGE = "//*[contains(text(),'Post updated')]";
    private static final String SUCCESS_ADD_MESSAGE = "//*[contains(text(),'Posted')]";

    private static final String TEXT_IN_BOX = "111111";
    private static final int RATING_POSITION = 0;


    public String getNamePage(){
        return $(By.xpath(NAME_DASHBOARD_PAGE)).getText();
    }

    public DashboardPage setupRating(String rating){
        $$(By.xpath(RATING_SELECT)).get(RATING_POSITION).selectOptionByValue(rating);
        return this;
    }

    public DashboardPage clickAddButton(){
        $$(By.xpath(ADD_BUTTON)).get(RATING_POSITION).click();
        return this;
    }

    public DashboardPage clickUpdateButton(){
        $$(By.xpath(UPDATE_BUTTON)).get(RATING_POSITION).click();
        return this;
    }

    public boolean isSuccessMessageDisplayed(){
        return $(By.xpath(SUCCESS_UPDATE_MESSAGE)).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }

    public DashboardPage addRating(String rating){
        $$(By.xpath(ADD_RATING_SELECT)).get(RATING_POSITION).selectOptionByValue(rating);
        return this;
    }


    public DashboardPage sendTextOnTextarea(){
        $$(By.xpath(TEXTAREA)).get(RATING_POSITION).sendKeys(TEXT_IN_BOX);
        return this;
    }

    public boolean isSuccessAddMessageDisplayed(){
        return $(By.xpath(SUCCESS_ADD_MESSAGE)).shouldBe(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }



}

