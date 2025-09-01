
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
public class Controller1 {

@FXML
TextField nametextfield;
@FXML
PasswordField pass;

Parent root;
Scene scene;
Stage stage;
	
public void login(ActionEvent event) {

	String username = nametextfield.getText(); 
	if(!(username.equals("Muhammad Saad")) ) {
		Alert WPass = new Alert(Alert.AlertType.ERROR);
		WPass.setTitle("Authentication Failed");
	    WPass.setHeaderText(null);
	    WPass.setContentText("Wrong Username");
	    WPass.showAndWait();
	}
	
	if(!(pass.getText().equals("Saad12345") )) {
		Alert WPass = new Alert(Alert.AlertType.ERROR);
		WPass.setTitle("Authentication Failed");
	    WPass.setHeaderText(null);
	    WPass.setContentText("Wrong Password");
	    WPass.showAndWait();
	}
	
	
	FXMLLoader Loader = new FXMLLoader(getClass().getResource("Logout.fxml")); 
	try {
		root = Loader.load();
		controller2 cont2 =  Loader.getController();
		cont2.display(username);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	scene = new Scene(root);
	
	stage.setScene(scene);
	stage.show();
	

	//event.getSource() fetch the action
	//in node
	//get Scene gets the scene
	//get Window
	//Stage
}
	
}
