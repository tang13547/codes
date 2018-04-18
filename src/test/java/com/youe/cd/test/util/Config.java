package com.youe.cd.test.util;

import org.openqa.selenium.By;

public class Config {

	public static final String chromedriverPath = "./src/test/java/res/chromedriver.exe";
	public static final String firefoxdriverPath = "./src/test/java/res/geckodriver.exe";
	
	public static final String baseUrl = "https://www.baidu.com/";
	public static final String baseUrl2 = "http://172.16.0.243:9203"; //临时测试使用
	public static final String txtFilePath = "./src/test/java/res/data.txt"; //前面必须加。 表示路径从工程开始
	public static final String csvFilePath = "./src/test/java/res/csvdata.csv";
	public static final String excelFilePath = "./src/test/java/res/exceldata.xls";
	public static final String errorHintStr = "验证码输入有误"; //输入错误验证后的提示
	
	//Tesseract-OCR处理生成图片路径及转换成txt结果路径配置
	public static final String picFilePath = "D:\\Tesseract-OCR\\train\\test.png";
	public static final String picFileDirAfterClean = "D:\\Tesseract-OCR\\train\\cleanpic"; //处理图片后的目录（注意是目录）
	public static final String txtResultFilePath = "D:\\Tesseract-OCR\\train\\result"; //特别注意：没有加.txt文件后缀
	
	//使用cookie登录配置
	public static final String cookieName = "BAIDUID";
	public static final String cookieValue = "56A7F56A88C2384696566954F4C441E7:FG=1";
	public static final String cookieName2 = "BDUSS";
	public static final String cookieValue2 = "2h4Ty02aFBvNTZ0Q0pCbUkwS1c3MUdyV25SQnVkWG9rVnVwTnFIa1lPeTQ4dTlaSUFBQUFBJCQAAAAAAAAAAAEAAAAZnv4vY2VyYWludGFuZzEyMwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAALhlyFm4ZchZU";
	
	
}
