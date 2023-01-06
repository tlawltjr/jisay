package utilex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExam {

	private static void doSome(List list) {
		for(int i = 0; i<list.size(); i++) {
			//doSome..
		}
	}
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Value");
		//Logic..
		if(false) {
			doSome(a);
		}else {
			//doSome(new ArrayList<String>());
			doSome(Collections.EMPTY_LIST);
		}

	}

}
