package org.edie.designpattern.Decorator;

public class DecoratorDemo {
	public static void main(String args[]) {
		Project employe = new Employe(); // 代码工人
		Project managerA = new ManagerA(employe); // 项目经理
		Project managerB = new ManagerB(employe); // 项目经理
		// 以经理的名义将编码完成，功劳都是经理的，实际编码的是工人
		managerA.doCoding();
		managerB.doCoding();
	}
}

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin 
 * Date: 2008-8-3 12:51:06 项目
 */
interface Project {

	/**
	 * 写代码
	 */
	void doCoding();
}

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin 
 * Date: 2008-8-3 12:52:12 代码工人
 */
class Employe implements Project {
	/**
	 * 编码
	 */
	public void doCoding() {
		System.out.println("代码工人 在编写代码，加班编啊编啊，终于编完了！");
	}
}

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin 
 * Date: 2008-8-3 12:51:26 项目经理
 */
class Manager implements Project {
	private Project project; // 实际上存放的是代码工人对象

	public Manager(Project project) {
		this.project = project;
	}

	/**
	 * 编码
	 */
	public void doCoding() {
		// 项目经理开始新的工作
		startNewWork();
	}

	/**
	 * 模板：定义项目经理自己的事情
	 */
	public void startNewWork() {
		// 项目经理在做早期工作
		doEarlyWork();
		// 项目经理很牛，做完需求和设计后，直接将编码委派给代码工人干
		project.doCoding();
		// 项目经理在做收尾工作
		doEndWork();
	}

	/**
	 * 项目经理自己的事情：做早期工作
	 */
	public void doEarlyWork() {
	}

	/**
	 * 项目经理做收尾工作
	 */
	public void doEndWork() {
	}
}

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin 
 * Date: 2008-8-3 13:45:18 具体的项目经理A
 */
class ManagerA extends Manager {

	public ManagerA(Project project) {
		super(project);
	}

	/**
	 * 项目经理自己的事情：做早期工作
	 */
	public void doEarlyWork() {
		System.out.println("项目经理A 在做需求分析");
		System.out.println("项目经理A 在做架构设计");
		System.out.println("项目经理A 在做详细设计");
	}
}

/**
 * Created by IntelliJ IDEA. 
 * User: leizhimin 
 * Date: 2008-8-3 13:45:27 具体的项目经理B
 */
class ManagerB extends Manager {

	public ManagerB(Project project) {
		super(project);
	}

	/**
	 * 项目经理自己的事情：做早期工作
	 */
	public void doEarlyWork() {
		System.out.println("项目经理B 在做需求分析");
		System.out.println("项目经理B 在做详细设计");
	}

	/**
	 * 项目经理做收尾工作
	 */
	public void doEndWork() {
		System.out.println("项目经理B 在做收尾工作");
	}
}
