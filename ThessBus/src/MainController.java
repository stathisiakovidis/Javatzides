
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public  class MainController {
	
	@FXML
	public Button startButton;
	@FXML
	public Button historyButton;
	@FXML
	public Button settingsButton;
	@FXML
	public Button depositButton;
	@FXML
	public Button infoButton;
	
	
	
	public void openStartScreen(ActionEvent e) throws Exception{ 	
		Stage primaryStage=Main.getStagefromEvent(e);
		Parent root=null;
		root= FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Home");
		primaryStage.show();
	}
	
	public void openDepositScreen(ActionEvent e) throws Exception{
		Stage primaryStage=Main.getStagefromEvent(e);
		Parent root=null;
		root= FXMLLoader.load(getClass().getResource("Deposit.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Deposit");
		primaryStage.show();
	}
	
	/* public void openHistortyScreen(ActionEvent e) throws Exception{
		Stage primaryStage=Main.getStagefromEvent(e);
		Parent root=null;
		root= FXMLLoader.load(getClass().getResource("History.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: History");
		primaryStage.show(); 
		
	}*/
	
	
	/* public void openSettingsScreen(ActionEvent e) throws Exception{
	Stage primaryStage=Main.getStagefromEvent(e);
	Parent root=null;
	root= FXMLLoader.load(getClass().getResource("Settings.fxml"));
	Scene scene = new Scene(root);
	primaryStage.setScene(scene);
	primaryStage.setTitle("ThessBus: Settings");
	primaryStage.show(); }*/
	
	/* public void openInfoScreen(ActionEvent e) throws Exception{
	Stage primaryStage=Main.getStagefromEvent(e);
	Parent root=null;
	root= FXMLLoader.load(getClass().getResource("Information.fxml"));
	Scene scene = new Scene(root);
	primaryStage.setScene(scene);
	primaryStage.setTitle("ThessBus: Information");
	primaryStage.show(); }*/

	
	
	
	
}
