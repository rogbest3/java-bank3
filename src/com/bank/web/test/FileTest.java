package com.bank.web.test;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class FileTest {

	public static final String FILE_PATH = String.format("C:%sUsers%suser%seclipse-jee%sjee-bitcamp%sWebContent%sresources%stxt%s", 
															File.separator,File.separator,File.separator,File.separator,
															File.separator,File.separator,File.separator,File.separator);
	
	public static void main(String[] args) {
		try {
			File file = new File(FILE_PATH + "list.txt");	// file 인스턴스 생성
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuffer buff = new StringBuffer();
			String msg = "";
			List<String> list = new ArrayList<>();
			while(true) {
				switch (JOptionPane.showInputDialog("0.종료 1.저장 2.읽기")) {
				case "0" :
					JOptionPane.showMessageDialog(null, "종료"); return;

				case "1" :
					msg = JOptionPane.showInputDialog("메세지 입력. 데이터 사이에 , 입력");
					writer.write(msg);
					writer.newLine();
					writer.flush();		// 한번에 보냄
					break;
					
				case "2" :
					while( (msg = reader.readLine()) != null ) {
							list.add(msg + "/\n");
					}
					JOptionPane.showMessageDialog(null, list);
					reader.close();
					break;
				}
			}
		} catch(Exception e) {	// 에러 발생 직전에 동작(throw)하여 해당 객체만 예외 처리
			// 수정할 코드 들어가야함.


		}
		
	}

}
