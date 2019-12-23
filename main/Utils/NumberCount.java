package Ppasseng;

import javax.swing.ImageIcon;

public class NumberCount extends Thread {

	PuzzlePaint imagepanel = new PuzzlePaint();
	
	FramePaint frame_second=new FramePaint();
	
	MouseHandler mHandler;
	
	int score;
	long sec;
	long start;
	long old;
	long cur = 0;
	long time;
	
	public NumberCount(MouseHandler mHandler,FramePaint frame_second,long sec) {
		this.mHandler=mHandler;
		this.frame_second=frame_second;
		this.sec = sec;
	}
	
	public void run() {
		try{
			time=sec;
			start = System.currentTimeMillis();
			
		while(cur<=sec){
			if(System.currentTimeMillis()-start-cur*1000>=1000){
				process();
				cur++;
			}
		}
		processEnd();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void process() {
		frame_second.countnumber.setIcon(new ImageIcon(Main.class.getResource("../number/num"+time+".png")));
		time=time-1;
	}
	public void processEnd() {
		score=mHandler.score;
		frame_second.dispose();
		new Frame_Third(score);
	}
	
}
