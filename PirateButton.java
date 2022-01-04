import javax.swing.JFrame; 
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*; 
import java.lang.*; 

public class PirateButton extends JButton implements ActionListener{
	Bay bay;

    public PirateButton(String label, Bay b) {
    	super(label);
    	bay = b;
    	addActionListener(this);
	}

	// spawn pirate
	public void actionPerformed (ActionEvent e){
		bay.spawnPirate();
	}		
}