package com.youe.cd.test.controller.modela; //申明本类文件所处的包位置

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.internal.ProfilesIni; 
import org.openqa.selenium.firefox.FirefoxProfile; 

//import org.junit.*;
import org.testng.*;
import org.testng.annotations.*;

import com.youe.cd.test.dao.TesseractOcrDao;
import com.youe.cd.test.dao.TxtDao;
import com.youe.cd.test.pageobject.login.LoginPage;
import com.youe.cd.test.service.modela.*;
import com.youe.cd.test.util.Config;
import com.youe.cd.test.util.WebTest;

public class ModelAController {
	
	WebDriver driver;
	
	@Parameters({"testEnv","testBrowser"})  //设置测试方法的入参，且设置了几个，下面的测试方法就必须要定义几个
	@BeforeClass
	public void setUp(String testEnv, String testBrowser) {  //即使是前面传递了的参数，在此方法中也要定义类型,也不能直接使用传参，否则不能resolve
		try {
			this.driver = WebTest.setUp(driver, testEnv, testBrowser); //实现了将其它类中的方法传递给主类中的属性
			//增加一个登陆的调用			
			//WebTest.loginWithVerifyCode(driver, Config.baseUrl2);
			//WebTest.loginWithVerifyCodeByCsv(driver, Config.baseUrl2, Config.csvFilePath);
			WebTest.loginWithVerifyCodeByExcel(driver, Config.baseUrl2, Config.excelFilePath);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 1, enabled = false)
	public void runtestSearchWebWithoutLogin(){		
		try {				
			driver.get(Config.baseUrl);
			Thread.sleep(5000);
			String homeHandle = driver.getWindowHandle();
			
			SearchWebService.searchWeb(driver);			
			Assert.assertEquals(driver.getTitle(), "聚力视频_百度百科");
			
			driver.close();
			driver.switchTo().window(homeHandle);
			//System.out.println("lastdriver title is: " + driver.getTitle());
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
		
	@Test(priority = 2, enabled = false)
	public void runtestSearchWebByTxtWithoutLogin() {
		try {
			String searchKey = TxtDao.getTxtList(Config.txtFilePath).get(0);
			ParamSearchWebService.paramSearchWeb(driver, searchKey);
			Assert.assertEquals(driver.getTitle(), "ppaa_百度搜索");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3, enabled = true)
	public void tempTestMethod() {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void tearDown() {
		try {
			//增加一个登出的调用
			//WebTest.logoutBaiduInSearchPage(driver);
			WebTest.tearDown(driver);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Test completed!!!--for Web.");
	}

}
