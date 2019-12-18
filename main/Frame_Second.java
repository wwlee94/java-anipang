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
		
		frame.setUndecorated(true); // 윈도우의 메뉴바가 사라짐
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// 페인트 컴포넌스로 그린 이미지뒷 배경이							
		frame.setLayout(null);					   // 하얀색?투명?으로
		frame.setVisible(true);
		
		NumberCount countdown = new NumberCount(mHandler, frame , 15);		//카운트 쓰레드
		countdown.start();
		
		//x버튼
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
		//x버튼

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
		//메뉴바
		frame._returnB.setBounds(110, 570, 60, 60);
		frame._returnB.setBorderPainted(false); // 버튼테두리
		frame._returnB.setContentAreaFilled(false); // 버튼영역배경표시
		frame._returnB.setFocusPainted(false); // 포커스표시

		frame._returnB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame._returnB.setIcon(frame.returnbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
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
		
		//frame의 이미지,라벨 그리기
		
		imagepanel.addMouseListener(mHandler);
		imagepanel.addMouseMotionListener(mHandler);
		imagepanel.setBounds(395, 115, 490, 490);//크기 설정
		frame.add(imagepanel);
		//frame.puzzlesquare.setBounds(375,95,530,530);
		//frame.add(frame.puzzlesquare);

		mHandler.score2.setBounds(120, 95, 200, 100);
		mHandler.score2.setFont(new Font("고딕", Font.BOLD, 40));
		frame.add(mHandler.score2);
		mHandler.combo2.setBounds(990, 95, 200, 100);
		mHandler.combo2.setFont(new Font("고딕", Font.BOLD, 40));
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
