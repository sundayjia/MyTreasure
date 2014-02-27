package org.edie;

import java.util.Hashtable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Hashtable<Bean,String> ht = new Hashtable<Bean,String>();
    	Bean bean = null;
    	ht.put(bean, "");
    	
    }
}

class Bean{
	public String id ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
