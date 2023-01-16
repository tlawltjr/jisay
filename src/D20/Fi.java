package D20;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.swing.JOptionPane;

public class Fi {
//	MemberDAO dao = dao.getInstance();
	File[] list;
	public void showMenu() {
	
	Properties pro = new Properties();
	Map<String, Integer> ha = new HashMap<String, Integer>();
	
	StringBuffer rankingString1 = new StringBuffer();
	StringBuffer rankingString = new StringBuffer();
	
	
	

		String path = "C:\\members\\";
		
		File dir = new File(path);
		

		
		
		
		if (dir.exists()) {this.list = dir.listFiles();}
//		List<Map<String,Object>> listMapInsert =new ArrayList<Map<String,Object>>();
			for (int i = 0; i < list.length; i++) {
				String id = list[i].getName();
				System.out.println(id.length());
				id.substring(0, id.indexOf('.')-1);
				System.out.println(id);

				try { 
					pro.load(new BufferedInputStream(new FileInputStream(path + id)));
					
				} catch (IOException e) {
					e.printStackTrace();
				}

				double win = Integer.parseInt(pro.getProperty("WIN"));
				int count = Integer.parseInt(pro.getProperty("CNT"));
				String name = pro.getProperty("ID");

				double rate = (win / count) * 100;

				ha.put(name, (int) rate);
//				
			}
//			listMapInsert.addAll((Collection<? extends Map<String, Object>>) ha);
//			System.out.println(listMapInsert.toString()+"!@#!$");
			List<String> keySet = new ArrayList<>(ha.keySet());
			
			
			
			
			keySet.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return (ha.get(o2)).compareTo(ha.get(o1));
				}
				
			});
			String[] fin= new String[20];
			for (String key2 : keySet) {
				rankingString1.append((keySet.indexOf(key2)+1)+"등   " + key2.substring(0 , key2.length()-3) + "*** 님    승률 : "
						+ ha.get(key2) + "%\n");
			
			}
			
			
			
			
//			System.out.println(keySet+keySet.subList(0, 1) +"!!!");
			System.out.println(ha.toString()+"!!!");
			System.out.println(keySet.toString()+"!@#$!@%");

			int a = list.length;// 총플레이어 수
		
			keySet.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return (ha.get(o1)).compareTo(ha.get(o2));
				}
				
			});
			for (String key : keySet) {
				
					rankingString.append((keySet.indexOf(key)+1)+"등   " + key.substring(0 , key.length()-3) + "*** 님    승률 : "
							+ ha.get(key) + "%\n");
					
				}
		

			while (true) {
				String[] menu = { "1.총 플레이어수", "2.승률 1위 플레이어", "3.랭킹(1위 부터)", "4.승률 꼴지부터 ", "5.종료" };
				int sele = JOptionPane.showOptionDialog(null, "메뉴를 골라주세요", "메뉴", 0, 0, null, menu, menu[2]);
				if (sele == 0) {
					JOptionPane.showMessageDialog(null, "총 " + a + "명이 플레이 했습니다");
					continue;
				} else if (sele == 1) {
					JOptionPane.showMessageDialog(null, "최고의 플레이어 " + keySet + "님" + "  승률 :" + ha.get(keySet));
					continue;
				} else if (sele == 2) {
					JOptionPane.showMessageDialog(null,rankingString);
					continue;
				} else if (sele == 3) {
					JOptionPane.showMessageDialog(null,rankingString1);
//					rankingString.reverse ();
					continue;

				} else {
					JOptionPane.showMessageDialog(null, "즐거웠습니다");
					break;
				}

			} // while end
		 // if end
	}// show end

}// class end
