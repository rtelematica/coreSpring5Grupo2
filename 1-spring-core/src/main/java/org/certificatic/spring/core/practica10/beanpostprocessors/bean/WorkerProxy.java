package org.certificatic.spring.core.practica10.beanpostprocessors.bean;

public class WorkerProxy implements IWorker {

	private Worker worker;

	public WorkerProxy(Worker worker) {
		this.worker = worker;
	}

	@Override
	public void setName(String name) {
		this.worker.setName(name);
		System.out.println("[Worker Proxy] name changed");
	}

	@Override
	public void setAge(int age) {
		this.worker.setAge(age);
		System.out.println("[Worker Proxy] age changed");
	}

	@Override
	public void showInfo() {
		System.out.println("[Worker Proxy] calling showInfo on target object");
		this.worker.showInfo();
		System.out.println("[Worker Proxy] showInfo finished");
	}

	@Override
	public String getName() {
		return this.worker.getName() + " from proxy";
	}

	@Override
	public int getAge() {
		return this.worker.getAge();
	}

	@Override
	public void init() {
		this.worker.init();
	}

	@Override
	public void destroy() {
		this.worker.destroy();
	}

}
