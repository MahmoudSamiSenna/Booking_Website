import org.testng.annotations.Test;
import pages.*;
import static org.testng.Assert.assertTrue;

public class ReservationTest extends BaseTest {
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private DetailsPage detailsPage;
    private ReservationPage reservationPage;
    @Test(priority = 1,dataProvider = "SearchData")
    public void searchPageTest(String cityName ,String checkInMonthYear , String checkInDay,String checkoutMonthYear , String checkoutDay  ) throws InterruptedException {
        homePage =new HomePage(driver);
        Thread.sleep(4000);
        homePage.cancelAlarm();
        Thread.sleep(4000);
        homePage.enterCity(cityName);
        homePage.selectCheckInMonthYear(checkInMonthYear);
        homePage.selectCheckInDay(checkInDay);
        homePage.selectCheckOutMonthYear(checkoutMonthYear);
        homePage.selectCheckOutDay(checkoutDay);
        Thread.sleep(2000);
        homePage.clickOnSearchButton();
    }
    @Test (priority = 2, dependsOnMethods = "searchPageTest") //Please wait until finish all tests because it takes much time to search for hotel
    public void searchForTolipHotel () throws InterruptedException {
        searchResultPage =new SearchResultPage(driver);
        searchResultPage.searchForTolipHotel();
    }
    @Test (priority = 3,dependsOnMethods = "searchForTolipHotel")
    public void detailsPageTest() throws InterruptedException {
        detailsPage=new DetailsPage(driver);
        Thread.sleep(3000);
        assertTrue(detailsPage.getStartDate().contains("Sun 1 Oct"),"Start date is incorrect");
        System.out.println("Start date is "+detailsPage.getStartDate());
        assertTrue(detailsPage.getEndDate().contains("Sat 14 Oct"),"End date is incorrect");
        System.out.println("End date is "+detailsPage.getEndDate());
        String option= "2";
        detailsPage.selectFromDropDown(option);
        detailsPage.clickOnSingleBedCheckBox();
        detailsPage.clickOnIWillReserveButton();
    }
    @Test (priority = 4,dependsOnMethods = "detailsPageTest")
    public void checkHotelName(){
        reservationPage=new ReservationPage(driver);
        assertTrue(reservationPage.getHotelName().contains("Tolip Hotel Alexandria"),"Name is incorrect");
        System.out.println("Hotel name is "+reservationPage.getHotelName());
    }
}
