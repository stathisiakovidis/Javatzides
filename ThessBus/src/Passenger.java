import java.util.ArrayList;

import com.google.zxing.WriterException;

import java.io.IOException;
import java.io.Serializable;

public class Passenger extends User implements Serializable{

	private String email;
	private String cardNum;
	private String id;
	private String phoneNum;
	private String passport;
	private double balance;
	private double totalFines;
	//Checks if the passenger if reduced.
	//Price * 2 for normal
	//Price * 1 for reduced
	private int check;
	private ArrayList<Product> products = new ArrayList<>();
	//An to apothikeuoume na mi to kanei remove
	private ArrayList<Fine> fines = new ArrayList<>();
	
	
	public Passenger(String username, String password, String email, String cardNum,
					 String id, String phoneNum, String passport, double balance) {
		super(username, password);
		
		this.email = email;
		this.cardNum = cardNum;
		this.id = id;
		this.phoneNum = phoneNum;
		this.balance = balance;	
		this.passport = passport;
		
		this.check = (this.passport.isEmpty())?2:1;
	}
	
	public Passenger(String username, String password, String email, String cardNum, 
					 String id, String phoneNum, String passport, double balance, String userNum) {
		super(username, password, userNum);
		
		this.email = email;
		this.cardNum = cardNum;
		this.id = id;
		this.phoneNum = phoneNum;
		this.balance = balance;	
		this.passport = passport;
		
		this.check = (this.passport.isEmpty())?2:1;
	}
	
	//Tin kaloume mono apo to controller ton settings
	public void setNewData(String username, String password, String email, String cardNum, String id, String phoneNum, String passport) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.cardNum = cardNum;
		this.id = id;
		this.phoneNum = phoneNum;
		this.passport = passport;
		
		this.check = (this.passport.isEmpty())?2:1;
	}
	
	/*public void payFine() {
		
		double totalCost;
		
		totalCost= calculateTotalFines();
		reduceBalance(totalCost);
		
		fines.clear();
		this.totalFines=0;
		
	}*/
	
	public int countNotValidCards() {
		int count = 0;
		for (Product product : products) {
			if(product instanceof Card && ((Card) product).isValid() == false)
				count++;
		}
		return count;
	}
	
	public int countMultiWayNotValidatedTickets() {
		int count = 0;
		for (Product product : products) {
			if(product instanceof Ticket && ((Ticket)product).getRemaining_routes() > 0)
				count++;
		}
		return count;
	}
	
	public int countUnpaidFines() {
		int count = 0;
		for(Fine fine: fines) {
			 if(fine.isPaid() == false)
				 count++;
		}
		return count;
	}
	
	public double calculateTotalFines()
	{	
		totalFines = 0;
		for(Fine fine: fines) {
			this.totalFines += fine.getPrice();
		}
		return this.totalFines;
	}
	
	
	public void updateBalance(double additionalMoney) {
		balance += additionalMoney;
	}
	
	public void reduceBalance(double reducedMoney) {
		balance -= reducedMoney;
	}


	public void setFines(ArrayList<Fine> fines) {
		this.fines = fines;
	}

	public int getCheck() {
		return check;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public double getBalance() {
		return balance;
	}
	
	public void addProduct(Product aProduct) throws WriterException, IOException {
		
/*		if(Main.loginUser.getProducts() == null)
*/		QRcode.generateQRCodeImage(aProduct.getProduct_num(), 350, 350, ".//QrcodeImages/"+Main.loginUser.getUserNum()+".png");
		products.add(aProduct);
	}
	
	public String getPassport() {
		return passport;
	}

	public String getEmail() {
		return email;
	}

	public String getCardNum() {
		return cardNum;
	}

	public String getId() {
		return id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public ArrayList<Fine> getFines() {
		return fines;
	}

}