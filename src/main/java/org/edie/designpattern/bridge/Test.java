package org.edie.designpattern.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: jiayingdi
 * Date: 13-3-17
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
public class Test{
    public static void main(){
        Person man=new Man();

        Person woman =new Woman();

        Clothing jacket=new Jacket();

        Clothing trouser=new Trouser();

        jacket.personDressClothing(man);

        trouser.personDressClothing(man);

        jacket.personDressClothing(woman);

        trouser.personDressClothing(woman);

    }


}
