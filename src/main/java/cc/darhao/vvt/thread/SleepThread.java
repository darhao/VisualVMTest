package cc.darhao.vvt.thread;

public class SleepThread extends Thread {

	@Override
	public void run() {
		try {
			sleep(10* 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
