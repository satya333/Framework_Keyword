package delta.main;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import generics.Excel;

public class BaseDriver implements AutomationConstants {
	 
	public WebDriver driver;
	public static ExtentReports eReport;
	public ExtentTest testReport;
	
	//@BeforeSuite
	@BeforeTest
	public void initFrameWork(){
		
		eReport=new ExtentReports(reportFilePath);
	}
	
	//@AfterSuite
	@AfterTest
	public void endFramework(){
		eReport.flush();
	}
	
	@DataProvider
	public String[][] getScenario(){
		
	/*	String[][] data=new String[2][1];
		data[0][0]="scenario1";
		data[1][0]="scenario2";
		return data;*/
		
		int scenarioCount=Excel.getRowCount(controllerFile,suiteSheet);
		String[][] data=new String[scenarioCount][2];
		for(int j=1;j<=scenarioCount;j++)
		{
		String scenarioName = Excel.getCellValue(controllerFile,suiteSheet, j, 0);
		String executionStatus = Excel.getCellValue(controllerFile,suiteSheet, j, 1);
		data[j-1][0]=scenarioName;
		data[j-1][1]=executionStatus;
		}
		return data;
		
	}

}
