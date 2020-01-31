// system imports
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Properties;
import java.util.Vector;

/**
 * The class containg the Listing view for the housing selection
 * application
 */

public class listingView extends View
{
    //Model. which this view talks  to
    private Listing myModel;

    //GUI components
    private TextField minimumPrice;
    private TextField maximumPrice;
    private TextField minimumArea;
    private TextField maximumArea;
    private TextField minimumBeds;
    private TextField maximumBeds;
    private TextField chosenHome;

    private Button submitButton;
    private Button findOtherButton;
    private Button resetButton;

    //For showing error message
    private MessageView statusLog;
    //contructor for this class -- takes a model object

    public listingView (Listing listing){
        super ("ListingView");
        myModel = listing;

        //create a container for showing the contents
        VBox container = new VBox(10);
        container.setPadding(new Insets(15, 5, 5, 5));

        //create our GUI components, add them to this panel
        container.getChildren().add(createTitle());
        container.getChildren().add(createFormContent());

        //Error message area
        container.getChildren().add(createStatusLog(" "));

        getChildren().add(container);
    }

    //Create the tittle container
    private Node createTitle()
    {
        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);

        Text titleText = new Text (" Real Estate Listings ");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setWrappingWidth(300);
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.DARKGREEN);
        container.getChildren().add(titleText);

        return container;

    }

    //Create the main form content
    private VBox createFormContent()
    {
        VBox vbox = new VBox (10);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        ///////////////////////////////////////////////////////
        Text minPriceLabel = new Text ("Minimum Price ");
        minPriceLabel.setWrappingWidth(150);
        minPriceLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(minPriceLabel, 0, 0);

        minimumPrice = new TextField();
        grid.add(minimumPrice, 1, 0);

        ///////////////////////////////////////////////////////
        Text maxPriceLabel = new Text ("Maximum Price ");
        maxPriceLabel.setWrappingWidth(150);
        maxPriceLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(maxPriceLabel, 0, 1);

        maximumPrice = new TextField();
        grid.add(maximumPrice, 1, 1);

        ///////////////////////////////////////////////////////
        Text minAreaLabel = new Text ("Minimum Area ");
        minAreaLabel.setWrappingWidth(150);
        minAreaLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(minAreaLabel, 0, 2);

        minimumArea = new TextField();
        grid.add(minimumArea, 1, 2);

        ///////////////////////////////////////////////////////
        Text maxAreaLabel = new Text ("Maximum Area ");
        maxAreaLabel.setWrappingWidth(150);
        maxAreaLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(maxAreaLabel, 0, 3);

        maximumArea = new TextField();
        grid.add(maximumArea, 1, 3);

        ///////////////////////////////////////////////////////
        Text minBedsLabel = new Text ("Minimum Beds ");
        minBedsLabel.setWrappingWidth(150);
        minBedsLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(minBedsLabel, 0, 4);

        minimumBeds = new TextField();
        grid.add(minimumBeds, 1, 4);

        ///////////////////////////////////////////////////////
        Text maxBedsLabel = new Text ("Maximum Beds ");
        maxBedsLabel.setWrappingWidth(150);
        maxBedsLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(maxBedsLabel, 0, 5);

        maximumBeds = new TextField();
        grid.add(maximumBeds, 1, 5);

        ///////////////////////////////////////////////////////
        Text chosenHomeLabel = new Text ("Chosen Home");
        chosenHomeLabel.setWrappingWidth(150);
        chosenHomeLabel.setTextAlignment(TextAlignment.RIGHT);
        grid.add(chosenHomeLabel, 0, 6);

        chosenHome = new TextField();
        grid.add(chosenHome, 1, 6);

        ///////////////////////////////////////////////////////
        submitButton = new Button ("Find my dream house!");
        submitButton.setOnAction(new EventHandler<ActionEvent>(){
            
                @Override
                public void handle(ActionEvent e) {
                    //clearErrorMessage();
                    // do the calculation
                    processAction(e);

                }
            });

        findOtherButton = new Button ("Not my dream - find me another");
        findOtherButton.setDisable(true);
        findOtherButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {

                    //--------------------------------------------
                    clearErrorMessage();
                  
                    myModel.getRandomHouse();
                    //myModel.cancelTransaction();
                }
            });

        resetButton = new Button ("Reset");

        resetButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {

                    //--------------------------------------------
                    clearErrorMessage();
                    resetFields(e);
                    
                    //myModel.cancelTransaction();
                }
            });

        HBox btnContainer = new HBox(100);
        btnContainer.setAlignment(Pos.CENTER);
        btnContainer.getChildren().add(submitButton);
        btnContainer.getChildren().add(findOtherButton);
        btnContainer.getChildren().add(resetButton);

        vbox.getChildren().add(grid);
        vbox.getChildren().add(btnContainer);
        return vbox;
    }

    //Create the status log field 
    //-------------------------------------------------------------
    private MessageView createStatusLog(String initialMessage)
    {
        statusLog = new MessageView(initialMessage);

        return statusLog;
    }

    //process events generated from our GUI components
    public void processAction (Event evt)
    
        
    {
        submitButton.setDisable(true);
        findOtherButton.setDisable(false);
        
        String minPriceEntered = minimumPrice.getText();
        String maxPriceEntered = maximumPrice.getText();

        String minAreaEntered =  minimumArea.getText();
        String maxAreaEntered =  maximumArea.getText();

        String minBedEntered =   minimumBeds.getText();
        String maxBedEntered =   maximumBeds.getText();
        
            processListing(minPriceEntered, maxPriceEntered,minAreaEntered, maxAreaEntered, minBedEntered,
                maxBedEntered);

    }

    /**
     * Process the data selected and entered by user.
     * Action is to pass this info on to the RealEstate(Model)
     * calling the appropiate method on the RealEstate object
     */
    private void processListing (String intMinPrice, String intMaxPrice, String intMinArea,
    String intMaxArea, String intMinBed, String intMaxBed)
    {
        Properties props = new Properties();
        props.setProperty("minPrice", intMinPrice);
        props.setProperty("maxPrice", intMaxPrice);
        props.setProperty("minArea", intMinArea);
        props.setProperty("maxArea", intMaxArea);
        props.setProperty("minBed", intMinBed);
        props.setProperty("maxBed", intMaxBed);

        findOtherButton.setDisable(false);
        myModel.processListing(props);
    }

    //------------------------------------------------------
    public void updateState (String key, Object value)
    {
        if (key.equals("ChosenHome") )
        {
             String val = (String) value;
            chosenHome.setText(val);

        }else 
        if (key.equals("NoChosenHome") )
        {
            String val = (String)value;
            chosenHome.setText(val);
        }

    }

    public void resetFields(ActionEvent e)
    {
        minimumPrice.clear();
        maximumPrice.clear();
        minimumArea.clear();
        maximumArea.clear();
        minimumBeds.clear();
        maximumBeds.clear();
        chosenHome.clear();
        
        
        submitButton.setDisable(false);
        findOtherButton.setDisable(true);
    }

    /**
     * Display error message
     */
    public void displayErrorMessage(String message)
    {
        statusLog.displayErrorMessage(message);
    }

    /**
     * Clear error message
     */
    public void clearErrorMessage()
    {
        statusLog.clearErrorMessage();
    }
}

