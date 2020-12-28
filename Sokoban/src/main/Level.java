package main;

import mapElements.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class for handling level objects, generates levels on the board, and handles movement logic
 */

public class Level {

    /**
     * Instance variables
     */
    private ArrayList<ArrayList<MapElement>> map;
    private int numberOfMoves;
    private int numberOfDiamonds;
    private int numberOfActivatedDiamonds;
    private int[] keeperPosition;

    /**
     * Constructor which ...
     */
    public Level() {

        map = new ArrayList<>();         // Initialize map and keeper position
        keeperPosition = new int[2];

        BufferedReader reader = null;

        try {
            File level = new File("./src/resources/SokobanMaps/level1.txt");
            reader = new BufferedReader(new FileReader(level));

            String line;
            int currentKeeperPos = 0;

            while ((line = reader.readLine()) != null) { //loop throught level file to add elements to Arraylists

                ArrayList<MapElement> mapObjects = new ArrayList<>(); //Arraylist of MapElements

                for (int i = 0; i < line.length(); i++) {  //loop through each line in level text file to instantiate Map Elements

                    MapElement element = convertElement(line.charAt(i)); //instantiate elements

                    mapObjects.add(element); //Add elements to ArrayList

                    if (element instanceof WarehouseKeeper) { //if converted element is a keeper, assign its position on the map

                        keeperPosition[0] = currentKeeperPos;
                        keeperPosition[1] = i;

                    } else if (element instanceof Diamond) { //if converted element is a Diamond, increase its value to determine how many diamonds is in the level

                        numberOfDiamonds++;

                    }

                } //end for

                map.add(mapObjects); //Add Arraylist of map Elements to the map
                currentKeeperPos++;

                System.out.println(line); //print the level in the console for testing


            } // end while

        } catch (IOException e) { //catch any IO errors

            e.printStackTrace();

        } finally { //disposing off of input buffer

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    } //End constructor

    /**
     * Getter for the map 2D ArrayList (used in controller class to draw map on the board)
     *
     * @return 2D ArrayList with all elements on it
     */
    public ArrayList<ArrayList<MapElement>> getMap() {

        return map;

    }

    /**
     * Convert and instantiate map elements to their corresponding characters from the level file
     */
    private MapElement convertElement(char element) {

        switch (element) {
            case 'X':
                return new Wall();
            case '@':
                return new WarehouseKeeper();
            case '*':
                return new Crate();
            case '.':
                return new Diamond();
            default:
                return new Tile();
        }

    }

    /**
     * Getter for the gerNumberOfMoves class
     *
     * @return numberOfMoves made by the keeper
     */
    public int getNumberOfMoves() {
        return numberOfMoves;
    }

    /**
     * Check if the level has been completed
     */
    public void checkLevelCompleted() {

    }

}
