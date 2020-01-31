// specify the package
 

// system imports
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// project imports
//==============================================================
public class MessageView extends Text
{
	// Class constructor
	//----------------------------------------------------------
	public MessageView(String initialMessage)
	{
		super(initialMessage);
		setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
		setFill(Color.BLUE);
		setTextAlignment(TextAlignment.LEFT);
	}

	/**
	 * Display ordinary message
	 */
	//----------------------------------------------------------
	public void displayMessage(String message)
	{
		// display the passed text in blue
		setFill(Color.BLUE);
		setText(message);
	}

	/**
	 * Display error message (errors are typically shown in red)
	 */
	//----------------------------------------------------------
	public void displayErrorMessage(String message)
	{
		// display the passed text in red
		setFill(Color.RED);
		setText(message);
	}

	/**
	 * Clear error message
	 */
	//----------------------------------------------------------
	public void clearErrorMessage()
	{
		setText("                           ");
	}
}
