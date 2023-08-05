package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReservationPage {
    private WebDriver driver;
    public ReservationPage(WebDriver driver) {
        this.driver = driver;
    }
    By hotelName=By.xpath("//h1[@class='ac78a73c96']");
    public String getHotelName (){
        return driver.findElement(hotelName).getText();
    }
}
