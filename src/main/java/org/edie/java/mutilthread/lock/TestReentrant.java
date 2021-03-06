package org.edie.java.mutilthread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrant {
	public static void main(String[] args) {
		BufferInterruptibly buff = new BufferInterruptibly();

		final ReEnentrantWriter writer = new ReEnentrantWriter(buff);
		final ReEnentrantReader reader = new ReEnentrantReader(buff);

		writer.start();
		reader.start();

		new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				for (;;) {
					if (System.currentTimeMillis() - start > 5000) {
						System.out.println("不等了，尝试中断");
						reader.interrupt();
						break;
					}

				}
			}
		}).start();
	}
}


class BufferInterruptibly {
	private ReentrantLock lock = new ReentrantLock();

	public void write() {
		lock.lock();
		try {
			long startTime = System.currentTimeMillis();
			System.out.println("开始往这个buff写入数据…");
			for (;;)// 模拟要处理很长时间
			{
				if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE)
					break;
			}
			System.out.println("终于写完了");
		} finally {
			lock.unlock();
		}
	}

	public void read() throws InterruptedException {
		lock.lockInterruptibly();// 注意这里，可以响应中断
		try {
			System.out.println("从这个buff读数据");
		} finally {
			lock.unlock();
		}
	}
}

class ReEnentrantReader extends Thread {

	private BufferInterruptibly buff;

	public ReEnentrantReader(BufferInterruptibly buff) {
		this.buff = buff;
	}

	@Override
	public void run() {

		try {
			buff.read();// 可以收到中断的异常，从而有效退出
		} catch (InterruptedException e) {
			System.out.println("我不读了");
		}

		System.out.println("读结束");

	}

}

class ReEnentrantWriter extends Thread {

	private BufferInterruptibly buff;

	public ReEnentrantWriter(BufferInterruptibly buff) {
		this.buff = buff;
	}

	@Override
	public void run() {
		buff.write();
	}

}

