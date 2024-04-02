package Utility;

import javax.naming.Context;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListners implements ITestListener{
	
	public void onStart(ITestContext c) {
		System.out.println("Execution Started");
	}
	public void onFinish(ITestContext c) {
		System.out.println("Execution Finished");
	}
	public void onTestStart(ITestResult c) {
		System.out.println("Test Execution Started");
	}
	public void onTestSuccess(ITestResult c) {
		System.out.println("Test Case is Successful");
	}
	public void onTestSkipped(ITestResult c) {
		System.out.println("Test is Skipped");
	}
	public void onTestFailure(ITestResult c) {
		System.out.println("Test Execution failed");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult c) {
		System.out.println("Execution on Test Failed But Within SuccessPercentage");
	}
}
