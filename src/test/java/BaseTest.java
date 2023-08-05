import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;


public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/index.en-gb.html?label=gen173nr-1BCAEoggI46AdIM1gEaEOIAQGYAQm4ARfIAQzYAQHoAQGIAgGoAgO4Auvps6YGwAIB0gIkZDc0ZmZhZjctZDJkZS00ZDk1LWI1MGItNDg2MGVmYWEwZGZj2AIF4AIB&sid=0bb4df41d8e7500fc482b13997664a3d&keep_landing=1&sb_price_type=total&");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @BeforeMethod
    public void waitLoading() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @DataProvider(name = "SearchData")
    public static Object[][] Data() {
        return new Object[][]{
                {"Alexandria", "2023-10", "1", "2023-10", "14"}
        };
    }

    @DataProvider(name="SearchDataExcel")
    public Object[][] testDataExample(){
        ReadExcelFile configuration = new ReadExcelFile("E:\\Testing\\Automation Testing\\Sumerga - Automation Challenge\\Sumerga - Automation Challenge\\TestData");
        int rows = configuration.getRowCount(0);
        Object[][]searchData = new Object[rows][4];

        for(int i=0;i<rows;i++)
        {
            searchData[i][0] = configuration.getData(0, i, 0);
            searchData[i][1] = configuration.getData(0, i, 1);
            searchData[i][2] = configuration.getData(0, i, 2);
            searchData[i][3] = configuration.getData(0, i, 3);
        }
        return searchData;
    }
}


