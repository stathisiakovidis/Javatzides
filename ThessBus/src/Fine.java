
public class Fine {

	String date_time;
	User owner;
	double price;	
	String  inspector_num;
	int bus;
	boolean paid;
	
	public Fine(String date_time, User owner, String inspector_num, int bus) {
		this.date_time = date_time;
		this.owner = owner;
		this.price = countPrice(owner.getPass_no());
		this.inspector_num = inspector_num;
		this.bus = bus;
		this.paid = false;
	}

	public void finePaid()
	{
		paid = true;
	}
	
	public double countPrice(String passenger_pass_num)
	{
		if(passenger_pass_num != null)
		{
			price = 15;
		}
		else
		{
			price = 30;
		}
		return price;
	}
}
