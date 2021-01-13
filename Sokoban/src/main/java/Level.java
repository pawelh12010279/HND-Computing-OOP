package main.java;

import main.java.mapElements.*;

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
    private final ArrayList<ArrayList<MapElement>> map; //2D grid of map elements
    private final int[] keeperPosition; //x and y axis array of positions of the warehouse keeper
    private int numberOfDiamonds; //total number of Diamonds to activate to complete the level
    private int numberOfActivatedDiamonds; //current number of activated diamonds

    /**
     * Constructor which takes no parameters loads level 1 automatically upon instatiating
     */
    public Level() {

        map = new ArrayList<>();         // Initialize map and keeper positions
        keeperPosition = new int[2];

        readLevel("./src/main/java/resources/SokobanMaps/level1.txt"); // Read level

    } //End constructor

    /**
     * Overloaded constructor which takes in a path String parameter which holds the path to the level text file
     */
    public Level(String path) {

        map = new ArrayList<>();         // Initialize map and keeper positions
        keeperPosition = new int[2];

        readLevel(path); // Read level

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
     * Method which handles file reading and map elements objects assigning and storing
     *
     * @param path path to where level text file is located
     */
    private void readLevel(String path) {

        BufferedReader reader = null;

        try {

            File level = new File(path);
            reader = new BufferedReader(new FileReader(level));

            String line;
            int xPos = 0; //x axis keeper position

            while ((line = reader.readLine()) != null) {

                ArrayList<MapElement> mapObjects = new ArrayList<>(); //Arraylist of MapElements

                for (int i = 0; i < line.length(); i++) {

                    MapElement element = readElement(line.charAt(i)); //instantiate elements

                    mapObjects.add(element); //Add elements to ArrayList

                    if (element instanceof WarehouseKeeper) { //if converted element is a keeper, assign its position on the map to the keeperPosition array

                        keeperPosition[0] = xPos;
                        keeperPosition[1] = i; //y axis keeper pos

                    } else if (element instanceof Diamond) { //if converted element is a Diamond, increase its value to determine how many diamonds is in the level

                        numberOfDiamonds++;

                    }

                } //end for

                map.add(mapObjects); //Add nested Arraylist of map Elements to the map 2D Arraylist
                xPos++; //increment xPos value alongside line reading in while loop to search for the keeper position

                System.out.println(line); //print the level in the console for testing

            } // end while

        } catch (IOException e) { //catch I/O errors

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

        System.out.println("Initial keeper position: " + Arrays.toString(keeperPosition)); //print out contents of keeperposition array for testing

    } //end readLevel

    /**
     * Read and instantiate map elements to their corresponding characters from the level file
     */
    private MapElement readElement(char element) {

        return switch (element) {

            case 'X' -> new Wall();
            case '@' -> new WarehouseKeeper();
            case '*' -> new Crate();
            case '.' -> new Diamond();
            default -> new Floor();

        };

    }

    /**
     * Method responsible for movement logic
     *
     * @param x position
     * @param y position
     */
    public void moveElement(int x, int y) {

        // move only if the destination position impassable value is not true
        if (!map.get(keeperPosition[0] + x).get(keeperPosition[1] + y).getImpassable()) {

            moveKeeper(x, y);
            System.out.println("Current keeper position: " + Arrays.toString(keeperPosition));

        // if the element next to keeper is crate and place to which crate is going to get pushed impassable value is false then move both keeper and crate
        } else if (map.get(keeperPosition[0] + x).get(keeperPosition[1] + y) instanceof Crate && !map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y).getImpassable()) {

            // if the place to which the crate is going to get pushed is an instance of the class Diamond, increment number of activated diamonds
            if (map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y) instanceof Diamond) {

                numberOfActivatedDiamonds++;
                System.out.println("Current no. of activated diamonds " +numberOfActivatedDiamonds);
            }

            moveCrate(x, y);
            moveKeeper(x, y);
            System.out.println("Current keeper position: " + Arrays.toString(keeperPosition));
        }
    } //end move

    /**
     * Method responsible for Warehouse Keeper movement on the grid
     *
     * @param x position
     * @param y position
     */
    private void moveKeeper(int x, int y) {

        MapElement nextElement = map.get(keeperPosition[0] + x).get(keeperPosition[1] + y);

        // Set the new position for the keeper
        map.get(keeperPosition[0] + x).set(keeperPosition[1] + y, map.get(keeperPosition[0]).get(keeperPosition[1]));

        // Move from the initial position leaving default replaceElement set in the constructor
        map.get(keeperPosition[0]).set(keeperPosition[1], ((WarehouseKeeper) map.get(keeperPosition[0]).get(keeperPosition[1])).getReplaceElement());

        // Translate keeper to the new position
        keeperPosition[0] = x + keeperPosition[0];
        keeperPosition[1] = y + keeperPosition[1];

        // Assign a new element to the place from which keeper just moved
        ((WarehouseKeeper) map.get(keeperPosition[0]).get(keeperPosition[1])).setReplaceElement(nextElement);
    }

    /**
     * Method responsible for the movements of the objects of the class Crate
     *
     * @param x position
     * @param y position
     */
    private void moveCrate(int x, int y) {

        MapElement nextElement = map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y);

        // Set the new position for the Crate
        map.get(keeperPosition[0] + 2 * x).set(keeperPosition[1] + 2 * y, map.get(keeperPosition[0] + x).get(keeperPosition[1] + y));
        // Place an empty floor tile to the place from which crate has been pushed
        map.get(keeperPosition[0] + x).set(keeperPosition[1] + y, ((Crate) map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y)).getReplaceElement());

        // if crate is being pushed back from the diamond, decrement the numberOfActivatedDiamonds value
        if (((Crate) map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y)).getReplaceElement() instanceof Diamond) {

            numberOfActivatedDiamonds--;
            System.out.println("Current no. of activated diamonds " +numberOfActivatedDiamonds);
        }

        // Assign a new element to the place from which crate has just been moved
        ((Crate) map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y)).setReplaceElement(nextElement);

    }

    /**
     * Check if the level has been completed, it is when number of diamonds on the current level is equal to the diamonds activated by pushing crates
     */
    public boolean checkLevelCompleted() {

        return numberOfActivatedDiamonds == numberOfDiamonds;

    }
}