import javax.swing.JFrame; 
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*; 
import java.lang.*; 

public class SpawnBox extends JComboBox<String> implements ActionListener{
	private Bay bay;

    public SpawnBox(Bay b) {
    	super();
    	this.addItem("Spawn Pacific");
    	this.addItem("Spawn South Bay");
    	this.addItem("Spawn Valleijo");
    	bay = b;
    	addActionListener(this);
	}

	public void actionPerformed (ActionEvent e){
		// setSpawn
		float x, y;
		if (this.getSelectedItem() == "Spawn Pacific"){
			x = 130;
			y = 170;
		} else if (this.getSelectedItem() == "Spawn South Bay"){
		    x = 400;
			y = 420;
		} else {
			x = 400;
			y = 30;
		}
		bay.setSpawn(x , y);
	}		
}