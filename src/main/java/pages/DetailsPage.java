package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DetailsPage {
    private WebDriver driver;
    public DetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    By startDate=By.xpath("//div[@data-placeholder='Check-in']");
    By endDate=By.xpath("//div[@data-placeholder='Check-out']");
    By dropdownList =By.xpath("(//select[@class='hprt-nos-select js-hprt-nos-select'])[1]");
    By singleBedCheckBox=By.xpath("(//input[@name='bedPreference_78883120'])[2]");
    By iWillReserveButton=By.xpath("//span[@class='bui-button__text js-reservation-button__text']");

    public String getStartDate() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(startDate).getText();
    }
    public String getEndDate() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElement(endDate).getText();
    }
    public void clickOnSingleBedCheckBox(){
        driver.findElement(singleBedCheckBox).click();
        System.out.println("Check box for single bed is enabled? "+driver.findElement(singleBedCheckBox).isEnabled());
    }
    public void selectFromDropDown(String option){
        Select dropdownElement=new Select(driver.findElement(dropdownList));
        dropdownElement.selectByValue(option);
    }
    public ReservationPage clickOnIWillReserveButton(){
        driver.findElement(iWillReserveButton).click();
        return new ReservationPage(driver);
    }
}
