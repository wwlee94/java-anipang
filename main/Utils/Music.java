package Ppasseng;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javazoom.jl.player.Player;

public class Music extends Thread{		// 프로그램안에 작은 프로그램

	Player player;
	boolean loop;
	String name;
	File file;
	FileInputStream fis;				//바이트 형식으로 인풋스트림
	BufferedInputStream bis;			//메모리 버퍼를 생성시켜 - 성능 향상 속도향상 
	
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