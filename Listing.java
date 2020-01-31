// system imports
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

// project imports

public class Listing
{
    // GUI Components
    private Stage       myStage;
    private View        loginView;
    private View        listingView;
    private Scene       currentScene;

    public Random randomGenerator;
    
    public HouseList houseList = new HouseList("insert houses.txt file here");
    public ArrayList <House> goodHouses = new ArrayList<House>();


    private String loginErrorMessage = "";
    private String transactionErrorMessage = "";

    //constructor for this class
    //--------------------------------------------------------
    public Listing ()
    {
        myStage = MainStageContainer.getInstance();
        createAndShowListingView();

    }

    public void processListing (Properties props)
    {
        int max = 385000;

        String intMinPrice = props.getProperty ("minPrice");
        String intMaxPrice = props.getProperty ("maxPrice");
        String intMinArea = props.getProperty ("minArea");
        String intMaxArea = props.getProperty ("maxArea");
        String intMinBed = props.getProperty ("minBed");
        String intMaxBed = props.getProperty ("maxBed");

        Integer minPrice;
        Integer maxPrice ;
        Integer minArea ;
        Integer maxArea ;
        Integer minBed ;
        Integer maxBed ;

        try { minPrice = Integer.parseInt(intMinPrice);}
        catch (NumberFormatException nfe)
        {                minPrice=0; }
        try {maxPrice = Integer.parseInt(intMaxPrice);}
        catch (NumberFormatException nfe)
        {                maxPrice=max; }
        try {minArea = Integer.parseInt(intMinArea);}
        catch (NumberFormatException nfe)
        {                minArea=0; }
        try {maxArea = Integer.parseInt(intMaxArea);}
        catch (NumberFormatException nfe)
        {                maxArea=max; }
        try {minBed = Integer.parseInt(intMinBed);}
        catch (NumberFormatException nfe)
        {                minBed=0; }
        try {maxBed = Integer.parseInt(intMaxBed);}
        catch (NumberFormatException nfe)
        {                maxBed=max; }

        Criteria c = new Criteria(minPrice, maxPrice, minArea, maxArea, minBed, maxBed);
        goodHouses = houseList.getMatchingHouses(c);
        
        if((goodHouses != null) && (goodHouses.size() > 0)){
            String randomHome = getRandomHouse();
            listingView.updateState("ChosenHome", "" + randomHome);

        }
        else
        {
            listingView.updateState("ChosenHome", "No more houses to display!");
        }

    }

    public String getRandomHouse (){
        String randomHome = "";
        if(goodHouses.size() < 1){
            listingView.updateState("NoChosenHome", "No more houses to display!");
            return "No more Houses Available";}
        else{

            int num = (int)(Math.random() * goodHouses.size()-1);
            House oneHouse = goodHouses.get(num);
            goodHouses.remove(num);
            oneHouse.getAddress();

              listingView.updateState("ChosenHome", "" + oneHouse.getAddress());

              return oneHouse.getAddress();
          }

    }
    
    public void createAndShowListingView ()
    {
        //create our new view
        listingView = new listingView(this);
        currentScene = new Scene (listingView);

        swapToView(currentScene);

    }

    public void swapToView(Scene newScene)
    {
        if (newScene == null)
        {
            System.out.println
            ("Loan.swapToView(): Missing view for display");
            return;
        }

        // SWAP THE SCENE ON THE STAGE
        myStage.setScene(newScene);
        // RE-SIZE STAGE TO FIT NEW SCENE SIZE
        myStage.sizeToScene();                  
        //Place in center again
        WindowPosition.placeCenter(myStage);

    }
}
