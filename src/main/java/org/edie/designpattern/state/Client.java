package org.edie.designpattern.state;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 */

interface State {
    /**
     * 状态对应的处理
     */
    public void handle(String sampleParameter);
}

class ConcreteStateA implements State {

    @Override
    public void handle(String sampleParameter) {

        System.out.println("ConcreteStateA handle ：" + sampleParameter);
    }

}

class ConcreteStateB implements State {

    @Override
    public void handle(String sampleParameter) {

        System.out.println("ConcreteStateB handle ：" + sampleParameter);
    }

}

class Context {
    //持有一个State类型的对象实例
    private State state;

    public void setState(State state) {
        this.state = state;
    }
    /**
     * 用户感兴趣的接口方法
     */
    public void request(String sampleParameter) {
        //转调state来处理
        state.handle(sampleParameter);
    }
}
public class Client {

    public static void main(String[] args){
        //创建状态
        State state = new ConcreteStateB();
        //创建环境
        Context context = new Context();
        //将状态设置到环境中
        context.setState(state);
        //请求
        context.request("test");
    }
}