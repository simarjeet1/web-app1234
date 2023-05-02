package com.utilityClasses;

import java.io.*;

public class FilePathReader {
	public static String getFilePath() {
		String dirPath= "C:\\Users\\simarjeetsingh\\eclipse-workspace\\searchFilterSpring\\csvFiles";
		System.out.println(dirPath);
		return dirPath;
	}
	
	public static void main(String[] args) {
		File file=new File("");
		System.out.println(file.getAbsolutePath());
	}
}
