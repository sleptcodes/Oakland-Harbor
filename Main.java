// Mateo Hadehsian
// Homework 2
// OOP
// 25 September 2020

import javax.swing.*; 
import java.awt.*;
import java.lang.*;

public class Main extends JFrame{

    public static void main (String[] args) {
        // init Frame
        JFrame window = initWindow();
	    
        // initialize bay and begin timer
        Bay bay = new Bay();
        window.add(bay, BorderLayout.CENTER);
        bay.setSail();

        // initialize scoreboard and swing widgets
        Controls controls = new Controls(bay);
        ScoreBoard score = new ScoreBoard(bay);

        // set layout of widgets and scoreboard
        JPanel info = new JPanel(new GridLayout(2, 1));
        info.add(score);
        info.add(controls);

        window.add(info, BorderLayout.SOUTH);

        window.setVisible(true);        
    }
    
    private static JFrame initWindow(){
        // initializes widow... makes main() seem barely cleaner
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize (1000, 600);
        f.setLayout (new BorderLayout());
        return f;
    }
}