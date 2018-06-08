import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fine {

	String date_time;
	Passenger owner;
	double price;	
	String  inspector_num;
	int bus;
	boolean paid;
	
	public Fine(Passenger owner, String inspector_num, int bus) {
		this.date_time =new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		this.owner = owner;
		countPrice();
		this.inspector_num = inspector_num;
		this.bus = bus;
		this.paid = false;
	}
	
	public Passenger getOwner() {
		return owner;
	}

	public void finePaid()
	{
		paid = true;
	}
	
	public void countPrice()
	{
		this.price = 60/owner.getCheck();
	}

	public double getPrice() {
		return price;
	}
	
	
}
