import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Card {

	private String date;
	// private User owner;
	private String type;
	private int cost;

	public Card(/* User owner, */ String type, int cost) {
		// this.owner=owner;
		this.type = type;
		this.cost=cost;
		setDate();
	}

	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public String getDate() {
		return date;
	}

	public void setDate() {
		Date today;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		today = Calendar.getInstance().getTime();
		this.date = formatter.format(today);

	}
	
	/* public User getOwner(){
	 * 		return owner;
	 * }
	 * 
	 * public void setOwner(User owner){
	 * 		this.owner=owner;
	 * }
	 */

}
