package jfcEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

public class FormEx2_Event extends JFrame {
	
	private Container con;
	//Icon타입 중에 이미지 Icon 객체를 이용해서 Image를 얻어냅니다
	private ImageIcon im;
	private ImageIcon img;
	
	JButton bt1 = new JButton("이건 버튼입니다");
	JButton bt2 = new JButton("이건 버튼입니다");
	JButton bt3 = new JButton("이건 버튼입니다");
	JButton bt4 = new JButton("이건 버튼입니다");
	JButton bt5;
	
	public FormEx2_Event() {
		super("이건 JFrame 타이틀 제목입니다");
		init(); //--> 초기화 메서드 호출해서 레이아웃이나, 컨테이너에 불틸
		//컴포넌트를 add하거나 생성하는 작업을 수행합니다
		start();//이벤트연결, 등록 및 쓰래드 작업등, 컨테이너가 화면에 보이기 전에
		//수행할 작업등을 정의합니다
		
		this.setIconImage(im.getImage());
		this.setSize(300, 200);
		
		//이번엔 영역객체인 Dimension을 이용해서 프레임을 화면 중간에 띄웁니다
		//이때 사용하는 대표적 객체가 Toolkit이라는 객체입니다
		//static메서드를 이용해서 얻어내는데, 화면의 크기, 해상도, 음성 출력등
		//사스템에 전반적인 내용을 리턴하는 객체입니다
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		Dimension dm1 = this.getSize();
		
		int x = (int)(dm.getWidth()/2 - dm1.getWidth()/2);
		int y = (int)(dm.getHeight()/2 - dm1.getHeight()/2);
		
		//좌표값을 정의한 point 객체를 이용해서 위 좌표값을 설정함
		Point p = new Point(x, y);
		
		this.setLocation(p);
		this.setVisible(true);
		
	}
	public void init() {
		im = new ImageIcon("img.jpg");
		img = new ImageIcon("img2.jpg");
		//JFrame에서 contentPane()을 호출하여 Container를 얻어낸다
		//이 위에 컴포넌트를 부탁한다
		con = this.getContentPane();
		//배치관리자를 컨테이너에 지정합니다. FlowLayout 배치관리자입니다
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		bt5 = new JButton("이건 버튼입니다", im);
		
		bt1.setEnabled(false);
		bt2.setMnemonic('a');
		bt3.setHorizontalAlignment(SwingConstants.RIGHT);
		bt4.setVerticalAlignment(SwingConstants.TOP);
		bt5.setMnemonic('b');
		
		bt1.setPressedIcon(img);
		bt1.setRolloverIcon(im);
		
		con.add(bt1);
		con.add(bt2);
		con.add(bt3);
		con.add(bt4);
		con.add(bt5);
	}

	//x를 누르면 프로그램 종료하도록 이벤트를 적용합니다
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//컴포넌트에 이벤트를 등록한다 addXXXListener(구현 객체)를 이용하면 된다
		bt1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//마우스가 클릭되면 자동호출되는 메서드입니다.
				System.out.println(e);
				System.out.println(e.getSource() + "를 클릭했습니다");
				//이벤트 대상 객체를 찾아보기  getSource()
				if(e.getSource() == bt1) {
					//bt버튼을 활성화 시키고, 5초 동안 지가 지를 클릭하도록 만듭니다
					bt1.setEnabled(true);
					bt1.doClick();
				}
				
			}
		});
	}
	
	public static void main(String[] args) {
		new FormEx2_Event();
		//JFrame을 구성하는 방법
		//1.생성자를 호출하여 구성하기
		//2.상속을 받아, 받은 클래스가 JFrame되기
		
		//프레임 객체를 생성합니다
//		JFrame jf = new JFrame();
		//프레임에사이즈를 정함
//		jf.setSize(300, 500);
//		jf.setLocation(300, 300);
//		jf.setVisible(true);
	}
}
