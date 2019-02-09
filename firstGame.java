package SimpleGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;

public class firstGame extends GamesPanel {

	int yBall;
	int xBall;
	int ySpeed;
	int xSpeed;
	int xBoard;
	int score;
	boolean start;

	public firstGame(JFrame frame) {
		super(frame);
		yBall = new Random().nextInt(50);
		xBall = new Random().nextInt(50);

		xBoard = frame.getWidth() / 2 - 60;
		ySpeed = 2;
		xSpeed = 2;
		score = 0;
		start = true;
	}

	@Override
	public void draw(Graphics g) {
		if (!start) {
			if (yBall >= 430) {
				Font font = new Font(Font.SERIF, Font.BOLD, 25);
				g.setFont(font);

				g.drawString("Game Over ", 150, 180);
				g.drawString("Press R to restart", 150, 210);
			}
			g.drawString("Score : " + score, 25, 25);
			g.fillOval(xBall, yBall, 8, 8);
			g.fillRect(xBoard, 430, 80, 10);
		} else {
			g.setFont(new Font(Font.SERIF, Font.BOLD, 40));
			g.drawString("Games in 1970", 60, 120);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 20));
			g.drawString("By M.Q", 290, 140);
			g.setFont(new Font(Font.SERIF, Font.BOLD, 40));
			g.drawString("Press any Key to start", 60, 180);
		}
	}

	public void Action() {
		if (!start) {
			if (yBall <= 430) {
				if (yBall + ySpeed <= 0)
					ySpeed *= -1;

				if (xBall + xSpeed < 0 || xBall + xSpeed >= 500)
					xSpeed *= -1;
				if (yBall >= 430 && yBall <= 430 + 10 && xBall >= xBoard && xBall <= xBoard + 80) {
					score++;
					ySpeed *= -1;
					if (score % 2 == 0) {
						ySpeed--;
						if (xSpeed < 0)
							xSpeed--;
						else
							xSpeed++;
					}
				}

				xBall += xSpeed;
				yBall += ySpeed;

				if (input.KeyIsDown(KeyEvent.VK_RIGHT))
					xBoard += 5;
				if (input.KeyIsDown(KeyEvent.VK_LEFT))
					xBoard -= 5;

			} else {
				if (input.KeyIsDown(KeyEvent.VK_R)) {
					yBall = new Random().nextInt(50);
					xBall = new Random().nextInt(50);
					ySpeed = 1;
					xSpeed = 1;
					score = 0;
				}

			}
		} else {
			if (input.anyKeyPress())
				start = false;
		}
	}

}
