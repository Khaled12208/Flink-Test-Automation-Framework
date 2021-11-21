package org.uiframework.helpers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.uiframework.weathershoppertests.TestBase;


public class TestNGListeners extends TestBase implements ITestListener {

    protected Logger logger ;

    public void onTestStart(ITestResult result) {

        logger = LogManager.getLogger("Test "+ result.getTestClass()+" started");
    }

    public void onTestSuccess(ITestResult result) {

        logger.info("Test " + result.getMethod().getMethodName() + " Success");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void onTestFailure(ITestResult result) {
        logger.info("Test " + result.getMethod().getMethodName() + " Failed");

    }

    public void onTestSkipped(ITestResult result) {
        logger.info("Test " + result.getMethod().getMethodName() + " Skipped");

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onFinish(ITestContext context) {
        logger.info("Test " + context.getName() + " Finished ");


    }

}
