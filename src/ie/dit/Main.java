package ie.dit;

// You have to import the classes you need
import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {
	
	PImage image;
	MovingThing thing;
	
	public void setup()
    {		
		// This image should be located in a folder called data inside the src folder
		// Of your project
		image = loadImage("BGE_Logo_01.png");
		thing = new MovingThing(this);
    }

	// The size call should go into a method called settings
    public void settings()
    {
    	size(530, 349);          
    }

    public void draw()
    {
    	background(0);
    	stroke(255);
    	
    	image(image, 0, 0);    	
    	thing.update();
    	thing.render();
    }

    public static void main(String[] args)
    {
        String[] a = {"MAIN"};
        PApplet.runSketch( a, new Main());
    }
}
