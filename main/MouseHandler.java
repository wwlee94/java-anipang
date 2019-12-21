package Ppasseng;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JLabel;

public class MouseHandler implements MouseListener, MouseMotionListener {
	Random random = new Random();

	PuzzlePaint panel;

	int score = 0, combo = 0, basiccombo, randomNumber;

	JLabel score2 = new JLabel("" + score);
	JLabel combo2 = new JLabel("" + combo);

	boolean firstClick = true, deleteH = false, deleteV = false, returnTo = false, anymoreNone = false,
			pangCheck = false;
	int basicRow, basicCol, term;
	int hi, hj, hk, vi, vj, vk;
	int firepang = 0;

	public MouseHandler(PuzzlePaint panel) {
		this.panel = panel;

	}

	public int getRow(int y) {
		return y / (panel.getHeight() / 7);
	}

	public int getCol(int x) {
		return x / (panel.getWidth() / 7);
	}

	public void mouseClicked(MouseEvent e) {
		int row = getRow(e.getY());
		int col = getCol(e.getX());

		if (firstClick) {
			Music buttonmusic = new Music("blockeffect", false);
			buttonmusic.start();
			firstClick = false;
			if (panel.board[row][col] == 8) {
				for (int i = 0; i < 7; i++) {
					panel.board[row][i] = 7;
					panel.board[i][col] = 7;
				}
				combo++;
				score = score + 5000 +(combo*800);
				buttonmusic = new Music("blockbomb", false);
				buttonmusic.start();
				for (int h = 0; h < 5; h++) {
					for (int i = 6; i >= 1; i--) {
						for (int j = 6; j >= 0; j--) {
							if (panel.board[i][j] == 7) {
								panel.board[i][j] = panel.board[i - 1][j];
								panel.board[i - 1][j] = 7;
							}
						}
					}
				}
				// ^ ��ĭ ������ ����
				for (int i = 6; i >= 0; i--) {
					for (int j = 6; j >= 0; j--) {
						if (panel.board[i][j] == 7) {
							panel.board[i][j] = random.nextInt(7);
						}
					}
				}
				pangCheck = true;
				firstClick = true;
			} // ��ź ���ý� ����
			else if (panel.board[row][col] == 9) {
				buttonmusic = new Music("blockbomb", false);
				buttonmusic.start();
				panel.board[row][col] = 7;
				randomNumber = random.nextInt(7);
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 7; j++) {
						if (panel.board[i][j] == randomNumber) {
							panel.board[i][j] = 7;
						}
					}
				}
				combo++;
				score = score+4000+(combo*500);
				for (int h = 0; h < 5; h++) {
					for (int i = 6; i >= 1; i--) {
						for (int j = 6; j >= 0; j--) {
							if (panel.board[i][j] == 7) {
								panel.board[i][j] = panel.board[i - 1][j];
								panel.board[i - 1][j] = 7;
							}
						}
					}
				}
				// ^ ��ĭ ������ ����
				for (int i = 6; i >= 0; i--) {
					for (int j = 6; j >= 0; j--) {
						if (panel.board[i][j] == 7) {
							panel.board[i][j] = random.nextInt(7);
						}
					}
				}
				pangCheck = true;
				firstClick = true;
			} else if (panel.board[row][col] == 10) {
				buttonmusic = new Music("blockbomb", false);
				buttonmusic.start();
				if (row == 0) {
					if (col == 0) {
						panel.board[row][col] = 7;
						panel.board[row+1][col] = 7;
						panel.board[row][col+1] = 7;
						panel.board[row+1][col+1] = 7;
					} else if (col == 6) {
						panel.board[row][col] = 7;
						panel.board[row+1][col] = 7;
						panel.board[row][col-1] = 7;
						panel.board[row+1][col-1] = 7;
					} else {
						panel.board[row][col-1] = 7;
						panel.board[row][col] = 7;
						panel.board[row][col+1] = 7;
						panel.board[row+1][col-1] = 7;
						panel.board[row+1][col] = 7;
						panel.board[row+1][col+1] = 7;
					}
				} else if (row == 6) {
					if (col == 0) {
						panel.board[row][col] = 7;
						panel.board[row-1][col] = 7;
						panel.board[row][col+1] = 7;
						panel.board[row-1][col+1] = 7;
					} else if (col == 6) {
						panel.board[row][col] = 7;
						panel.board[row-1][col] = 7;
						panel.board[row][col-1] = 7;
						panel.board[row-1][col-1] = 7;
					} else {
						panel.board[row][col-1] = 7;
						panel.board[row][col] = 7;
						panel.board[row][col+1] = 7;
						panel.board[row-1][col-1] = 7;
						panel.board[row-1][col] = 7;
						panel.board[row-1][col+1] = 7;
					}
				} else {
					if (col == 0) {
						panel.board[row-1][col] = 7;
						panel.board[row][col] = 7;
						panel.board[row+1][col] = 7;
						panel.board[row-1][col+1] = 7;
						panel.board[row][col+1] = 7;
						panel.board[row+1][col+1] = 7;
					} else if (col == 6) {
						panel.board[row-1][col] = 7;
						panel.board[row][col] = 7;
						panel.board[row+1][col] = 7;
						panel.board[row-1][col-1] = 7;
						panel.board[row][col-1] = 7;
						panel.board[row+1][col-1] = 7;
					} else {
						panel.board[row-1][col-1] = 7;
						panel.board[row-1][col] = 7;
						panel.board[row-1][col+1] = 7;
						panel.board[row][col-1] = 7;
						panel.board[row][col] = 7;
						panel.board[row][col+1] = 7;
						panel.board[row+1][col-1] = 7;
						panel.board[row+1][col] = 7;
						panel.board[row+1][col+1] = 7;
					}
				}
				combo++;
				score = score + 1000;
				for (int h = 0; h < 5; h++) {
					for (int i = 6; i >= 1; i--) {
						for (int j = 6; j >= 0; j--) {
							if (panel.board[i][j] == 7) {
								panel.board[i][j] = panel.board[i - 1][j];
								panel.board[i - 1][j] = 7;
							}
						}
					}
				}
				// ^ ��ĭ ������ ����
				for (int i = 6; i >= 0; i--) {
					for (int j = 6; j >= 0; j--) {
						if (panel.board[i][j] == 7) {
							panel.board[i][j] = random.nextInt(7);
						}
					}
				}
				pangCheck = true;
				firstClick = true;
			}
			basicRow = row;
			basicCol = col;
		} else {
			firstClick = true;
			returnTo = false;

			if ((basicRow == row + 1 && basicCol == col) || (basicRow == row - 1 && basicCol == col)
					|| (basicRow == row && basicCol == col + 1) || (basicRow == row && basicCol == col - 1)) {
				Music buttonmusic = new Music("blockeffect", false);
				buttonmusic.start();
				
				term = panel.board[row][col];
				panel.board[row][col] = panel.board[basicRow][basicCol];
				panel.board[basicRow][basicCol] = term;
				returnTo = true;
				pangCheck = true;
				
			}
		}
		// pangCheck = 1;
		while (pangCheck) {
			// 3���� ��ġ�Ǵ°�� ���� .. 3���� ���, 4���ΰ�� , + �� �� , �� ��� ������� ��ġ�� ��쵵 ����
			// ����
			
			for (int h = 0; h < 2; h++) {
				for (int i = 2; i < 7; i++) {
					for (int j = 0; j < 7; j++) {
						if (panel.board[i][j] != 7) {
							if (panel.board[i][j] == panel.board[i - 1][j]
									&& panel.board[i - 1][j] == panel.board[i - 2][j]) {
								hk = i - 2;
								for (int k = 3; i - k >= 0 && panel.board[i - k][j] == panel.board[i - k + 1][j]; k++) {
									hk = i - k;
								}
								deleteH = true;
								hi = i;
								hj = j;
							}
						}
					}
				}
				
				for (int j = 2; j < 7; j++) {
					for (int i = 0; i < 7; i++) {
						if (panel.board[i][j] != 7) {
							if (panel.board[i][j] == panel.board[i][j - 1]
									&& panel.board[i][j - 1] == panel.board[i][j - 2]) {
								vk = j - 2;	
								for (int k = 3; j - k >= 0 && panel.board[i][j - k] == panel.board[i][j - k + 1]; k++) {
									vk = j - k;
								}
								deleteV = true;
								vi = i;
								vj = j;
							}
						}
					}
				}
				// ^ ����Ǽ� ��� �����޸𸮿� ����
				if (deleteH) {
					
					Music buttonmusic = new Music("blockbomb", false);
					buttonmusic.start();
					
					basiccombo = combo;
					combo++;
					if(hi - hk == 2){
						score = score+ 250 + (combo * 100);
					}
					else if(hi - hk == 3){
						score = 2*(score+ 250 + (combo * 100));
					}
					else if(hi - hk == 4){
						score = 4*(score+ 250 + (combo * 100));
					}
					deleteH = false;
					returnTo = false;
					for (int i = hi; i >= hk; i--) {
						panel.board[i][hj] = 7;
						firepang++;
					}
				}
				if (deleteV) {
					
					Music buttonmusic = new Music("blockbomb", false);
					buttonmusic.start();
				
					basiccombo = combo;
					combo++;
					if(vj - vk == 2){
						score = score+ 250 + (combo * 100);
					}
					else if(vj - vk == 3){
						score = 2*(score+ 250 + (combo * 100));
					}
					else if(vj - vk == 4){
						score = 4*(score+ 250 + (combo * 100));
					}
					deleteV = false;
					returnTo = false;
					for (int j = vj; j >= vk; j--) {
						panel.board[vi][j] = 7;
						firepang++;
					}
				}
				
			}
			// ^ ���� ����
			for (int h = 0; h < 5; h++) {
				for (int j = 0; j <= 6; j++) {
					for (int i = 6; i >= 1; i--) {
						if (panel.board[i][j] == 7) {
							if (firepang >= 30) {
								firepang = 0;
								panel.board[i][j] = 8;
							} else {
								if (vj - vk == 4 || hi - hk == 4) {
							
									panel.board[i][j] = 9;
									vj = 0;
									hi = 0;
								} else if (vj - vk == 3 || hi - hk == 3) {
									
									panel.board[i][j] = 10;
									vj = 0;
									hi = 0;
								} else {
									
									panel.board[i][j] = panel.board[i - 1][j];
									panel.board[i - 1][j] = 7;
								}
							}
						}
					}
				}
				
			}
			// ^ ��ĭ ������ ����
			for (int i = 6; i >= 0; i--) {
				for (int j = 6; j >= 0; j--) {
					if (panel.board[i][j] == 7) {
						panel.board[i][j] = random.nextInt(7);
					}
				}
			}
			// ������ ��ĭ ������ ä��� ����
			pangCheck = false;
			for (int i = 2; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (panel.board[i][j] != 7) {
						if (panel.board[i][j] == panel.board[i - 1][j]
								&& panel.board[i - 1][j] == panel.board[i - 2][j]) {
							pangCheck = true;
						}
					}
				}
			}

			for (int j = 2; j < 7; j++) {
				for (int i = 0; i < 7; i++) {
					if (panel.board[i][j] != 7) {
						if (panel.board[i][j] == panel.board[i][j - 1]
								&& panel.board[i][j - 1] == panel.board[i][j - 2]) {
							pangCheck = true;
						}
					}
				}
			}
		} // pangCheck = false �϶����� �ݺ�.

		if (returnTo) {
			term = panel.board[row][col];
			panel.board[row][col] = panel.board[basicRow][basicCol];
			panel.board[basicRow][basicCol] = term;
		} // ������ ���ٸ� �ڸ� ����ġ

		do {
			anymoreNone = true;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					if (i < 6 && j < 5 && panel.board[i][j] == panel.board[i][j + 1]
							&& panel.board[i][j + 1] == panel.board[i + 1][j + 2])
						anymoreNone = false;
					if (j < 4 && panel.board[i][j] == panel.board[i][j + 1]
							&& panel.board[i][j + 1] == panel.board[i][j + 3])
						anymoreNone = false;
					if (i > 0 && j < 5 && panel.board[i][j] == panel.board[i][j + 1]
							&& panel.board[i][j + 1] == panel.board[i - 1][j + 2])
						anymoreNone = false;

					if (i > 0 && j < 5 && panel.board[i][j] == panel.board[i - 1][j + 1]
							&& panel.board[i - 1][j + 1] == panel.board[i - 1][j + 2])
						anymoreNone = false;
					if (j < 4 && panel.board[i][j] == panel.board[i][j + 2]
							&& panel.board[i][j + 2] == panel.board[i][j + 3])
						anymoreNone = false;
					if (i < 6 && j < 5 && panel.board[i][j] == panel.board[i + 1][j + 1]
							&& panel.board[i + 1][j + 1] == panel.board[i + 1][j + 2])
						anymoreNone = false;

					if (i < 6 && j < 5 && panel.board[i][j] == panel.board[i + 1][j + 1]
							&& panel.board[i + 1][j + 1] == panel.board[i][j + 2])
						anymoreNone = false;
					if (i > 0 && j < 5 && panel.board[i][j] == panel.board[i - 1][j + 1]
							&& panel.board[i - 1][j + 1] == panel.board[i][j + 2])
						anymoreNone = false;

					if (i < 5 && j < 6 && panel.board[i][j] == panel.board[i + 1][j + 1]
							&& panel.board[i + 1][j + 1] == panel.board[i + 2][j + 1])
						anymoreNone = false;
					if (i < 4 && panel.board[i][j] == panel.board[i + 2][j]
							&& panel.board[i + 2][j] == panel.board[i + 3][j])
						anymoreNone = false;
					if (i < 5 && j > 0 && panel.board[i][j] == panel.board[i + 1][j - 1]
							&& panel.board[i + 1][j - 1] == panel.board[i + 2][j - 1])
						anymoreNone = false;

					if (i < 5 && j > 0 && panel.board[i][j] == panel.board[i + 1][j]
							&& panel.board[i + 1][j] == panel.board[i + 2][j - 1])
						anymoreNone = false;
					if (i < 4 && panel.board[i][j] == panel.board[i + 1][j]
							&& panel.board[i + 1][j] == panel.board[i + 3][j])
						anymoreNone = false;
					if (i < 5 && j < 6 && panel.board[i][j] == panel.board[i + 1][j]
							&& panel.board[i + 1][j] == panel.board[i + 2][j + 1])
						anymoreNone = false;

					if (i > 0 && i < 6 && j < 6 && panel.board[i][j] == panel.board[i + 1][j + 1]
							&& panel.board[i + 1][j + 1] == panel.board[i - 1][j + 1])
						anymoreNone = false;
					if (i > 0 && i < 6 && j > 0 && panel.board[i][j] == panel.board[i - 1][j - 1]
							&& panel.board[i - 1][j - 1] == panel.board[i + 1][j - 1])
						anymoreNone = false;
				}
			}
			// ������ �ִ��� �˻�
			if (anymoreNone) {
				Music buttonmusic = new Music("blockbomb", false);
				buttonmusic.start();
				for (int i = 0; i < 7; i++) {
					for (int j = 0; j < 7; j++) {
						panel.board[i][j] = random.nextInt(7);
						if (i >= 2) {
							while (panel.board[i][j] == panel.board[i - 1][j]
									&& panel.board[i - 1][j] == panel.board[i - 2][j])
								panel.board[i][j] = random.nextInt(7);
						}
						if (j >= 2) {
							while (panel.board[i][j] == panel.board[i][j - 1]
									&& panel.board[i][j - 1] == panel.board[i][j - 2])
								do {
									panel.board[i][j] = random.nextInt(7);
								} while ((panel.board[i][j] == panel.board[i - 1][j]
										&& panel.board[i - 1][j] == panel.board[i - 2][j])
										|| (panel.board[i][j] == panel.board[i][j - 1]
												&& panel.board[i][j - 1] == panel.board[i][j - 2]));
						}
					}
				}
			}
		} while (anymoreNone);
		// ������ ���ٸ� ��� ���� ������ �ֱ�

		panel.repaint();
		score2.setText("" + score);
		combo2.setText("" + combo);
	}

	public void mousePressed(MouseEvent e) {
		// String s = "The Mouse has been pressed";
		// tf.setText(s);
	}

	public void mouseReleased(MouseEvent e) {
		// String s = "The Mouse has been released";
		// tf.setText(s);
	}

	public void mouseEntered(MouseEvent e) {
		// String s = "The Mouse entered";
		// tf.setText(s);
	}

	public void mouseExited(MouseEvent e) {
		// String s = "The Mouse has left the building";
		// tf.setText(s);
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		// String s = "The Mouse moving: X = "+e.getX()+" Y = "+e.getY();
		// tf.setText(s);
	}

}