package main.mapElements;

/**
 * Class for Diamond objects
 */
public class Diamond extends MapElement {

    /**
     * Constructor for class Tile
     */
    public Diamond() {

        String filepath = "main/resources/SokobanImages/Diamond.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(false);

    }

}
