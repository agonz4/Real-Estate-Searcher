import javafx.application.Application;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// project imports
/** The class containing the main program for the Listing application */
public class ListingDisplay extends Application
{
    private Listing myListing;
    
    /** Main frame of the application */
    private Stage mainStage;
    
    //Start method for this class, the main application object
    public void start (Stage primaryStage)
    {
        System.out.println("Listing Version 1.00");
        System.out.println ("Copyright 2019 Anthony Gonzalez");
        
        //Create the top-level container (main stage) and add contents to it
        MainStageContainer.setStage
        (primaryStage, "Real Estate Listings 1.00");
        mainStage = MainStageContainer.getInstance();
        
        // Finish setting up the stage 
        // (ENABLE THE GUI TO BE CLOSED USING THE TOP RIGHT 'X' IN THE 
        //  WINDOW), and show it.
        mainStage.setOnCloseRequest(new EventHandler
            <javafx.stage.WindowEvent>() {
                @Override
                public void handle(javafx.stage.WindowEvent event) {
                    System.exit(0);
                }
            });

        try
        {
            myListing = new Listing();
        }
        catch(Exception exc)
        {
            System.err.println
            ("ListingDisplay.ListingDisplay - could not create " +
                "listing!");
            exc.printStackTrace();
        }

        WindowPosition.placeCenter(mainStage);
        mainStage.show();
    }
    
    /** 
     * The "main" entry point for the application. Carries out 
     * actions to set up the application
     */
    //----------------------------------------------------------
    public static void main(String[] args)
    {
       // HouseList availableHouses = new HouseList("/Users/anthonygonzalez/Desktop/houses.txt");
        launch(args);
    }
}