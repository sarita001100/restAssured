 package com.excelRaeding;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_InputStream {

	public static void main(String[] args) throws Throwable {
		datareader("name");
		dataread("name");
	}
		public static void datareader(String keyName) throws IOException {
			try {
	File fl=	new File ("data.properties");

	FileInputStream input=	new FileInputStream(fl);
	Properties  proper =new Properties();

		proper.load(input);
	    System.out.println(proper.getProperty(keyName));
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
		
		
		public static void dataread(String keyname) throws Throwable {
			File fl=new File ("datas.properties");
			FileInputStream input=	new FileInputStream(fl);
			Properties proper=	new Properties();
			proper.load(input);
	String str=	proper.getProperty(keyname);
	System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
