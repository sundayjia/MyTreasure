package org.edie.java.mutilthread.lock;
/*
 * 假定有一个绑定的缓冲区，它支持 put 和 take 方法。
 * 如果试图在空的缓冲区上执行take 操作，则在某一个项变得可用之前，线程将一直阻塞；
 * 如果试图在满的缓冲区上执行put 操作，则在有空间变得可用之前，线程将一直阻塞。
 * 我们喜欢在单独的等待 set 中保存put 线程和take 线程，这样就可以在缓冲区中的项或空间变得可用时利用最佳规划，一次只通知一个线程。
 */
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TestReenTrantCondition {
	final Lock lock = new ReentrantLock();// 实例化一个锁对象
	final Condition put = lock.newCondition(); // 实例化两个condition
	final Condition take = lock.newCondition();

	final Object[] items = new Object[100];// 初始化一个长度为100的队列
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();// 获取锁
		try {
			while (count == items.length)
				put.await();// 当计数器count等于队列的长度时，不能在插入，因此等待
			items[putptr] = x; // 将对象放入putptr索引处
			if (++putptr == items.length)
				putptr = 0;// 当索引长度等于队列长度时，将putptr置为0
			// 原因是，不能越界插入
			++count;// 没放入一个对象就将计数器加1
			take.signal();// 一旦插入就唤醒取数据线程
		} finally {
			lock.unlock();// 最后释放锁
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();// 获取锁
		try {
			while (count == 0)
				// 如果计数器等于0那么等待
				take.await();
			Object x = items[takeptr]; // 取得takeptr索引处对象
			if (++takeptr == items.length)
				takeptr = 0;// 当takeptr达到队列长度时，从零开始取
			--count;// 每取一个讲计数器减1
			put.signal();// 枚取走一个就唤醒存线程
			return x;
		} finally {
			lock.unlock();// 释放锁
		}
	}
}

