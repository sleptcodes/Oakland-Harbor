import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Boat extends Vehicle{

	private ArrayList<Dock> docks;
	private Dock destiny, ocean;
	private boolean hasCargo;

	// Constructor.
	public Boat(ArrayList<Dock> d, float xpos, float ypos){
		super(xpos, ypos);

		docks = d;
		hasCargo = true; // allows us to know when a boat's done with task
		ocean = new Dock(130, 110);

		destiny = docks.get(findDestination());
	}

	// lets pirate know if there's booty to be plundered
	public boolean plunderable(){
		return hasCargo;
	}

	// returns index of dock with least boats going to it
	private int findDestination(){
		int min = docks.get(0).queueSize;
		int d = 0;
		int len = docks.size(); 
		// attempt for better locality... java is a vm anyways tho...
		for (int i = 1; i < len; i++){
			if (docks.get(i).queueSize < min){
				min = docks.get(i).queueSize;
				d = i;
			}
		}
		docks.get(d).queueSize += 1;
		return d;
	}

	// moves boats slightly towards destination
	// once boat is done with its task, its destination becomes the sea
	// math wworks out so that boats speed is always 1 unit/tick
	// ... in any direction
	public int update(){
		int success = 0;

		float deltaX, deltaY;
		double c;
		deltaX = destiny.x - x;
		deltaY = destiny.y - y;

		// if its within root2 of the destination... its there.
		// note: thiss range must be larger than the speed of the boat
		// I believe my math makes the boat speed 1.
		// - hasCargo = false.
		// - destination dock queueSize -= 1		
		if ((deltaX > -5 && deltaX < 5) && (deltaY > -5 && deltaY < 5)){
			if (destiny == ocean){
				setAvast(true);
			}
			else {
				hasCargo = false;
				success++;
				destiny.queueSize -= 1;
				destiny = ocean;
			}
		}

		// move boat slightly towards destination... 
		// I suspect pythagorus to make an apperance... he did
		c = Math.sqrt((double)(deltaX*deltaX + deltaY*deltaY)); 

		deltaX /= c;
		deltaY /= c;

		this.x += deltaX;
		this.y += deltaY;

		return success;
	}
}
