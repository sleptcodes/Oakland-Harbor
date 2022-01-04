import javax.swing.JFrame; 
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*; 
import java.lang.*; 

// clears all boats off screen
public class ResetButton extends JButton implements ActionListener{
	Bay bay;
    public ResetButton(String label, Bay b) {
    	super(label);
    	bay = b;
    	addActionListener(this);
	}

	public void actionPerformed (ActionEvent e){
		bay.killBoats();
	}		
}