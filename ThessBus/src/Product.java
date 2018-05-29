import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Product {

	private String date_time;
	private Passenger owner;
	private double price;
	private String type;
	private String product_num;
	private byte[] QRcode;
	
	
	public Product(String date_time, double price,Passenger owner, String type, String product_num, byte[] qRcode) {
		super();
		this.date_time = date_time;
		this.owner = owner;
		this.price = price;
		this.type = type;
		this.product_num = product_num;
	}

	public String getDate_time() {
		return date_time;
	}
	
	public void setDate_time() {
		Date today;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		today = (Date) Calendar.getInstance().getTime();
		this.date_time = formatter.format(today);
	}

	public void setQR (byte[] QRcode) {
		
	}
	
	public void printQR() {
		
	}
	
	public boolean isValid() {
		return false;
		
	}
}
