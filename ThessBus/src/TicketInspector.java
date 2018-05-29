import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TicketInspector extends User {

	public String username;
	public String inspector_num;
	public HashMap<Integer, Integer> durations = new HashMap<>(); 
	
	public TicketInspector(String aName, String aPassword, String username, String inspector_num) {
		super(aName, aPassword);
		
		this.username = username;
		this.inspector_num = inspector_num;
		durations.put(14, 60);
		durations.put(2, 70);
	}
	
	public Product browseQR(String filepath_of_qr, int type) {			//type: the type of product the inspector is examining
		String product_num, filename;
		Product product;
		
		product_num = QRcode.decodeQRCodeImage(filepath_of_qr);
		if(!type)
			filename = "Cards";
		else
			filename = "Tickets";
		
		product = (Product) FileManager.search(product_num, filename);
		
		return product;
	}
	
	//duration = 0 if product = ticket
	//bus, validation = 0, null if product = card
	//validation = null if product = 1way ticket
	
	//Δυνατότητα αγοράς κάρτας 25-5 του μηνός - //τι γίνεται αν κάποιος παρει λεωφ λιγο πριν τις 12
	public boolean ticketValidation(String date_time, int duration, int bus, String validation_date_time) throws ParseException {
		String dates = date_time.substring(0,10);
		String times  = date_time.substring(11, 19);
		
		DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		DateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		Date date = null;
		Date time = null;
			
		date = sdf.parse(dates);
		time = sdf2.parse(times);
		
		//Date current_date = Calendar.getInstance().getTime();
		Date current_date;
		current_date = sdf.parse(sdf.format(new Date()));
		Date current_time;
		current_time = sdf2.parse(sdf2.format(new Date()));
		
		if(duration != 0) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			Date expiration_date = cal.getTime();
			expiration_date = sdf.parse(sdf.format(expiration_date));
			
			if((expiration_date.before(current_date)) || (expiration_date.equals(current_date))) {
				return true;
			}
			else
				return false;
			
		}
		
		if(date.equals(current_date)) {
		
			if(validation_date_time != null) {
				String validation_times = validation_date_time.substring(11, 19);
				Date validation_time = null;
				validation_time = sdf2.parse(validation_times);
				long diff = validation_time.getTime() - time.getTime();
			
				if(diff/(1000*60) <= 70) {
					
					long diff2 = current_time.getTime() - validation_time.getTime();
					if(diff2 > durations.get(bus))
						return false;
					return true;
				}
				else
					return false;
			}
			else {
				long diff2 = current_time.getTime() - time.getTime();
				if(diff2 > durations.get(bus))
					return false;
				return true;
			}
		
		}
		else
			return false;
	}

}
