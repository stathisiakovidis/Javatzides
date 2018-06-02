import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import javafx.scene.image.Image;

public abstract class Product {

	public String date_time;
	private Passenger owner;
	private double price;
	private String type;
	private String product_num;
	private byte[] QR_code;
	private QRcode qr;
	private Image qrImage;
	
	
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
	
	public Passenger getOwner() {
		return owner;
	}
	
	public void setDate_time() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/ddHH:mm:ss");
		Calendar cal = Calendar.getInstance();
		date_time = dateFormat.format(cal.getTime());
	}

	public void setQR (byte[] QRcode) throws WriterException, IOException {
		QR_code = qr.generateQRCode(date_time, 350, 350);
	}
	
	public void printQR() {
		qrImage = qr.printQRCode(QR_code);
	}
	
	public boolean isValid() throws FileNotFoundException, NotFoundException, IOException {
		String text = qr.decodeQRCode(QR_code);
		return false;
		
	}
}
