package ie.dit;

import processing.core.*;

public class MovingThing {
	PApplet papplet;
	PVector pos;
	PVector forward;
	float w;
	float halfW;
	float theta;
	
	// You should pass the processing applet in so that we can call Processing methods 
	MovingThing(PApplet papplet)
	{
		this.papplet = papplet;
		pos = new PVector(papplet.width / 2, papplet.height / 2);
		theta = PApplet.HALF_PI;
		forward = new PVector(0, -1);
		w = 50;
		halfW = w * 0.5f;
	}
	
	public void update()
	{
		// Sin & cos are static methods on PApplet so we call them this way...  
		forward.x = PApplet.sin(theta);
		forward.y = - PApplet.cos(theta);		
		pos.add(forward);
		
		if (pos.x > papplet.width - halfW)
		{
			pos.x = papplet.width - halfW;
			theta = - PApplet.HALF_PI; 			
		}
		
		if (pos.x < halfW)
		{
			pos.x = halfW;
			theta = PApplet.HALF_PI; 			
		}		
	}
	
	public void render()
	{
		// processing methods are actually methods on the papplet
		papplet.stroke(255, 0, 0);
		papplet.pushMatrix();
		papplet.translate(pos.x, pos.y);
		papplet.rotate(theta);
		papplet.line(- halfW, halfW, 0, - halfW);
		papplet.line(0, - halfW, halfW, halfW);
		papplet.line(halfW, halfW, 0, 0);
		papplet.line(0, 0, - halfW, halfW);
		papplet.popMatrix();
		
	}
}
