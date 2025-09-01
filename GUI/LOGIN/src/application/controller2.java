import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Optional;

public class controller2 {
    @FXML
    private Label nameLabel;

    @FXML
    private AnchorPane scenePane;

    private Stage stage;

    public void display(String username) {
        if ("Hania".equals(username)) {
            nameLabel.setText("Welcome Bholro");
        } else {
            nameLabel.setText("Welcome " + username);
        }
    }

    public void logout(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logged out!");
            stage.close();
        } else {
            System.out.println("Logout canceled.");
        }
    }
}
