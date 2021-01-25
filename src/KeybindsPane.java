import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class KeybindsPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
	// all of the GraphicsProgram calls

	private GButton back;

	//initializing buttons for key remapping
	private GButton changeUpKeybind;
	private GButton changeDownKeybind;
	private GButton changeLeftKeybind;
	private GButton changeRightKeybind;

	//labels for keybinds 
	private GLabel currentUpKeybind;
	private GLabel currentDownKeybind;
	private GLabel currentLeftKeybind;
	private GLabel currentRightKeybind;

	//labels that change depending on what they current keybind has been changed to. 
	private GLabel upKeybind;
	private GLabel downKeybind;
	private GLabel leftKeybind;
	private GLabel rightKeybind;

	//records int value of keyboard presses
	public int keyPress;
	
	private Keybinds keybinds;




	public KeybindsPane(MainApplication app) {
		this.program = app;

		keybinds = program.getKeybinds();

		back = new GButton("Back", 280,500,200,50);
		changeUpKeybind = new GButton("Change Up Keybind", 480,100,200,50);
		changeDownKeybind = new GButton("Change Down Keybind", 480,150,200,50);
		changeLeftKeybind = new GButton("Change Left Keybind", 480,200,200,50);
		changeRightKeybind = new GButton("Change Right Keybind", 480,250,200,50);

		currentUpKeybind = new GLabel("Current Up Keybind",80, 125);
		currentDownKeybind = new GLabel("Current Down Keybind",80, 175);
		currentLeftKeybind = new GLabel("Current Left Keybind",80, 225);
		currentRightKeybind = new GLabel("Current Right Keybind",80, 275);

		//default initialize labels
		upKeybind = new GLabel(KeyEvent.getKeyText(keybinds.getUpKeybind()),280, 125);
		downKeybind = new GLabel(KeyEvent.getKeyText(keybinds.getDownKeybind()),280, 175);
		leftKeybind = new GLabel(KeyEvent.getKeyText(keybinds.getLeftKeybind()),280, 225);
		rightKeybind = new GLabel(KeyEvent.getKeyText(keybinds.getRightKeybind()),280, 275);
		
		

	}

	@Override
	public void showContents() {
		program.add(back);

		program.add(changeUpKeybind);
		program.add(changeDownKeybind);
		program.add(changeLeftKeybind);
		program.add(changeRightKeybind);

		program.add(currentUpKeybind);
		program.add(currentDownKeybind);
		program.add(currentLeftKeybind);
		program.add(currentRightKeybind);

		program.add(upKeybind);
		program.add(downKeybind);
		program.add(leftKeybind);
		program.add(rightKeybind);
	}

	@Override
	public void hideContents() {
		program.removeAll();
		program.remove(back);

		program.remove(changeUpKeybind);
		program.remove(changeDownKeybind);
		program.remove(changeLeftKeybind);
		program.remove(changeRightKeybind);

		program.remove(currentUpKeybind);
		program.remove(currentDownKeybind);
		program.remove(currentLeftKeybind);
		program.remove(currentRightKeybind);

		program.remove(upKeybind);
		program.remove(downKeybind);
		program.remove(leftKeybind);
		program.remove(rightKeybind);
	}

	//on mouse event actions.... 
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			program.switchToSettings();
			//back button takes you back to settings panel
		}
		//if change up keybind has been pressed
		if(obj == changeUpKeybind) {
			//needs to wait for a keypress
			keybinds.setUpKeybind(keyPress);
			//change keybind to new key
			upKeybind.setLabel(KeyEvent.getKeyText(keybinds.getUpKeybind()));
			//update label indicating what it's been changed to. 
			
		}
		//if change down keybind has been pressed
		if(obj == changeDownKeybind) {
			keybinds.setDownKeybind(keyPress);
			//change keybind to new key
			downKeybind.setLabel(KeyEvent.getKeyText(keybinds.getDownKeybind()));
			//update label indicating what it's been changed to. 

		}
		//if change left keybind has been pressed

		if(obj == changeLeftKeybind) {
			keybinds.setLeftKeybind(keyPress);
			leftKeybind.setLabel(KeyEvent.getKeyText(keybinds.getLeftKeybind()));


		}
		//if change right keybind has been pressed
		if(obj == changeRightKeybind) {
			keybinds.setRightKeybind(keyPress);
			//change keybind to new key
			rightKeybind.setLabel(KeyEvent.getKeyText(keybinds.getRightKeybind()));
			//update label indicating what it's been changed to. 


		}

	}
	//on keyboard event actions... 
	@Override
	public void keyPressed(KeyEvent e) {
		keyPress = e.getKeyCode();
	}

}