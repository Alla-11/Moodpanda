package page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedGlobalPage {

    private static final String YOUR_DASHBORD_LINK = "//a[@href='/dashboard']";

    public DashboardPage clickYourDashboardLink(){
        $(By.xpath(YOUR_DASHBORD_LINK)).click();
        return new DashboardPage();
    }

}
