import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.scene.control.Dialog;
import javafx.util.Pair;
import javafx.scene.image.ImageView;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Authentication extends Application {
	private String adminUsername = "alicces";
	private String adminPassword = "alidemir";

	@Override
	public void start(Stage primaryStage)
	{
		Dialog<Pair<String,String>> dialog = new Dialog<>();
		dialog.setTitle("Authentication");
		dialog.setHeaderText("Login to use group size calc");
		dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));
		ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
		
		GridPane grid = new GridPane();
		grid.setVgap(15);
		grid.setHgap(15);

		TextField username = new TextField();
		username.setPromptText("Enter Username");
		
		PasswordField password = new PasswordField();
		password.setPromptText("Enter Password");

		grid.add(new Label("Username:"),0,0);
		grid.add(username,1,0);
		grid.add(new Label("Password:"),0,1);
		grid.add(password,1,1);

		dialog.getDialogPane().setContent(grid);

		dialog.setResultConverter(dialogButton-> {
			if(dialogButton == loginButtonType) {
				return new Pair<>(username.getText(), password.getText());
			}
			return null;
		});
		int count = 0;
			Optional<Pair<String, String>> result;
		do {
			result = dialog.showAndWait();
			username.clear();
			password.clear();
			count ++;
		} while(!result.get().getKey().equals(adminUsername) && !result.get().equals(adminPassword) && count < 3 );

		if (!(count < 3)){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Authentification");
			alert.setContentText("You have tried too many times, so your account will be locked");
			alert.setHeaderText(null);
			alert.showAndWait();
		} else {
		
		Stage stage = new Stage();
		groupSizeApplication groupsize = new groupSizeApplication();
		groupsize.start(stage);

		}


	}

	public static void main(String [] args) {
		launch(args);
	}
}
