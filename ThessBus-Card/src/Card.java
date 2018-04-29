import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Card {

	private String date;
	private String owner;
	private String num_pas;
	private String type;
	private int cost;

	public Card(String owner, String num_pas, String type) {
		this.owner = owner;
		this.num_pas = num_pas;
		this.type = type;
		setDate();
		setCost(type,owner);

	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(String type, String num_pas) {
		if (num_pas == null) {
			if (type.equals("лгмиаиа")) {
				this.cost = 30;
			} else if (type.equals("TRIMHNIAIA")) {
				this.cost = 84;
			} else if (type.equals("EXAMINIAIA")) {
				this.cost = 150;
			} else if (type.equals("ETHSIA")) {
				this.cost = 270;
			} else {
				if (type.equals("лгмиаиа")) {
					this.cost = 15;
				} else if (type.equals("TRIMHNIAIA")) {
					this.cost = 42;
				} else if (type.equals("EXAMINIAIA")) {
					this.cost = 75;
				} else if (type.equals("ETHSIA")) {
					this.cost = 135;
				}
			}

		}
	}

	public void setDate(String date) {
		this.date = date;
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
