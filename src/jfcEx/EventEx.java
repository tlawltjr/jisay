package jfcEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/*
 * 거의 대부분의 이벤트 종류(자주쓰는)
 * ActionEvent --> Action리스너
 * FocusEvent --> Focus리스너,FocusAdapter
 * Item 이벤트 --> Item리스너
 * Key 이벤트(키보드입력) --> key리스너
 * Mouse 이벤트 --> Mouse리스너
 * MouseMotion 이벤트 --> MouseMotion리스너, MouseMotionAdapter
 * Window 이벤트(프레임, 팝업, 다이얼로드등의 윈도우에서 발생되는 이벤트) --> 
 * Window리스너, WindowAdater
 * 
 * 이벤트를 구현하는 방법
 * 1.리스너를 구현한 클래스를 생성하여 이벤트 핸들러로 지정한다
 * 2.Adater 클래스를 상속받아 필요한 매서드만 오버라이드 후 핸들러로 지정한다
 * 3.무명클래스로 정의하여 필요한 매서드만 오버라이드한다
 */
//1번 Mouse리스너를 구현한 클래스 정의하기
class MyMouseListen implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스를 클릭했군요");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
class MyKeyAdt extends KeyAdapter{
	
	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println(e.getSource());
		System.out.println(e.getID());
		System.out.println(e.getKeyChar());
		System.out.println(new Date(e.getWhen()));
		System.out.println("타이핑 중이군요");
	}
}

public class EventEx extends JFrame{

	Container con;
	JButton close;
	JTextField jf;
	
	
	public EventEx() {
		start();
		
		this.setSize(300,300);
		this.add(close);
		this.setVisible(true);
		
		
	}
	void start() {
		//여기에선 이벤트 등록 및 구현 객체를 지정한다
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		close = new JButton("닫기");
		con.add("North", close);
		jf = new JTextField(20);
		jf.setBackground(Color.cyan);
		con.add("South", jf);
		close.addMouseListener(new MyMouseListen());
		jf.addKeyListener(new MyKeyAdt());
	}
	public static void main(String[] args) {
		//버튼에 이벤트를 등록한다
		new EventEx();
	}
}
