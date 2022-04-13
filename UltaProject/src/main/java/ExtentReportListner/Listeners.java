package ExtentReportListner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;

public class Listeners  implements ITestListener {

	ExtentReports extent=ExtentReportNG.getReportObject();
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		//System.out.println("onTestStart-----------------------"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println( result.getName());
		test.log(Status.PASS,"Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
	//	test.log(Status.FAIL,"Test Failed");
		test.fail(result.getThrowable());
	//	test.fail("Testfailed");
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkippe-----------------------"+result.getName());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		test.fail(result.getThrowable());
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		test.fail(result.getThrowable());
	}

	public void onStart(ITestResult result) {
	
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		//System.out.println("onFinish------------------------------------"+context.getName());
	}

	

}



