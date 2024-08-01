package com.bimabharosa.hooks;


import com.bimabharosa.base.BaseClass;
import com.bimabharosa.objectRepository.LoginPage;
import com.bimabharosa.utilities.SharedContext;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class Hooks extends BaseClass {

    private final SharedContext sharedContext;

    public Hooks(SharedContext sharedContext) {
        this.sharedContext = sharedContext;
    }


    @Before
    public void before(Scenario scenario) throws IOException {
        logger.info("<------------------------------------------------------------------>");
        logger.info("Scenario Started: {}", scenario.getName());
        logger.info("<------------------------------------------------------------------>");
    }


    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        final byte[] ss = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(ss, "image/png", "image");
    }


    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        Status status = scenario.getStatus();

        switch (status) {
            case PASSED:
                logger.info("Scenario Passed: {}", scenario.getName());
                break;
            case FAILED:
                logger.error("Scenario failed: {}", scenario.getName());
                scenario.log("Scenario failed: " + scenario.getName());

                // Log the exception details if available
                Throwable throwable = sharedContext.getThrowable();
                if (throwable != null) {
                    StringWriter error = new StringWriter();
                    throwable.printStackTrace(new PrintWriter(error));
                    logger.error(error.toString());
                    scenario.log(error.toString());
                }
                break;
            case SKIPPED:
                logger.warn("Scenario skipped: {}", scenario.getName());
                break;
            case PENDING:
                logger.warn("Scenario pending: {}", scenario.getName());
                break;
            case UNDEFINED:
                logger.warn("Scenario undefined: {}", scenario.getName());
                break;
            case AMBIGUOUS:
                logger.warn("Scenario ambiguous: {}", scenario.getName());
                break;
            default:
                logger.info("Scenario status unknown: {}", scenario.getName());
                break;
        }


        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "image");
        logger.info("==========================================================================");
        logger.info("================================Test {}===============================", scenario.getStatus().toString());
        logger.info("==========================================================================");

    }


    @After(order = 1)
    public void logOut() throws InterruptedException {
        LoginPage lp = new LoginPage();
        lp.logOutSuccess();
    }

    @After(order = 0)
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
