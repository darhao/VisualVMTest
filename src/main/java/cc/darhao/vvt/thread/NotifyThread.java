package cc.darhao.vvt.thread;

import cc.darhao.vvt.mock.BusyMocker;

public class NotifyThread extends Thread {

	private Object lock;
	
	private long notifyDelay;
	
	
	public NotifyThread(Object lock, long notifyDelay) {
		this.notifyDelay = notifyDelay;
		this.lock = lock;
	}
	
	
	@Override
	public void run() {
		try {
			sleep(notifyDelay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (lock) {
			new BusyMocker().doSomething();
			lock.notifyAll();
		}
	}
	
}
