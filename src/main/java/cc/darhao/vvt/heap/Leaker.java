package cc.darhao.vvt.heap;

import java.util.ArrayList;
import java.util.List;

public class Leaker {

	private static List<MyClass> classes = new ArrayList<>();
	
	public Leaker() {
		classes.add(new MyClass());
	}
	
}
