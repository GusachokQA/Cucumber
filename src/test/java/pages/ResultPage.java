package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {
    private WebDriver driver;

    private By HOTELNAME = By.xpath("//span[contains(text(),'Five Jumeirah Village')]");
    private By SCORE = By.xpath("//span[contains(text(),'Five Jumeirah Village')]" +
            "/ancestor::div[@class='sr_item_content sr_item_content_slider_wrapper ']/descendant::div[@aria-label='Scored 8.5 ']");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHotelName(){
        return driver.findElement(HOTELNAME);
    }

    public String getHotelNameText(){
        return getHotelName().getText();
    }

    public WebElement getScore(){
        return driver.findElement(SCORE);
    }

    public String getScoreText(){
        return getScore().getText();
    }

}
