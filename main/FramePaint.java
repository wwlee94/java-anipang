package Ppasseng;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class FramePaint extends JFrame {
	Image Image;
	Graphics Graphic;
	
	ImageIcon closebutton = new ImageIcon(Main.class.getResource("../image/closebutton.png"));
	ImageIcon closebuttonentered = new ImageIcon(Main.class.getResource("../image/closebuttonentered.png"));
	ImageIcon startbutton = new ImageIcon(Main.class.getResource("../image/startbutton.png"));
	ImageIcon startbuttonentered = new ImageIcon(Main.class.getResource("../image/startbuttonentered.png"));
	ImageIcon exitbutton = new ImageIcon(Main.class.getResource("../image/exitbutton.png"));
	ImageIcon exitbuttonentered = new ImageIcon(Main.class.getResource("../image/exitbuttonentered.png"));
	ImageIcon returnbutton = new ImageIcon(Main.class.getResource("../image/returnbutton.png"));
	ImageIcon returnbuttonentered = new ImageIcon(Main.class.getResource("../image/returnbuttonentered.png"));
	ImageIcon endbutton = new ImageIcon(Main.class.getResource("../image/endbutton.png"));
	ImageIcon endbuttonentered = new ImageIcon(Main.class.getResource("../image/endbuttonentered.png"));
	
	Image background ; 					//changevisible
	
	JLabel countnumber=new JLabel();	//changevisible
	JLabel timefont=new JLabel(new ImageIcon(Main.class.getResource("../image/timefont.png")));				//fixvisible
	JLabel timeicon=new JLabel(new ImageIcon(Main.class.getResource("../image/timeicon.png")));				//fixvisible
	JLabel puzzlesquare=new JLabel(new ImageIcon(Main.class.getResource("../image/puzzlesquare.png")));					//fixvisible
	
	JLabel writename=new JLabel(new ImageIcon(Main.class.getResource("../image/writename.png")));			//fixvisible
	JLabel ranksquare=new JLabel(new ImageIcon(Main.class.getResource("../image/ranksquare.png")));					//fixvisible
	JLabel ranklabel=new JLabel(new ImageIcon(Main.class.getResource("../image/ranklabel.png")));	
	JTextField textname=new JTextField(); //����� �̸� �Է¹���
	JButton textbutton=new JButton(new ImageIcon(Main.class.getResource("../image/ok.png")));	//text���� ������� ��ư
	JButton resetfile=new JButton(new ImageIcon(Main.class.getResource("../image/filereset.png")));  //text���� ����
	
	JLabel player[]=new JLabel[8];
	JLabel score = new JLabel(new ImageIcon(Main.class.getResource("../image/score.png")));					//fixvisible
	JLabel combo = new JLabel(new ImageIcon(Main.class.getResource("../image/combo.png")));					//fixvisible
	JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../image/menubar.png")));				//fixvisible

	JButton closeB;	//changevisible
	JButton startB;	//changevisible
	JButton exitB;		//changevisible
	JButton _returnB;		//changevisible
	JButton endB;		//changevisible


	public void paint(Graphics g) { // ù��°�� ȭ���� �׷��ִ� �Լ�
		super.paint(g);
		Image = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ��ũ�� ũ�⸸ŭ									
		Graphic = Image.getGraphics(); 							   // �̹����� ����
		draw(Graphic);
		g.drawImage(Image, 0, 0, null); 
	}

	public void draw(Graphics g) {
		g.drawImage(background, 0, 0, null); // ��Ʈ�ι�׶��带 0,0�� ��ġ�� �׷��ش�
		this.paintComponents(g);
		this.repaint();
	}
}
