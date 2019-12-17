package Ppasseng;

import java.util.Random;

public class Main {
	
	public static final int SCREEN_WIDTH=1280;
	public static final int SCREEN_HEIGHT=720;
	
	public static void main(String args[]){
		int randnum;
		String str;
		Random random = new Random();
		
		new Frame_First();
		
		randnum = random.nextInt(3) + 1;
		str = Integer.toString(randnum);
		Music intromusic = new Music("intromusic" + str, true);
		intromusic.start();
		
	}
}
