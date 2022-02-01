package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public abstract class TestBase {

    protected WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));

    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }

    public void tumSayfaScreenShot() throws IOException {

        TakesScreenshot tss=(TakesScreenshot) driver;

        File tumSayfa=new File("target/ScreenShot/tumSayfa.jpg");

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);
    }
}
