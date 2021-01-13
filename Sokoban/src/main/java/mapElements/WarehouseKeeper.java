package main.java.mapElements;

/**
 * Class for WarehouseKeeper object
 */
public class WarehouseKeeper extends MapElement {

    /**
     * Instance variables
     */
    private MapElement replaceElement;

    /**
     * Constructor for class WarehouseKeeper
     */
    public WarehouseKeeper() {

        String filepath = "main/java/resources/SokobanImages/WarehouseKeeper.png";

        createElement(filepath); //call inherited method from abstract class MapElement
        setImpassable(true);
        replaceElement = new Floor(); //places new tile after warehouse keeper moves to the new position

    }

    /**
     * Getter for the replaceElement variable
     *
     * @return replaceElement variable for the Warehousekeeper
     */
    public MapElement getReplaceElement() {

        return replaceElement;

    }

    /**
     * Setter for the replaceElement variable
     *
     * @param replaceElement which places new tile after warehouse keeper moves to the new position
     */
    public void setReplaceElement(MapElement replaceElement) {

        this.replaceElement = replaceElement;

    }
}
