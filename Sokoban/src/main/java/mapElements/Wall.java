package main.java.mapElements;

/**
 * Class for Wall objects
 */
public class Wall extends MapElement {

    /**
     * Constructor for class Wall
     */
    public Wall() {

        String filepath = "main/java/resources/SokobanImages/Wall.png";

        createElement(filepath); //call inherited methods from abstract class MapElement
        setImpassable(true);

    }

}
