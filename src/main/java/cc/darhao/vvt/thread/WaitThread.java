package cc.darhao.vvt.thread;

import cc.darhao.vvt.mock.BusyMocker;

public class WaitThread extends Thread {

	private Object lock;
	
	public WaitThread(Object lock) {
		this.lock = lock;
	}
	
	
	@Override
	public void run() {
		synchronized (lock) {
			BusyMocker busyMocker = new BusyMocker();
			busyMocker.doSomething();
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			busyMocker.doSomething();
		}
	}
	
}
