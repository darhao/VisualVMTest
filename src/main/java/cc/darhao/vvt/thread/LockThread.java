package cc.darhao.vvt.thread;

import cc.darhao.vvt.mock.BusyMocker;

public class LockThread extends Thread {

	private Object lock;
	
	public LockThread(Object lock) {
		this.lock = lock;
	}
	
	
	@Override
	public void run() {
		synchronized (lock) {
			new BusyMocker().doSomething();
		}
	}
	
}
