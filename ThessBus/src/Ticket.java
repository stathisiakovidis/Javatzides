import java.io.IOException;

import com.google.zxing.WriterException;

public class Ticket extends Product{

	private int no_of_routes;
	private int bus;
	private String validation_date_time;
	
	
	public Ticket(String date_time, double price,Passenger owner, String type, String product_num, byte[] qRcode, int no_of_routes, int bus, String validation_date_time) {
		super(price, owner, type);
		this.no_of_routes = no_of_routes;
		this.bus = bus;
		this.validation_date_time = validation_date_time;
	}
	
	@Override
	public void setQR () throws WriterException, IOException {
		super.setQR();
	}
	
	public void printQR() {
		super.printQR();
	}
	
    public boolean isValid() {
		
		String timeText = getCurrentTime().substring(10, 14);
		int time = Integer.parseInt(timeText);
		
		String purchaseTimeText = getDate_time().substring(10, 14);
		int purchaseTime = Integer.parseInt(purchaseTimeText);
				
		if(no_of_routes > 1) {
			
			if(time > purchaseTime + 70) {
				return false;
			}
			else 
				return true;
			
		}
		return true;
	}
	
	public void Refresh_num_of_routes() {
		no_of_routes = no_of_routes - 1;
	}

	public int getBus() {
		return bus;
	}

	public void setBus(int bus) {
		this.bus = bus;
	}

	

	public void setNo_of_routes(int no_of_routes) {
		this.no_of_routes = no_of_routes;
	}

	public String getValidation_date_time() {
		return validation_date_time;
	}
}
