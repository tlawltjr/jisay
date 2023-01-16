package jfcEx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaEx extends JFrame {

	Container con;
	JButton bt = new JButton("1");
	JButton bt1 = new JButton("2");
	JTextArea ta = new JTextArea();
	JScrollPane jsp = new JScrollPane(ta);// 스크롤이 필요한 컴포넌트를 파라미터로 준다

	public JTextAreaEx() {
		init();
		start();
		this.setSize(300, 300);
		this.setLocation(300, 300);
		this.setVisible(true);

	}

	private void init() {
		// TODO Auto-generated method stub
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		// JPane1 --> 컨테이너의 일종 여기에 컴포넌트를 붙인 후 프레임이나
		// 다른 컨테이너에 부탁하는데 사용되는 중간 컨테이너임

		JPanel jp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jp.add(bt);
		jp.add(bt1);

		// 구성된 컨테이너 jp를 Frame 컨테이너에 부착한다
		con.add("North", jp);// BorderLayout의 방위 값은 반드시 "첫자는 대문자"여야함
		jsp.setWheelScrollingEnabled(true);
		con.add("Center", jsp);
	}

	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		JTextAreaEx d = new JTextAreaEx();

	}

}
