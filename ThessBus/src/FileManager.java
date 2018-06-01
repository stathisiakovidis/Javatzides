import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
	
	ArrayList passengers = new ArrayList();
	
	public void InsertPassenger(Passenger passenger, String filename) {
		ObjectOutputStream oos = null;
		try 
		{
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);
			
			//read previous list of users from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			passengers = (ArrayList) ois.readObject();
			
			//add the new user
			passengers.add(passenger);
			oos.writeObject(passengers);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			//if class not found then first time adding a user so no need to read the list 
			passengers.add(passenger);
			try {
				oos.writeObject(passenger);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public User searchPassenger(Passenger aPassenger, String filename) {
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			passengers = (ArrayList) ois.readObject();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		if(passengers.contains(aPassenger))
		{
			return aPassenger;
		}
		else
		{
			return null;
		}
		
	}
	
	public void updatePassenger(Passenger aPassenger, String filename) {
		boolean found;
		
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			passengers = (ArrayList) ois.readObject();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		for (int i = 0; i < passengers.size(); i++) {
			if(passengers.get(i).equals(aPassenger))
			{
				passengers.set(i, aPassenger);
				found=true;
				try 
				{
					FileOutputStream fout = new FileOutputStream(filename);
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(passengers);
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
		}
		
	}

	
}
