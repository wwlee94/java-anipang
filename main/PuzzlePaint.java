package Ppasseng;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;

class PuzzlePaint extends JPanel {
	Random random = new Random();
	Image[] images = new Image[11];
	Toolkit toolkit = getToolkit();
	boolean anymoreNone;
	
	int[][] board = new int[7][7];
	{
		do{
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j] = random.nextInt(7);
				if (i >= 2) {
					while (board[i][j] == board[i - 1][j] && board[i - 1][j] == board[i - 2][j])
						board[i][j] = random.nextInt(7);
				}
				if (j >= 2) {
					if(i>2){
					while (board[i][j] == board[i][j - 1] && board[i][j - 1] == board[i][j - 2])
						do {
							board[i][j] = random.nextInt(7);
						} while ((board[i][j] == board[i - 1][j] && board[i - 1][j] == board[i - 2][j])
								|| (board[i][j] == board[i][j - 1] && board[i][j - 1] == board[i][j - 2]));
					}
					else{
						while (board[i][j] == board[i][j - 1] && board[i][j - 1] == board[i][j - 2])
							board[i][j] = random.nextInt(7);
					}
				}
			}
		}
		anymoreNone = true;
		for(int i =0;i<7;i++){
			for(int j = 0;j<7;j++){
				if(i<6 && j<5 && board[i][j] == board[i][j+1]&&board[i][j+1] ==board[i+1][j+2]) anymoreNone = false;
				if(j<4 && board[i][j] == board[i][j+1]&&board[i][j+1] ==board[i][j+3])anymoreNone = false;
				if(i>0 && j<5 && board[i][j] == board[i][j+1]&&board[i][j+1] ==board[i-1][j+2])anymoreNone = false;
				
				if(i>0 && j<5 && board[i][j] == board[i-1][j+1]&&board[i-1][j+1] ==board[i-1][j+2])anymoreNone = false;
				if(j<4 && board[i][j] == board[i][j+2]&&board[i][j+2] ==board[i][j+3])anymoreNone = false;
				if(i<6 && j<5 && board[i][j] == board[i+1][j+1]&&board[i+1][j+1] ==board[i+1][j+2])anymoreNone = false;
				
				if(i<6 && j<5 && board[i][j] == board[i+1][j+1]&&board[i+1][j+1] ==board[i][j+2])anymoreNone = false;
				if(i>0 && j<5 && board[i][j] == board[i-1][j+1]&&board[i-1][j+1] ==board[i][j+2])anymoreNone = false;
				
				if( i<5&& j<6&& board[i][j] == board[i+1][j+1]&&board[i+1][j+1] ==board[i+2][j+1])anymoreNone = false;
				if( i<4&& board[i][j] == board[i+2][j]&&board[i+2][j] ==board[i+3][j])anymoreNone = false;
				if( i<5&& j>0 && board[i][j] == board[i+1][j-1]&&board[i+1][j-1] ==board[i+2][j-1])anymoreNone = false;
				
				if(i<5 && j>0 &&board[i][j] == board[i+1][j]&&board[i+1][j] ==board[i+2][j-1])anymoreNone = false;
				if(i<4 && board[i][j] == board[i+1][j]&&board[i+1][j] ==board[i+3][j])anymoreNone = false;
				if(i<5 && j<6 &&board[i][j] == board[i+1][j]&&board[i+1][j] ==board[i+2][j+1])anymoreNone = false;
				
				if( i>0 && i<6 && j<6 && board[i][j] == board[i+1][j+1]&&board[i+1][j+1] ==board[i-1][j+1])anymoreNone = false;
				if( i>0 && i<6 && j>0 && board[i][j] == board[i-1][j-1]&&board[i-1][j-1] ==board[i+1][j-1])anymoreNone = false;
			}
		}
		}while(anymoreNone);
	}

	public PuzzlePaint() {
		for (int i = 0; i < 11; i++)
			images[i] = toolkit.getImage("C:/Users/micke/Desktop/자료모음/자바/Anipang/image/f"+(i+1)+".png");
	}

	public int getX(int col) {
		return col * (getWidth()-5) / 7;
	}

	public int getY(int row) {
		return row * (getHeight()-5) / 7;
	}

	public void drawCell(Graphics g, int col, int row) {
		g.drawImage(images[board[row][col]], 5+getX(col), 5+getY(row), (getWidth()-70) / 7, (getHeight()-70) / 7, this);
	}

	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		for (int row = 0; row < 7; ++row)
			for (int col = 0; col < 7; ++col)
				drawCell(g, row, col);
	}
}
