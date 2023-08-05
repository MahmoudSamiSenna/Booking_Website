package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    By alert =By.xpath("//button[@aria-label='Dismiss sign in information.']");
    By searchBar=By.name("ss");
    By ckeckInMonthYear =By.xpath("//select[@data-name='year-month']");
    By ckeckInDay=By.xpath("//select[@data-name='day']");
    By ckeckOutMonthYear =By.xpath("//select[@data-name='year-month']");
    By ckeckOutDay=By.xpath("//select[@data-name='day']");
    By searchButton=By.xpath("//button[@type = 'submit']");
    public void cancelAlarm (){
        driver.findElement(alert).click();
    }
    public void enterCity(String city){
        driver.findElement(searchBar).sendKeys(city);
    }
    public void selectCheckInMonthYear(String option){
        WebElement searchBoxElement=driver.findElement(searchBar);
        searchBoxElement.sendKeys(Keys.TAB);
        Select dropdownElement=new Select(driver.findElement(ckeckInMonthYear));
        dropdownElement.selectByValue(option);
    }
    public void selectCheckInDay(String option){
        WebElement searchBoxElement=driver.findElement(ckeckInMonthYear);
        searchBoxElement.sendKeys(Keys.TAB);
        Select dropdownElement=new Select(driver.findElement(ckeckInDay));
        dropdownElement.selectByValue(option);
    }
    public void selectCheckOutMonthYear(String option){
        WebElement searchBoxElement=driver.findElement(ckeckInDay);
        searchBoxElement.sendKeys(Keys.TAB);
        Select dropdownElement=new Select(driver.findElement(ckeckOutMonthYear));
        dropdownElement.selectByValue(option);
    }
    public void selectCheckOutDay(String option){
        WebElement searchBoxElement=driver.findElement(ckeckOutMonthYear);
        searchBoxElement.sendKeys(Keys.TAB);
        Select dropdownElement=new Select(driver.findElement(ckeckOutDay));
        dropdownElement.selectByValue(option);
    }
    public SearchResultPage clickOnSearchButton(){
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }
}
