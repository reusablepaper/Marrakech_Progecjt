package marrakech;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Setting extends JFrame {

	private Color p1color = Color.RED;
	private Color p2color = Color.ORANGE;
	private Color p3color = Color.YELLOW;
	private Color p4color = Color.BLUE;
	private int delay = 200;
	private boolean bgmOn = true;

	Setting() {
		int x = 320;
		int y = 260;
		int temp=0;
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 3; i++) {
				Button_n_Label.setcolors[temp] = new JTextField(3);
				Button_n_Label.setcolors[temp].setBounds(x, y, 80, 30);
				y+=40;
				temp++;
			}
			x+=100;
			y=260;
		}

	}

	public void screenDraw(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 24));
		g.setColor(Color.BLACK);
		g.drawString("Carpet Color", 150, 280);
		g.drawString("Background Music", 150, 450);
		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.drawString("1P Color", 330, 250);
		g.drawString("2P Color", 430, 250);
		g.drawString("3P Color", 530, 250);
		g.drawString("4P Color", 630, 250);
		g.drawString("R", 305, 280);
		g.drawString("G", 305, 320);
		g.drawString("B", 305, 360);
		g.fillRect(100, 380, 700, 24);
		g.setFont(new Font("Century Gothic", Font.BOLD, 15));
		g.setColor(Color.WHITE);
		g.drawString("If you want basic color, Enter nothing. And please fill the fields with a number from 0 to 255.", 115,400);

	}

	public Color getP1color() {
		return p1color;
	}

	public void setP1color(Color p1color) {
		this.p1color = p1color;
	}

	public Color getP2color() {
		return p2color;
	}

	public void setP2color(Color p2color) {
		this.p2color = p2color;
	}

	public Color getP3color() {
		return p3color;
	}

	public void setP3color(Color p3color) {
		this.p3color = p3color;
	}

	public Color getP4color() {
		return p4color;
	}

	public void setP4color(Color p4color) {
		this.p4color = p4color;
	}

	public boolean getbgmOn() {
		return bgmOn;
	}

	public void setbgmOn(boolean bgmOn) {
		this.bgmOn = bgmOn;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	public Color getPlayerColor(int player) {
		if (player==1)
			return p1color;
		else if (player==2)
			return p2color;
		else if (player ==3)
			return p3color;
		else if (player==4)
			return p4color;
		else return Color.BLACK;//사실상 쓸일 없음
	}
}
