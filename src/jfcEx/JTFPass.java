package jfcEx;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTFPass extends JFrame implements ActionListener{

	Container con;
	JTextArea ta = new JTextArea("asdasd");
	JScrollPane jsp = new JScrollPane(ta);
	JLabel lb = new JLabel("ID : ", JLabel.RIGHT);
	JTextField tf = new JTextField();
	JLabel lb1 = new JLabel("Pass : ", JLabel.RIGHT);
	JPasswordField jpf = new JPasswordField();
	
	public JTFPass() {
		init();
		start();
		this.setSize(300,200);
		this.setVisible(true);
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		ta.replaceRange("ABCD", 0, 4);//0~4까지의 문자열을 "ABCD"로 변경함
	}
	private void init() {
		// TODO Auto-generated method stub
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		
		//JPanel(컨테이너)를 이용해서 다른 컴포넌트를 부착시킵니다
		//이것도 컨테이너기에 배치가 필요합니다. 그래서 생성시 보더레이아웃으로 배치 지정합니다
		JPanel jp = new JPanel(new BorderLayout());
		
		jp.add("West",lb);
		tf.setHorizontalAlignment(JTextField.CENTER);
		jp.add("Center",tf);
		jp.setBackground(Color.yellow);
		
		JPanel jp1 = new JPanel(new BorderLayout());
		jp1.setBackground(Color.blue);
		jp1.add("West",lb1);
		//암호필드에 값 입력시 입력값을 대체하는 문자 지정 abcd로 입력하면 지정된 문자로 표시됩니다 간단히 메서드로 가능합니다
		jpf.setEchoChar('&');
		jp1.add("Center",jpf);
		con.add("South",jp1);
		con.add("North",jp);
		con.add("Center",jsp);
	}
	private void start() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTFPass();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jpf) {
			String str = new String(jpf.getPassword());
			System.out.println("비밀번호 : " + str);
		}
	}
}
