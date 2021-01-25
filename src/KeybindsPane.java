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

	private GButton changeUpKeybind;
	private GButton changeDownKeybind;
	private GButton changeLeftKeybind;
	private GButton changeRightKeybind;

	private GLabel currentUpKeybind;
	private GLabel currentDownKeybind;
	private GLabel currentLeftKeybind;
	private GLabel currentRightKeybind;

	private GLabel upKeybind;
	private GLabel downKeybind;
	private GLabel leftKeybind;
	private GLabel rightKeybind;

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

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == back) {
			program.switchToSettings();
		}
		
		if(obj == changeUpKeybind) {
			//needs to wait for a keypress
			keybinds.setUpKeybind(keyPress);
			upKeybind.setLabel(KeyEvent.getKeyText(keybinds.getUpKeybind()));
			
		}
		if(obj == changeDownKeybind) {
			keybinds.setDownKeybind(keyPress);
			downKeybind.setLabel(KeyEvent.getKeyText(keybinds.getDownKeybind()));


		}
		if(obj == changeLeftKeybind) {
			keybinds.setLeftKeybind(keyPress);
			leftKeybind.setLabel(KeyEvent.getKeyText(keybinds.getLeftKeybind()));


		}
		if(obj == changeRightKeybind) {
			keybinds.setRightKeybind(keyPress);
			rightKeybind.setLabel(KeyEvent.getKeyText(keybinds.getRightKeybind()));

		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		keyPress = e.getKeyCode();
	}

}