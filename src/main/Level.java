package main;

import main.mapElements.*;

import java.io.*;
import java.util.ArrayList;

/**
 * Class for handling level objects, generates levels on the board, and handles movement logic
 */

public class Level {

    /**
     * Instance variables
     */
    private ArrayList<ArrayList<MapElement>> map; //2D grid of map elements
    private int[] keeperPosition;
    private int numberOfDiamonds;
    private int numberOfActivatedDiamonds;

    /**
     * Constructor which reads the level layout from the level text file and adds map elements to the ArrayLists
     */
    public Level(String levelpath) {

        map = new ArrayList<>();         // Initialize map and keeper position
        keeperPosition = new int[2];

        BufferedReader reader = null;

        try {

            //File level = new File("./src/main/resources/SokobanMaps/level1.txt");
            File level = new File(levelpath);
            reader = new BufferedReader(new FileReader(level));

            String line;
            int centerPos = 0; //x axis keeper position

            while ((line = reader.readLine()) != null) { //loop throught level file to add elements to Arraylists

                ArrayList<MapElement> mapObjects = new ArrayList<>(); //Arraylist of MapElements

                for (int i = 0; i < line.length(); i++) {  //loop through each line in level text file to instantiate Map Elements

                    MapElement element = readElement(line.charAt(i)); //instantiate elements

                    mapObjects.add(element); //Add elements to ArrayList

                    if (element instanceof WarehouseKeeper) { //if converted element is a keeper, assign its position on the map to the keeperPosition array

                        keeperPosition[0] = centerPos;
                        keeperPosition[1] = i; //y axis keeper pos

                    } else if (element instanceof Diamond) { //if converted element is a Diamond, increase its value to determine how many diamonds is in the level

                        numberOfDiamonds++;

                    }

                } //end for

                map.add(mapObjects); //Add Arraylist of map Elements to the map 2D Arraylist
                centerPos++;

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
    public void move(int x, int y) {

        if (!map.get(keeperPosition[0] + x).get(keeperPosition[1] + y).getImpassable()) {

            moveKeeper(x, y);

        } else if (map.get(keeperPosition[0] + x).get(keeperPosition[1] + y) instanceof Crate && !map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y).getImpassable()) {

            if (map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y) instanceof Diamond) {

                numberOfActivatedDiamonds++;

            }

            moveCrate(x, y);
            moveKeeper(x, y);

        }
    } //end move

    private void moveKeeper(int x, int y) {

        MapElement nextTile;

        if (map.get(keeperPosition[0] + x).get(keeperPosition[1] + y).getImpassable()) {

            nextTile = new Floor();

        } else {

            nextTile = map.get(keeperPosition[0] + x).get(keeperPosition[1] + y);

        }

        map.get(keeperPosition[0] + x).set(keeperPosition[1] + y, map.get(keeperPosition[0]).get(keeperPosition[1]));
        map.get(keeperPosition[0]).set(keeperPosition[1], ((WarehouseKeeper) map.get(keeperPosition[0]).get(keeperPosition[1])).getReplaceElement());

        keeperPosition[0] += x;
        keeperPosition[1] += y;

        ((WarehouseKeeper) map.get(keeperPosition[0]).get(keeperPosition[1])).setReplaceElement(nextTile);
    }

    private void moveCrate(int x, int y) {

        MapElement nextTile;

        if (map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y).getImpassable()) {

            nextTile = new Floor();

        } else {

            nextTile = map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y);

        }

        map.get(keeperPosition[0] + 2 * x).set(keeperPosition[1] + 2 * y, map.get(keeperPosition[0] + x).get(keeperPosition[1] + y));
        map.get(keeperPosition[0] + x).set(keeperPosition[1] + y, ((Crate) map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y)).getReplaceElement());

        if (((Crate) map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y)).getReplaceElement() instanceof Diamond) {
            numberOfActivatedDiamonds--;
        }

        ((Crate) map.get(keeperPosition[0] + 2 * x).get(keeperPosition[1] + 2 * y)).setReplaceElement(nextTile);

    }

    /**
     * Getter for the map 2D ArrayList (used in controller class to draw map on the board)
     *
     * @return 2D ArrayList with all elements on it
     */
    public ArrayList<ArrayList<MapElement>> getMap() {

        return map;

    }

    /**
     * Check if the level has been completed
     */
    public boolean checkLevelCompleted() {

        return numberOfActivatedDiamonds == numberOfDiamonds;
    }
}
