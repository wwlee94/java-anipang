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
		//frame 초기화 부분
		frame=new FramePaint();
		frame.background = new ImageIcon(Main.class.getResource("../image/introbackground.jpg")).getImage();
		frame.closeB = new JButton(frame.closebutton);
		frame.startB = new JButton(frame.startbutton);
		frame.exitB = new JButton(frame.exitbutton);

		// frame 초기화 부분

		frame.setUndecorated(true); // 윈도우의 메뉴바가 사라짐
		frame.setTitle("frame_first");
		frame.setLocation(300, 150);
		frame.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// 페인트 컴포넌스로 그린 이미지뒷 배경이							
		frame.setLayout(null);					   // 하얀색?투명?으로
		frame.setVisible(true);

		// 메뉴바 x아이콘

		frame.closeB.setBounds(1242, 1, 27, 27);
		frame.closeB.setBorderPainted(false); // 버튼테두리
		frame.closeB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.closeB.setFocusPainted(false); // 포커스표시
		frame.closeB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.closeB.setIcon(frame.closebuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
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

		// 메뉴바
		frame.menubar.setBounds(0, 0, 1280, 30);
		frame.menubar.addMouseListener(new MouseAdapter() { // 메뉴바의 이벤트
			@Override
			public void mousePressed(MouseEvent e) { // 마우스가 메뉴바를 눌렀을때
				mouseX = e.getX(); // 누른 마우스의 x,y좌표를 가져옴
				mouseY = e.getY();
			}
		});
		frame.menubar.addMouseMotionListener(new MouseMotionAdapter() { // 메뉴바
																		// 움직임
																		// 이벤트
			@Override
			public void mouseDragged(MouseEvent e) {
				int screenX = e.getXOnScreen(); // 드래드할 때 현재 스크린의 x,y좌표 가져옴
				int screenY = e.getYOnScreen();
				frame.setLocation(screenX - mouseX, screenY - mouseY);
			}
		});
		frame.add(frame.menubar);

		// start버튼
		frame.startB.setBounds(390, 340, 200, 50);
		frame.startB.setBorderPainted(false); // 버튼테두리
		frame.startB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.startB.setFocusPainted(false); // 포커스표시
		frame.startB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.startB.setIcon(frame.startbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
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
		frame.exitB.setBorderPainted(false); // 버튼테두리
		frame.exitB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.exitB.setFocusPainted(false); // 포커스표시

		frame.exitB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.exitB.setIcon(frame.exitbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.exitB.setIcon(frame.exitbutton);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
				try {
					Thread.sleep(500); // 재생되고 있는 music 쓰레드를 0.5초 지연
				} catch (Exception ex) {
					ex.getMessage();
				}

				System.exit(0);
			}
		});
		frame.add(frame.exitB);

	} // 밑은 애니팡 Anipang외곽에 있는 함수임

}
