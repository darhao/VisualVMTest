package cc.darhao.vvt.mock;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 忙碌模拟器
 * <br>
 * <b>2019年3月25日</b>
 * @author 几米物联自动化部-洪达浩
 */
public class BusyMocker {

	public void doSomething() {
		for (int i = 0; i < 50; i++) {
			byte[] bytes = new byte[1024 * 1024 * 200];
			FileInputStream fis;
			try {
				fis = new FileInputStream("data");
				fis.read(bytes);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
