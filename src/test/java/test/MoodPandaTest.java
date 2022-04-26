package test;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoodPandaTest extends BaseTest{

    private String ratingAdd = "5";
    private String ratingUpdate = "9";
    User user = new User();
    private String expectedNameDashboardPage = "Your dashboard";


    @Test(description = "Opening Dashboard Page")
    public void openDashboardPageTest(){
        dashboardPage = loginPage.openLoginPage()
                                 .login(user)
                                 .clickYourDashboardLink();
        Assert.assertEquals(dashboardPage.getNamePage(),expectedNameDashboardPage);
    }

    @Test (description = "Add Rating")
    public void addRatingTest(){
        dashboardPage = loginPage.openLoginPage()
                .login(user)
                .clickYourDashboardLink()
                .addRating(ratingAdd)
                .sendTextOnTextarea()
                .clickAddButton();
        Assert.assertTrue(dashboardPage.isSuccessAddMessageDisplayed());
    }


    @Test (description = "Update Rating")
    public void moodTest(){
        dashboardPage = loginPage.openLoginPage()
                .login(user)
                .clickYourDashboardLink()
                .setupRating(ratingUpdate)
                .clickUpdateButton();
        Assert.assertTrue(dashboardPage.isSuccessMessageDisplayed());
    }


}


