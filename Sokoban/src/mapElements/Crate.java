package mapElements;

/**
 * Class for Crate objects
 */
public class Crate extends MapElement {

    /**
     * Instance variables
     */
    private MapElement replaceElement;

    /**
     * Constructor for class WarehouseKeeper
     */
    public Crate() {

        String filepath = "resources/SokobanImages/Crate.png";

        createElement(filepath); //call inherited method from abstract class MapElement
        setImpassable(true);
        replaceElement = new Tile(); //places new tile after crate is being put to the new position

    }

    public Crate(String inPlace) {

        String filepath = "resources/SokobanImages/Crate.png";

        createElement(filepath); //call inherited method from abstract class MapElement
        setImpassable(true);
        replaceElement = new Tile(); //places new tile after crate is being put to the new position

    }

    /**
     * Getter for the replaceElement variable
     *
     * @return replaceElement variable for the Crate objects
     */
    public MapElement getReplaceElement() {

        return replaceElement;

    }

    /**
     * Setter for the replaceElement variable
     *
     * @param replaceElement which places new tile after crate is being put to the new position
     */
    public void setReplaceElement(MapElement replaceElement) {

        this.replaceElement = replaceElement;

    }

}
