import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Card {
	private Date today;
	private int cost;
	private String date;
	
	
	public Card(Date today, int cost, String date) {
		this.today = today;
		this.cost= cost;
		this.date=date;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		setToday(Calendar.getInstance().getTime());
		date=formatter.format(getToday());
		

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


	public void setDate(String date) {
		this.date = date;
	}


	public Date getToday() {
		return today;
	}

	public void setToday(Date today) {
		this.today = today;
	}

}
