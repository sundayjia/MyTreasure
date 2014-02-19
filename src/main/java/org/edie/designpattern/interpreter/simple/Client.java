package org.edie.designpattern.interpreter.simple;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午1:15
 * 让一个表达式a经过PlusExpression解释器处理后使该表达式+1，经过MinusExpression解释器处理后使该表达式-1。.
 */
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String []args) {
        String inputExpr = "10";

        Context context = new Context(inputExpr);

        List list = new ArrayList();

        list.add(new PlusExpression());
        list.add(new PlusExpression());
        list.add(new MinusExpression());
        list.add(new MinusExpression());
        list.add(new MinusExpression());

        for (int i=0;i<list.size();i++) {
            AbstractExpression expression = (AbstractExpression)list.get(i);
            expression.interpret(context);
        }

        System.out.println(context.getOutput());
    }
}


/**
 * Context
 *
 */
class Context {
    private String input;
    private int output;

    public Context (String input) {
        this. input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }
}


/**
 * Expression & subclass
 *
 */
abstract class AbstractExpression {
    public abstract void interpret(Context context);
}

class PlusExpression extends AbstractExpression {
    public void interpret(Context context) {
        System.out.println("PlusExpression ++");
        String input = context.getInput();
        int parsedResult = Integer.parseInt(input);
        parsedResult ++;
        context.setInput(String.valueOf(parsedResult));
        context.setOutput(parsedResult);
    }
}

class MinusExpression extends AbstractExpression {
    public void interpret(Context context) {
        System.out.println("PlusExpression --");
        String input = context.getInput();
        int parsedResult = Integer.parseInt(input);
        parsedResult --;
        context.setInput(String.valueOf(parsedResult));
        context.setOutput(parsedResult);
    }
}
