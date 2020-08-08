package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private WebDriver driver;

    private By SEARCHFIELD = By.id("ss");
    private By SEARCHBUTTON = By.cssSelector(".sb-searchbox__button ");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSearchField(){
        return driver.findElement(SEARCHFIELD);
    }

    public WebElement getButtonField(){
        return driver.findElement(SEARCHBUTTON);
    }

    public void findHotel(String hotelName){
        getSearchField().sendKeys(hotelName);
        getButtonField().submit();
    }
}
