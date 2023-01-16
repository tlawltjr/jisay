package jfcEx;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileAndColorCh extends JFrame{
	
	private JColorChooser jcc = new JColorChooser();
	private JFileChooser jfc = new JFileChooser("C:\\");
	
	public FileAndColorCh() {
		this.setSize(300,300);
		this.setLocation(300,300);
		this.setVisible(true);
		
		Color cc = jcc.showDialog(this, "색상선택",Color.blue);
		JOptionPane.showMessageDialog(this, cc);
		jcc.setColor(cc);
		
		System.out.println("선택한 컬러 : " + jcc.getColor());
		
		jfc.setDialogTitle("파일선택");
		jfc.setMultiSelectionEnabled(true);//다중선택 가능하도록 설정
		jfc.setApproveButtonToolTipText("파일을 선택하세요");
		//다이얼로그 창 보이기
		jfc.showDialog(this, "파일선택");
//		jfc.showOpenDialog(this);
//		jfc.showSaveDialog(this);
		
	}
	
	public static void main(String[] args) {
		FileAndColorCh s = new FileAndColorCh();
		
	}

}
