import java.io.File;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import com.google.zxing.NotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class InspectorController implements Initializable{

	@FXML private Button browseButton;
	@FXML private Button printImageButton;
	@FXML private Button FineButton;
	@FXML private ImageView QRimage;
	@FXML private RadioButton cardRadioButton;
	@FXML private RadioButton ticketRadioButton;
	
	private int typeOfProductChecked = -1;
	private ToggleGroup toggleGroup;
	private Path filePathOfQR;
	
	
	public void onClickedBrowse(ActionEvent actionEvent) throws IOException {
	
		Stage primaryStage = MainController.getStageFromEvent(actionEvent);
		
		String filepathofQR = filePathOfQR.toString();
		String product_num = "";
		try {
			product_num = QRcode.decodeQRCodeImage(filepathofQR);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(cardRadioButton.isSelected())
		{
			Card card = (Card) FileManager.search(product_num, "Products.dat");
			
			if(card == null)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Alert");
				alert.setHeaderText(null);
				alert.setContentText("invalid QRCode. No purchased products is encoded in that code");
				alert.showAndWait();
			}
			else 
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchaseData.fxml"));
				Parent root = null;
				root = loader.load();
		        
				PurchaseDataController ctrl = (PurchaseDataController)loader.getController();
		        /*String name="", surname ="",date="",time="";
		        StringTokenizer st = new StringTokenizer(card.getOwner().getUsername() );
		        name = st.nextToken();
		        surname = st.nextToken();
		        StringTokenizer dt = new StringTokenizer(card.getDate_time() );
		        date = dt.nextToken();
		        time = dt.nextToken();
		        
				ctrl.setDataToFields(name,surname,"","Card",date,time,card.getOwner().getPassport(),0 ,card.getDuration());*/
				ctrl.setDataToFields(card, typeOfProductChecked);
				
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("ThessBus: PurchaseData");
				primaryStage.show();
			}
		}	
		else if(ticketRadioButton.isSelected()) {
			Ticket ticket = (Ticket) FileManager.search(product_num, "Products.dat");
			
			if(ticket == null)
			{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Alert");
				alert.setHeaderText(null);
				alert.setContentText("invalid QRCode. No purchased products is encoded in that code");
				alert.showAndWait();
			}
			else 
			{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("PurchaseData.fxml"));
				Parent root = null;
				root = loader.load();
		        
				PurchaseDataController ctrl = (PurchaseDataController)loader.getController();
		        /*String name="", surname ="",date="",time="";
		        StringTokenizer st = new StringTokenizer(ticket.getOwner().getUsername() );
		        name = st.nextToken();
		        surname = st.nextToken();
		        StringTokenizer dt = new StringTokenizer(ticket.getDate_time() );
		        date = dt.nextToken();
		        time = dt.nextToken();
		        
				ctrl.setDataToFields(name,surname,ticket.getBus(),"Ticket",date,time,ticket.getOwner().getPassport(),ticket.getNo_of_routes() ,0);*/
				ctrl.setDataToFields(ticket, typeOfProductChecked);
				
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.setTitle("ThessBus: PurchaseData");
				primaryStage.show();
			}
	
		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Alert");
			alert.setHeaderText(null);
			alert.setContentText("You've not selected the type of product to be checked");
			alert.showAndWait();
		}
	}
	
	public void onClickedPrintImage() {
		FileChooser fc = new FileChooser();
		//fc.setInitialDirectory(new File ("C:\\JavaCodeRepository\\TicketInspectorUI\\"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("PNG Files","*.png"));
		File selectedFile = fc.showOpenDialog(null);
		filePathOfQR = selectedFile.toPath();
		
		if(selectedFile !=  null)
		{
			Image img = new Image(selectedFile.toURI().toString());
			QRimage.setImage(img);
		}
		else
		{
			System.out.println("File is not valid");
		}
	}
	
	public void onClickedFine(ActionEvent actioEvent) {
		Stage primaryStage = MainController.getStageFromEvent(actioEvent);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Fine.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Scene scene = new Scene(root);
		
		//setUserData so that the fxml file of the loader can be retrieved
		scene.setUserData(loader);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Fine");
		primaryStage.show();
	}
	
	public void OnRadioButtonSelected() {
		if(this.toggleGroup.getSelectedToggle().equals(this.cardRadioButton))
			typeOfProductChecked = 0;
		else
			typeOfProductChecked = 1;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		toggleGroup = new ToggleGroup();
		
		cardRadioButton.setToggleGroup(toggleGroup);
		ticketRadioButton.setToggleGroup(toggleGroup);
	}
	
}
