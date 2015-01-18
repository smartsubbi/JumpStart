package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;



import java.util.concurrent.TimeUnit;

/**
 * Created by Subramanya on 17-05-2014.
 */
public class Browser
{
    public static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void BeforeClass(String browser)
    {
        if (browser.equalsIgnoreCase("firefox"))
        {
        	//driver.quit();
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            // Set Path for the executable file
            System.setProperty("webdriver.chrome.driver",
                    "chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            // Set Path for the executable file
            System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        else
        {
            throw new IllegalArgumentException("The Header.Browser.Browser Type is Undefined");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @AfterTest
    public void AfterClass()
    {
        driver.close();   
        try
        {
            Thread.sleep(3000);
            driver.quit();
        }
        catch(Exception e)
        {
        }
    }
}
