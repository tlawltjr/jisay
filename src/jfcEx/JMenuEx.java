package jfcEx;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class JMenuEx extends JFrame{

	//menuBar 생성
	JMenuBar jbm = new JMenuBar();
	//구성될 메뉴 생성
	JMenu file = new JMenu("파일");
	JMenuItem fnew = new JMenuItem("새파일");
	
	ImageIcon im = new ImageIcon("img2.jpg");
	JMenuItem fopen = new JMenuItem("파일열기",im);
	
	ImageIcon im1 = new ImageIcon("img.jpg");
	JMenuItem fexit = new JMenuItem("종료",im1);
	
	JMenu edit = new JMenu("편집");
	JMenu eSize = new JMenu("크기");
	
	JRadioButtonMenuItem es10 = new JRadioButtonMenuItem("10");
	JRadioButtonMenuItem es20 = new JRadioButtonMenuItem("20");
	JRadioButtonMenuItem es30 = new JRadioButtonMenuItem("30");
	
	ButtonGroup bg = new ButtonGroup();
	
	JMenu ecolor = new JMenu("컬러");
	JCheckBoxMenuItem ecred = new JCheckBoxMenuItem("RED");
	JCheckBoxMenuItem ecgreen = new JCheckBoxMenuItem("Green");
	JCheckBoxMenuItem ecblue = new JCheckBoxMenuItem("Blue");
	
	JMenu help = new JMenu("도움말");
	
	public JMenuEx() {
		super("이건 메뉴 예제");
		init();
		start();
		this.setSize(300,300);
		this.setVisible(true);
	}
	private void init() {
		//프레임에 메뉴바를 부착합니다
		this.setJMenuBar(jbm);
		fexit.setArmed(true);
		//파일 메뉴에 아이템 추가하기
		file.add(fnew);
		//구분선 넣기
		file.addSeparator();
		file.add(fopen);
		file.addSeparator();
		file.add(fexit);
		//메뉴에 아이템 모두 add 했으면, 메뉴바에 메뉴 붙이기
		jbm.add(file);
		
		//라디오메뉴아이템은 토글로 만들어야 하기때문에
		//ButtonGroup으로 묶어 줍니다
		bg.add(es10);
		bg.add(es20);
		bg.add(es30);
		
		//크기 메뉴 아이템 등록
		eSize.add(es10);
		eSize.add(es20);
		eSize.add(es30);
		
		//메뉴에 메뉴 넣기
		edit.add(eSize);
		edit.addSeparator();
		ecolor.add(ecblue);
		ecolor.add(ecred);
		ecolor.add(ecgreen);
		
		//편집 메뉴에 컬러 메뉴를 add
		edit.add(ecolor);
		
		//메뉴바에 메뉴 add
		jbm.add(edit);
		//help메뉴 add
		jbm.add(help);
	}
	private void start() {
		fexit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				System.out.println(e.getSource());
				System.out.println(e.getActionCommand());
				//System.exit(0);
				if(e.getSource() == fexit) {
					System.out.println("종료한다고 합니다");
				}
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new JMenuEx();
	}
}
