
public class Card extends Product{
	
	private int duration;

	public Card(double price,Passenger owner, String type, int duration) {
		super(price, owner, type);
		this.duration = duration;
	}
	
	public int getDuration() {
		return duration;
	}

	public boolean isValid() {
		return false;
		
	}

}
