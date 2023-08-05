package pages;

import org.openqa.selenium.*;
public class SearchResultPage {
    private WebDriver driver;
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
    }
    By hotel = By.xpath("//img[@alt='Tolip Hotel Alexandria']");
    By nextButton = By.xpath("//button[@aria-label='Next page']");
    public DetailsPage searchForTolipHotel() throws InterruptedException {
        while (isElementDisplayed(hotel)) {
            String script = "arguments[0].scrollIntoView();";
            WebElement nextPageElement = driver.findElement(nextButton);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(script, nextPageElement);
            Thread.sleep(2000);
            driver.findElement(nextButton).click();
        }
        WebElement hotelElement = driver.findElement(hotel);
        hotelElement.click();
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        return new DetailsPage(driver);
    }
    private Boolean isElementDisplayed(By elementLoc) {
        try {
            return !driver.findElement(elementLoc).isDisplayed();
        } catch (NoSuchElementException exception) {
            return true;
        }
    }
}
