import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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
	private Image qrImage;
	
	
	public Product(double price,Passenger owner, String type) {
		setDate_time();
		this.owner = owner;
		this.price = price;
		this.type = type;
		setProduct_num();	
		try {
			setQR();
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setProduct_num() {
		this.product_num= date_time + owner.getPassengerNum();
	}

	public String getDate_time() {
		return date_time;
	}
	
	public Passenger getOwner() {
		return owner;
	}
	
	public void setDate_time() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		this.date_time = dateFormat.format(cal.getTime());
	}

	public void setQR () throws WriterException, IOException {
		this.QR_code = QRcode.generateQRCode(product_num, 350, 350);
	}
	
	public void printQR() {
		qrImage = QRcode.printQRCode(QR_code);
	}
	
	public boolean isValid() {
		return false;
	}
}
