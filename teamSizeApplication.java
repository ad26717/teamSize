import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class teamSizeApplication extends Application
{

	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		TextInputDialog inputdialog = new TextInputDialog();
		inputdialog.setTitle("Team Size Application");
		inputdialog.setHeaderText(null);
		inputdialog.setContentText("Please enter the number of players:\t");

		Optional<String> numPeople = inputdialog.showAndWait();
		Integer intNumPeople = Integer.parseInt(numPeople.get());
		Integer groupNumber;
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Team Size Application");

		if (intNumPeople> 10)
		{
			alert.setContentText("The number of the teams is: " + intNumPeople/11);
			alert.showAndWait();

		}
		else if (intNumPeople< 10) 
		{
			alert.setContentText("The number of the teams is: 1");
			alert.showAndWait();
		}

	}


}
