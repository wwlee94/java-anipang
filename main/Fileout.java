package Ppasseng;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;

class Fileout {
	// ==========================//
	// 텍스트 파일 쓰기
	// ==========================//
	File outFilescore = new File("C:/Users/micke/Desktop/자료모음/자바/Anipang/text/rankscore.txt");
	File outFilename = new File("C:/Users/micke/Desktop/자료모음/자바/Anipang/text/rankname.txt");
	String s1,s2;
	boolean isnew;
	Fileout(String name, String score,boolean isnew) {
		s1=score+"\n";
		s2=name+"\n";
		BufferedWriter bw1,bw2;

		try {
			if(isnew==true){
				
			bw1 = new BufferedWriter(new FileWriter(outFilescore,true));
			bw1.write(s1);
			bw1.flush();
			bw1.close();
			
			bw2 = new BufferedWriter(new FileWriter(outFilename,true));
			bw2.write(s2);
			bw2.flush();
			bw2.close();
			}
			else if(isnew==false){
				bw1 = new BufferedWriter(new FileWriter(outFilescore));
				bw1.close();
				bw2= new BufferedWriter(new FileWriter(outFilename));
				bw2.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
	


