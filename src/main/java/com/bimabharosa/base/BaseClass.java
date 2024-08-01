package com.bimabharosa.base;

import com.bimabharosa.enums.DriverType;
import com.bimabharosa.enums.OperatingSystem;
import com.bimabharosa.utilities.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver = null;

    PropertyReader pro = new PropertyReader("./src/main/resources/bimabharosa.properties");
    public OperatingSystem operatingSystem = pro.getOperatingSystem();
    public DriverType browser = pro.getBrowser();
    public String chromeDriverPath = pro.getChromeDriverPath();
    public String edgeDriverPath = pro.getEdgeDriverPath();
    public String firefoxDriverPath = pro.getFirefoxDriverPath();
    public String chromePathLinuxMac = pro.getChromeDriverPathLinuxMax();
    public String firefoxPathLinuxMac = pro.getFirefoxDriverPathLinuxMax();
    public String edgeDriverPathLinuxMac = pro.getEdgeDriverPathLinuxMac();
    public long timeout = pro.getTime();


    /* Uncomment line to implement logger*/
    public static Logger logger = LogManager.getLogger(BaseClass.class);

    public void launchBrowser() throws IOException {
        if(operatingSystem.equals(OperatingSystem.WINDOWS)) {
            if (browser.equals(DriverType.CHROME)) {
                System.setProperty("webdriver.chrome.driver", chromeDriverPath);
                driver = new ChromeDriver();

            } else if (browser.equals(DriverType.EDGE)) {
                System.setProperty("webdriver.edge.driver", edgeDriverPath);
                driver = new EdgeDriver();

            } else if (browser.equals(DriverType.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
                FirefoxOptions options = new FirefoxOptions();
                options.setBinary("C:/Users/abhishekg/AppData/Local/Mozilla Firefox/firefox.exe");
                driver = new FirefoxDriver(options);
            }

        } else if (operatingSystem.equals(OperatingSystem.LINUX)) {
            if (browser.equals(DriverType.CHROME)) {
                System.setProperty("webdriver.chrome.driver", chromePathLinuxMac);
                driver = new ChromeDriver();

            } else if (browser.equals(DriverType.EDGE)) {
                System.setProperty("webdriver.edge.driver", edgeDriverPathLinuxMac);
                driver = new EdgeDriver();
            } else if (browser.equals(DriverType.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", firefoxPathLinuxMac);
                driver = new FirefoxDriver();
            }

        } else if (operatingSystem.equals(OperatingSystem.MAC)) {
            if (browser.equals(DriverType.CHROME)) {
                System.setProperty("webdriver.chrome.driver", chromePathLinuxMac);
                driver = new ChromeDriver();

            } else if (browser.equals(DriverType.EDGE)) {
                System.setProperty("webdriver.edge.driver", edgeDriverPathLinuxMac);
                driver = new EdgeDriver();

            } else if (browser.equals(DriverType.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", firefoxPathLinuxMac);
                driver = new FirefoxDriver();

            } else if (browser.equals(DriverType.SAFARI)) {
                driver = new SafariDriver();
            }
        }

        try {
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    public void backToSafety() {
        try {
            JavascriptExecutor jse1 = (JavascriptExecutor) driver;
            jse1.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='details-button']")));

            JavascriptExecutor jse2 = (JavascriptExecutor) driver;
            jse2.executeScript("arguments[0].click();", driver.findElement(By.xpath("//a[@id='proceed-link']")));

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void hitURL(String Url){
        driver.get(Url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }
}
