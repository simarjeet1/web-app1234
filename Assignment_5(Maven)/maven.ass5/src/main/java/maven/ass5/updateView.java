package maven.ass5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class updateView {
	public static ArrayList<Tshirt> Update(ArrayList<Tshirt> result, int choice){
		if(choice == 1) {
			Collections.sort(result,new Comparator<Tshirt>(){
				public int compare(Tshirt o1,Tshirt o2) {
					return (int)(o1.getPrice() - o2.getPrice());
				}
			});
		}
		else if(choice == 2) {
			Collections.sort(result,new Comparator<Tshirt>() {
				public int compare(Tshirt o1, Tshirt o2) {
					return (int)(o1.getRating() - o2.getRating());
				}
			});
		}
		else if(choice == 3) {
			Collections.sort(result,new Comparator<Tshirt>() {
				public int compare(Tshirt o1, Tshirt o2) {
					return (int)(o1.getPrice() + o1.getRating() - (o2.getPrice()+o2.getRating()));
				}
			});
		}
		else {
			System.out.println("Wrong Input!!");
		}
		
		return result;
	}

}

