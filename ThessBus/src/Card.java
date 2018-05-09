import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Card {

	private String date;
	//private User owner;
	private String type;
	private int cost;

	public Card(/*User owner,*/ String type) {
		//this.owner=owner;
		this.type = type;
		setDate();
		setCost(type/*,owner*/);
		

	}

	
	public int getCost() {
		return cost;
	}

	public void setCost(String type) {
		if (/*owner.num_pas==null*/true) {
			if (type.contains("Μηνιαία")) {
				this.cost = 30;
			} else if (type.contains("Τριμηνιαία")) {
				this.cost = 84;
			} else if (type.contains("Εξαμηνιαία")) {
				this.cost = 150;
			} else if (type.contains("Ετήσια")) {
				this.cost = 270;
			} else {
				if (type.contains("Μηνιαία")) {
					this.cost = 15;
				} else if (type.contains("Τριμηνιαία")) {
					this.cost = 42;
				}  else if (type.contains("Εξαμηνιαία")) {
					this.cost = 75;
				} else if (type.contains("Ετήσια")) {
					this.cost = 135;
				}
			}
		}
		
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

}
