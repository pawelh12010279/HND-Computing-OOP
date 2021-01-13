package main.java.mapElements;

/**
 * Class for Diamond objects
 */
public class Diamond extends MapElement {

    /**
     * Constructor for class Diamond
     */
    public Diamond() {

        String filepath = "main/java/resources/SokobanImages/Diamond.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(false);

    }

}
