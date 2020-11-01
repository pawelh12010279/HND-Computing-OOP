package week4_medialibrary;

//import java.util.Vector;

abstract class Media {

    private String mName;
    private String mDescription;
    private String mFilePath;

    //Vector mCategories = new Vector<>();

    public Media(String name, String desc, String filepath) {

        this.mName = name;
        this.mDescription = desc;
        this.mFilePath = filepath;
        
    }
    /**
     * Getters
     */
	public String getName() {

        return mName;
        
    }

    public String getDescription() {

        return mDescription;
        
    }

    public String getFilepath() {

        return mFilePath;
        
    }

    /**
     * Setters
     */
    public void setName(String name) {
        
        this.mName = name;
    }

    public void setDescription(String desc) {

        this.mDescription = desc;
        
    }

    public void setFilepath(String filepath) {

        this.mFilePath = filepath;
        
    }

    public String toString() {

        return mName + " " + mDescription;
    }

	public abstract boolean addCategory(String category);
    
} //end class

