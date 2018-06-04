
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public  class MainController {
	
	
	
	
	@FXML
	public void onClickedPurchase(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Deposit.fxml"));
		Parent root = null;
		root = loader.load();
		DepositController ctrl = (DepositController)loader.getController();
		
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
        InformationController ctrl = (InformationController)loader.getController();
		
        
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Information");
		primaryStage.show();
	}
	
	public void onClickedSignOut(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("LogInScreen.fxml"));
		Parent root = null;
		root = loader.load();
        LoginScreenController ctrl = (LoginScreenController)loader.getController();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Login");
		primaryStage.show();
	}
	public void onClickedSettings(ActionEvent actionEvent) throws IOException
	{
		Stage primaryStage = getStageFromEvent(actionEvent);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Settings.fxml"));
		Parent root = null;
		root = loader.load();
        SettingsController ctrl = (SettingsController)loader.getController();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Login");
		primaryStage.show();
	}

	public static Stage getStageFromEvent(ActionEvent actionEvent)
	{
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		return stage;
	}
	
	
}
