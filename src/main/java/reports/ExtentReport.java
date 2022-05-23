package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {

	static ExtentReports report;
	
	public static ExtentReports ExtentReports()
	{
		report = new ExtentReports();
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter rep = new ExtentSparkReporter(path); 
		rep.config().setTheme(Theme.DARK);
		report.attachReporter(rep);
		rep.config().setDocumentTitle("PracticeReport");
		rep.config().setReportName("chinniah");
		report.setSystemInfo("Tester", "Chinniah");
		report.addTestRunnerOutput("C:\\Users\\VENKATEC\\espncricinfo\\Practice\\index.log");
		return report;
	}
}

