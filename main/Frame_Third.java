package Ppasseng;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame_Third {

	FramePaint frame = new FramePaint();

	Fileout fileout;
	Filein filein;
	int mouseX, mouseY;
	int sco;
	String score, name;

	boolean isentered=false;
	
	public Frame_Third(int sco) {
		this.sco = sco;

		frame.background = new ImageIcon(Main.class.getResource("../image/endbackground.jpg")).getImage();
		frame.closeB = new JButton(frame.closebutton);
		frame._returnB = new JButton(frame.returnbutton);
		frame.endB = new JButton(frame.endbutton);

		frame.setUndecorated(true); // �������� �޴��ٰ� �����
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// ����Ʈ �����ͽ��� �׸� �̹����� �����
		frame.setLayout(null); // �Ͼ��?����?����
		frame.setVisible(true);

		// x��ư
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
		// x��ư

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
		// �޴���

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
				new Frame_First();
			}
		});
		frame.add(frame._returnB);

		frame.endB.setBounds(990, 560, 180, 40);
		frame.endB.setBorderPainted(false); // ��ư�׵θ�
		frame.endB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.endB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.endB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame.endB.setIcon(frame.endbutton);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500); // ����ǰ� �ִ� music �����带 0.5�� ����
				} catch (Exception ex) {
					ex.getMessage();
				}
				System.exit(0);
			}
		});
		frame.add(frame.endB);
		//////////////////////
		
		frame.resetfile.setBounds(1150, 430, 50, 24);
		//frame.resetfile.setBorderPainted(false); // ��ư�׵θ�
		frame.resetfile.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.resetfile.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.resetfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				
				filein.panel.setVisible(false);
				fileout = new Fileout(name, score,false);
				
			}
		});
		frame.add(frame.resetfile);

		
		//////////////////////
		frame.textbutton.setBounds(1105, 430, 40, 24);
		//frame.textbutton.setBorderPainted(false); // ��ư�׵θ�
		frame.textbutton.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.textbutton.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.textbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			
				if(!isentered){				//��ŷ����� �� ���� ����!!
				score = ("" + sco);
				name = frame.textname.getText();
				filein.panel.setVisible(false);
				fileout = new Fileout(name, score,true);
				filein=new Filein(frame);
				isentered=true;
				
				}
			}
		});
		frame.add(frame.textbutton);
		
		filein=new Filein(frame);
		
		frame.ranklabel.setBounds(890,60,150,30);
		frame.ranksquare.setBounds(890,90,360,300);
		frame.textname.setBounds(920, 430, 180,25);
		frame.writename.setBounds(910,400,180,20);
		frame.add(frame.ranklabel);
		frame.add(frame.ranksquare);
		frame.add(frame.textname);
		frame.add(frame.writename);
		

	}
}
