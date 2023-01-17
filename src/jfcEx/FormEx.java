package jfcEx;

import javax.swing.JFrame;

public class FormEx {
	
	public FormEx() {
		
	}

	public static void main(String[] args) {
		//JFrame을 구성하는 방법
		//1.생성자를 호출하여 구성하기
		//2.상속을 받아, 받은 클래스가 JFrame되기
		
		//프레임 객체를 생성합니다
		JFrame jf = new JFrame();
		//프레임에사이즈를 정함
		jf.setSize(300, 500);
		jf.setLocation(300, 300);
		jf.setVisible(true);
	}
}
