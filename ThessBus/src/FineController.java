import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

public class FineController {
	
	@FXML private Hyperlink backHyperlink;
	
	public void onHyperlinkGoBack(ActionEvent actionEvent) {
		Stage primaryStage = getStageFromEvent(actionEvent);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Inspector.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("ThessBus: Inspector");
		primaryStage.show();
	}
	
	public static Stage getStageFromEvent(ActionEvent actionEvent) {
		Node source = (Node) actionEvent.getSource();
		Stage stage = (Stage) source.getScene().getWindow();
		return stage;
	}
	
}