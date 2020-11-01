package week4_medialibrary;

//import java.util.ArrayList;

public class MediaLibrary {

    Media lib[] = new Media[4];
    //ArrayList<Media> lib = new ArrayList<Media>(4);

    public static void main(String[] args) {

        MediaLibrary library = new MediaLibrary();

        MediaLibraryTest_w4.acceptanceTest(library);

    }

    public void addMedia(Media media) {

        for (int i = 0; i < lib.length; i++) {

            if (lib[i] == media) {

                

            } else {

                lib[i] = media;

            }

        }

    }

    public void printMedia() {

        for (int i = 0; i < lib.length; i++) {

            System.out.println(lib[i].getName());
            System.out.println(lib[i].getDescription());
            System.out.println(lib[i].getFilepath());

        }

    }

    public Media findMedia(String string) {

        return null;

    }
}
