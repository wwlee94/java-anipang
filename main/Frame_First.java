package Ppasseng;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame_First {

	FramePaint frame;

	int mouseX, mouseY; 
	
	public Frame_First() {
		//frame �ʱ�ȭ �κ�
		frame=new FramePaint();
		frame.background = new ImageIcon(Main.class.getResource("../image/introbackground.jpg")).getImage();
		frame.closeB = new JButton(frame.closebutton);
		frame.startB = new JButton(frame.startbutton);
		frame.exitB = new JButton(frame.exitbutton);

		// frame �ʱ�ȭ �κ�

		frame.setUndecorated(true); // �������� �޴��ٰ� �����
		frame.setTitle("frame_first");
		frame.setLocation(300, 150);
		frame.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// ����Ʈ �����ͽ��� �׸� �̹����� �����							
		frame.setLayout(null);					   // �Ͼ��?����?����
		frame.setVisible(true);

		// �޴��� x������

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

		// start��ư
		frame.startB.setBounds(390, 340, 200, 50);
		frame.startB.setBorderPainted(false); // ��ư�׵θ�
		frame.startB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.startB.setFocusPainted(false); // ��Ŀ��ǥ��
		frame.startB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.startB.setIcon(frame.startbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame.startB.setIcon(frame.startbutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {

				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();

				frame.dispose();
				new Frame_Second();
			}
		});
		frame.add(frame.startB);

		frame.exitB.setBounds(650, 340, 200, 50);
		frame.exitB.setBorderPainted(false); // ��ư�׵θ�
		frame.exitB.setContentAreaFilled(false); // ��ư�������ǥ��
		frame.exitB.setFocusPainted(false); // ��Ŀ��ǥ��

		frame.exitB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش� ��ư�� �÷��������� ������
														// ����
				frame.exitB.setIcon(frame.exitbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� �ش��ư���� �������� ������ ����
				frame.exitB.setIcon(frame.exitbutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
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
		frame.add(frame.exitB);

	} // ���� �ִ��� Anipang�ܰ��� �ִ� �Լ���

}
