package main.java.mapElements;

/**
 * Class for Floor objects
 */
public class Floor extends MapElement {

    /**
     * Constructor for class Floor
     */
    public Floor() {

        String filepath = "main/java/resources/SokobanImages/Floor.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(false);

    }

}
