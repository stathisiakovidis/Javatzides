import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileManager {

	public static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Product> products = new ArrayList<Product>();
	public static ArrayList<Fine> fines = new ArrayList<Fine>();

	public static void InsertUser(User user, String filename) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);

			// read previous list of users from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList<User>) ois.readObject();

			// add the new user
			users.add(user);
			oos.writeObject(users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// if class not found then first time adding a user so no need to read the list
			users.add(user);
			try {
				oos.writeObject(users);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// if class not found then first time adding a user so no need to read the list
			users.add(user);
			try {
				oos.writeObject(user);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static User searchUser(String username, String password, String filename) {
		boolean found = false;
		User foundUser = null;
		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList<User>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
				found = true;
				foundUser = users.get(i);

			}
		}

		if (found == true) {
			return foundUser;
		} else {
			return null;
		}

	}

	public static void updatePassenger(User user, String filename, User newUser) {
		boolean found;

		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			users = (ArrayList<User>) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(user.getUsername())) {
				users.remove(i);
				users.add(newUser);
				found = true;
				try {
					FileOutputStream fout = new FileOutputStream(filename);
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(users);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static void insertProducts(String username, ArrayList<Product> productstoInsert, String filename) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);

			// read previous list of products from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			products = (ArrayList) ois.readObject();

			for (int i = 0; i <= products.size(); i++) {
				if (products.get(i).getOwner().getUsername().equals(username)) {
					products.remove(i);
				}
			}

			// add the new products
			for (int i = 0; i < productstoInsert.size(); i++)
				products.add(productstoInsert.get(i));
			oos.writeObject(products);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("geia");
			// if io exception then first time adding a product so no need to read the list
			for (int i = 0; i < productstoInsert.size(); i++)
				products.add(productstoInsert.get(i));
			try {
				oos.writeObject(products);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("geia 1");
			// if class not found then first time adding a product so no need to read the
			// list
			for (int i = 0; i < productstoInsert.size(); i++)
				products.add(productstoInsert.get(i));
			try {
				oos.writeObject(products);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static ArrayList<Product> getProducts(String username, String filename) {
		ArrayList<Product> foundproducts = new ArrayList<Product>();

		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			products = (ArrayList) ois.readObject();
			for (int i = 0; i < products.size(); i++) {
				if (products.get(i).getOwner().getUsername().equals(username)) {
					foundproducts.add(products.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		

		return foundproducts;
	}

	public static void insertFine(Fine issued_fine, String filename) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fout = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fout);

			// read previous list of fines from file
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fines = (ArrayList) ois.readObject();

			// add the new fine
			fines.add(issued_fine);
			oos.writeObject(users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// if io exception then first time adding a fine so no need to read the list
			fines.add(issued_fine);
			try {
				oos.writeObject(fines);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// if class not found then first time adding a fine so no need to read the list
			fines.add(issued_fine);
			try {
				oos.writeObject(fines);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public static ArrayList<Fine> getFines(String username, String filename) {
		ArrayList<Fine> foundfines = new ArrayList<Fine>();

		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fines = (ArrayList) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < fines.size(); i++) {
			if (fines.get(i).getOwner().getUsername().equals(username)) {
				foundfines.add(fines.get(i));
			}
		}

		return foundfines;
	}

	public static void updateFines(String username, ArrayList<Fine> updatedfines, String filename) {

		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			fines = (ArrayList) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < fines.size(); i++) {
			if (fines.get(i).getOwner().getUsername().equals(username)) {
				fines.remove(i);
			}
		}

		for (int i = 0; i < updatedfines.size(); i++) {
			insertFine(updatedfines.get(i), filename);
		}

	}

	public static Object search(String searchvalue, String filename) {
		ArrayList<Object> listOfItems = new ArrayList<>();

		try {
			FileInputStream fin = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(fin);
			listOfItems = (ArrayList) ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		if (filename.equals("Products.dat")) {
			for (int i = 0; i < listOfItems.size(); i++) {
				if (((Product) listOfItems.get(i)).getProduct_num().equals(searchvalue)) {
					return listOfItems.get(i);
				}
			}
		} else if (filename.equals("Users.dat")) {
			for (int i = 0; i < listOfItems.size(); i++) {
				if (((User) listOfItems.get(i)).getUsername().equals(searchvalue)) {
					return listOfItems.get(i);
				}
			}
		}

		return null;

	}

}
