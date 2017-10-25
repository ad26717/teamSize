import javafx.application.Application;
import javafx.stage.Stage;
import java.util.Optional;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class groupSizeApplication extends Application
{

	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		TextInputDialog inputdialog = new TextInputDialog();
		inputdialog.setTitle("Group Size Application");
		inputdialog.setHeaderText(null);
		inputdialog.setContentText("Please enter the number of people:\t");

		Optional<String> numPeople = inputdialog.showAndWait();
		Integer intNumPeople = Integer.parseInt(numPeople.get());
		Integer groupNumber = intNumPeople/2;
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setTitle("Group Size Application");

		if (intNumPeople> 10)
		{
			alert.setContentText("The number of the group is: " + groupNumber);
			alert.showAndWait();

		}
		else if (intNumPeople < 10 && intNumPeople > 3) 
		{
			alert.setContentText("The number of the group is: " + groupNumber);
			alert.showAndWait();
		}
		else 
		{
			alert.setContentText("The number of people has to be at least 3.");
			alert.showAndWait();

		}

	}


}
