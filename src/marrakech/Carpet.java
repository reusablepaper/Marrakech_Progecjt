package marrakech;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Carpet extends Thread {
	int setcarpet = 0;
	int assamlocate;
	int player;
	Setting set;

	Carpet(int assamlocate, Setting set, int player) {
		this.assamlocate = assamlocate;
		this.set = set;
		this.player = player;
		/*
		 * for (int i = 0; i <= 48; i++) Button_n_Label.blocks[i].setEnabled(false);
		 */
		Button_n_Label.blocks[assamlocate].setEnabled(false);
		if (assamlocate == 0) {// 네 귀퉁이
			possibleF(1);
			possibleF(7);

		} else if (assamlocate == 6) {
			possibleF(5);
			possibleF(13);
		} else if (assamlocate == 42) {
			possibleF(35);
			possibleF(43);
		} else if (assamlocate == 48) {
			possibleF(41);
			possibleF(47);
		} else if (assamlocate >= 1 && assamlocate <= 5) {// 네 모서리 윗면
			possibleF(assamlocate - 1);
			possibleF(assamlocate + 1);
			possibleF(assamlocate + 7);
		} else if (assamlocate >= 1 && assamlocate <= 42 && assamlocate % 7 == 0) {// 왼쪽
			possibleF(assamlocate - 7);
			possibleF(assamlocate + 1);
			possibleF(assamlocate + 7);
		} else if (assamlocate >= 1 && assamlocate <= 48 && (assamlocate + 1) % 7 == 0) {// 오른쪽
			possibleF(assamlocate - 1);
			possibleF(assamlocate - 7);
			possibleF(assamlocate + 7);
		} else if (assamlocate >= 43 && assamlocate <= 47) {// 아랫면
			possibleF(assamlocate - 1);
			possibleF(assamlocate + 1);
			possibleF(assamlocate - 7);
		} else {
			possibleF(assamlocate - 1);
			possibleF(assamlocate + 1);
			possibleF(assamlocate - 7);
			possibleF(assamlocate + 7);
		}

	}



	private void possibleF(int element) {// 첫번째로 선택할 수 있는 원소
		Button_n_Label.blocks[element].setRolloverIcon(Images.blockEntered);

		Button_n_Label.blocks[element].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// 첫번째 후보에 마우스를 올렸을 때
				if (element == 0) {// 네 귀퉁이//첫번째로 고를수 있는 원소의 후보가 0이라면
					if (1 == assamlocate) {
					} else
						possibleS(1);// 두번째 후보는 1과 7임, 1과 7은 마우스가 올라가면 불이 켜져야 됨
					if (7 == assamlocate) {
					} else
						possibleS(7);

				} else if (element == 6) {
					if (5 == assamlocate) {
					} else
						possibleS(5);
					if (13 == assamlocate) {
					} else
						possibleS(13);
				} else if (element == 42) {
					if (35 == assamlocate) {
					} else
						possibleS(35);
					if (43 == assamlocate) {
					} else
						possibleS(43);
				} else if (element == 48) {
					if (41 == assamlocate) {
					} else
						possibleS(41);
					if (47 == assamlocate) {
					} else
						possibleS(47);
				} else if (element >= 1 && element <= 5) {// 네 모서리 윗면
					if (element + 7 == assamlocate) {
					} else
						possibleS(element + 7);
					if (element - 1 == assamlocate) {
					} else
						possibleS(element - 1);
					if (element + 1 == assamlocate) {
					} else
						possibleS(element + 1);
				} else if (element >= 1 && element <= 42 && element % 7 == 0) {// 왼쪽
					if (element - 7 == assamlocate) {
					} else
						possibleS(element - 7);
					if (element + 7 == assamlocate) {
					} else
						possibleS(element + 7);
					if (element + 1 == assamlocate) {
					} else
						possibleS(element + 1);
				} else if (element >= 1 && element <= 48 && (element + 1) % 7 == 0) {// 오른쪽
					if (element - 1 == assamlocate) {
					} else
						possibleS(element - 1);
					if (element - 7 == assamlocate) {
					} else
						possibleS(element - 7);
					if (element + 7 == assamlocate) {
					} else
						possibleS(element + 7);
				} else if (element >= 43 && element <= 47) {// 아랫면
					if (element - 1 == assamlocate) {
					} else
						possibleS(element - 1);
					if (element + 1 == assamlocate) {
					} else
						possibleS(element + 1);
					if (element + 7 == assamlocate) {
					} else
						possibleS(element + 7);
				} else {
					if (element - 1 == assamlocate) {
					} else
						possibleS(element - 1);
					if (element + 1 == assamlocate) {
					} else
						possibleS(element + 1);
					if (element - 7 == assamlocate) {
					} else
						possibleS(element - 7);
					if (element + 7 == assamlocate) {
					} else
						possibleS(element + 7);
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				for (int i = 0; i <= 48; i++) {
					if (i == assamlocate)
						continue;
					else if (Button_n_Label.blocks[element].getIcon() == null)
						continue;
					else
						Button_n_Label.blocks[i].setIcon(Images.blockNormal);
				}

			}

			@Override
			public void mousePressed(MouseEvent e) {
				Button_n_Label.blocks[element].setIcon(null);
				Button_n_Label.blocks[element].setBackground(set.getPlayerColor(player));

			}
		});
	}

	public void possibleS(int element) {
		Button_n_Label.blocks[element].setIcon(Images.blockEntered);
		//Button_n_Label.blocks[element].setEnabled(false);
		Button_n_Label.blocks[element].addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {//두번째 후보를 클릭했을 때
				for (int i = 0; i <= 48; i++) {
					if (i == assamlocate)//아쌈이 있는 장소는 안바꿈
						continue;
					else if (Button_n_Label.blocks[i].getIcon() == null)//이미 양탄자가 있는 장소라면 안바꿈
						continue;
					else
						Button_n_Label.blocks[i].setIcon(Images.blockNormal);
				}
				Button_n_Label.gameLabels[player+4].setText(String.valueOf(Integer.parseInt(Button_n_Label.gameLabels[player+4].getText())-1));
				Button_n_Label.blocks[element].setIcon(null);
				Button_n_Label.blocks[element].setBackground(set.getPlayerColor(player));
				Button_n_Label.gameButtons[0].setVisible(true);
				Button_n_Label.gameButtons[1].setVisible(true);
				Button_n_Label.gameButtons[2].setVisible(true);
				Button_n_Label.gameButtons[3].setVisible(true);
				Game.nowplay++;
				if (Game.nowplay>Marrakech.playerNum+Marrakech.comNum) {
					Game.nowplay=1;
				}
				Button_n_Label.gameLabels[0].setText("<html>플레이어" + Game.nowplay + "의 차례입니다.<br/><br/>방향을 정해주세요.<html>");
			}
		});
	}

}
