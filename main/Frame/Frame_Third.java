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

		frame.setUndecorated(true); // 윈도우의 메뉴바가 사라짐
		frame.setTitle("frame");
		frame.setLocation(300, 150);
		frame.setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0, 0, 0, 0));// 페인트 컴포넌스로 그린 이미지뒷 배경이
		frame.setLayout(null); // 하얀색?투명?으로
		frame.setVisible(true);

		// x버튼
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
		// x버튼

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
		// 메뉴바

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
				new Frame_First();
			}
		});
		frame.add(frame._returnB);

		frame.endB.setBounds(990, 560, 180, 40);
		frame.endB.setBorderPainted(false); // 버튼테두리
		frame.endB.setContentAreaFilled(false); // 버튼영역배경표시
		frame.endB.setFocusPainted(false); // 포커스표시

		frame.endB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 해당버튼에서 나갔을때 아이콘 변경
				frame.endB.setIcon(frame.endbutton);
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
		frame.add(frame.endB);
		//////////////////////
		
		frame.resetfile.setBounds(1150, 430, 50, 24);
		//frame.resetfile.setBorderPainted(false); // 버튼테두리
		frame.resetfile.setContentAreaFilled(false); // 버튼영역배경표시
		frame.resetfile.setFocusPainted(false); // 포커스표시

		frame.resetfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
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
		//frame.textbutton.setBorderPainted(false); // 버튼테두리
		frame.textbutton.setContentAreaFilled(false); // 버튼영역배경표시
		frame.textbutton.setFocusPainted(false); // 포커스표시

		frame.textbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당 버튼에 올려져있을때 아이콘
														// 변경
				// frame.endB.setIcon(frame.endbuttonentered);
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonmusic = new Music("buttonmusic", false);
				buttonmusic.start();
			
				if(!isentered){				//랭킹등록은 한 번만 가능!!
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
