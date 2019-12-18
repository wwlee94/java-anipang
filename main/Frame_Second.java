package Ppasseng;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame_Second {

	FramePaint frame=new FramePaint();
	
	PuzzlePaint imagepanel = new PuzzlePaint();
	MouseHandler mHandler = new MouseHandler(imagepanel);
	
	int mouseX, mouseY;
	
	public Frame_Second(){
		
		frame.closeB = new JButton(frame.closebutton);
		frame._returnB=new JButton(frame.returnbutton);
		frame.background = new ImageIcon(Main.class.getResource("../image/startbackground.jpg")).getImage();
		
		frame.setUndecorated(true); // �������� �޴��ٰ� �����
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// ����Ʈ �����ͽ��� �׸� �̹����� �����							
		frame.setLayout(null);					   // �Ͼ��?����?����
		frame.setVisible(true);
		
		NumberCount countdown = new NumberCount(mHandler, frame , 15);		//ī��Ʈ ������
		countdown.start();
		
		//x��ư
		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // ��ư�׵θ�
		frame.closeB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.closeB.setFocusPainted(false); // ��Ŀ��ǥ��
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame.closeB.setIcon(frame.closebutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.closeB);
		//x��ư

		// �޴���
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // �޴����� �̺�Ʈ
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� �޴��ٸ� ��������
				mouseX = e.getX(); // ���� ���콺�� x,y��ǥ�� ������
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // �޴���
																		// ������
																		// �̺�Ʈ
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // �巡���� �� ���� ��ũ���� x,y��ǥ ������
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});
		
		frame.add(frame.menubar);
		//�޴���
		frame._returnB.setBounds(110, 570, 60, 60);
		frame._returnB.setBorderPainted(false); // ��ư�׵θ�
		frame._returnB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame._returnB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame._returnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame._returnB.setIcon(frame.returnbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame._returnB.setIcon(frame.returnbutton);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				
				frame.dispose();
				countdown.stop();
				new Frame_First();
			}
		});
		frame.add(frame._returnB);
		
		//frame�� �̹���,�� �׸���
		
		imagepanel.addMouseListener(mHandler);
		imagepanel.addMouseMotionListener(mHandler);
		imagepanel.setBounds(395, 115, 490, 490);//ũ�� ����
		frame.add(imagepanel);
		//frame.puzzlesquare.setBounds(375,95,530,530);
		//frame.add(frame.puzzlesquare);

		mHandler.score2.setBounds(120, 95, 200, 100);
		mHandler.score2.setFont(new Font("���", Font.BOLD, 40));
		frame.add(mHandler.score2);
		mHandler.combo2.setBounds(990, 95, 200, 100);
		mHandler.combo2.setFont(new Font("���", Font.BOLD, 40));
		frame.add(mHandler.combo2);

		frame.score.setBounds(90, 55, 205, 70);
		frame.combo.setBounds(970, 55, 205, 70);
		frame.countnumber.setBounds(1022, 340, 100, 100);
		frame.timeicon.setBounds(965, 325, 50, 50);
		frame.timefont.setBounds(1018,321,100,25);
		frame.add(frame.score);
		frame.add(frame.combo);
		frame.add(frame.countnumber);
		frame.add(frame.timeicon);
		frame.add(frame.timefont);
	}
}
