package marrakech;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

public class Game {
	public static boolean gameEnd = false;

	int playerNum;
	int comNum;
	int diceNums[] = { 1, 2, 2, 3, 3, 4 };
	int diceNum;
	public static int nowplay = 1;
	int assamlocate = 24;
	Font font_s = new Font("배달의민족 주아", Font.PLAIN, 15);
	Font font_d = new Font("배달의민족 주아", Font.PLAIN, 24);
	Setting set;
	Carpet carpet;
	String stateString;
	String nowdirection = "up";

	public Game(int playerNum, int comNum, Setting set) {
		this.playerNum = playerNum;
		this.comNum = comNum;
		this.set = set;
		int garo = 65, sero = 115, temp = 0;
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 7; i++) {
				JButton tempblock = new JButton(Images.blockNormal);
				tempblock.setBackground(new Color(159, 218, 255));
				tempblock.setBounds(garo, sero, 70, 70);
				tempblock.setBorderPainted(false);// 버튼의 외곽선
				tempblock.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
				Button_n_Label.blocks[temp] = tempblock;

				garo += 70;
				temp++;

			}
			garo = 65;
			sero += 70;
		}

		Button_n_Label.blocks[assamlocate].setIcon(Images.assamUp);

		JLabel p1Money = new JLabel();
		JLabel p2Money = new JLabel();
		JLabel p3Money = new JLabel();
		JLabel p4Money = new JLabel();
		JLabel p1Carpet = new JLabel();
		JLabel p2Carpet = new JLabel();
		JLabel p3Carpet = new JLabel();
		JLabel p4Carpet = new JLabel();
		p1Money.setFont(font_s);
		p1Money.setBounds(700, 153, 40, 20);
		p1Money.setText("30");
		p2Money.setFont(font_s);
		p2Money.setBounds(700, 223, 40, 20);
		p2Money.setText("30");
		;
		p3Money.setFont(font_s);
		p3Money.setBounds(700, 293, 40, 20);
		p3Money.setText("30");
		p4Money.setFont(font_s);
		p4Money.setBounds(700, 363, 40, 20);
		p4Money.setText("30");
		p1Carpet.setFont(font_s);
		p1Carpet.setBounds(790, 130, 40, 20);
		p2Carpet.setFont(font_s);
		p2Carpet.setBounds(790, 200, 40, 20);
		p3Carpet.setFont(font_s);
		p3Carpet.setBounds(790, 270, 40, 20);
		p4Carpet.setFont(font_s);
		p4Carpet.setBounds(790, 340, 40, 20);
		p1Carpet.setText("12");
		p2Carpet.setText("12");
		p3Carpet.setText("12");
		p4Carpet.setText("12");
		if (playerNum + comNum == 2) {

			p2Carpet.setBounds(790, 153, 40, 20);
			p3Carpet.setBounds(790, 200, 40, 20);
			p4Carpet.setBounds(790, 223, 40, 20);

			p3Money.setVisible(false);
			p4Money.setVisible(false);

		} else if (playerNum + comNum == 3) {
			p1Carpet.setText("15");
			p2Carpet.setText("15");
			p3Carpet.setText("15");

			p4Money.setVisible(false);
			p4Carpet.setVisible(false);
		}
		Button_n_Label.gameButtons[0] = new JButton();
		Button_n_Label.gameButtons[1] = new JButton();
		Button_n_Label.gameButtons[2] = new JButton();
		Button_n_Label.gameButtons[3] = new JButton();
		Button_n_Label.gameButtons[4] = new JButton();
		Button_n_Label.gameLabels[0] = new JLabel();
		Button_n_Label.gameLabels[1] = p1Money;
		Button_n_Label.gameLabels[2] = p2Money;
		Button_n_Label.gameLabels[3] = p3Money;
		Button_n_Label.gameLabels[4] = p4Money;
		Button_n_Label.gameLabels[5] = p1Carpet;
		Button_n_Label.gameLabels[6] = p2Carpet;
		Button_n_Label.gameLabels[7] = p3Carpet;
		Button_n_Label.gameLabels[8] = p4Carpet;
		stateString = "<html>플레이어" + nowplay + "의 차례입니다.<br/><br/>방향을 정해주세요.<html>";
		
		start();
	}

	public void start() {

		
		JLabel state = new JLabel(stateString);
		state.setVisible(true);
		state.setFont(font_s);
		state.setBounds(660, 400, 180, 100);

		JButton leftButton = new JButton(Images.leftNormal);
		JButton foreButton = new JButton(Images.foreNormal);
		JButton rightButton = new JButton(Images.rightNormal);
		JButton rollButton = new JButton(Images.rollNormal);
		JButton diceButton = new JButton();

		leftButton.setRolloverIcon(Images.leftPressed);
		leftButton.setBounds(660, 540, 50, 50);
		leftButton.setBorderPainted(false);// 버튼의 외곽선
		leftButton.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		leftButton.setVisible(true);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//carpet.interrupted();
				Music pop = new Music("button.mp3", false);
				pop.start();
				if (nowdirection == "up") {
					nowdirection = "left";
					stateString = "<html>방향은 왼쪽입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamLeft);
				} else if (nowdirection == "left") {
					nowdirection = "down";
					stateString = "<html>방향은 아래입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamDown);
				} else if (nowdirection == "down") {
					nowdirection = "right";
					stateString = "<html>방향은 오른쪽입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamRight);
				} else if (nowdirection == "right") {
					nowdirection = "up";
					stateString = "<html>방향은 위입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamUp);
				}
				
				leftButton.setVisible(false);
				foreButton.setVisible(false);
				rightButton.setVisible(false);
				rollButton.setVisible(true);
				state.setText(stateString);
			}
		});

		foreButton.setRolloverIcon(Images.forePressed);
		foreButton.setBounds(725, 540, 50, 50);
		foreButton.setBorderPainted(false);// 버튼의 외곽선
		foreButton.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		foreButton.setVisible(true);
		foreButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Music pop = new Music("button.mp3", false);
				pop.start();
				if (nowdirection == "left") {
					nowdirection = "left";
					stateString = "<html>방향은 왼쪽입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamLeft);
				} else if (nowdirection == "down") {
					nowdirection = "down";
					stateString = "<html>방향은 아래입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamDown);
				} else if (nowdirection == "right") {
					nowdirection = "right";
					stateString = "<html>방향은 오른쪽입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamRight);
				} else if (nowdirection == "up") {
					nowdirection = "up";
					stateString = "<html>방향은 위입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamUp);
				}
				
				leftButton.setVisible(false);
				foreButton.setVisible(false);
				rightButton.setVisible(false);
				rollButton.setVisible(true);
				state.setText(stateString);
			}
		});

		rightButton.setRolloverIcon(Images.rightPressed);
		rightButton.setBounds(790, 540, 50, 50);
		rightButton.setBorderPainted(false);// 버튼의 외곽선
		rightButton.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		rightButton.setVisible(true);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			
				Music pop = new Music("button.mp3", false);
				pop.start();
				if (nowdirection == "down") {
					nowdirection = "left";
					stateString = "<html>방향은 왼쪽입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamLeft);
				} else if (nowdirection == "right") {
					nowdirection = "down";
					stateString = "<html>방향은 아래입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamDown);
				} else if (nowdirection == "up") {
					nowdirection = "right";
					stateString = "<html>방향은 오른쪽입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamRight);
				} else if (nowdirection == "left") {
					nowdirection = "up";
					stateString = "<html>방향은 위입니다. 주사위를 굴려주세요.<html>";
					Button_n_Label.blocks[assamlocate].setIcon(Images.assamUp);
				}
		
				leftButton.setVisible(false);
				foreButton.setVisible(false);
				rightButton.setVisible(false);
				state.setText(stateString);
			}
		});
		diceButton.setFont(font_d);
		diceButton.setBounds(725, 540, 50, 50);
		diceButton.setContentAreaFilled(false);// 버튼의 투명영역 채우기
		diceButton.setBorderPainted(false);// 버튼의 외곽선
		diceButton.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		diceButton.setVisible(true);

		rollButton.setRolloverIcon(Images.rollPressed);
		rollButton.setBounds(725, 540, 50, 50);
		rollButton.setBorderPainted(false);// 버튼의 외곽선
		rollButton.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		rollButton.setVisible(true);
		rollButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				Music pop = new Music("bone.mp3", false);
				pop.start();
				diceNum = diceNums[(int) (Math.random() * 6)];
				diceButton.setText(String.valueOf(diceNum));
				rollButton.setVisible(false);
				AssamMove move = new AssamMove(assamlocate, nowdirection, diceNum);
				assamlocate = move.getNewlocate();
				stateString = "<html>양탄자를 설치할 블럭을 클릭해주세요.<html>";
				state.setText(stateString);
				carpet = new Carpet(assamlocate, set, nowplay);
			

			}
		});

		Button_n_Label.gameButtons[0] = leftButton;
		Button_n_Label.gameButtons[1] = foreButton;
		Button_n_Label.gameButtons[2] = rightButton;
		Button_n_Label.gameButtons[3] = rollButton;
		Button_n_Label.gameButtons[4] = diceButton;
		Button_n_Label.gameLabels[0] = state;
		
	}

	

	public void screenDraw(Graphics g) {

		g.setFont(new Font("Arial", Font.BOLD, 18));
		g.setColor(new Color(30, 90, 130));
		int gap = 130;
		for (int i = 0; i < playerNum; i++) {// 플레이어 수, 동전 그림 표시
			g.drawString("P" + String.valueOf(i + 1), 650, gap);
			g.drawImage(Images.coinImage.getImage(), 670, gap - 10, null);

			gap += 70;

		}
		for (int i = 0; i < comNum; i++) {// 컴퓨터 수, 동전 그림 표시
			g.drawString("C" + String.valueOf(i + 1), 650, gap);
			g.drawImage(Images.coinImage.getImage(), 670, gap - 10, null);
			gap += 70;
		}
		if (playerNum + comNum == 2)// 둘이서 진행할 때 양탄자 분배
		{
			g.setColor(set.getP1color());
			g.fillRect(750, 130, 30, 15);
			g.setColor(set.getP2color());
			g.fillRect(750, 155, 30, 15);
			g.setColor(set.getP3color());
			g.fillRect(750, 200, 30, 15);
			g.setColor(set.getP4color());
			g.fillRect(750, 225, 30, 15);

		} else if (playerNum + comNum == 3)// 셋이서 진행할 때 양탄자 분배
		{
			g.setColor(set.getP1color());
			g.fillRect(750, 130, 30, 15);
			g.setColor(set.getP2color());
			g.fillRect(750, 200, 30, 15);
			g.setColor(set.getP3color());
			g.fillRect(750, 270, 30, 15);
		} else if (playerNum + comNum == 4)// 넷이서 진행할 때 양탄자 분배
		{
			g.setColor(set.getP1color());
			g.fillRect(750, 130, 30, 15);
			g.setColor(set.getP2color());
			g.fillRect(750, 200, 30, 15);
			g.setColor(set.getP3color());
			g.fillRect(750, 270, 30, 15);
			g.setColor(set.getP4color());
			g.fillRect(750, 340, 30, 15);
		}

	}

}
