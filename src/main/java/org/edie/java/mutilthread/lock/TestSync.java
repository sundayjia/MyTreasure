package org.edie.java.mutilthread.lock;

public class TestSync {
	public static void main(String[] args) {
		Buffer buff = new Buffer();

		final SyncWriter writer = new SyncWriter(buff);
		final SyncReader reader = new SyncReader(buff);
		writer.start();
		reader.start();
		new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				for (;;) {
					// 等5秒钟去中断读
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

class Buffer {
	private Object lock;
	public Buffer() {
		lock = this;
	}
	public void write() {
		synchronized (lock) {
			long startTime = System.currentTimeMillis();
			System.out.println("开始往这个buff写入数据…");
			for (;;)// 模拟要处理很长时间
			{
				if (System.currentTimeMillis() - startTime > Integer.MAX_VALUE)
					break;
			}
			System.out.println("终于写完了");
		}
	}
	public void read() {
		synchronized (lock) {
			System.out.println("从这个buff读数据");
		}
	}
}

class SyncWriter extends Thread {
	private Buffer buff;
	public SyncWriter(Buffer buff) {
		this.buff = buff;
	}
	@Override
	public void run() {
		buff.write();
	}
}

class SyncReader extends Thread {
	private Buffer buff;
	public SyncReader(Buffer buff) {
		this.buff = buff;
	}
	@Override
	public void run() {
		buff.read();// 这里估计会一直阻塞
		System.out.println("读结束");
	}
}