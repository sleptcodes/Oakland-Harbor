import javax.swing.JFrame; 
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*; 
import java.lang.*; 

public class PauseButton extends JButton implements ActionListener{
	private Bay bay;
    public PauseButton(Bay b) {
    	super("Pause");
    	bay = b;
    	addActionListener(this);
	}

	// toggles timer and checks its state to make label correct
	public void actionPerformed (ActionEvent e){
		// toggle timer, switch label
		if (bay.toggleTimer()){
			this.setText("Resume");
		} else {
			this.setText("Pause");
		}
	}		
}