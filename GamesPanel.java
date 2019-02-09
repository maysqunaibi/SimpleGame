package SimpleGame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public abstract class GamesPanel extends JPanel {
	protected Input input;
	protected Timer timer;

	public GamesPanel(JFrame frame) {
		input = new Input(frame);
		
		
		timer = new Timer(20, null);
		timer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Action();
				repaint();
			}
		});
		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public abstract void draw(Graphics g);

	public abstract void Action();
}
