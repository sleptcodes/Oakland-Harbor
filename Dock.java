// literally just data. no methods needed
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;

// Dock remembers how many boats are going to it
public class Dock{
	public int queueSize;
	public float x, y;

	public Dock(float xpos, float ypos){
		x = xpos;
		y = ypos;
		queueSize = 0;
	}

	public void draw(Graphics g){
		g.drawRect((int)x, (int)y, 20, 10);
	}
}