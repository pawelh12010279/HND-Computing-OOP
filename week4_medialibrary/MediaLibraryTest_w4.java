package week4_medialibrary;

/**
 * A class to test the MediaLibrary
 */
public class MediaLibraryTest_w4 {
	/**
	 * A set of acceptance tests for MediaLibrary.
	 */
	static public void acceptanceTest(MediaLibrary library){
		System.out.println("*******************");
		System.out.println("Insert Media test.");
		// create some clearly defined test data, we can see quickly if it is in order when outputted
		library.addMedia(new AudioMedia("Explosion", "A short explosion sound.", "res/explosion.wav"));
		library.addMedia(new AudioMedia("Future Legend", "David Bowie, Future Legend.", "res/davidbowie_futurelegend.wav"));
		library.addMedia(new ImageMedia("Landscape", "A very pretty landscape, with a tree.", "res/a_landscape.png"));
		library.addMedia(new ImageMedia("Abstract", "Priceless.", "res/an_abstract.png"));
		library.addMedia(new ImageMedia("Portrait", "A business bloke.", "res/a_portrait.png"));
		
		// test if the media is in library and in sorted order by printing
		library.printMedia();
		System.out.println("*******************");

		System.out.println("*******************");
		System.out.println("Search library test.");
		Media searchResult = library.findMedia("Landscape");
		if(searchResult != null){
			System.out.println("Success : Landscape found");
			if(searchResult.addCategory("Landscape")){
				System.out.println("Success : Added category Landscape");
			}else{
				System.out.println("Fail : Landscape category not added.");
			}
			if(searchResult.addCategory("FX")){
				System.out.println("Fail : Added category FX");
			}else{
				System.out.println("Success : FX category not added.");
			}
		}else{
			System.out.println("Fail : Landscape not found");
		}
		
		searchResult = library.findMedia("Abstract");
		if(searchResult != null){
			System.out.println("Success : Abstract found");
			if(searchResult.addCategory("Abstract")){
				System.out.println("Success : Added category Abstract");
			}else{
				System.out.println("Fail : Abstract category not added.");
			}
			if(searchResult.addCategory("FX")){
				System.out.println("Fail : Added category FX");
			}else{
				System.out.println("Success : FX category not added.");
			}
		}else{
			System.out.println("Fail : Landscape not found");
		}
		
		searchResult = library.findMedia("Portrait");
		if(searchResult != null){
			System.out.println("Success : Portrait found");
			if(searchResult.addCategory("Portrait")){
				System.out.println("Success : Added category Portrait");
			}else{
				System.out.println("Fail : Portrait category not added.");
			}
			if(searchResult.addCategory("FX")){
				System.out.println("Fail : Added category FX");
			}else{
				System.out.println("Success : FX category not added.");
			}
		}else{
			System.out.println("Fail : Landscape not found");
		}
		
		searchResult = library.findMedia("AnotherLandscape");
		if(searchResult != null){
			System.out.println("Fail : AnotherLandscape found");
			System.out.println(searchResult);
		}else{
			System.out.println("Success : AnotherLandscape not found");
		}
		
		

		searchResult = library.findMedia("Future Legend");
		if(searchResult != null){
			System.out.println("Success : Future Legend found");
			if(searchResult.addCategory("Music")){
				System.out.println("Success : Added category Music");
			}else{
				System.out.println("Fail : Music category not added.");
			}
			if(searchResult.addCategory("Portrait")){
				System.out.println("Fail : Added category Portrait");
			}else{
				System.out.println("Success : Portrait category not added.");
			}
		}else{
			System.out.println("Fail : Future Legend not found");
		}
		
		searchResult = library.findMedia("Explosion");
		if(searchResult != null){
			System.out.println("Success : Explosion found");
			if(searchResult.addCategory("FX")){
				System.out.println("Success : Added category FX");
			}else{
				System.out.println("Fail : FX category not added.");
			}
			if(searchResult.addCategory("Portrait")){
				System.out.println("Fail : Added category Portrait");
			}else{
				System.out.println("Success : Portrait category not added.");
			}
		}else{
			System.out.println("Fail : Explosion not found");
		}
		
		searchResult = library.findMedia("DifferentSound");
		if(searchResult != null){
			System.out.println("Fail : DifferentSound found");
			System.out.println(searchResult);
		}else{
			System.out.println("Success : DifferentSound not found");
		}
		System.out.println("*******************");
	}
}
