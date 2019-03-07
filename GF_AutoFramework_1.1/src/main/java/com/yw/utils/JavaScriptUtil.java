package com.yw.utils;

import java.util.Random;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptUtil {
	private static WebDriver driver;
	//移除属性的js
	public static void jsStrToRemoveAtt(WebElement textEle,String Str) {		
		String jsStrToRemoveAtt="arguments[0].removeAttribute(arguments[1],arguments[2])";
		((JavascriptExecutor) driver).executeScript(jsStrToRemoveAtt, textEle, Str);
		        
	}
	//新增、修改id属性的js
	public static WebElement jsStrToSetAtt(WebDriver driver2,WebElement textEle2,String value) {		
        String jsStrToSetAtt="arguments[0].setAttribute(arguments[1],arguments[2])";
        ((JavascriptExecutor) driver2).executeScript(jsStrToSetAtt, textEle2, "id", value);
        return textEle2;
	}
	//通过ID获取值
	public static String jsGetValue(WebDriver driver2,String idVal) {
		JavascriptExecutor js=(JavascriptExecutor) driver2;		
		return (String) js.executeScript("return document.getElementById(\""+idVal+"\").value");
	}
	//生成随机字符串
	public static String getRandomString() {
		//定义一个字符串（A-Z，a-z，0-9）即62位；
	    String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
	    //由Random生成随机数
	    Random random=new Random();
	    StringBuffer sb=new StringBuffer();
	    //长度为几就循环几次
	    for (int i = 0; i < 12; i++) {
	    	//产生0-61的数字
	    	int num=random.nextInt(62);
	    	//将产生的数字通过length次承载到sb中
	    	sb.append(str.charAt(num));
		}
	    //将承载的字符转换成字符串
	    return sb.toString();	    
	}	
	
}
