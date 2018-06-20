import java.io.IOException;
import java.io.Serializable;

import com.google.zxing.WriterException;

public class Ticket extends Product implements Serializable {

	private int no_of_routes;
	private int remaining_routes;
	private String bus;
	private String validation_date_time;
	
	
	public Ticket(double price, Passenger owner, String type, int no_of_routes, String bus) {
		super(price, owner, type);
		this.no_of_routes = no_of_routes;
		this.remaining_routes = this.no_of_routes - 1;
		this.bus = bus;
	}
	
	public void setValidation_date_time() {
		this.validation_date_time = getCurrentTime();
		
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
				
		int duration = 0;
		/*if(no_of_routes > 1) {*/
			
			switch(no_of_routes) {
			case 2:
				duration = 70;
				break;
			case 3:
				duration = 90;
				break;
			case 4:
				duration = 120;
				break;
			}
			
			if(time > purchaseTime + duration) {
				return false;
			}
			else 
				return true;
			
		/*}
		return true;*/
	}
	
	public void Refresh_num_of_routes() {
		remaining_routes = remaining_routes - 1;
	}

	public String getBus() {
		return bus;
	}

	public void setBus(String bus) {
		this.bus = bus;
	}

	public void setNo_of_routes(int no_of_routes) {
		this.no_of_routes = no_of_routes;
	}

	public String getValidation_date_time() {
		return validation_date_time;
	}

	public int getNo_of_routes() {
		return no_of_routes;
	}

	public int getRemaining_routes() {
		return remaining_routes;
	}
	
}
