/**
 * Reads a file called houses.txt containing information of houses
 * and populates an ArrayList with house objects. Allows for searching
 * of houses that satisfy criteria
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Random;

public class HouseList{

    //------------------------------------------------------------------------------------------------------------
    //Create an ArrayList of House objects
    ArrayList<House> houseList = new ArrayList<House>();
    public Random randomNum;
    //------------------------------------------------------------------------------------------------------------
    /**
     * HouseList
     * @param //fileName houses.txt
     * Reads the file houses.txt and populates the arrayList with house objects
     */
    public HouseList(String fileName) {
        try {
            File inputFile = new File(fileName);
            Scanner input = new Scanner(inputFile);

            while (input.hasNext()) {
                String address = input.next();
                int price = input.nextInt();
                int area = input.nextInt();
                int numBedRooms = input.nextInt();

                House house = new House(address, price, area, numBedRooms);
                houseList.add(house);

            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File: " + " was not found");
        }

    }
    //------------------------------------------------------------------------------------------------------------
    /**
     * printHouses
     * @param c
     * Prints all the houses that satisfy the criterion c
     */
    public void printHouses(Criteria c) {
        //print all houses that satisfy criteria
        for (int i = 0; i < houseList.size(); i++) {
            if (houseList.get(i).satisfies(c)) {
                System.out.println(houseList.get(i).toString());
            }
        }
    }
    
    //------------------------------------------------------------------------------------------------------------
    /**
     * getHouses
     * @param c
     * @return concatenated String of the details of all houses that satisfy
     * criterion c
     */
    public ArrayList<House> getMatchingHouses(Criteria c) {
        ArrayList<House> matchHouses = new ArrayList<House>();
        for (int i = 0; i <= houseList.size() - 1; i++){
            House h = houseList.get(i);
            if(h.satisfies(c)== true){
                matchHouses.add(h);
            }
        }
        return matchHouses;
    }
}
