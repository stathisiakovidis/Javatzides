
public class Card extends Product{
	
	private int duration;

	public Card(String date_time, double price,Passenger owner, String type, String product_num, byte[] qRcode, int duration) {
		super(date_time, price, owner, type, product_num, qRcode);
		this.duration = duration;
	}
	
    public void setQR (byte[] QRcode) {
		
	}
	
	public int getDuration() {
		return duration;
	}

	public void printQR() {
		
	}
	
	public boolean isValid() {
		return false;
		
	}

	
	

}
