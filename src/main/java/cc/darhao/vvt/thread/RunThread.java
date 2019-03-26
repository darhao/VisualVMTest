package cc.darhao.vvt.thread;

import cc.darhao.vvt.mock.BusyMocker;

public class RunThread extends Thread {

	@Override
	public void run() {
		new BusyMocker().doSomething();
	}
	
}
