package Ppasseng;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Filein {
	// ==========================//
	// �ؽ�Ʈ ���� �б�
	// ==========================//
	File inFilescore = new File("C:/Users/micke/Desktop/�ڷ����/�ڹ�/Anipang/text/rankscore.txt");
	File inFilename = new File("C:/Users/micke/Desktop/�ڷ����/�ڹ�/Anipang/text/rankname.txt");

	FramePaint frame;
	
	JPanel panel=new JPanel();
	
	int number[] = new int[8];
	int cycle = 0;
	int tmp;
	String stmp;
	int max;
	String s;
	String score[] = new String[8];
	String name[] = new String[8];

	Filein(FramePaint frame_third) {

		try {

			frame = frame_third;

			Scanner scan1 = new Scanner(inFilescore);
			Scanner scan2 = new Scanner(inFilename);
		

			while (scan2.hasNext()) { // �̸��� ������ �ֳ� ���� ����� ������ ������ while���� ��� ����
				name[cycle] = scan2.nextLine();
				score[cycle] = scan1.nextLine(); 					// ������ �����ϱ� ����������� ���� �о temp
				s = new String();
				stmp = new String();
				
				for (int i = 0; i < score[cycle].length(); i++) {
					if (48 <= score[cycle].charAt(i) && 57 >= score[cycle].charAt(i)) { // �ƽ�Ű
																						// 48==0
																						// 57==9
						s = s + score[cycle].charAt(i);
					}
				}
				number[cycle] = Integer.parseInt(s);

				for (int i = 0; i < 8; i++) {
					max = i;
					for (int j = i; j < 8; j++) {
						if (number[i] < number[j]) {
							max = j;
						}
					}
					tmp = number[max];
					number[max] = number[i];
					number[i] = tmp; // score�� ������ �ٲ��ָ�
					
					stmp=name[max];
					name[max]=name[i];
					name[i]=stmp;	//name�� ������ �����Ѵ�!
					
				}
				cycle++; // ������ ����� �̾� ���ϴ�.
			}
			
			for(int i=0;i<cycle;i++){
				frame.player[i] = new JLabel(i+1+"��. ����: " + number[i]+" �̸�: "+name[i]);
				frame.player[i].setFont(new Font("���", Font.ITALIC, 20));
				frame.player[i].setBounds(930, 110 + (i * 30), 300, 30);
				
				panel.setBounds(885, 105, 350, 300);
				
				panel.setBackground(new Color(255, 0, 0, 0));    //����
				
				panel.add(frame.player[i]);
			}
			frame.add(panel);
		
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
