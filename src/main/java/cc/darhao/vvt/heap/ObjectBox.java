package cc.darhao.vvt.heap;

import java.util.ArrayList;
import java.util.List;

public class ObjectBox {

	private List<MyClass> myClasses;
	
	
	public ObjectBox() {
		myClasses = new ArrayList<>();
	}
	
	
	public void create() {
		myClasses.add(new MyClass());
	}
	
	
	public void destory() {
		if(myClasses.size() != 0) {
			myClasses.remove(0);
		}
	}
	
}
