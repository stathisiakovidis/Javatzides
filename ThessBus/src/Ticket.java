
public class Ticket extends Product{

	private int no_of_routes;
	private int bus;
	private String validation_date_time;
	
	public Ticket(String date_time, double price,Passenger owner, String type, String product_num, byte[] qRcode, int no_of_routes, int bus, String validation_date_time) {
		super(date_time, price, owner, type, product_num, qRcode);
		this.no_of_routes = no_of_routes;
		this.bus = bus;
		this.validation_date_time = validation_date_time;
	}
	
	
	public void setQR (byte[] QRcode) {
		
	}
	
	public void printQR() {
		
	}
	
	public boolean isValid() {
		return false;
		
	}
	
	public void Refresh_num_of_routes() {
		
	}

	public int getBus() {
		return bus;
	}

	public void setBus(int bus) {
		this.bus = bus;
	}


	public String getValidation_date_time() {
		return validation_date_time;
	}
}
