
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {
	
		
	@FXML
	public void onClickedPurchase(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Deposit.fxml"));
		Parent root = null;
		root = loader.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Deposit");
		primaryStage.show();
	}
	
	@FXML
	public void onClickedHistory(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("History.fxml"));
		Parent root = null;
		root = loader.load();
		
		HistoryController ctrl = (HistoryController)loader.getController();
		ctrl.setFieldsandData(Main.loginUser.getProducts(), Main.loginUser.getFines());
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: History");
		primaryStage.show();
	}
	
	public void onClickedStartScreen(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
		Parent root = null;
		root = loader.load();
		
        StartScreenController ctrl = (StartScreenController)loader.getController();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Start Screen");
		primaryStage.show();
	}
	
	public void onClickedInformation(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Information.fxml"));
		Parent root = null;
		root = loader.load();		
        
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Information");
		primaryStage.show();
	}
	
	public void onClickedSignOut(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		primaryStage.close();
		
		FXMLLoader loader = (FXMLLoader) primaryStage.getScene().getUserData();
		String fxmlFile = "";
		if(loader != null)
			fxmlFile = loader.getLocation().getFile();
		
		if(fxmlFile.contains("Inspector.fxml") || fxmlFile.contains("Fine.fxml") || fxmlFile.contains("PurchaseData.fxml")) {
			Main.loginIns = null;
		}
		else {
			Passenger temp = new Passenger(Main.loginUser.getUsername(),
			Main.loginUser.getPassword(), Main.loginUser.getEmail(),
			Main.loginUser.getCardNum(), Main.loginUser.getId(),
			Main.loginUser.getPhoneNum(), Main.loginUser.getPassport(),
			Main.loginUser.getBalance());

			FileManager.updatePassenger(Main.loginUser, "Users.dat", temp);
			FileManager.insertProducts(Main.loginUser.getUsername(), Main.loginUser.getProducts(),
											"Products.dat");
			/*FileManager.updateFines(Main.loginUser.getUsername(), Main.loginUser.getFines(),
											"Fines.dat");*/
					
			Main.loginUser = null;
		}
		
		Stage stage = new Stage();
		FXMLLoader loader1 = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
		Parent root = null;
		root = loader1.load();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("ThessBus: Login");
		stage.show();
		
	}
	
	public void onClickedSettings(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
		Parent root = null;
		root = loader.load();		
        Scene scene = new Scene(root);
        
        //setUserData so that the fxml file of the loader can be retrieved
        scene.setUserData(loader);
        
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Login");
		primaryStage.show();
	}

	public void onHyperlinkGoBack(ActionEvent actionEvent) throws IOException {
		Stage primaryStage = getStageFromEvent(actionEvent);
		
		FXMLLoader loader = (FXMLLoader) primaryStage.getScene().getUserData();
		String fxmlFile = "";
		if(loader != null)
			fxmlFile = loader.getLocation().getFile();
		
		if(fxmlFile.contains("Card.fxml")) {
			CardController controller = (CardController) loader.getController();
			if(controller.getNavBarVBox().isMouseTransparent()) {
				loader = new FXMLLoader(getClass().getResource("VisitorScreen.fxml"));
				Parent root = null;
				root = loader.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("ThessBus: Visitor");
				primaryStage.show();
			}
			else {
				loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
				Parent root = null;
				root = loader.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("ThessBus: StartScreen");
				primaryStage.show();
			}
		}
		else if(fxmlFile.contains("Fine.fxml")) {
			loader = new FXMLLoader(getClass().getResource("Inspector.fxml"));
			Parent root = null;
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ThessBus: Inspector");
			primaryStage.show();
		}
		else if(fxmlFile.contains("Ticket_Panel.fxml")) {
			TicketController controller = (TicketController) loader.getController();
			if(controller.getNavBarVBox().isMouseTransparent()) {
				loader = new FXMLLoader(getClass().getResource("VisitorScreen.fxml"));
				Parent root = null;
				root = loader.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("ThessBus: Visitor");
				primaryStage.show();
			}
			else {
				loader = new FXMLLoader(getClass().getResource("Startscreen.fxml"));
				Parent root = null;
				root = loader.load();
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("ThessBus: StartScreen");
				primaryStage.show();
			}
		}
		else if(fxmlFile.contains("Settings.fxml")) {
			loader = new FXMLLoader(getClass().getResource("StartScreen.fxml"));
			Parent root = null;
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ThessBus: StartScreen");
			primaryStage.show();
		}
		else { //RegisterScreen.fxml, VisitorScreen.fxml
			loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
			Parent root = null;
			root = loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("ThessBus: Login");
			primaryStage.show();
		}
	}
	
	public static Stage getStageFromEvent(ActionEvent actionEvent)
	{
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		return stage;
	}
	
	
}
