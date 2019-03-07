package com.yw.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	//这个类作为加载读取properties文件
		public Properties prop;
		//构造函数
		public TestBase() {
			try {
				prop=new Properties();
				FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+
						"/src/main/resources/properties/config.properties");
				
					prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}			
}
