import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

// a pirate boat will attack any boat with cargo
public class Pirate extends Vehicle{

	private Boat target;
	private int targetId;
	private int numKills;
	// Canon canon;

	public Pirate(){
		super(600, 130);
		numKills = 0;
		//canon = new Canon();
	}


	public void update(ArrayList<Boat> boats){
		if (boats.size() == 0) return;

 		targetId = findNearestVictim(boats);
 		if (targetId == -1) return;
 		target = boats.get(targetId);

		float deltaX, deltaY;
		double c;
		deltaX = target.x - x;
		deltaY = target.y - y;

		// if its within root2 of the target... its there.
		// note: thiss range must be larger than the speed of the boat
		// I believe my math makes the boat speed 1.
		// - hasCargo = false.
		// - destination dock queueSize -= 1		
		if ((deltaX > -5 && deltaX < 5) && (deltaY > -5 && deltaY < 5)){
			target.setAvast(true);
			numKills++;
			return;
		}

		// move boat slightly towards destination... 
		// I suspect pythagorus to make an apperance... he did
		c = Math.sqrt((double)(deltaX*deltaX + deltaY*deltaY)); 

		c /= 2; // double speed (makes pirate overpowered)

		deltaX /= c;
		deltaY /= c;

		this.x += deltaX;
		this.y += deltaY;
	}

	public int numKills(){
		return numKills;
	}

	// returns the index of the closest boat with cargo
	private int findNearestVictim(ArrayList<Boat> boats){
		int nearest = -1;
		float currMin = 1000000;
		float deltaX, deltaY;
		Boat curr;

		for (int i = 0; i < boats.size(); i++){
			curr = boats.get(i);
			if (curr.plunderable()){
				deltaX = curr.x - x;
				deltaY = curr.y - y;

				if (deltaX < 0) deltaX *= -1; // set distances positive
				if (deltaY < 0) deltaY *= -1;

				if (currMin > (deltaX + deltaY)){ // update nearest
					currMin = deltaX + deltaY;
					nearest = i;
				}
			}
		}
		return nearest;
	}

}
