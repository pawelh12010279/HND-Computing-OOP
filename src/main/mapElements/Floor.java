package main.mapElements;

/**
 * Class for Tile objects
 */
public class Floor extends MapElement {

    /**
     * Constructor for class Tile
     */
    public Floor() {

        String filepath = "main/resources/SokobanImages/Floor.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(false);

    }

}
