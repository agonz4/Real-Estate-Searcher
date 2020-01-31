/**
 * This program will allow a user to enter their criteria
 * for a house and it will read and output houses from a .txt file
 * that satisfies their criteria.
 *
 * @ Anthony Gonzalez
 * @ version October 28, 2019
 */
public class House {

    public String address;      //Address of the house object
    public int price;           //Price of the house object
    public int area;            //Area of the house object
    public int numBedrooms;     //number of bedrooms of the house object

    //------------------------------------------------------------------------------------------------------------
    /**
     * The Constructor
     * @param address
     * @param price
     * @param area
     * @param numBedrooms
     * Creates the house object
     */

    public House(String address, int price, int area, int numBedrooms) {
        this.address = address;
        this.price = price;
        this.area = area;
        this.numBedrooms = numBedrooms;
    }

    //------------------------------------------------------------------------------------------------------------
    /**
     * Satisfies method
     * @param c
     * @return boolean value true or false depending on whether
     * house satisfies the criteria entered by the user
     */
    public boolean satisfies (Criteria c){

        if ((price >= c.getMinimumPrice()) && (price <= c.getMaximumPrice()) && (area >= c.getMinimumArea()) && (area <=c.getMaximumArea()) &&
                (numBedrooms >= c.getMinimumNumberOfBedrooms()) && (numBedrooms <= c.getMaximumNumberOfBedrooms())) {
            return true;
        }
        return false;
    }

    //------------------------------------------------------------------------------------------------------------
    /** getter Methods
     * @return Instance Variables of the house object
     */

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }

    public int getArea() {
        return area;
    }

    public int getNumBedrooms() {
        return numBedrooms;
    }

    //------------------------------------------------------------------------------------------------------------
    /**
     * toString method
     * @return Concatenated String of a house object
     */

    public String toString(){
        return getAddress() + " " + getPrice()  + " " + getArea() + " "+ getNumBedrooms();
    }
}
