package maven.ass5;

import java.util.ArrayList;

public class validTshirt {
	
	public ArrayList<Tshirt> validT(ArrayList<Tshirt> arr,String tColor,String tSize,String tGender){
		ArrayList<Tshirt> result = new ArrayList<Tshirt>();
		for(int i = 0 ; i<arr.size();i++) {
			Tshirt t = arr.get(i);
			if(t.getColor().equalsIgnoreCase(tColor) && t.getGender().equalsIgnoreCase(tGender) && t.getSize().equalsIgnoreCase(tSize)) {
				result.add(t);
			}
		}
		return result;
	}
}
