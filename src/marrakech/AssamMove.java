package marrakech;

import javax.swing.JToggleButton;

public class AssamMove {
	int newlocate;
	int leftNum;

	AssamMove(int locate, String direction, int diceNum) {
	
		leftNum = diceNum;

		if (direction == "up") {
			loop: for (int i = 0; i < diceNum; i++) {
				leftNum--;
				if (!Button_n_Label.blocks[locate].getIcon().equals(null))
					Button_n_Label.blocks[locate].setIcon(Images.blockNormal);// 아쌈 위치 변경

				switch (locate) {
				case 0:
					Button_n_Label.blocks[0].setIcon(Images.assamRight);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 0;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(0, "right", leftNum);
						break loop;
					}
				case 1:
					Button_n_Label.blocks[3].setIcon(Images.assamDown);
					if (leftNum == 0) {
						newlocate = 3;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(3, "down", leftNum);
						break loop;
					}
				case 2:
					Button_n_Label.blocks[2].setIcon(Images.assamDown);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 2;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(2, "down", leftNum);
						break loop;
					}
				case 3:
					Button_n_Label.blocks[4].setIcon(Images.assamDown);
					if (leftNum == 0) {
						newlocate = 4;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(4, "down", leftNum);
						break loop;
					}
				case 4:
					Button_n_Label.blocks[3].setIcon(Images.assamDown);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 3;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(5, "down", leftNum);
						break loop;
					}
				case 5:
					Button_n_Label.blocks[6].setIcon(Images.assamDown);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 6;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(6, "down", leftNum);
						break loop;
					}
				case 6:
					Button_n_Label.blocks[5].setIcon(Images.assamDown);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 5;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(5, "down", leftNum);
						break loop;
					}
				}

				locate -= 7;
				Button_n_Label.blocks[locate].setIcon(Images.assamUp);// 아쌈 위치 변경
				newlocate = locate;
			}
		} else if (direction == "left") {
			loop: for (int i = 0; i < diceNum; i++) {
				leftNum--;
				if (!Button_n_Label.blocks[locate].getIcon().equals(null))
					Button_n_Label.blocks[locate].setIcon(Images.blockNormal);// 아쌈 위치 변경
				switch (locate) {
				case 0:
					Button_n_Label.blocks[0].setIcon(Images.assamDown);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 0;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(0, "down", leftNum);
						break loop;
					}
				case 7:
					Button_n_Label.blocks[14].setIcon(Images.assamRight);
					if (leftNum == 0) {
						newlocate = 14;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(14, "right", leftNum);
						break loop;
					}
				case 14:
					Button_n_Label.blocks[7].setIcon(Images.assamRight);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 7;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(7, "right", leftNum);
						break loop;
					}
				case 21:
					Button_n_Label.blocks[28].setIcon(Images.assamRight);
					if (leftNum == 0) {
						newlocate = 28;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(28, "right", leftNum);
						break loop;
					}
				case 28:
					Button_n_Label.blocks[21].setIcon(Images.assamRight);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 21;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(21, "right", leftNum);
						break loop;
					}
				case 35:
					Button_n_Label.blocks[42].setIcon(Images.assamRight);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 42;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(42, "right", leftNum);
						break loop;
					}
				case 42:
					Button_n_Label.blocks[35].setIcon(Images.assamRight);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 35;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(35, "right", leftNum);
						break loop;
					}
				}

				locate -= 1;
				Button_n_Label.blocks[locate].setIcon(Images.assamLeft);// 아쌈 위치 변경
				newlocate = locate;

			}

		} else if (direction == "down") {
			loop: for (int i = 0; i < diceNum; i++) {
				leftNum--;
				if (!Button_n_Label.blocks[locate].getIcon().equals(null))
					Button_n_Label.blocks[locate].setIcon(Images.blockNormal);// 아쌈 위치 변경
				switch (locate) {
				case 42:
					Button_n_Label.blocks[43].setIcon(Images.assamUp);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 43;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(43, "up", leftNum);
						break loop;
					}
				case 43:
					Button_n_Label.blocks[42].setIcon(Images.assamUp);
					if (leftNum == 0) {
						newlocate = 42;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(42, "up", leftNum);
						break loop;
					}
				case 44:
					Button_n_Label.blocks[45].setIcon(Images.assamUp);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 45;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(45, "up", leftNum);
						break loop;
					}
				case 45:
					Button_n_Label.blocks[44].setIcon(Images.assamUp);
					if (leftNum == 0) {
						newlocate = 44;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(44, "up", leftNum);
						break loop;
					}
				case 46:
					Button_n_Label.blocks[47].setIcon(Images.assamUp);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 47;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(47, "up", leftNum);
						break loop;
					}
				case 47:
					Button_n_Label.blocks[46].setIcon(Images.assamUp);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 46;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(46, "up", leftNum);
						break loop;
					}
				case 48:
					Button_n_Label.blocks[48].setIcon(Images.assamLeft);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 48;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(48, "left", leftNum);
						break loop;
					}
				}

				locate += 7;
				Button_n_Label.blocks[locate].setIcon(Images.assamDown);// 아쌈 위치 변경
				newlocate = locate;

			}

		} else if (direction == "right") {
			loop: for (int i = 0; i < diceNum; i++) {
				leftNum--;
				if (!Button_n_Label.blocks[locate].getIcon().equals(null))
					Button_n_Label.blocks[locate].setIcon(Images.blockNormal);// 아쌈 위치 변경
				switch (locate) {
				case 6:
					Button_n_Label.blocks[13].setIcon(Images.assamLeft);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 13;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(13, "left", leftNum);
						break loop;
					}
				case 13:
					Button_n_Label.blocks[6].setIcon(Images.assamLeft);
					if (leftNum == 0) {
						newlocate = 6;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(6, "left", leftNum);
						break loop;
					}
				case 20:
					Button_n_Label.blocks[27].setIcon(Images.assamLeft);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 27;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(27, "left", leftNum);
						break loop;
					}
				case 27:
					Button_n_Label.blocks[20].setIcon(Images.assamLeft);
					if (leftNum == 0) {
						newlocate = 20;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(20, "left", leftNum);
						break loop;
					}
				case 34:
					Button_n_Label.blocks[41].setIcon(Images.assamLeft);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 41;
						break loop;
					} else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(41, "left", leftNum);
						break loop;
					}
				case 41:
					Button_n_Label.blocks[47].setIcon(Images.assamLeft);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 34;
						break loop;
					}

					else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(47, "left", leftNum);
						break loop;
					}
				case 48:
					Button_n_Label.blocks[48].setIcon(Images.assamUp);// 화살표 목적지에 그려줌
					if (leftNum == 0) {
						newlocate = 48;
						break loop;
					}

					else {
						Button_n_Label.blocks[locate].setIcon(Images.blockNormal);
						new AssamMove(48, "up", leftNum);
						break loop;
					}
				}
				locate += 1;
				Button_n_Label.blocks[locate].setIcon(Images.assamRight);// 아쌈 위치 변경
				newlocate = locate;

			}
		}
	}

	public int getNewlocate() {
		return newlocate;
	}

}
