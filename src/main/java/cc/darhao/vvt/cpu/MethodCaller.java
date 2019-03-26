package cc.darhao.vvt.cpu;

import cc.darhao.vvt.mock.BusyMocker;

public class MethodCaller {

	private BusyMocker mocker;
	
	
	public MethodCaller() {
		mocker = new BusyMocker();
		mocker.doSomething();
		m1();
	}
	
	
	private void m1() {
		m2a();
		m2b();
	}
	
	
	private void m2a() {
		mocker.doSomething();
		m3();
	}
	
	
	private void m2b() {
		m3();
	}
	
	
	private void m3() {
		mocker.doSomething();
	}
	
	
}
