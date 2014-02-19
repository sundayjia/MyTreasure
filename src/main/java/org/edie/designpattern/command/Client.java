package org.edie.designpattern.command;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午1:55
 * 下面给个例子，是模拟对电视机的操作有开机、关机、换台命令
 */


//命令接收者
class Tv {
    public int currentChannel = 0;

    public void turnOn() {
        System.out.println("The televisino is on.");
    }

    public void turnOff() {
        System.out.println("The television is off.");
    }

    public void changeChannel(int channel) {
        this.currentChannel = channel;
        System.out.println("Now TV channel is " + channel);
    }
}

//执行命令的接口
interface Command {
    void execute();
}

//开机命令
class CommandOn implements Command {
    private Tv myTv;

    public CommandOn(Tv tv) {
        myTv = tv;
    }


    public void execute() {
        myTv.turnOn();
    }
}

//关机命令
class CommandOff implements Command {
    private Tv myTv;

    public CommandOff(Tv tv) {
        myTv = tv;
    }

    public void execute() {
        myTv.turnOff();
    }
}

//频道切换命令
class CommandChange implements Command {
    private Tv myTv;
    private int channel;

    public CommandChange(Tv tv, int channel) {
        myTv = tv;
        this.channel = channel;
    }

    public void execute() {
        myTv.changeChannel(channel);
    }
}

//可以看作是遥控器吧
class Control {
    private Command onCommand, offCommand, changeChannel;

    public Control(Command on, Command off, Command channel) {
        onCommand = on;
        offCommand = off;
        changeChannel = channel;
    }

    public void turnOn() {
        onCommand.execute();
    }

    public void turnOff() {
        offCommand.execute();
    }

    public void changeChannel() {
        changeChannel.execute();
    }
}

//测试类
public class Client {
    public static void main(String[] args) {
        // 命令接收者
        Tv myTv = new Tv();
        // 开机命令
        CommandOn on = new CommandOn(myTv);
        // 关机命令
        CommandOff off = new CommandOff(myTv);
        // 频道切换命令
        CommandChange channel = new CommandChange(myTv, 2);
        // 命令控制对象
        Control control = new Control(on, off, channel);

        // 开机
        control.turnOn();
        // 切换频道
        control.changeChannel();
        // 关机
        control.turnOff();
    }
}
