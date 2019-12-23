package Ppasseng;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javazoom.jl.player.Player;

public class Music extends Thread{		// ���α׷��ȿ� ���� ���α׷�

	Player player;
	boolean loop;
	String name;
	File file;
	FileInputStream fis;				//����Ʈ �������� ��ǲ��Ʈ��
	BufferedInputStream bis;			//�޸� ���۸� �������� - ���� ��� �ӵ���� 
	
	int randomnum;
	String str;
 public Music(String name,boolean loop){
		this.loop=loop;
		this.name=name;
}
	public void close(){
		loop=false;
		player.close();
		this.interrupt();
	}
	@Override
	public void run(){			//Thread
		try{
			do{
				file=new File(Main.class.getResource("../music/" + name +".mp3").toURI());
				fis=new FileInputStream(file);  
				player =new Player(fis);
				player.play();
			}while(loop);
		}catch(Exception e){
		System.out.println(e.getMessage());
	}
}
}