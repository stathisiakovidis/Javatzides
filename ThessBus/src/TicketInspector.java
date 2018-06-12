import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.zxing.NotFoundException;

public class TicketInspector extends User implements Serializable {

	public String name;
	public String inspector_num;
	public HashMap<String, Integer> durations = new HashMap<>(); //Πρέπει να ειναι String λόγω 78Ν 

	
	public TicketInspector(String aName, String aPassword, String username) {
		super(username, aPassword);
		this.name = aName;

		durations.put("14", 60);
		durations.put("02", 70);
		durations.put("31", 65);
		durations.put("30", 70);
		durations.put("78N", 80);
		
	}
	
	public Product browseQR(String filepath_of_qr, int type) throws FileNotFoundException, NotFoundException, IOException {			//type: the type of product the inspector is examining
		String product_num, filename;
		Product product;
		
		product_num = QRcode.decodeQRCodeImage(filepath_of_qr);
		if(type == 0)
			filename = "Cards.dat";
		else
			filename = "Tickets.dat";
		
		product = (Product) FileManager.search(product_num, filename);
		
		return product;
	}
	
	//duration = {70, 90, 120, 1, 3, 6, 12} depending on the product (multi-way ticket or card)
	//bus, validation = 0, null if product = card
	//validation = null if product = 1way ticket

	//Δυνατότητα αγοράς κάρτας 25-5 του μηνός - //τι γίνεται αν κάποιος παρει λεωφ λιγο πριν τις 12
	public boolean ticketValidation(String date_time, int duration, String bus, String validation_date_time, double price) throws ParseException {
		Set<Integer> foo = new HashSet<>();
		foo.add(1);
		foo.add(3);
		foo.add(6);
		foo.add(12);
		
		String dates = date_time.substring(0,10);
		String times  = date_time.substring(11, 17);
		
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat sdf2 = new SimpleDateFormat("HHmmss");
		Date date = null;
		Date time = null;
			
		date = sdf.parse(dates);
		time = sdf2.parse(times);
		
		//Date current_date = Calendar.getInstance().getTime();
		Date current_date;
		current_date = sdf.parse(sdf.format(new Date()));
		Date current_time;
		current_time = sdf2.parse(sdf2.format(new Date()));
		
		if(foo.contains(duration)) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MONTH, 1);
			Date expiration_date = cal.getTime();
			expiration_date = sdf.parse(sdf.format(expiration_date));
			
			//Η κάρτα δεν έληξε
			if((expiration_date.after(current_date)) || (expiration_date.equals(current_date))) {
				return true;
			}
			else //Η κάρτα έχει λήξει
				return false;
			
		}
		
		if(date.equals(current_date)) {
		
			//Έλεγχος τιμής εισιτηρίου σε περίπτωση που το λεωφορείο είναι το 78Ν
			if(bus.equals("78N") && (price != 2))
				return false;
			
			if(validation_date_time != null) {
				String validation_times = validation_date_time.substring(11, 17);
				Date validation_time = null;
				validation_time = sdf2.parse(validation_times);
				long diff = validation_time.getTime() - time.getTime();
			
				if(diff/(1000*60) <= duration) {
					
					long diff2 = current_time.getTime() - validation_time.getTime();
					if(diff2/(1000*60) > durations.get(bus))
						return false;
					return true;
				}
				return false;
			}
			else {
				long diff2 = current_time.getTime() - time.getTime();
				if(diff2/(1000*60) > durations.get(bus))
					return false;
				return true;
			}
		
		}
		else
			return false;
	}

}

//Χρειάζεται να μπουν οι εντολές για ανανέωση των αρχείων στην closeOperation??
//Να αλλάξει ο τρόπος που τσεκάρεται ο χρήστης στη FileManager για προϊόντα και πρόστιμα
//Να μπουν και στο SignOut
//Να προστεθούν εντολές για retrieve προϊόντων και προστίμων κατά την εγγραφή και τη σύνδεση
//Πρώτη φορά που αγοράζεται εισιτήριο αποθήκευση της εικόνας
//Alerts στο login αν δεν συμπληρωμενα πεδία - browseQR όταν δεν έχει επιλεγεί qr  
//Μηνύματα πληροφόρησης στο χρήστη και ελεγκτή ια αγορά προϊόντος, έκδοση προστίμου
//Να επιστρέφεται boolean μεταβλητή ή το μηνυμα που θα εμφανιστεί στον ελεγκτή; - ticketValidation
//Login -> StartScreen, Register -> StartScreen, Login -> InspectorScreen αλλαγή stage
//Αυτόματη συμπλήρωση πεδίων στο navBar και την αρχική
//Αυτόματη εμφάνιση μηνυμάτων για πρόστιμα, εισιτήρια πολλαπλών και ληγμένες κάρτες -> Αρχική
//DepositController!!