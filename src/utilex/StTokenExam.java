package utilex;

import java.util.StringTokenizer;

public class StTokenExam {

	public static void main(String[] args) {
		String msg ="Hell,Java,World/Jsp";
		
		StringTokenizer st = new StringTokenizer(msg, ",&/");
		
		System.out.println(st.countTokens());
		
		while(st.hasMoreTokens()) {
			String s = st.nextToken();
			System.out.println(s);
		}
		

	}

}
