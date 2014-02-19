package org.edie.designpattern.interpreter.complex;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午12:44
 * To change this template use File | Settings | File Templates.
 */
public class Constant extends Expression{

    private boolean value;

    public Constant(boolean value){
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj != null && obj instanceof Constant){
            return this.value == ((Constant)obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean interpret(Context ctx) {
        System.out.println("Constant begin to interperet");
        return value;
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }

}
