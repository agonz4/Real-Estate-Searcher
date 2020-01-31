import javafx.scene.control.TextField;

/**
 * Creates the criteria based on what the user entered
 */


public class Criteria{
     int minimumPrice;           //minimumPrice for criteria
     int maximumPrice;           //maximumPrice for criteria

     int minimumArea;            //minimumArea for criteria
     int maximumArea;            //maximumArea for crieria

     int minimumNumberOfBedrooms; //minimum number of Bedrooms for criteria
     int maximumNumberOfBedrooms; //maximum number of Bedrooms for criteria

    //------------------------------------------------------------------------------------------------------------
    /**
     *
     * @param minimumPrice
     * @param maximumPrice
     * @param minimumArea
     * @param maximumArea
     * @param minumumNumberOfBedrooms
     * @param maximumNumberOfBedrooms
     *
     * Creates Criteria Object
     */

    public Criteria(int minimumPrice, int maximumPrice, int minimumArea, int maximumArea, int minumumNumberOfBedrooms, int maximumNumberOfBedrooms) {
        this.minimumPrice = minimumPrice;
        this.maximumPrice = maximumPrice;
        this.minimumArea = minimumArea;
        this.maximumArea = maximumArea;
        this.minimumNumberOfBedrooms = minumumNumberOfBedrooms;
        this.maximumNumberOfBedrooms = maximumNumberOfBedrooms;

    }
    //------------------------------------------------------------------------------------------------------------
    /**
     * getter Methods
     * @return Instance Variables of Criteria Object
     */
    public int getMinimumPrice() {
        return minimumPrice;
    }

    public int getMaximumPrice() {
        return maximumPrice;
    }

    public int getMinimumArea() {
        return minimumArea;
    }

    public int getMaximumArea() {
        return maximumArea;
    }

    public int getMinimumNumberOfBedrooms() {
        return minimumNumberOfBedrooms;
    }

    public int getMaximumNumberOfBedrooms() {
        return maximumNumberOfBedrooms;
    }
}
