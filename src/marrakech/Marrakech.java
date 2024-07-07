package marrakech;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class Marrakech extends JFrame {

	private Music mainMusic = new Music("main.mp3", true);
	private Music main2;// BGM onoff에 쓸 변수
	private Image screenImage;
	private Graphics screenGraphic;
	private Image background;
	private Image mainImage = new ImageIcon(Main.class.getResource("../images/mainimage.png")).getImage();
	private Image MKBoard = new ImageIcon(Main.class.getResource("../images/MKBoard.png")).getImage();
	private ButtonGroup playerNumButtons = new ButtonGroup();
	private ButtonGroup comNumButtons = new ButtonGroup();
	public static String nowState;
	public static int playerNum = 0, comNum = 0;
	boolean isblockmade = false;
	Game game;
	Setting set = new Setting();
	
	public Marrakech() {
		mainMusic.start();
		setUndecorated(true);// 기본 메뉴바 안보임
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		background = mainImage;

		Button_n_Label.logoLabel.setBounds(190, 80, 500, 100);// 로고
		add(Button_n_Label.logoLabel);

		Button_n_Label.onlineLabel.setBounds(200, 270, 170, 50);// -온라인
		add(Button_n_Label.onlineLabel);

		Button_n_Label.offlineLabel.setBounds(200, 410, 170, 50);// -오프라인
		add(Button_n_Label.offlineLabel);

		Button_n_Label.playerNumDeco.setBounds(171, 190, 538, 170);// 플레이어 인원 꾸밈
		Button_n_Label.playerNumDeco.setVisible(false);
		add(Button_n_Label.playerNumDeco);

		Button_n_Label.comNumDeco.setBounds(171, 360, 538, 170);// 컴퓨터 인원 꾸밈
		Button_n_Label.comNumDeco.setVisible(false);
		add(Button_n_Label.comNumDeco);

		setButton(Button_n_Label.createButton, Images.createButtonEntered, 375, 270, 170, 50);// 서버생성 버튼
		Button_n_Label.createButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 서버 생성 이벤트
				nowState = "create";
			}
		});
		add(Button_n_Label.createButton);

		setButton(Button_n_Label.joinButton, Images.joinButtonEntered, 375, 340, 170, 50);// 서버참가 버튼
		Button_n_Label.joinButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 서버 참가 이벤트
				nowState = "join";
			}
		});
		add(Button_n_Label.joinButton);

		setButton(Button_n_Label.startButton, Images.startButtonEntered, 375, 410, 170, 50);// 게임시작 버튼
		Button_n_Label.startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 게임 시작 이벤트
				nowState = "start";
				start();
			}
		});
		add(Button_n_Label.startButton);

		setButton(Button_n_Label.setButton, Images.setButtonEntered, 375, 480, 170, 50);// 환경설정 버튼
		Button_n_Label.setButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 환경설정 이벤트
				nowState = "setting";
				setting();
				for (int i = 0; i < 12; i++) {
					add(Button_n_Label.setcolors[i]);
				}

			}
		});
		add(Button_n_Label.setButton);

		setButton(Button_n_Label.exitButton, Images.exitButtonEntered, 375, 550, 170, 50);// 종료 버튼
		Button_n_Label.exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(Button_n_Label.exitButton);

		setButton(Button_n_Label.menuButton, Images.menuButtonEntered, 10, 5, 170, 50);// 메뉴로 돌아가기 버튼
		Button_n_Label.menuButton.setVisible(false);
		Button_n_Label.menuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 메뉴로 가는 이벤트
				nowState = "mainmenu";
				menu();
			}
		});
		add(Button_n_Label.menuButton);

		setButton(Button_n_Label.game_exitButton, Images.exitButtonEntered, 700, 5, 170, 50);// 게임화면에서 끝내는 버튼
		Button_n_Label.game_exitButton.setVisible(false);
		Button_n_Label.game_exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(Button_n_Label.game_exitButton);

		setButton(Button_n_Label.applyButton, Images.applyButtonEntered, 375, 550, 170, 50);// 확인 버튼(인원설정, 환경설정)
		Button_n_Label.applyButton.setVisible(false);
		Button_n_Label.applyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// 게임 시작 이벤트

				if (nowState == "start") {
					if (playerNum == 0 || playerNum + comNum >= 5 || playerNum + comNum <= 1) {
						// 아무일도 안일어남
						Music wrong = new Music("wrong.mp3", false);
						wrong.start();
					}

					else if (playerNum + comNum < 5 && playerNum + comNum > 1) { // 인원수 맞음, 게임 시작
						game = new Game(playerNum, comNum, set);
						for (int j = 0; j < 49; j++)
							add(Button_n_Label.blocks[j]);
						isblockmade = true;
						gamestart();// 게임시작화면(버튼 전부 안보이게)
						nowState = "gaming";	
						for (int j = 0; j < 5; j++)// 게임버튼
							add(Button_n_Label.gameButtons[j]);
						for (int j = 0; j < 9; j++)// 게임레이블
							add(Button_n_Label.gameLabels[j]);
						
						
						/*
						 * while (!game.gameEnd) { for (int i = 1; i <= playerNum + comNum; i++) {
						 * 
						 * }
						 * 
						 * }
						 */
						

					}
				}
				if (nowState == "setting")// 환경설정 화면에서 확인버튼 누르면 설정 변수 저장 후 메인메뉴로.
				{
					nowState = "mainmenu";

					String R1 = Button_n_Label.setcolors[0].getText();
					String G1 = Button_n_Label.setcolors[1].getText();
					String B1 = Button_n_Label.setcolors[2].getText();
					String R2 = Button_n_Label.setcolors[3].getText();
					String G2 = Button_n_Label.setcolors[4].getText();
					String B2 = Button_n_Label.setcolors[5].getText();
					String R3 = Button_n_Label.setcolors[6].getText();
					String G3 = Button_n_Label.setcolors[7].getText();
					String B3 = Button_n_Label.setcolors[8].getText();
					String R4 = Button_n_Label.setcolors[9].getText();
					String G4 = Button_n_Label.setcolors[10].getText();
					String B4 = Button_n_Label.setcolors[11].getText();
					if (R1.equals("") || G1.equals("") || B1.equals(""))
						set.setP1color(Color.RED);
					else
						set.setP1color(new Color(Integer.parseInt(R1), Integer.parseInt(G1), Integer.parseInt(B1)));
					if (R2.equals("") || G2.equals("") || B2.equals(""))
						set.setP2color(Color.ORANGE);
					else
						set.setP2color(new Color(Integer.parseInt(R2), Integer.parseInt(G2), Integer.parseInt(B2)));
					if (R3.equals("") || G3.equals("") || B3.equals(""))
						set.setP3color(Color.YELLOW);
					else
						set.setP3color(new Color(Integer.parseInt(R3), Integer.parseInt(G3), Integer.parseInt(B3)));
					if (R4.equals("") || G4.equals("") || B4.equals(""))
						set.setP4color(Color.BLUE);
					else
						set.setP4color(new Color(Integer.parseInt(R4), Integer.parseInt(G4), Integer.parseInt(B4)));

					for (int i = 0; i < 12; i++) {
						Button_n_Label.setcolors[i].setVisible(false);
					}
					menu();
				}
			}
		});
		add(Button_n_Label.applyButton);

		setToggleButton(Button_n_Label.onoffButton, Images.onImage, Images.offImage, 435, 420, 70, 70);
		Button_n_Label.onoffButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				if (set.getbgmOn()) {
					set.setbgmOn(false);
					mainMusic.close();
					if (main2 != null)
						main2.close();
					main2 = null;

				} else if (!set.getbgmOn()) {
					set.setbgmOn(true);
					Music mainMusic_re = new Music("main.mp3", true);
					main2 = mainMusic_re;
					main2.start();
				}
			}
		});
		add(Button_n_Label.onoffButton);

		playerNumButtons.add(Button_n_Label.p1Button);
		playerNumButtons.add(Button_n_Label.p2Button);
		playerNumButtons.add(Button_n_Label.p3Button);
		playerNumButtons.add(Button_n_Label.p4Button);

		setToggleButton(Button_n_Label.p1Button, Images.p1ButtonEntered, Images.p1ButtonPressed, 350, 255, 50, 50);
		Button_n_Label.p1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// player1
				playerNum = 1;

			}
		});
		add(Button_n_Label.p1Button);

		setToggleButton(Button_n_Label.p2Button, Images.p2ButtonEntered, Images.p2ButtonPressed, 420, 255, 50, 50);
		Button_n_Label.p2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// plater2
				playerNum = 2;

			}
		});
		add(Button_n_Label.p2Button);

		setToggleButton(Button_n_Label.p3Button, Images.p3ButtonEntered, Images.p3ButtonPressed, 490, 255, 50, 50);
		Button_n_Label.p3Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// player3
				playerNum = 3;

			}
		});
		add(Button_n_Label.p3Button);

		setToggleButton(Button_n_Label.p4Button, Images.p4ButtonEntered, Images.p4ButtonPressed, 560, 255, 50, 50);
		Button_n_Label.p4Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// player4
				playerNum = 4;
			}
		});
		add(Button_n_Label.p4Button);

		comNumButtons.add(Button_n_Label.c0Button);
		comNumButtons.add(Button_n_Label.c1Button);
		comNumButtons.add(Button_n_Label.c2Button);
		comNumButtons.add(Button_n_Label.c3Button);

		setToggleButton(Button_n_Label.c0Button, Images.p0ButtonEntered, Images.p0ButtonPressed, 350, 425, 50, 50);
		Button_n_Label.c0Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// com0
				comNum = 0;

			}
		});
		add(Button_n_Label.c0Button);

		setToggleButton(Button_n_Label.c1Button, Images.p1ButtonEntered, Images.p1ButtonPressed, 420, 425, 50, 50);
		Button_n_Label.c1Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// com1
				comNum = 1;

			}
		});
		add(Button_n_Label.c1Button);

		setToggleButton(Button_n_Label.c2Button, Images.p2ButtonEntered, Images.p2ButtonPressed, 490, 425, 50, 50);
		Button_n_Label.c2Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// com2
				comNum = 2;

			}
		});
		add(Button_n_Label.c2Button);

		setToggleButton(Button_n_Label.c3Button, Images.p3ButtonEntered, Images.p3ButtonPressed, 560, 425, 50, 50);
		Button_n_Label.c3Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// player3
				comNum = 3;

			}
		});
		add(Button_n_Label.c3Button);

	}

	public void start() {// 오프라인-게임시작버튼 화면
		background = mainImage;
		Button_n_Label.logoLabel.setVisible(true);

		Button_n_Label.onlineLabel.setVisible(false);// 온라인 오프라인 서버생성 서버참가 게임시작 환경설정 종료
		Button_n_Label.offlineLabel.setVisible(false);
		Button_n_Label.createButton.setVisible(false);
		Button_n_Label.joinButton.setVisible(false);
		Button_n_Label.startButton.setVisible(false);
		Button_n_Label.setButton.setVisible(false);
		Button_n_Label.exitButton.setVisible(false);

		Button_n_Label.menuButton.setVisible(true);// 메뉴로 확인 플레이어수 컴퓨터수 1P 2P 3P 4P & 0P 1P 2P 3P
		Button_n_Label.applyButton.setVisible(true);
		Button_n_Label.playerNumDeco.setVisible(true);
		Button_n_Label.comNumDeco.setVisible(true);
		Button_n_Label.p1Button.setVisible(true);
		Button_n_Label.p2Button.setVisible(true);
		Button_n_Label.p3Button.setVisible(true);
		Button_n_Label.p4Button.setVisible(true);
		Button_n_Label.c0Button.setVisible(true);
		Button_n_Label.c1Button.setVisible(true);
		Button_n_Label.c2Button.setVisible(true);
		Button_n_Label.c3Button.setVisible(true);
		Button_n_Label.game_exitButton.setVisible(true);
		setFocusable(false);

	}

	public void menu() {// 메인메뉴 화면
		background = mainImage;
		Button_n_Label.logoLabel.setVisible(true);

		Button_n_Label.onlineLabel.setVisible(true);// 온라인 오프라인 서버생성 서버참가 게임시작 환경설정 종료
		Button_n_Label.offlineLabel.setVisible(true);
		Button_n_Label.createButton.setVisible(true);
		Button_n_Label.joinButton.setVisible(true);
		Button_n_Label.startButton.setVisible(true);
		Button_n_Label.setButton.setVisible(true);
		Button_n_Label.exitButton.setVisible(true);

		Button_n_Label.menuButton.setVisible(false);// 메뉴로 확인 플레이어수 컴퓨터수 1P 2P 3P 4P & 0P 1P 2P 3P
		Button_n_Label.applyButton.setVisible(false);
		Button_n_Label.playerNumDeco.setVisible(false);
		Button_n_Label.comNumDeco.setVisible(false);
		Button_n_Label.p1Button.setVisible(false);
		Button_n_Label.p2Button.setVisible(false);
		Button_n_Label.p3Button.setVisible(false);
		Button_n_Label.p4Button.setVisible(false);
		Button_n_Label.c0Button.setVisible(false);
		Button_n_Label.c1Button.setVisible(false);
		Button_n_Label.c2Button.setVisible(false);
		Button_n_Label.c3Button.setVisible(false);
		Button_n_Label.game_exitButton.setVisible(false);
		Button_n_Label.onoffButton.setVisible(false);

		if (isblockmade == true) {
			for (int i = 0; i < 49; i++)
				Button_n_Label.blocks[i].setVisible(false);// 보드 위 블록
			for (int i = 0; i < 5; i++)
				Button_n_Label.gameButtons[i].setVisible(false);
			for (int i = 0; i < 9; i++)
				Button_n_Label.gameLabels[i].setVisible(false);

		}
		setFocusable(false);
	}

	public void gamestart() {// 게임 시작 화면
		background = MKBoard;
		Button_n_Label.logoLabel.setVisible(false);

		Button_n_Label.applyButton.setVisible(false);
		Button_n_Label.playerNumDeco.setVisible(false);
		Button_n_Label.comNumDeco.setVisible(false);
		Button_n_Label.p1Button.setVisible(false);
		Button_n_Label.p2Button.setVisible(false);
		Button_n_Label.p3Button.setVisible(false);
		Button_n_Label.p4Button.setVisible(false);
		Button_n_Label.c0Button.setVisible(false);
		Button_n_Label.c1Button.setVisible(false);
		Button_n_Label.c2Button.setVisible(false);
		Button_n_Label.c3Button.setVisible(false);
		Button_n_Label.game_exitButton.setVisible(true);
		for (int i = 0; i < 49; i++)
			Button_n_Label.blocks[i].setVisible(true);// 보드 위 블록
		setFocusable(true);

	}

	public void setting() {// 오프라인-게임시작버튼 화면
		background = mainImage;
		Button_n_Label.onlineLabel.setVisible(false);// 온라인 오프라인 서버생성 서버참가 게임시작 환경설정 종료
		Button_n_Label.offlineLabel.setVisible(false);
		Button_n_Label.createButton.setVisible(false);
		Button_n_Label.joinButton.setVisible(false);
		Button_n_Label.startButton.setVisible(false);
		Button_n_Label.setButton.setVisible(false);
		Button_n_Label.exitButton.setVisible(false);

		// Button_n_Label.menuButton.setVisible(true);//메뉴로 확인 플레이어수 컴퓨터수 1P 2P 3P 4P &
		// 0P 1P 2P 3P
		Button_n_Label.applyButton.setVisible(true);
		Button_n_Label.onoffButton.setVisible(true);
		setFocusable(false);

		for (int i = 0; i < 12; i++) {
			Button_n_Label.setcolors[i].setVisible(true);
		}
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
		if (nowState == "gaming") {
			game.screenDraw(g);
		}
		if (nowState == "setting") {
			set.screenDraw(g);
		}

	}

	public void setButton(JButton btn, ImageIcon btnEntered, int x, int y, int width, int height) {
		btn.setBounds(x, y, width, height);
		btn.setContentAreaFilled(false);// 버튼의 투명영역 채우기
		btn.setBorderPainted(false);// 버튼의 외곽선
		btn.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		btn.setRolloverIcon(btnEntered);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("button.mp3", false);
				buttonSound.start();
			}
		});
	}

	public void setToggleButton(JToggleButton btn, ImageIcon btnEntered, ImageIcon btnPressed, int x, int y, int width,
			int height) {
		btn.setBounds(x, y, width, height);
		btn.setContentAreaFilled(false);// 버튼의 투명영역 채우기
		btn.setBorderPainted(false);// 버튼의 외곽선
		btn.setFocusPainted(false);// 버튼이 선택되었을 때 테두리
		btn.setRolloverIcon(btnEntered);
		btn.setSelectedIcon(btnPressed);
		btn.setVisible(false);
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonSound = new Music("button.mp3", false);
				buttonSound.start();
			}
		});
	}

}