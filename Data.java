import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Data{
	// all boats currently in world
	private ArrayList<Boat> boats;
	// all docks
	private ArrayList<Dock> docks;

	// Ye most horrible night terror
	private Pirate pirate;

	// number of booty plunndered/cargo dropped
	private int drops, pirateKills;
	private float xpos, ypos; // boat spawn point

	public Data(){
		pirate = null;
		drops = 0;
		pirateKills = 0;

		xpos = 130;
		ypos = 170;

		docks = new ArrayList<Dock>();
		// manually construct and add all final docks here

		// Bushrod
		docks.add(new Dock(600, 130));
		docks.add(new Dock(620, 130));

		// Jack London
		docks.add(new Dock(590, 200));
		docks.add(new Dock(610, 200));
		docks.add(new Dock(630, 200));

		// Alameda
		docks.add(new Dock(590, 220));
		docks.add(new Dock(570, 220));
		docks.add(new Dock(575, 260));
		docks.add(new Dock(555, 260));
		docks.add(new Dock(610, 350));
		docks.add(new Dock(630, 350));

		// Berkeley
		docks.add(new Dock(660, 70));
		docks.add(new Dock(640, 70));


		boats = new ArrayList<Boat>();
	}

	// getter
	public int numDrops(){
		return drops;
	}

	// getter
	public int pirateKills(){
		return pirateKills;
	}

	// lets bay know if there are any boats
	public boolean isEmpty(){
		if (boats.size() == 0 && pirate == null) return true;
		else return false;
	}

	// setter
	public void setSpawn(float x, float y){
		xpos = x;
		ypos = y;
	}

	// insert boat
	public void spawnBoat(){
		boats.add(new Boat(docks, xpos, ypos));
	}

	// insert anarchy
	public void spawnPirate(){
		if (pirate == null) pirate = new Pirate();
	}

	// updates all vehicles
	public void update(){
		if (isEmpty()) return;

		if (pirate != null){
			pirate.update(boats);
			pirateKills = pirate.numKills();
		}

		Boat curr;

		for (int i = 0; i < boats.size(); i++){
			curr = boats.get(i);

			if (curr != null){
				if (curr.isAvast()){
					boats.remove(i);
				}
				else drops += curr.update();
			}
		}
	}

	// kills all
	public void killBoats(){
		pirate = null;
		boats.clear();
	}

	// draws all objects
	public void drawData(Bay b, Graphics g){
		if (pirate != null) pirate.draw(b, g);

		int len = docks.size();
    	for (int i = 0; i < len; i++){
    		docks.get(i).draw(g);
    	}

    	// draw boats here
    	len = boats.size();
    	for (int j = 0; j < len; j++){
    		boats.get(j).draw(b, g);
    	}
	}

	// tells all objects that mouse wwas clicked
	public void mouseClicked(Point click){		
		if (pirate != null) pirate.mouseClicked(click);
		for (int i = 0; i < boats.size(); i++){
			boats.get(i).mouseClicked(click);
		}
	}
}