package MyTests;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("My Test is Started..." +result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("My Test is Passed..." +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("My Test is Failed..." +result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("My Test is Skipped..." +result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
