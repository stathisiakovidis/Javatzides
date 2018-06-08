import java.util.ArrayList;

public class Passenger extends User{

	private String email;
	private String passengerNum;
	private String id;
	private String phoneNum;
	private String passport;
	private double balance;
	
	//Checks if the passenger if reduced.
	//Price * 2 for normal
	//Price * 1 for reduced
	private int check;
	
	private ArrayList<Product> products = new ArrayList<>();
	
	//An to apothikeuoume na mi to kanei remove
	private ArrayList<Fine> fines = new ArrayList<>();
	
	
	public Passenger(String username, String password, String email, String passengerNum, String id, String phoneNum, String passport, double balance) {
		super(username, password);
		
		this.email = email;
		this.passengerNum = passengerNum;
		this.id = id;
		this.phoneNum = phoneNum;
		this.balance = balance;	
		this.passport = passport;
		
		check = (this.passport==null)?1:2;
	}
	
	//Tin kaloume mono apo to controller ton settings
	public void setNewData(String username, String password, String email, String passengerNum, String id, String phoneNum, String passport) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.passengerNum = passengerNum;
		this.id = id;
		this.phoneNum = phoneNum;
		this.passport = passport;
	}
	
	public void payFine() {
		
		double totalCost = 0;
		
		for(Fine fine: fines) {
			totalCost += fine.getPrice();
		}
		
		balance -= totalCost;
		fines.clear();
		
	}
	
	public void updateBalance(double additionalMoney) {
		balance += additionalMoney;
	}
	
	public void reduceBalance(double reducedMoney) {
		balance -= reducedMoney;
	}

	public String getPassengerNum() {
		return passengerNum;
	}

	public int getCheck() {
		return check;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public double getBalance() {
		return balance;
	}
	
	public void addProduct(Product aProduct) {
		products.add(aProduct);
	}

	
	

}