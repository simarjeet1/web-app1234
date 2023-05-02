package maven.ass5;

public class Tshirt {
	private String Id;
	private String Name;
	private String Color;
	private String Gender;
	private String Size;
	private float Price;
	private float Rating;
	private String Availability; 
	
	public Tshirt(String Id,String Name,String Color,String Gender,String Size,float Price,float Rating,String Availability){
		this.Id = Id;
		this.Name = Name;
		this.Color = Color;
		this.Gender = Gender;
		this.Size = Size;
		this.Price = Price;
		this.Rating = Rating;
		this.Availability = Availability;
		
	}
	public String getColor() {
		return Color;
	}
	public String getGender() {
		return Gender;
	}
	public String getSize() {
		return Size;
	}
	public float getPrice() {
		return Price;
	}
	public float getRating() {
		return Rating;
	}
	public String getId() {
		return Id;
	}
	public String getName() {
		return Name;
	}
	public String getAvail() {
		return Availability;
	}
}
