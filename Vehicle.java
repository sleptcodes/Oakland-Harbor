import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public abstract class Vehicle{
	public float x, y;

	private boolean avast, clicked;
	private ImageIcon boatIcon, clown; // images

	public Vehicle(float xpos, float ypos){
		x = xpos; // 
		y = ypos; // spawn point

		avast = false; // true when boat is dead/off to sea


		ImageIcon temp = new ImageIcon("boat.png");
		boatIcon = new ImageIcon(temp.getImage().
				getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		temp = new ImageIcon("clown.png");
		clown = new ImageIcon(temp.getImage().
				getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	}

	// drawws icon at currPos
	public void draw(Bay b, Graphics g){
		if (clicked) {
			boatIcon = clown;
		}
		boatIcon.paintIcon(b, g, (int)x, (int)y);
	}

	// lets data know if boat should be removed
	public boolean isAvast(){
		return avast;
	}

	// allows data/pirate to kill boats
	public void setAvast(boolean b){
		avast = b;
	}

	// checks if mouseclick is on the vehicle and changes the image if so.
	public void mouseClicked(Point p){
		float deltaX, deltaY;
		deltaX = p.x - this.x; // minus 50 for offset
		deltaY = p.y - this.y - 50;

		if ((deltaX > -5 && deltaX < 25) && (deltaY > -5 && deltaY < 25)){
			this.clicked = true;
		} else this.clicked = false;
	}
}
