import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import java.util.*;

public class Controls extends JPanel implements ActionListener{
	private SpawnBox spb;
	private SpawnButton sb;
	private ResetButton rb;
	private PauseButton pb;
	private PirateButton pirateButton; 
	private Bay bay;
	private Timer t;

	public Controls(Bay b){
		super(new GridLayout(2, 3));
		bay = b;

		spb = new SpawnBox(bay);
        this.add(spb);        
        sb = new SpawnButton("Spawn Boat", bay);
        this.add(sb);
        pirateButton = new PirateButton("Spawn Pirate", bay);
        this.add(pirateButton);

        pb = new PauseButton(bay);
        this.add(pb);
        rb = new ResetButton("Sink All Ships", bay);
        this.add(rb);

        t = new Timer(10, this);
        t.start();
	}

	// continuously checks if bay is empty 
	public void actionPerformed(ActionEvent e){
		if (bay.isEmpty()) rb.setEnabled(false);
		else rb.setEnabled(true);
	}
}