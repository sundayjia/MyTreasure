package org.edie.designpattern.strategy;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
abstract class Strategy {
    public abstract void backupDatabase();
}

class StrategyImplA extends Strategy {

    @Override
    public void backupDatabase() {
        System.out.println("策略1: 完全物理备份");
    }
}

class StrategyImplB extends Strategy {

    @Override
    public void backupDatabase() {
        System.out.println("策略2: 基础联机备份");
    }
}

class StrategyImplC extends Strategy {

    @Override
    public void backupDatabase() {
        System.out.println("策略3: 增量联机备份");
    }
}

class DBContext {
    Strategy strategy;
    public DBContext(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeBackupDatabase() {
        strategy.backupDatabase();
    }
}

public class StrategyTest {

    public static void main(String[] args) {
        System.out.println("尝试策略A");
        DBContext context = new DBContext(new StrategyImplA());
        context.executeBackupDatabase();

        System.out.println("==================");
        System.out.println("尝试策略B");
        context = new DBContext(new StrategyImplB());
        context.executeBackupDatabase();

        System.out.println("==================");
        System.out.println("尝试策略C");
        context = new DBContext(new StrategyImplC());
        context.executeBackupDatabase();
    }
}
