package com.qcz.demo.common;

/**
 * 服务线程
 * @author changzhongq
 * @time 2019年2月23日 下午8:16:14
 */
public abstract class ServiceThread implements Runnable {
	
	@Override
	public void run() {
		beforeRun();
		doSomething();
		afterRun();
	}

	protected void beforeRun() {
		
	}
	
	protected void afterRun() {
		
	}
	
	public abstract void doSomething();
}
