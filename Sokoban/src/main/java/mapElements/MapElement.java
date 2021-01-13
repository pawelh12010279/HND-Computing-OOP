package main.java.mapElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.java.Level;

/**
 * Abstract class MapElement
 */
public abstract class MapElement extends ImageView {

    /**
     * Class variables
     */
    private boolean impassable; //to check whether keeper can move throught the objects on the map

    /**
     * Getter for impassable boolean
     *
     * @return boolean which checks if keeper can move through certain objects
     */
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    public boolean getImpassable() {
        return impassable;
    }

    /**
     * Setter for impassable bool
     *
     * @param impassable boolean which checks if keeper can pass through objects on the map (eg. walls)
     */
    public void setImpassable(boolean impassable) {
        this.impassable = impassable;
    }

    /**
     * Method used for creating map elements
     */
    public void createElement(String path) {

        setImage(new Image(path));

    }

    //TODO moveElement method here, movecrate to crate, move keeper to keeper


}
