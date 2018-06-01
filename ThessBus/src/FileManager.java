import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {
	
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Fine> fines = new ArrayList<Fine>();
	
	public void InsertUser(User user, String filename) {
		ObjectOutputStream oos = null;
		try 
		{
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);
			
			//read previous list of users from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList) ois.readObject();
			
			//add the new user
			users.add(user);
			oos.writeObject(users);
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
			users.add(user);
			try {
				oos.writeObject(user);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public User searchUser(User user, String filename) {
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList) ois.readObject();
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
		
		if(users.contains(user))
		{
			return user;
		}
		else
		{
			return null;
		}
		
	}
	
	public void updatePassenger(User user, String filename) {
		boolean found;
		
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList) ois.readObject();
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
		
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(user.getUsername()))
			{
				users.set(i, user);
				found=true;
				try 
				{
					FileOutputStream fout = new FileOutputStream(filename);
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(users);
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
	
	public void insertProduct(Product product, String filename) {
		ObjectOutputStream oos = null;
		try 
		{
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);
			
			//read previous list of users from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			products = (ArrayList) ois.readObject();
			
			//add the new user
			products.add(product);
			oos.writeObject(users);
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
			products.add(product);
			try {
				oos.writeObject(product);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public ArrayList<Product> getProducts(String username, String filename){
		ArrayList<Product> foundproducts = new ArrayList<Product>();
		
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			products = (ArrayList) ois.readObject();
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
		
		for (int i = 0; i < products.size(); i++) {
			if(products.get(i).getOwner().getUsername().equals(username))
			{
				foundproducts.add(products.get(i));
			}
		}
		
		return foundproducts;
	}
	
	public void insertFine(Fine issued_fine, String filename) {
		ObjectOutputStream oos = null;
		try 
		{
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);
			
			//read previous list of users from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fines = (ArrayList) ois.readObject();
			
			//add the new user
			fines.add(issued_fine);
			oos.writeObject(users);
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
			fines.add(issued_fine);
			try {
				oos.writeObject(issued_fine);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public ArrayList<Fine> getFines(String username, String filename){
		ArrayList<Fine> foundfines = new ArrayList<Fine>();
		
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fines = (ArrayList) ois.readObject();
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
		
		for (int i = 0; i < products.size(); i++) {
			if(fines.get(i).getOwner().getUsername().equals(username))
			{
				foundfines.add(fines.get(i));
			}
		}
		
		return foundfines;
	}
	
	public void updateFines(String username,ArrayList<Fine> updatedfines,String filename){
		
		try 
		{
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fines = (ArrayList) ois.readObject();
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
		
		for (int i = 0; i < fines.size(); i++) {
			if(fines.get(i).getOwner().getUsername().equals(username))
			{
				fines.remove(i);
			}
		}
		
		for (int i = 0; i < fines.size(); i++) {
			insertFine(updatedfines.get(i),filename);
		}
		
	}
	
	

	
}
