/**
 * 
 */
package org.xmlrobot.common;

import java.lang.reflect.InvocationTargetException;

import org.xmlrobot.util.Abort;

/**
 * @author joan
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		
	}
	public interface IProva<X> {
		
	}

	public static class Prova implements IProva<String> {
		
		public Prova(){
			
		}
		public Prova(IProva<String> parent){
			
		}
	}
	public static <X,Y> X instance(Class<X> type, IProva<Y> parent){
		try {
			return type.getConstructor(IProva.class).newInstance(parent);
		} 
		catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new Abort();
		}
	}
	
	public static void main(String[] args) {
		Prova prova1 = new Prova();
		
		Prova prova2 = instance(Prova.class, prova1);
		
		System.out.print(prova2.getClass().getName());
	}
}
