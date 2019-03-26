package cc.darhao.vvt.main;

import java.util.Scanner;

import cc.darhao.vvt.cpu.MethodCaller;
import cc.darhao.vvt.heap.ObjectBox;
import cc.darhao.vvt.jdbc.JDBCCaller;
import cc.darhao.vvt.thread.LockThread;
import cc.darhao.vvt.thread.NotifyThread;
import cc.darhao.vvt.thread.RunThread;
import cc.darhao.vvt.thread.SleepThread;
import cc.darhao.vvt.thread.WaitThread;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("0：线程运行测试；1：线程睡眠测试；2：线程锁测试；3：线程通知测试, 4：函数调用耗时测试, 5：对象存活测试, 6：查询DB");
		while(true) {
			int commandId = scanner.nextInt();
			switch (commandId) {
			case 0:
				runTest();
				break;
			case 1:
				sleepTest();
				break;
			case 2:
				lockTest();
				break;
			case 3:
				notifyTest();
				break;
			case 4:
				MethodCallTest();
				break;
			case 5:
				objectLiveTest();
				break;
			case 6:
				jdbcTest();
				break;
			default:
				scanner.close();
				return;
			}
		}
	}
	
	
	private static void jdbcTest() {
		JDBCCaller caller = new JDBCCaller();
		try {
			caller.exeQuery();
			Thread.sleep(5000);
			caller.exeQuery();
			Thread.sleep(5000);
			caller.exeQuery();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void objectLiveTest() throws InterruptedException {
		ObjectBox box = new ObjectBox();
		for (int i = 0; i < 10; i++) {
			box.create();
			Thread.sleep(2000);
		}
		for (int i = 0; i < 10; i++) {
			box.destory();
			Thread.sleep(2000);
		}
	}


	private static void MethodCallTest() {
		new MethodCaller();
	}


	private static void lockTest() {
		Object lock = new Object();
		LockThread t1 = new LockThread(lock);
		t1.setName("LockThread-1");
		LockThread t2 = new LockThread(lock);
		t2.setName("LockThread-2");
		LockThread t3 = new LockThread(lock);
		t3.setName("LockThread-3");
		LockThread t4 = new LockThread(lock);
		t4.setName("LockThread-4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}


	private static void sleepTest() {
		SleepThread t1 = new SleepThread();
		t1.setName("SleepThread-1");
		t1.start();
	}

	
	private static void notifyTest() throws InterruptedException {
		Object lock = new Object();
		WaitThread t1 = new WaitThread(lock);
		t1.setName("waitThread");
		t1.start();
		NotifyThread t2 = new NotifyThread(lock, 10*1000);
		t2.setName("notifyThread");
		t2.start();
	}

	
	private static void runTest() {
		RunThread t1 = new RunThread();
		t1.setName("RunThread-1");
		t1.start();
	}
	
}
