package maven.ass5;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;

import java.util.ArrayList;

public class ReadFromCSV extends Thread{
	private static CSVReader reader;

	@SuppressWarnings("deprecation")
	public static ArrayList<ArrayList<String>> listFilesForFolder(final File folder) throws IOException {
		// CSVReader reader = null;
		ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				String s = fileEntry.getName();
				reader = new CSVReader(new FileReader("src/main/resources/" + s),'|');
				String line[];
				// Iterator it = reader.iterator();
				line = reader.readNext();
				while ((line = reader.readNext()) != null) {
					ArrayList<String> list = new ArrayList<String>();
					for (int i = 0; i < line.length; i++) {
						list.add(line[i]);
					}
					arr.add(list);
				}
			}
		}
		return arr;
	}

}