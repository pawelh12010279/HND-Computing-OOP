package main.mapElements;

/**
 * Class for Wall objects
 */
public class Wall extends MapElement {

    /**
     * Constructor for class Tile
     */
    public Wall() {

        String filepath = "main/resources/SokobanImages/Wall.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(true);

    }

}
