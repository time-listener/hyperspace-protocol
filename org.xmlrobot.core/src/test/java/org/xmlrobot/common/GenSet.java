/**
 * 
 */
package org.xmlrobot.common;

import java.lang.reflect.Array;


public class GenSet<E> {  
    private E[] a;

    public GenSet(Class<E[]> o, int length) {  
        a = o.cast(Array.newInstance(o.getComponentType(), length));
    }  

    public static void main(String[] args) {
        GenSet<String> foo = new GenSet<String>(String[].class, 1);  
//        String[] bar = foo.a;  
        foo.a[0] = "xyzzy";  
        String baz = foo.a[0];  
        
        System.out.print(baz);
    }  
}