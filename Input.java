package SimpleGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Input implements KeyListener {

	private boolean[] keys;
	private boolean anyKeyPress;

	public Input(JFrame frame) {
		frame.addKeyListener(this);
		keys = new boolean[200];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		anyKeyPress = true;

	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		anyKeyPress = false;

	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean KeyIsDown(int KeyCode) {
		return keys[KeyCode];
	}

	public boolean KeyIsUp(int KeyCode) {
		return !keys[KeyCode];
	}

	public boolean anyKeyPress() {
		return anyKeyPress;
	}

}
