import javax.swing.JFrame; 
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*; 
import java.lang.*; 

// A buttton that spawns a boat at the current spawn location
public class SpawnButton extends JButton implements ActionListener{
	Bay bay;
    public SpawnButton(String label, Bay b) {
    	super(label);
    	bay = b;
    	addActionListener(this);
	}

	public void actionPerformed (ActionEvent e){
		bay.spawnBoat();
	}		
}