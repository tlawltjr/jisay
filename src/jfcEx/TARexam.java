package jfcEx;
/*
 * TextAera : 다중의 문자열을 담는 객체
 * 스크롤이 필요시 반드시 JScrollPane에 파라미터로 넘겨줘야 생성됩니다
 * 참고로 Vertical
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TARexam extends JFrame implements ActionListener, MouseListener{

	private Container con;
	private JLabel lb = new JLabel("메모장", JLabel.CENTER);
	private JButton bt = new JButton("확인");
	private JTextArea ta = new JTextArea();
	private JScrollPane jsp = new JScrollPane(ta);
	
	public TARexam() {
		init();
		start();
		this.setSize(300,200);
		this.setVisible(true);
	}

	private void init() {

		con = this.getContentPane();
		con.setLayout(new BorderLayout());
		con.add("North",lb);
		con.add("South",bt);
		//TextArea 의 메서드를 이용, 이벤트업시 간단한 조작 확인해보세요
		ta.setDragEnabled(true);
		ta.setFocusAccelerator('r');
		ta.setSelectedTextColor(Color.red);
		ta.setSelectionColor(Color.yellow);
		
		con.add(jsp);
	}

	private void start() {
		// TODO Auto-generated method stub
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//TextArea 객체에 마우스 이벤트 등록합니다
		ta.addMouseListener(this);
		
	}
	public static void main(String[] args) {
		new TARexam();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ta) {
			if(e.getClickCount() == 2) {
				ta.paste();
				//아래는 커서(caret)의 위치값을 찾는 메서드입니다
				System.out.println(ta.getCaretPosition());
				ta.moveCaretPosition(0);//내용의 처음으로 이동시킵니다
				ta.setEditable(false);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == ta) {
			//마우스 우클릭을 했는지 확인하는 메서드 호출
			if(e.isPopupTrigger()) {
				ta.copy();
				ta.setEditable(true);
				ta.setSelectionStart(3);
				ta.setSelectionEnd(7);
				ta.setText("심지석");
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
