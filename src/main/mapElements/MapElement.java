package main.mapElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Abstract class MapElement
 */
public abstract class MapElement extends ImageView {

    /**
     * Instance variables
     */
    private boolean impassable; //to check whether keeper can move throught the objects on the map

    /**
     * Getter for impassable boolean
     *
     * @return boolean which checks if keeper can move through certain objects
     */
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

}
