package maven.ass5;

import java.io.File;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// ReadFromCSV reader = new ReadFromCSV();
		Scanner sc = new Scanner(System.in);
		final File folder = new File("src/main/resources/");
		File fileList[] = folder.listFiles();
		int numberOfthreads = fileList.length;
		Thread[] threads = new Thread[numberOfthreads];
		int fiesperthread = fileList.length/numberOfthreads;
		int remainingfiles = fileList.length%numberOfthreads;
		
		
		ArrayList<ArrayList<String>> arr = ReadFromCSV.listFilesForFolder(folder);
		//System.out.println(arr);
		ArrayList<Tshirt> tshirt = new ArrayList<Tshirt>();
		for(int i = 0;i<arr.size();i++) {
			ArrayList<String> str = arr.get(i);
			Tshirt model = new Tshirt(str.get(0),str.get(1),str.get(2),str.get(3),str.get(4),Float.parseFloat(str.get(5)),Float.parseFloat(str.get(6)),str.get(7));
			tshirt.add(model);
		}
		while (true) {
			System.out.println("Enter the color of tshirt you want:");
			String tColor = sc.nextLine();
			System.out.println("Enter size do you want:");
			String tSize = sc.nextLine();
			System.out.println("Enter gender :");
			String tGender = sc.nextLine();
			System.out.print("Enter the output preference:");
			System.out.print("1.Price" + "\t");
			System.out.print("2.Rating" + "\t");
			System.out.println("3.Both");
			int tOutput = sc.nextInt();
			validTshirt tee = new validTshirt();
			ArrayList<Tshirt> result = tee.validT(tshirt, tColor, tSize, tGender);
			System.out.print("ID" + "\t\t");
			System.out.print("Name" + "\t\t");
			System.out.print("Colour" + "\t\t");
			System.out.print("Gender" + "\t\t");
			System.out.print("Size" + "\t\t");
			System.out.print("Price" + "\t\t");
			System.out.print("Rating" + "\t\t");
			System.out.println("Availability");
			if(result.size() == 0) {
				System.out.println("Your prefered Tshirt is not available!!");
			}
			else if (result.size() != 1) {
				result = updateView.Update(result,tOutput);
			} 
			for(int i = 0; i<result.size();i++) {
				System.out.print(result.get(i).getId() + "\t");
				System.out.print(result.get(i).getName() + "\t");
				System.out.print(result.get(i).getColor() + "\t");
				System.out.print(result.get(i).getGender() + "\t");
				System.out.print(result.get(i).getSize()+"\t");
				System.out.print(result.get(i).getPrice()+"\t");
				System.out.print(result.get(i).getRating() + "\t");
				System.out.println(result.get(i).getAvail());
			}
			System.out.println("*********************************");
			System.out.print("Do you want to search any more Tshirt(yes/no):"+"\t");
			String option = sc.next();
			if(!option.equalsIgnoreCase("yes")) {
				break;
			}
			

		}
		sc.close();

	}

}
