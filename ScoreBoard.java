import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class ScoreBoard extends JPanel implements ActionListener{

	private Bay bay;
	private Timer t;

	JLabel pirate, boats;

	public ScoreBoard(Bay b){
		super(new GridLayout(1, 2));
		bay = b;

		pirate = new JLabel();
		boats = new JLabel();

		this.add(boats);
		this.add(pirate);

        t = new Timer(10, this);
        t.start();
	}
	public void actionPerformed(ActionEvent e){
		printScore();
	}

	// prints score
	private void printScore(){
		boats.setText("Successful Deliveries: " + bay.numDrops());
		pirate.setText("Booty Plundered: " + bay.pirateKills());
	}
}