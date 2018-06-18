import java.io.Serializable;
import java.util.Random;

public abstract class User implements Serializable {
	
	protected String username;
	protected String password;
	protected String userNum;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		setUserNum();
	}
	
	public User(String username, String password, String userNum) {
		this.username = username;
		this.password = password;
		this.userNum = userNum;
	}
	
	// Getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserNum() {
		return userNum;
	}

	public void setUserNum() {
		Random random = new Random(System.nanoTime());
		int randomInt = random.nextInt(1000000000);
		this.userNum= Integer.toString(randomInt);
	}

	
	
	
}
