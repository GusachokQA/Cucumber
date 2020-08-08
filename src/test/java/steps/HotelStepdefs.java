package steps;

import base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.ResultPage;
import pages.SearchPage;
import utils.Waiters;

public class HotelStepdefs extends BaseUtil {
    private BaseUtil baseUtil;

    public HotelStepdefs(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Given("browser is started")
    public void browserIsStarted() {
        baseUtil.driver = new ChromeDriver();
    }

    @Given("search page is opened")
    public void searchPageIsOpened() {
        baseUtil.driver.get("https://www.booking.com/searchresults.en-gb.html");
    }
    
    @Given("search button is displayed")
    public void searchButtonIsDisplayed() {
        SearchPage searchPage = new SearchPage(baseUtil.driver);
        Assert.assertTrue(searchPage.getButtonField().isDisplayed());
    }

    @When("find {string} hotel click button")
    public void findHotel(String hotelName) {
        SearchPage searchPage = new SearchPage(baseUtil.driver);
        searchPage.findHotel(hotelName);
    }

    @Then("hotel name {string} is displayed")
    public void hotelNameIsDisplayed(String visibleHotelName) {
        Waiters waiters = new Waiters(baseUtil.driver);
        waiters.waitFor(By.xpath("//span[contains(text(),'Five Jumeirah Village')]"));
        ResultPage resultPage = new ResultPage(baseUtil.driver);
        Assert.assertEquals(resultPage.getHotelNameText(), visibleHotelName);
    }

    @Then("score {string} is displayed")
    public void scoreIsDisplayed(String visibleScore) {
        ResultPage resultPage = new ResultPage(baseUtil.driver);
        Assert.assertEquals(resultPage.getScoreText(), visibleScore);
    }
}
