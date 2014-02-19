package org.edie.designpattern.visitor;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-31
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */

/**
 * 访问者模式示例
 *
 * @author iihero
 */

interface Visitor {
    //访问中科院
    public void visitCAS(CAS cas);

    //访问高校
    public void visitUniversities(University university);

    //访问企业
    public void visitEnterprises(Enterprise ent);
}

class ConcreteVisitor implements Visitor {

    @Override
    public void visitCAS(CAS cas) {
        System.out.println("ConcreteVisitor visit institute of CAS: " + cas.instituteName);
    }

    @Override
    public void visitEnterprises(Enterprise ent) {
        System.out.println("ConcreteVisitor visit Enterprise: " + ent.name);
    }

    @Override
    public void visitUniversities(University university) {
        System.out.println("ConcreteVisitor visit University: " + university.name);
    }


}

abstract class Organization {
    public abstract void accept(Visitor visitor);
}

class CAS extends Organization {
    String instituteName;
    Visitor visitor;

    public CAS(String name) {
        this.instituteName = name;
    }

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }

    public void specialJob() {
        visitor.visitCAS(this);
        System.out.println("Some special job done for CAS.....");
    }
}

class University extends Organization {
    String name;
    Visitor visitor;

    public University(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }

    public void specialJob() {
        visitor.visitUniversities(this);
        System.out.println("Some special job done for University.....");
    }
}

class Enterprise extends Organization {
    String name;
    Visitor visitor;

    public Enterprise(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        this.visitor = visitor;
    }

    public void specialJob() {
        visitor.visitEnterprises(this);
        System.out.println("Some special job done for Enterprise.....");
    }
}


public class VisitorTest {

    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        CAS cas = new CAS("中科院数学科学研究院");
        cas.accept(visitor);
        Enterprise ent = new Enterprise("三一重工集团有限公司");
        ent.accept(visitor);
        University university = new University("清华大学");
        university.accept(visitor);

        visitor.visitCAS(cas);
        visitor.visitEnterprises(ent);
        visitor.visitUniversities(university);
    }

}