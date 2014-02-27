package org.edie.designpattern.observer;

import java.util.Vector;

public class ObserverDemo {

	public static void main(String args[]) {
		// 创建一个被观察者
		Subject subject = new Subject();

		// 创建两个观察者
		Observer mailObserver = new MailObserver();
		Observer jmsObserver = new JMSObserver();

		// 把两个观察者加到被观察者列表中
		subject.addObserver(mailObserver);
		subject.addObserver(jmsObserver);

		// 执行业务操作
		subject.doBusiness();
	}

}

interface Observer {
	void update(Observable o, Object arg);
}

class JMSObserver implements Observer {

	public void update(Observable o, Object arg) {
		System.out.println("发送消息给jms服务器的观察者已经被执行");
	}
}

class MailObserver implements Observer {

	/**
	 * 这个类取名为MailObserver，顾名思义，她是一个用来发送邮件的观察者
	 */
	public void update(Observable o, Object arg) {
		System.out.println("发送邮件的观察者已经被执行");
	}
}

class Observable {
	private boolean changed = false;
	private Vector obs;

	// 创建被观察者时就创建一个它持有的观察者列表，注意，这个列表是需要同步的。
	public Observable() {
		obs = new Vector();
	}

	/**
	 * 添加观察者到观察者列表中去
	 */
	public synchronized void addObserver(Observer o) {
		if (o == null)
			throw new NullPointerException();
		if (!obs.contains(o)) {
			obs.addElement(o);
		}
	}

	/**
	 * 删除一个观察者
	 */
	public synchronized void deleteObserver(Observer o) {
		obs.removeElement(o);
	}

	/**
	 * 通知操作，即被观察者发生变化，通知对应的观察者进行事先设定的操作，不传参数的通知方法
	 */
	public void notifyObservers() {
		notifyObservers(null);
	}

	/**
	 * 与上面的那个通知方法不同的是，这个方法接受一个参数，这个参数一直传到观察者里，以供观察者使用
	 */
	public void notifyObservers(Object arg) {

		Object[] arrLocal;

		synchronized (this) {
			if (!changed)
				return;
			arrLocal = obs.toArray();
			clearChanged();
		}

		for (int i = arrLocal.length - 1; i >= 0; i--)
			((Observer) arrLocal[i]).update(this, arg);
	}

	private void clearChanged() {

	}

	protected void setChanged() {

	}
}

class Subject extends Observable {

	/**
	 * 业务方法，一旦执行某个操作，则通知观察者
	 */
	public void doBusiness() {
		if (true) {
			super.setChanged();
		}
		notifyObservers("现在还没有的参数");
	}
}