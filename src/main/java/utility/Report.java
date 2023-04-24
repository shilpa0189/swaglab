package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	public static ExtentReports createReports()
	{
		ExtentSparkReporter htmlReports = new ExtentSparkReporter("swagLabs.html");
		ExtentReports reports=new ExtentReports();
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("TestedBy","Shilpa Dukare");
		reports.setSystemInfo("TestType", "Regression");
		return reports;
		
	}

}


