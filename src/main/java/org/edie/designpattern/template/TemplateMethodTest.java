package org.edie.designpattern.template;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午1:23
 * To change this template use File | Settings | File Templates.
 */
abstract class Template {
    protected abstract void laterWork();

    protected void step1() {
        System.out.println("执行明确的步骤1: step");
    }

    protected void lastStep() {
        System.out.println("执行明确的步骤: lastStep");
    }

    public void execute() {
        step1();
        laterWork();
        lastStep();
    }
}

class CustomizedTemplate extends Template {

    @Override
    protected void laterWork() {
        System.out.println("CustomizedTemplate: 在子类中执行后期任务");
    }
}

public class TemplateMethodTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Template template = new CustomizedTemplate();
        template.execute();
    }

}