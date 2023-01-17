package jfcEx;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FormEx1 extends JFrame {
	
	private Container con;
	
	private ImageIcon im;
	
	
	public FormEx1() {
		super("이건 JFrame 타이틀 제목입니다");
		init(); //--> 초기화 메서드 호출해서 레이아웃이나, 컨테이너에 불틸
		//컴포넌트를 add하거나 생성하는 작업을 수행합니다
		start();//이벤트연결, 등록 및 쓰래드 작업등, 컨테이너가 화면에 보이기 전에
		//수행할 작업등을 정의합니다
		im = new ImageIcon("img.jpg");
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
		//JFrame에서 contentPane()을 호출하여 Container를 얻어낸다
		//이 위에 컴포넌트를 부탁한다
		con = this.getContentPane();
	}

	//x를 누르면 프로그램 종료하도록 이벤트를 적용합니다
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new FormEx1();
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
