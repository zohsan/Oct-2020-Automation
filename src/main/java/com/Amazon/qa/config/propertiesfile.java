package com.Amazon.qa.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;




public class propertiesfile {
	public static void main(String[]args) {
		readpropertiesFile();
	}
public static void readpropertiesFile() {
	Properties prop=new Properties();
	try {
	InputStream input= new FileInputStream("/testautomation/src/main/java/com/Amazon/qa/config/config properties");
	prop.load(input);
	System.out.println(prop.getProperty("browser"));
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
//public static void WritePropertiesFile() {
	//OutputStream output=new FileOutputStream("\"/testautomation/src/main/java/com/Amazon/qa/config/config properties\"")
   }

 
