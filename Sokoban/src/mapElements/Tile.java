package mapElements;

/**
 * Class for Tile objects
 */
public class Tile extends MapElement {

    /**
     * Constructor for class Tile
     */
    public Tile() {

        String filepath = "resources/SokobanImages/Floor.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(false);

    }

}
