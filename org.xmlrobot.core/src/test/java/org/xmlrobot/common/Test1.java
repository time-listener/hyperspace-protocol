/**
 * 
 */
package org.xmlrobot.common;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.function.BiFunction;

import org.xmlrobot.TimeListener;
import org.xmlrobot.util.Abort;
import org.xmlrobot.util.Commandment;

/**
 * @author joan
 *
 */
public class Test1 {

	public static void main(String[] args) {
		
//		Tick tick = new Tick(Tack.class);
//		
//		tick.setPositive('a');
//		tick.setNegative(100);
//		
//		AbstractTest test;
//		test = instance(AbstractTest.class);
//		System.out.print(test.getKey());
		
		BiFunction<String,String,String> bi = (x, y) -> {      
		      return x + y;
		    };
		    
		    Commandment<String, String> bic = new Commandment<String, String>(bi);

		    System.out.println(bic.apply("java2s.com", " tutorial"));
	}

	/**
	 * {@link TimeListener} instantiation method #0.
	 * @param type the instantiated type
	 * @return the new X instance
	 */
	protected static <X> X instance(Class<X> type) {
		
		if (type == null)
			throw new Abort();
		
		try {
			return type.getDeclaredConstructor().newInstance();
		}
		catch(ClassCastException | 
				InstantiationException | 
					IllegalAccessException |
						IllegalArgumentException |
					InvocationTargetException | 
				NoSuchMethodException | 
			SecurityException e) {
			
			throw new Abort(e, null);
		}
	}
	public abstract static class AbstractTest implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -7506157945597718869L;
		
		public AbstractTest() {
			super();
		}
		public String getKey(){
			return "blablabla";
		}
	}
}
