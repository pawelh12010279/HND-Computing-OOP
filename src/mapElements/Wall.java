package mapElements;

/**
 * Class for Wall objects
 */
public class Wall extends MapElement {

    /**
     * Constructor for class Tile
     */
    public Wall() {

        String filepath = "resources/SokobanImages/Wall.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(true);

    }
}
