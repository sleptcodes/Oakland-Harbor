// Mateo Hadehsian
// Homework 3
// OOP

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.*;
import javax.imageio.*;
import java.lang.Object;
import javax.swing.*;
import javax.swing.Timer;

public class Bay extends JPanel implements ActionListener, MouseListener{
	// private JButton reset, spawnBoat; 
	// These buttons will ultimately become their own classes
	// and implement their own actionlistening and function

	//this class will ultimately contain port or dock objects

    private float offsetX, offsetY, scaler;
    // as stated in README, not fully implemented/used to potential

    private final int MAX_HEIGHT = 382;
    private final int MAX_WIDTH = 680;

	private Data data; // model 
    
    private Timer timer;
	private ImageIcon background; // backround image

	public Bay(){
		super();
        addMouseListener(this);

		data = new Data();
        timer = new Timer(10, this);

        // setup background for easy drawing
		ImageIcon temp = new ImageIcon("background.png");
        background = new ImageIcon(temp.getImage().
                getScaledInstance(MAX_WIDTH, MAX_HEIGHT, Image.SCALE_SMOOTH)); 	


        // zoom/pan variable initialization
        offsetX = 0;
        offsetY = 0;
        scaler = 1;	
	}

    // start timer
    public void setSail(){
        this.timer.start();
    }

    // simply draws bay
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBay(g);
        drawData(data, g);        
    }

    private void drawBay(Graphics g){
    	background.paintIcon(this, g, 150, 50);
    }

    private void drawData(Data data, Graphics g){
        data.drawData(this, g);
    }

    // allows controls to setSpaw
    public void setSpawn(float x, float y){
        data.setSpawn(x, y);
    }

    // allows controls to spawnBoat
    public void spawnBoat(){ 
    	data.spawnBoat();
    }

    // allows controls to spawnPirate
    public void spawnPirate(){
        data.spawnPirate();
    }

    // allows controls to kill all boats
    public void killBoats(){
        data.killBoats();
    }

    // timer tick action performed
    public void actionPerformed(ActionEvent e) {
        data.update();
        repaint();
    }

    // lets controls know if bay is empty
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // returns true if paused, false if not
    // toggles timer 
    public boolean toggleTimer(){
        if (timer.isRunning()){
            timer.stop();
            return true;
        } else {
            timer.start();
            return false;
        }
    }

    // lets scoreboard know how much booty be plundered yarg
    public int pirateKills(){
        return data.pirateKills();
    }

    // lets scoreboard know numDropoffs
    public int numDrops(){
        return data.numDrops();
    }

    // translates screen locations to world locations and signals that a click
    // ocurred to the model.
    public void mouseClicked(MouseEvent e){
        Point click = e.getLocationOnScreen();

        click = screenToWorld(click);

        data.mouseClicked(click);
        return;
    }

///////////////////////// panning/zooming section

    // takes a point in screen space and 
    // returns its corresponding point in world spance
    private Point screenToWorld(Point p){
        p.x = (int)((p.x - offsetX) * scaler);
        p.y = (int)((p.y - offsetY) * scaler);
        return p;
    }

    // takes a point in world space and 
    // returns its corresponding point in screen spance
    private Point worldToScreen(Point p){
        p.x = (int)((float)(p.x / scaler) + offsetX);       
        p.y = (int)((float)(p.y / scaler) + offsetY);
        return p;
    }

    /////////////////////////////////////////
    //unnecessary overrides

    public void mouseEntered(MouseEvent e){
        return;
    }

    public void mouseExited(MouseEvent e){
        return;
    }

    // would implement panning with this probably.
    public void mousePressed(MouseEvent e){
        return;
    }

    public void mouseReleased(MouseEvent e){
        return;
    }
}