package com.utilityClasses;

import java.io.File;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.MyTshirtDao;
import com.entities.MyTshirt;

//import databaseConnectivity.HibernateConnectivity;
//import databaseConnectivity.JDBClass;

@Component
public class MyFileChangeThread extends Thread {
	
	@Autowired
	MyTshirtDao mytdao;

	public void run() {
		try {
			while (true) {
				File dirPath= new File(FilePathReader.getFilePath());
				int filetemp=dirPath.listFiles().length;
				System.out.println("Thread Started");
				if(filetemp!=MyCSVParser.totalFilesParsed) {
					MyCSVParser.totalFilesParsed=filetemp;
					ArrayList<MyTshirt> temp=MyCSVParser.parseCSVFiles();
					for(MyTshirt t:temp) {
						mytdao.save(t);
					}
				}

				Thread.sleep(8000);
			}
			
		}

		catch (Exception e) {

		}
	}
}
