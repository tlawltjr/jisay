package jfcEx;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class JDialogEx extends JFrame implements ActionListener{

	private Container con;
	private FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
	private JLabel lb = new JLabel("ID : " + JLabel.LEFT);
	private JTextField jf = new JTextField(10);
	private JDialog jd = new JDialog(this, "팝업창");
	private Container dlgcon;//Dialog도 컨테이너 타입이기 때문에 배치 관리자 및 컨테이너가 필요함. dlgcon은 다이얼로그 배치 컨테이너로 사용됨
	JLabel dlglb = new JLabel("사용 가능한 ID입니다",JLabel.CENTER);
	BorderLayout bd = new BorderLayout();
	
	public JDialogEx() {
		init();
		start();
		this.setSize(300,300);
		this.setLocation(300,300);
		this.setVisible(true);
	}
	private void init() {
		con = this.getContentPane();
		con.setLayout(fl);
		con.add(lb);
		con.add(jf);
		
		
		//다이얼로그에도 컴포넌트를 add시키려면 작업대인 Contaiber가 필요합니다
		dlgcon = jd.getContentPane();
		//레이아웃지정
		dlgcon.setLayout(bd);
		//다이얼로그에 라벨 add
		dlgcon.add("Center",dlglb);
		jd.setSize(200,200);
		jd.setLocation(500,500);
	}
	private void start() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//텍스트박스에 액션 이벤트 연동합니다
		jf.addActionListener(this);
		jd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//숨기란 뜻
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jf) {
			jd.setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new JDialogEx();
	}
}
