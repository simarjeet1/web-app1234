package com.utilityClasses;

import com.entities.MyTshirt;



import java.io.*;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;

public class MyCSVParser { 
	static int totalFilesParsed;
	
	// This will return the arrayList of all available tshirts;
	public static ArrayList<MyTshirt> parseCSVFiles() {
		ArrayList<MyTshirt> alltshirts=new ArrayList<MyTshirt>();
		try {
			File dirPath= new File(FilePathReader.getFilePath());
			File csvFiles[]=dirPath.listFiles(); 
			
			if(csvFiles != null) {
				for(File eachFile:csvFiles) {
					Reader tempReader= new FileReader(eachFile.getAbsoluteFile());
					Iterable<CSVRecord> TshirtRecord= CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(tempReader);
					
					for(CSVRecord record: TshirtRecord) {
							alltshirts.add(new MyTshirt(record.get(0),record.get(1),record.get(2),record.get(3),
									record.get(4),record.get(5),record.get(6),record.get(7)));

					}
				}
			}
			totalFilesParsed=csvFiles.length;
			
			return alltshirts;
			
		}
		catch(Exception e) {
			System.out.println("Some error occured while processing the csv files "+ e);
			
		}
		return alltshirts;
	}

}
