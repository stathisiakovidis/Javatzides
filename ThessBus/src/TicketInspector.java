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
	//ενδεικτικές διάρκειες δρομολογίων 
	public HashMap<String, Integer> durations = new HashMap<>(); 

	
	public TicketInspector(String aName, String aPassword, String username) {
		super(username, aPassword);
		this.name = aName;

		durations.put("01", 80);   durations.put("01Α", 80);  durations.put("02", 65);   durations.put("02Α", 70);
		durations.put("03", 60);   durations.put("04Α", 85);  durations.put("04Β", 85);  durations.put("04Ε", 90);
		durations.put("05", 62);   durations.put("06", 65);   durations.put("07", 60);   durations.put("08", 65);
		durations.put("09", 50);   durations.put("09Α", 54);  durations.put("09Β", 57);  durations.put("10", 64);
		durations.put("11", 60);   durations.put("11Β", 63);  durations.put("12", 70);   durations.put("14", 65);
		durations.put("14Α", 65);  durations.put("15", 35);   durations.put("15Α", 40);  durations.put("14", 40);
		durations.put("17", 57);   durations.put("18", 70);   durations.put("19", 70);   durations.put("19Α", 68);
		durations.put("20", 65);   durations.put("21", 56);   durations.put("21Α", 60);  durations.put("22", 55);
		durations.put("23", 70);   durations.put("24", 65);   durations.put("25", 67);   durations.put("25Α", 68);
		durations.put("26", 75);   durations.put("27", 70);   durations.put("27Α", 72);  durations.put("27Β", 75);
		durations.put("28Α", 82);  durations.put("28Β", 80);  durations.put("29", 75);   durations.put("29Α", 78);
		durations.put("30", 50);   durations.put("31", 70);   durations.put("32", 78);   durations.put("32Α", 78);
		durations.put("33", 40);   durations.put("33Α", 42);  durations.put("34", 45);   durations.put("35", 30);
		durations.put("36", 45);   durations.put("36Α", 45);  durations.put("36Β", 45);  durations.put("36Ε", 45);
		durations.put("36Η", 40);  durations.put("36Κ", 40);  durations.put("36Ν", 40);  durations.put("36Ρ", 40);
		durations.put("36Τ", 40);  durations.put("36Υ", 40);  durations.put("36Ζ", 40);  durations.put("37", 40);
		durations.put("38", 40);   durations.put("39", 40);   durations.put("39Α", 40);  durations.put("40", 40);
		durations.put("40Α", 40);  durations.put("40Κ", 40);  durations.put("42", 40);   durations.put("42Α", 40);
		durations.put("42Β", 40);  durations.put("43", 40);   durations.put("45", 40);   durations.put("45Α", 40);
		durations.put("45Β", 40);  durations.put("50", 40);   durations.put("51", 40);   durations.put("51Α", 40);
		durations.put("52", 40);   durations.put("52Α", 40);  durations.put("53", 40);   durations.put("54", 40);
		durations.put("54Α", 40);  durations.put("55", 40);   durations.put("55Α", 40);  durations.put("55Β", 40);
		durations.put("55Ε", 40);  durations.put("55Κ", 40);  durations.put("55Μ", 40);  durations.put("55Ν", 40);
		durations.put("55Ρ", 40);  durations.put("56", 40);   durations.put("56Α", 40);  durations.put("57", 40);
		durations.put("58", 40);   durations.put("59", 40);   durations.put("59Α", 40);  durations.put("59Β", 40);
		durations.put("59Κ", 40);  durations.put("60Α", 40);  durations.put("60Β", 40);  durations.put("60Ε", 40);
		durations.put("61", 40);   durations.put("61Α", 40);  durations.put("64", 40);   durations.put("64Α", 40);
		durations.put("64Β", 40);  durations.put("64Ε", 40);  durations.put("64Κ", 40);  durations.put("66", 40);
		durations.put("67", 40);   durations.put("67Α", 40);  durations.put("67Β", 40);  durations.put("68Α", 40);
		durations.put("68Β", 40);  durations.put("69Α", 40);  durations.put("69Β", 40);  durations.put("69Η", 40);
		durations.put("69Κ", 40);  durations.put("69Ν", 40);  durations.put("69Ρ", 40);  durations.put("69Τ", 40);
		durations.put("70", 40);   durations.put("70Α", 40);  durations.put("71", 40);   durations.put("71Α", 40);
		durations.put("72", 40);   durations.put("72Α", 40);  durations.put("72Β", 40);  durations.put("76", 40);
		durations.put("76Α", 40);  durations.put("76Β", 40);  durations.put("77", 40);   durations.put("77Α", 40);
		durations.put("77Β", 40);  durations.put("77Ε", 40);  durations.put("77Η", 40);  durations.put("77Κ", 40);
		durations.put("79", 40);   durations.put("79Α", 40);  durations.put("79Β", 40);  durations.put("80", 40);
		durations.put("80Α", 40);  durations.put("80Β", 40);  durations.put("80Ε", 40);  durations.put("80Ζ", 40);
		durations.put("81", 40);   durations.put("81Α", 40);  durations.put("81Β", 40);  durations.put("81Ε", 40);
		durations.put("81Κ", 40);  durations.put("82Α", 40);  durations.put("82Β", 40);  durations.put("82Ε", 40);
		durations.put("82Κ", 40);  durations.put("82Μ", 40);  durations.put("82Ν", 40);  durations.put("83", 40);
		durations.put("83Α", 40);  durations.put("83Β", 40);  durations.put("83Μ", 40);  durations.put("83Ν", 40);
		durations.put("83Τ", 40);  durations.put("83Χ", 40);  durations.put("84Α", 40);  durations.put("84Β", 40);
		durations.put("85", 40);   durations.put("85Α", 40);  durations.put("85Β", 40);  durations.put("85Η", 40);
		durations.put("85Κ", 40);  durations.put("85Μ", 40);  durations.put("85Ν", 40);  durations.put("85Τ", 40);
		durations.put("85Χ", 40);  durations.put("85Ζ", 40);  durations.put("86", 40);   durations.put("86Α", 40);
		durations.put("86Β", 40);  durations.put("86Ε", 40);  durations.put("86Ζ", 40);  durations.put("86Η", 40);
		durations.put("86Κ", 40);  durations.put("86Λ", 40);  durations.put("86Μ", 40);  durations.put("86Ν", 40);
		durations.put("86Ρ", 40);  durations.put("86Τ", 40);  durations.put("86Χ", 40);  durations.put("86Υ", 40);
		durations.put("86Φ", 40);  durations.put("87Α", 40);  durations.put("87Β", 40);  durations.put("87Γ", 40);
		durations.put("87Ε", 40);  durations.put("87Ζ", 40);  durations.put("87Η", 40);  durations.put("87Θ", 40);
		durations.put("87Λ", 40);  durations.put("87Μ", 40);  durations.put("87Ν", 40);  durations.put("87Π", 40);
		durations.put("87Ρ", 40);  durations.put("87Τ", 40);  durations.put("87Φ", 40);  durations.put("87Χ", 40);
		durations.put("88", 40);   durations.put("88Α", 40);  durations.put("88Β", 40);  durations.put("88Ε", 40);
		durations.put("88Η", 40);  durations.put("88Κ", 40);  durations.put("88Μ", 40);  durations.put("88Ν", 40);
		durations.put("89Α", 40);  durations.put("89Β", 40);  durations.put("89Ε", 40);  durations.put("89Κ", 40);
		durations.put("89Ν", 40);  durations.put("90", 40);   durations.put("90Α", 40);  durations.put("90Β", 40);
		durations.put("90Ε", 40);  durations.put("90Κ", 40);  durations.put("91Α", 40);  durations.put("91Β", 40);
		durations.put("91Ε", 40);  durations.put("91Η", 40);  durations.put("91Κ", 40);  durations.put("91Ν", 40);
		durations.put("91Τ", 40);  durations.put("91Χ", 40);  durations.put("91Υ", 40);  durations.put("92", 40);
		durations.put("92Α", 40);  durations.put("92Ε", 40);  durations.put("92Ρ", 40);  durations.put("Ν1", 40);
		durations.put("Ν1Α", 40);  durations.put("Χ1", 40);
		
	}
	
	public Product browseQR(String filepath_of_qr) throws FileNotFoundException, NotFoundException, IOException {			
		String product_num;
		Product product;
		
		product_num = QRcode.decodeQRCodeImage(filepath_of_qr);
		
		product = (Product) FileManager.search(product_num, "Products.dat");
		
		return product;
	}
	
	//duration = {70, 90, 120, 1, 3, 6, 12} depending on the product (multi-way ticket or card)
	//bus, validation = 0, null if product = card
	//validation = null if product = 1way ticket
	
	//τι γίνεται αν κάποιος παρει λεωφ λιγο πριν τις 12
	public boolean ticketValidation(String date_time, int duration, String bus, String validation_date_time, double price) throws ParseException {
		Set<Integer> foo = new HashSet<>();
		foo.add(1);
		foo.add(3);
		foo.add(6);
		foo.add(12);
		
		String dates = date_time.substring(0,10);
		String times  = date_time.substring(11, 19);
		
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
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
			if((bus.equals("N1") || bus.equals("N1A")) && (price != 2.0))
				return false;
			
			if(validation_date_time.equals("-") == false) {
				String validation_times = validation_date_time.substring(11, 19);
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

//Χρειάζεται να μπουν οι εντολές για ανανέωση των αρχείων στην closeOperation?? ν
//Να αλλάξει ο τρόπος που τσεκάρεται ο χρήστης στη FileManager για προϊόντα και πρόστιμα 
//Να μπουν και στο SignOut ν
//Να προστεθούν εντολές για retrieve προϊόντων και προστίμων κατά την εγγραφή και τη σύνδεση
//Πρώτη φορά που αγοράζεται εισιτήριο αποθήκευση της εικόνας ν
//Alerts στο login να μην εξαφανίζουν παράθυρο ν 
//Μηνύματα πληροφόρησης στο χρήστη και ελεγκτή για αγορά προϊόντος, έκδοση προστίμου ν
//Να επιστρέφεται boolean μεταβλητή ή το μηνυμα που θα εμφανιστεί στον ελεγκτή; - ticketValidation ν
//Register -> StartScreen αλλαγή stage ν
//Αυτόματη συμπλήρωση πεδίων στο navBar και την αρχική ν
//Αυτόματη εμφάνιση μηνυμάτων για πρόστιμα, εισιτήρια πολλαπλών και ληγμένες κάρτες -> Αρχική
//DepositController!! ν
//Έλεγχος εισιτηρίου: να δοκιμαστούν διάφορα