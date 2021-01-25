import java.awt.event.KeyEvent;

public class Keybinds {
	private int upKeybind;
	private int downKeybind;
	private int leftKeybind;
	private int rightKeybind;
	
	public Keybinds() {
		upKeybind = KeyEvent.VK_UP;
		downKeybind = KeyEvent.VK_DOWN;
		leftKeybind = KeyEvent.VK_LEFT;
		rightKeybind = KeyEvent.VK_RIGHT;
	}
	public int getUpKeybind() {
		return upKeybind;
	}
	public int getDownKeybind() {
		return downKeybind;
	}
	public int getLeftKeybind() {
		return leftKeybind;
	}
	public int getRightKeybind() {
		return rightKeybind;
	}
	public void setUpKeybind(int upKeybind) {
		this.upKeybind = upKeybind;
	}
	public void setDownKeybind(int downKeybind) {
		this.downKeybind = downKeybind;
	}
	public void setLeftKeybind(int leftKeybind) {
		this.leftKeybind = leftKeybind;
	}
	public void setRightKeybind(int rightKeybind) {
		this.rightKeybind = rightKeybind;
	}
	
	
}
