public class Fine {

	String date_time;
	Passenger owner;
	double price;	
	String  inspector_num;
	int bus;
	boolean paid;
	
	public Fine(String date_time, Passenger owner, String inspector_num, int bus) {
		this.date_time = date_time;
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
