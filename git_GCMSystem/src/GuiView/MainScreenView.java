package GuiView;

import javafx.scene.control.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainScreenView implements Initializable {

	@FXML
	Label SignIn;
	@FXML
	Button helpBtn1;
	@FXML
	Button helpBtnToMain;
	@FXML
	Button cancelBtn;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/GuiView/MainScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/*
	 * methode will change the scene to SignIn
	 * 
	 */
	public void changeSceneToSignIn(ActionEvent event) throws IOException {
		Parent SignInParent = FXMLLoader.load(getClass().getResource("/GuiView/SignIn.fxml"));
		Scene SignInView = new Scene(SignInParent);
		// get the Stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(SignInView);
		window.show();
	}

	/*
	 * methode will make PopUp for "HELP" and will be closed after "save" button
	 * 
	 */
	public void changeSceneToHelp(ActionEvent event) throws IOException {
		Stage stage;
		Parent root;
		if (event.getSource() == helpBtn1) {
			stage = new Stage();

			// load help fxml
			root = FXMLLoader.load(getClass().getResource("/GuiView/Help.fxml"));
			stage.setScene(new Scene(root));
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(helpBtn1.getScene().getWindow());
			stage.showAndWait();
		} else {
			stage = (Stage) helpBtnToMain.getScene().getWindow();
			stage.close();
		}
	}
	
	
	//** canceling method to main view.
	public void cancelBackToMainView(ActionEvent event) throws IOException {
		Stage stage;
		Parent root =FXMLLoader.load(getClass().getResource("/GuiView/MainScreen.fxml"));
		stage = (Stage) cancelBtn.getScene().getWindow();
		stage.close();
		//open main view (just trying) 
		Scene MainView = new Scene(root);
		// get the Stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(MainView);
		window.show();
		
	}

}
