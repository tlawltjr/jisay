package jfcEx;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOpPanelEx extends JFrame{

	Container con;
	JOptionPane jop = new JOptionPane();
	
	public JOpPanelEx() {
		init();
		start();
		this.setSize(300, 300);
		this.setLocation(100, 100);
		this.setVisible(true);
		
		//JOptionPane은 Dailog의 일종입니다. 그래서 기본적으로는
		//자신을 열어준 부모 컴포넌트를 주도록 되어있습니다
		System.out.println(JOptionPane.showConfirmDialog(this, "저장할래","저장",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,new ImageIcon("img2.jpg")));
		
		jop.showMessageDialog(this, "오류발생함","오류",JOptionPane.ERROR_MESSAGE);
		
		String[] str = {"a","b","c","d","e","f"};
		
		System.out.println(jop.showOptionDialog(this, "선택해요", "물건선택", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, str, "a"));
	}

	private void init() {
		// TODO Auto-generated method stub
		con = this.getContentPane();
		con.setLayout(new BorderLayout());
	}

	private void start() {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new JOpPanelEx();
	}
}
