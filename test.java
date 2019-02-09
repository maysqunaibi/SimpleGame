package SimpleGame;

import javax.swing.JFrame;

public class test {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Test Game ");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		 firstGame game = new firstGame(frame);
		 
		 frame.add(game);
		 
		frame.setVisible(true);
	}

}
